<template>
  <div class="confirmation">
    <BIconCheckCircleFill class="success-icon"/>
    <h2 class="booking-title">Booking Confirmed!</h2>
    <p class="order-id">Booking #{{ order.id }}</p>

    <div class="section-card">
      <h3 class="section-title">Booking Details</h3>
      <div class="info-rows">
        <div class="info-row">
          <span class="label">Room</span>
          <span>{{ order.room?.roomType?.name }} ({{ order.room?.roomNumber }})</span>
        </div>
        <div class="info-row">
          <span class="label">Check-in</span>
          <span>{{ order.bookingStart }}</span>
        </div>
        <div class="info-row">
          <span class="label">Check-out</span>
          <span>{{ order.bookingEnd }}</span>
        </div>
        <div class="info-row">
          <span class="label">Nights</span>
          <span>{{ order.nights }}</span>
        </div>
        <div class="info-row">
          <span class="label">Breakfast</span>
          <span>{{ order.hasBreakfast ? 'Yes' : 'No' }}</span>
        </div>
        <div class="info-row">
          <span class="label">Guest</span>
          <span>{{ order.user?.firstName }} {{ order.user?.lastName }}</span>
        </div>
        <div class="info-row">
          <span class="label">Email</span>
          <span>{{ order.user?.email }}</span>
        </div>
        <div class="info-row">
          <span class="label">Status</span>
          <span class="status-confirmed">{{ order.status }}</span>
        </div>
      </div>
    </div>

    <div class="section-card">
      <h3 class="section-title">Directions &amp; Contact</h3>
      <location-map
          title="Hotel Hasi location on OpenStreetMap"
          embed-src="https://www.openstreetmap.org/export/embed.html?bbox=16.371%2C48.236%2C16.381%2C48.243&layer=mapnik&marker=48.239378%2C16.376495"
          link-href="https://www.openstreetmap.org/?mlat=48.239378&mlon=16.376495#map=19/48.239378/16.376495"
          print-src="https://render.openstreetmap.org/cgi-bin/export?bbox=16.371%2C48.236%2C16.381%2C48.243&scale=5000&format=png"
      />
      <div class="info-rows">
        <div class="info-row">
          <span class="label">Address</span>
          <span>Höchstädtplatz 1, 1200 Wien</span>
        </div>
        <div class="info-row">
          <span class="label">Phone</span>
          <a href="tel:+4312345678">+43 1 234 5678</a>
        </div>
        <div class="info-row">
          <span class="label">Email</span>
          <a href="mailto:kontakt@hotel-hasi.at">kontakt@hotel-hasi.at</a>
        </div>
        <div class="info-row info-row--top">
          <span class="label">Public Transport</span>
          <div class="pt-lines">
            <div class="pt-line">
              <span class="pt-badge pt-u6">U6</span>
              <span>Dresdner Straße</span>
            </div>
            <div class="pt-stop">
              <div class="pt-line">
                <span class="pt-badge pt-tram">O</span>
                <span class="pt-badge pt-tram">2</span>
                <span class="pt-badge pt-tram">5</span>
                <span class="pt-badge pt-tram">12</span>
                <span class="pt-badge pt-tram">30</span>
                <span class="pt-badge pt-tram">31</span>
              </div>
              <span>Höchstädtplatz</span>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="actions no-print">
      <ion-button fill="solid" class="btn-print" @click="printConfirmation()">
        Print Confirmation
      </ion-button>
      <ion-button expand="block" color="primary" @click="$emit('done')">
        Back to Rooms
      </ion-button>
    </div>
  </div>
</template>

<script setup lang="ts">
import {IonButton} from '@ionic/vue';
import {BIconCheckCircleFill} from 'bootstrap-icons-vue';
import type {OrderResponseDto} from '@/generated/model';
import LocationMap from '@/components/organisms/LocationMap.vue';

defineProps<{ order: OrderResponseDto }>();
defineEmits<{ done: [] }>();

function printConfirmation() {
  if (typeof globalThis.window?.print === 'function') {
    globalThis.window.print();
  }
}
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

.booking-title {
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

.section-card {
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08);
  overflow: hidden;
  margin-bottom: 16px;
  text-align: left;
}

.section-title {
  font-size: 1rem;
  font-weight: 700;
  color: #0d0d1a;
  margin: 0;
  padding: 16px 16px 12px;
  border-bottom: 1px solid #f0f0f0;
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

.info-row:last-child {
  border-bottom: none;
}

.info-row--top {
  align-items: flex-start;
}

.info-row a {
  color: #1a56db;
  text-decoration: none;
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

.pt-lines {
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.pt-line {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 4px;
}

.pt-stop {
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.pt-badge {
  color: white;
  border-radius: 8px;
  font-size: 0.875rem;
  font-weight: 500;
  padding: 6px;
  width: 2.5rem;
  display: inline-flex;
  justify-content: center;
}

.pt-u6 {
  background-color: #9D6830;
}

.pt-tram {
  background-color: red;
}

.actions {
  display: flex;
  gap: 12px;
  margin-top: 8px;
}

.actions ion-button:first-child {
  flex-shrink: 0;
}

.actions ion-button:last-child {
  flex: 1;
}

.btn-print {
  --background: #111111;
  --background-activated: #333333;
  --background-hover: #2a2a2a;
  --color: #ffffff;
}

@media print {
  .no-print {
    display: none !important;
  }

  .section-card {
    box-shadow: none;
    border: 1px solid #ddd;
  }
}
</style>
