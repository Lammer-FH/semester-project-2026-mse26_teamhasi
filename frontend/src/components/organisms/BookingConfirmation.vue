<template>
  <div class="confirmation">
    <BIconCheckCircleFill class="success-icon" />
    <h2>Booking Confirmed!</h2>
    <p class="order-id">Booking #{{ order.id }}</p>

    <div class="details-card">
      <div class="detail-row">
        <span class="label">Room</span>
        <span>{{ order.room?.roomType?.name }} ({{ order.room?.roomNumber }})</span>
      </div>
      <div class="detail-row">
        <span class="label">Check-in</span>
        <span>{{ order.bookingStart }}</span>
      </div>
      <div class="detail-row">
        <span class="label">Check-out</span>
        <span>{{ order.bookingEnd }}</span>
      </div>
      <div class="detail-row">
        <span class="label">Nights</span>
        <span>{{ order.nights }}</span>
      </div>
      <div class="detail-row">
        <span class="label">Breakfast</span>
        <span>{{ order.hasBreakfast ? 'Yes' : 'No' }}</span>
      </div>
      <div class="detail-row">
        <span class="label">Guest</span>
        <span>{{ order.user?.firstName }} {{ order.user?.lastName }}</span>
      </div>
      <div class="detail-row">
        <span class="label">Email</span>
        <span>{{ order.user?.email }}</span>
      </div>
      <div class="detail-row">
        <span class="label">Status</span>
        <span class="status-confirmed">{{ order.status }}</span>
      </div>
    </div>

    <ion-button expand="block" color="primary" @click="$emit('done')">
      Back to Rooms
    </ion-button>
  </div>
</template>

<script setup lang="ts">
import {IonButton} from '@ionic/vue';
import {BIconCheckCircleFill} from 'bootstrap-icons-vue';
import type {OrderResponseDto} from '@/generated/model';

defineProps<{ order: OrderResponseDto }>();
defineEmits<{ done: [] }>();
</script>

<style scoped>
.confirmation {
  text-align: center;
  padding: 32px 0;
}

.success-icon {
  font-size: 3rem;
  color: #2e7d32;
  margin-bottom: 16px;
}

h2 {
  font-size: 1.6rem;
  font-weight: 700;
  color: #0d0d1a;
  margin: 0 0 8px;
}

.order-id {
  color: #666;
  font-size: 0.95rem;
  margin: 0 0 24px;
}

.details-card {
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08);
  padding: 20px;
  margin-bottom: 24px;
  text-align: left;
}

.detail-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 0;
  border-bottom: 1px solid #f0f0f0;
  font-size: 0.9rem;
  gap: 12px;
}

.detail-row:last-child {
  border-bottom: none;
}

.label {
  color: #555;
  font-weight: 600;
  flex-shrink: 0;
}

.status-confirmed {
  color: #2e7d32;
  font-weight: 600;
}
</style>
