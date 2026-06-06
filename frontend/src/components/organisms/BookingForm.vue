<template>
  <div>
    <h1 class="page-title">Book Your Room</h1>
    <p class="step-label">Step 1 of 3 — Guest Details</p>

    <div class="room-summary">
      <room-media :room="room" />
      <div class="room-summary-info">
        <room-meta-row :room="room" />
        <div class="dates-summary">
          <span>{{ checkIn }}</span>
          <span class="dates-arrow">→</span>
          <span>{{ checkOut }}</span>
          <span class="nights-badge">{{ nights }} night{{ nights !== 1 ? 's' : '' }}</span>
        </div>
      </div>
    </div>

    <div class="form-card">
      <h2 class="section-title">Your Details</h2>

      <div class="form-field">
        <label class="field-label">First Name</label>
        <ion-input
          fill="outline"
          type="text"
          placeholder="Enter your first name"
          :value="store.firstName"
          @ionInput="store.firstName = ($event as CustomEvent<{value: string}>).detail.value ?? ''"
          @ionBlur="validateField('firstName')"
        />
        <p v-if="errors.firstName" class="field-error">{{ errors.firstName }}</p>
      </div>

      <div class="form-field">
        <label class="field-label">Last Name</label>
        <ion-input
          fill="outline"
          type="text"
          placeholder="Enter your last name"
          :value="store.lastName"
          @ionInput="store.lastName = ($event as CustomEvent<{value: string}>).detail.value ?? ''"
          @ionBlur="validateField('lastName')"
        />
        <p v-if="errors.lastName" class="field-error">{{ errors.lastName }}</p>
      </div>

      <div class="form-field">
        <label class="field-label">Email Address</label>
        <ion-input
          fill="outline"
          type="email"
          placeholder="Enter your email"
          :value="store.email"
          @ionInput="store.email = ($event as CustomEvent<{value: string}>).detail.value ?? ''"
          @ionBlur="validateField('email')"
        />
        <p v-if="errors.email" class="field-error">{{ errors.email }}</p>
      </div>

      <div class="form-field">
        <label class="field-label">Confirm Email</label>
        <ion-input
          fill="outline"
          type="email"
          placeholder="Repeat your email"
          :value="store.confirmEmail"
          @ionInput="store.confirmEmail = ($event as CustomEvent<{value: string}>).detail.value ?? ''"
          @ionBlur="validateField('confirmEmail')"
        />
        <p v-if="errors.confirmEmail" class="field-error">{{ errors.confirmEmail }}</p>
      </div>

      <div class="breakfast-row">
        <span class="field-label">Breakfast included</span>
        <ion-toggle
          :checked="store.hasBreakfast"
          @ionChange="store.hasBreakfast = ($event as CustomEvent).detail.checked"
        />
      </div>
    </div>

    <ion-button expand="block" color="primary" @click="handleSubmit">
      Continue to Review
    </ion-button>
  </div>
</template>

<script setup lang="ts">
import {computed, reactive} from 'vue';
import {IonButton, IonInput, IonToggle} from '@ionic/vue';
import type {RoomDto} from '@/generated/model';
import RoomMedia from '@/components/molecules/RoomMedia.vue';
import RoomMetaRow from '@/components/molecules/RoomMetaRow.vue';
import {useBookingStore} from '@/stores/bookingStore';

const props = defineProps<{ room: RoomDto; checkIn: string; checkOut: string }>();
const emit = defineEmits<{ submit: [] }>();

const store = useBookingStore();

const nights = computed(() =>
  Math.round((new Date(props.checkOut).getTime() - new Date(props.checkIn).getTime()) / 86400000)
);

const errors = reactive({ firstName: '', lastName: '', email: '', confirmEmail: '' });

const EMAIL_REGEX = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

function validateField(field: keyof typeof errors) {
  switch (field) {
    case 'firstName':
      errors.firstName = store.firstName.trim() ? '' : 'First name is required.';
      break;
    case 'lastName':
      errors.lastName = store.lastName.trim() ? '' : 'Last name is required.';
      break;
    case 'email':
      errors.email = EMAIL_REGEX.test(store.email) ? '' : 'Please enter a valid email address.';
      break;
    case 'confirmEmail':
      errors.confirmEmail = store.confirmEmail === store.email ? '' : 'Email addresses do not match.';
      break;
  }
}

function validate(): boolean {
  (['firstName', 'lastName', 'email', 'confirmEmail'] as const).forEach(validateField);
  return !Object.values(errors).some(Boolean);
}

function handleSubmit() {
  if (validate()) emit('submit');
}
</script>

<style scoped>
.page-title {
  font-size: 1.8rem;
  font-weight: 700;
  color: #0d0d1a;
  margin: 0 0 4px;
}

.step-label {
  color: #888;
  font-size: 0.85rem;
  margin: 0 0 20px;
}

.room-summary {
  background: #fff;
  border-radius: 12px;
  overflow: hidden;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08);
  margin-bottom: 20px;
}

.room-summary-info {
  padding: 12px 16px;
}

.dates-summary {
  display: flex;
  align-items: center;
  gap: 8px;
  font-size: 0.85rem;
  color: #444;
  margin-top: 8px;
  flex-wrap: wrap;
}

.dates-arrow { color: #aaa; }

.nights-badge {
  background: #f0f4ff;
  color: #1a56db;
  padding: 2px 8px;
  border-radius: 12px;
  font-size: 0.8rem;
  font-weight: 600;
}

.form-card {
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08);
  padding: 20px;
  margin-bottom: 20px;
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.section-title {
  font-size: 1rem;
  font-weight: 700;
  color: #0d0d1a;
  margin: 0;
}

.form-field {
  display: flex;
  flex-direction: column;
  gap: 4px;
}

.field-label {
  font-size: 0.8rem;
  font-weight: 600;
  color: #555;
}

.field-error {
  color: #c0392b;
  font-size: 0.8rem;
  margin: 0;
}

.breakfast-row {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 4px 0;
}
</style>
