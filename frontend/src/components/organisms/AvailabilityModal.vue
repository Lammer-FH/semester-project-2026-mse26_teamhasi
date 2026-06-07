<template>
  <ion-modal :is-open="isOpen" @did-dismiss="$emit('close')">
    <ion-header>
      <ion-toolbar>
        <ion-title>Check Availability</ion-title>
        <ion-buttons slot="end">
          <ion-button color="primary" fill="clear" class="modal-close" @click="$emit('close')">
            <BIconXCircleFill />
          </ion-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-header>

    <ion-content class="modal-content">
      <div class="modal-body">
        <p class="modal-room-name">{{ selectedRoomName }}</p>

        <div class="date-fields">
          <div class="date-field">
            <label>Check-in</label>
            <ion-input
              type="date"
              :min="today"
              v-model="checkInValue"
              fill="outline"
              label-placement="stacked"
            />
          </div>
          <div class="date-field">
            <label>Check-out</label>
            <ion-input
              type="date"
              :min="checkInValue || today"
              v-model="checkOutValue"
              fill="outline"
              label-placement="stacked"
            />
          </div>
        </div>

        <p v-if="dateError" class="field-error">{{ dateError }}</p>

        <ion-button expand="block" color="primary" :disabled="loading" @click="$emit('check')">
          <ion-spinner v-if="loading" name="crescent" slot="start" />
          Check
        </ion-button>

        <div v-if="result" class="result-box" :class="result.available ? 'available' : 'unavailable'">
          <BIconCheckCircleFill v-if="result.available" class="result-icon" />
          <BIconXCircleFill v-else class="result-icon" />
          <p v-if="result.available">This room is available for your selected dates!</p>
          <p v-else>Sorry, this room is not available for the selected dates.</p>
        </div>

        <ion-button
          v-if="result?.available"
          expand="block"
          color="primary"
          @click="$emit('book')"
        >
          Book this room
        </ion-button>

        <div v-if="error" class="result-box unavailable">
          <p>{{ error }}</p>
        </div>
      </div>
    </ion-content>
  </ion-modal>
</template>

<script setup lang="ts">
import { computed } from 'vue';
import {
  IonButton,
  IonButtons,
  IonContent,
  IonHeader,
  IonInput,
  IonModal,
  IonSpinner,
  IonTitle,
  IonToolbar,
} from '@ionic/vue';
import { BIconCheckCircleFill, BIconXCircleFill } from 'bootstrap-icons-vue';

export interface RoomAvailability {
  available: boolean;
}

const props = defineProps<{
  isOpen: boolean;
  selectedRoomName: string;
  today: string;
  checkIn: string;
  checkOut: string;
  loading: boolean;
  result: RoomAvailability | null;
  error: string | null;
  dateError: string;
}>();

const emit = defineEmits<{
  close: [];
  'update:checkIn': [value: string];
  'update:checkOut': [value: string];
  check: [];
  book: [];
}>();

const checkInValue = computed({
  get: () => props.checkIn,
  set: value => emit('update:checkIn', value),
});

const checkOutValue = computed({
  get: () => props.checkOut,
  set: value => emit('update:checkOut', value),
});
</script>

<style scoped>
.modal-content {
  --background: #ffffff;
  --color: #111111;
}

.modal-body {
  padding: 24px 20px;
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.modal-room-name {
  font-weight: 700;
  font-size: 1.05rem;
  color: #0d0d1a;
  margin: 0;
}

.date-fields {
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.date-field label {
  display: block;
  font-size: 0.8rem;
  font-weight: 600;
  color: #555;
  margin-bottom: 4px;
}

.field-error {
  color: #c0392b;
  font-size: 0.8rem;
  margin: 0;
}

.result-box {
  border-radius: 8px;
  padding: 14px 16px;
  display: flex;
  align-items: center;
  gap: 10px;
}

.result-box p {
  margin: 0;
  font-size: 0.9rem;
}

.result-box.available {
  background: #e8f5e9;
  color: #2e7d32;
}

.result-box.unavailable {
  background: #fdecea;
  color: #c0392b;
}

.result-icon {
  font-size: 1.4rem;
  flex-shrink: 0;
}

@media (min-width: 640px) {
  .date-fields {
    flex-direction: row;
  }

  .date-field {
    flex: 1;
  }
}
</style>