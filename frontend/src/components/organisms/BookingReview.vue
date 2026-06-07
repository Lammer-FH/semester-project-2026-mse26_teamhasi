<template>
  <div>
    <h1 class="page-title">Review Your Booking</h1>
    <p class="step-label">Step 2 of 3 — Confirm Details</p>

    <div class="section-card">
      <h2 class="section-title">Room &amp; Dates</h2>
      <room-media :room="room" />
      <div class="room-info">
        <room-meta-row :room="room" />
        <room-extras-chips :extras="room.extras ?? []" />
      </div>
      <div class="info-rows">
        <div class="info-row">
          <span class="label">Check-in</span>
          <span>{{ checkIn }}</span>
        </div>
        <div class="info-row">
          <span class="label">Check-out</span>
          <span>{{ checkOut }}</span>
        </div>
        <div class="info-row">
          <span class="label">Nights</span>
          <span>{{ nights }}</span>
        </div>
        <div class="info-row">
          <span class="label">Breakfast</span>
          <span>{{ store.hasBreakfast ? 'Yes' : 'No' }}</span>
        </div>
      </div>
    </div>

    <div class="section-card">
      <h2 class="section-title">Guest Details</h2>
      <div class="info-rows">
        <div class="info-row">
          <span class="label">First Name</span>
          <span>{{ store.firstName }}</span>
        </div>
        <div class="info-row">
          <span class="label">Last Name</span>
          <span>{{ store.lastName }}</span>
        </div>
        <div class="info-row">
          <span class="label">Email</span>
          <span>{{ store.email }}</span>
        </div>
      </div>
    </div>

    <div v-if="error" class="error-box">
      <p>{{ error }}</p>
      <p v-if="errorCode === 'ROOM_NOT_AVAILABLE'" class="error-hint">
        Please go back and select different dates.
      </p>
    </div>

    <div class="actions">
      <ion-button fill="outline" class="btn-back" :disabled="submitting" @click="$emit('back')">
        Back
      </ion-button>
      <ion-button color="primary" expand="block" :disabled="submitting" @click="$emit('confirm')">
        <ion-spinner v-if="submitting" name="crescent" slot="start" />
        Confirm Booking
      </ion-button>
    </div>
  </div>
</template>

<script setup lang="ts">
import {computed} from 'vue';
import {IonButton, IonSpinner} from '@ionic/vue';
import type {RoomDto} from '@/generated/model';
import RoomMedia from '@/components/molecules/RoomMedia.vue';
import RoomMetaRow from '@/components/molecules/RoomMetaRow.vue';
import RoomExtrasChips from '@/components/molecules/RoomExtrasChips.vue';
import {useBookingStore} from '@/stores/bookingStore';
import {nightsBetween} from '@/utils/nightsBetween';

const props = defineProps<{
  room: RoomDto;
  checkIn: string;
  checkOut: string;
  submitting: boolean;
  error: string | null;
  errorCode: string | null;
}>();

defineEmits<{ confirm: []; back: [] }>();

const store = useBookingStore();

const nights = computed(() => nightsBetween(props.checkIn, props.checkOut));
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

.section-card {
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08);
  overflow: hidden;
  margin-bottom: 16px;
}

.section-title {
  font-size: 1rem;
  font-weight: 700;
  color: #0d0d1a;
  margin: 0;
  padding: 16px 16px 12px;
  border-bottom: 1px solid #f0f0f0;
}

.room-info {
  padding: 12px 16px 0;
}

.info-rows {
  padding: 0 16px;
}

.info-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 0;
  border-bottom: 1px solid #f0f0f0;
  font-size: 0.9rem;
  gap: 12px;
}

.info-row:last-child { border-bottom: none; }

.label {
  color: #555;
  font-weight: 600;
  flex-shrink: 0;
}

.error-box {
  background: #fdecea;
  color: #c0392b;
  border-radius: 8px;
  padding: 14px 16px;
  margin-bottom: 16px;
}

.error-box p { margin: 0; font-size: 0.9rem; }
.error-hint { margin-top: 6px !important; opacity: 0.85; }

.actions {
  display: flex;
  gap: 12px;
  margin-top: 8px;
}

.actions ion-button:first-child { flex-shrink: 0; }
.actions ion-button:last-child { flex: 1; }

.btn-back {
  --color: #333333;
  --border-color: #333333;
}
</style>
