<template>
  <ion-page>
    <site-header />

    <ion-content :fullscreen="true" class="rooms-content">
      <div class="container">
        <h1 class="page-title">Our Rooms</h1>

        <!-- Date filter bar -->
        <div class="filter-bar">
          <div class="filter-fields">
            <div class="filter-field">
              <label>Check-in</label>
              <ion-input type="date" :min="today" v-model="filterCheckIn" fill="outline" />
            </div>
            <div class="filter-field">
              <label>Check-out</label>
              <ion-input type="date" :min="filterCheckIn || today" v-model="filterCheckOut" fill="outline" />
            </div>
          </div>
          <div class="filter-actions">
            <ion-button :disabled="!filterCheckIn || !filterCheckOut" @click="search">
              Search
            </ion-button>
            <ion-button v-if="isFiltered" fill="outline" color="medium" @click="clearFilter">
              Clear
            </ion-button>
          </div>
          <p v-if="filterError" class="filter-error">{{ filterError }}</p>
          <p v-if="isFiltered" class="filter-active">
            Showing available rooms for {{ filterCheckIn }} → {{ filterCheckOut }}
          </p>
        </div>

        <!-- Loading -->
        <div v-if="store.loading" class="state-box">
          <ion-spinner name="crescent" />
          <p>Loading rooms…</p>
        </div>

        <!-- Error -->
        <div v-else-if="store.error" class="state-box error">
          <p>{{ store.error }}</p>
          <ion-button fill="outline" size="small" @click="load">Retry</ion-button>
        </div>

        <!-- Room grid -->
        <template v-else>
          <div v-if="store.rooms.length === 0" class="state-box">
            <p>No rooms available for the selected dates. Try different dates or <a href="#" @click.prevent="clearFilter">clear the filter</a>.</p>
          </div>

          <div v-else class="rooms-grid">
            <room-card
              v-for="room in store.rooms"
              :key="room.id"
              :room="room"
              @check-availability="openAvailability"
            />
          </div>

          <!-- Pagination -->
          <div v-if="store.pagination" class="pagination">
            <span class="page-info">{{ pageLabel }}</span>
            <ion-buttons>
              <ion-button
                fill="outline"
                :disabled="currentOffset === 0"
                @click="prev"
              >
                Previous
              </ion-button>
              <ion-button
                fill="outline"
                :disabled="!store.pagination.next_offset"
                @click="next"
              >
                Next
              </ion-button>
            </ion-buttons>
          </div>
        </template>
      </div>

      <!-- Availability modal -->
      <ion-modal :is-open="modalOpen" @did-dismiss="closeModal">
        <ion-header>
          <ion-toolbar>
            <ion-title>Check Availability</ion-title>
            <ion-buttons slot="end">
              <ion-button @click="closeModal">Close</ion-button>
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
                  v-model="avStore.checkIn"
                  fill="outline"
                  label-placement="stacked"
                />
              </div>
              <div class="date-field">
                <label>Check-out</label>
                <ion-input
                  type="date"
                  :min="avStore.checkIn || today"
                  v-model="avStore.checkOut"
                  fill="outline"
                  label-placement="stacked"
                />
              </div>
            </div>

            <p v-if="dateError" class="field-error">{{ dateError }}</p>

            <ion-button
              expand="block"
              :disabled="avStore.loading"
              @click="submitAvailability"
            >
              <ion-spinner v-if="avStore.loading" name="crescent" slot="start" />
              Check
            </ion-button>

            <!-- Result -->
            <div v-if="avStore.result" class="result-box" :class="avStore.result.available ? 'available' : 'unavailable'">
              <BIconCheckCircleFill v-if="avStore.result.available" class="result-icon" />
              <BIconXCircleFill v-else class="result-icon" />
              <p v-if="avStore.result.available">This room is available for your selected dates!</p>
              <p v-else>Sorry, this room is not available for the selected dates.</p>
            </div>

            <div v-if="avStore.error" class="result-box unavailable">
              <p>{{ avStore.error }}</p>
            </div>
          </div>
        </ion-content>
      </ion-modal>

      <site-footer />
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { ref, computed, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import {
  IonPage, IonContent, IonButton, IonButtons, IonModal, IonHeader, IonToolbar,
  IonTitle, IonSpinner, IonInput, onIonViewWillEnter,
} from '@ionic/vue';
import { BIconCheckCircleFill, BIconXCircleFill } from 'bootstrap-icons-vue';
import SiteHeader from '@/components/organisms/SiteHeader.vue';
import SiteFooter from '@/components/organisms/SiteFooter.vue';
import RoomCard from '@/components/molecules/RoomCard.vue';
import { useRoomStore } from '@/stores/roomStore';
import { useAvailabilityStore } from '@/stores/availabilityStore';

const route = useRoute();
const store = useRoomStore();
const avStore = useAvailabilityStore();

const LIMIT = 5;
const currentOffset = ref(0);
const modalOpen = ref(false);
const activeRoomId = ref<number | null>(null);

const today = new Date().toISOString().split('T')[0];

// Global date filter
const filterCheckIn = ref('');
const filterCheckOut = ref('');
const isFiltered = ref(false);

const filterError = computed(() => {
  if (!filterCheckIn.value || !filterCheckOut.value) return '';
  if (filterCheckOut.value <= filterCheckIn.value) return 'Check-out must be after check-in.';
  return '';
});

const selectedRoomName = computed(() => {
  const id = activeRoomId.value;
  return (store.rooms.find(r => r.id === id) ?? store.featured.find(r => r.id === id))?.name ?? '';
});

const pageLabel = computed(() => {
  if (!store.pagination) return '';
  const current = Math.floor(currentOffset.value / LIMIT) + 1;
  const total = Math.ceil(store.pagination.total_count / LIMIT);
  return `Page ${current} of ${total}`;
});

const dateError = computed(() => {
  if (!avStore.checkIn || !avStore.checkOut) return '';
  if (avStore.checkOut <= avStore.checkIn) return 'Check-out must be after check-in.';
  return '';
});

function load() {
  const ci = isFiltered.value ? filterCheckIn.value : undefined;
  const co = isFiltered.value ? filterCheckOut.value : undefined;
  return store.fetchRooms(currentOffset.value, ci, co);
}

function prev() {
  currentOffset.value = Math.max(0, currentOffset.value - LIMIT);
  load();
}

function next() {
  if (!store.pagination?.next_offset) return;
  currentOffset.value = store.pagination.next_offset;
  load();
}

function search() {
  if (filterError.value || !filterCheckIn.value || !filterCheckOut.value) return;
  isFiltered.value = true;
  currentOffset.value = 0;
  load();
}

function clearFilter() {
  filterCheckIn.value = '';
  filterCheckOut.value = '';
  isFiltered.value = false;
  currentOffset.value = 0;
  store.fetchRooms(0);
}

function openAvailability(roomId: number) {
  activeRoomId.value = roomId;
  avStore.reset();
  // Pre-fill modal dates from the filter bar so user doesn't re-enter them
  if (filterCheckIn.value) avStore.checkIn = filterCheckIn.value;
  if (filterCheckOut.value) avStore.checkOut = filterCheckOut.value;
  modalOpen.value = true;
}

function closeModal() {
  modalOpen.value = false;
  avStore.reset();
}

function submitAvailability() {
  if (!activeRoomId.value) return;
  if (dateError.value) return;
  if (!avStore.checkIn || !avStore.checkOut) return;
  avStore.checkAvailability(activeRoomId.value);
}

onIonViewWillEnter(async () => {
  await load();
  const roomParam = route.query.room;
  if (roomParam) {
    const id = Number(roomParam);
    if (!isNaN(id)) openAvailability(id);
  }
});
</script>

<style>
.rooms-content {
  --background: #f5f5f8;
  --color: #111111;
}
</style>

<style scoped>
.container {
  max-width: 900px;
  margin: 0 auto;
  padding: 24px 16px 40px;
}

.page-title {
  font-size: 1.8rem;
  font-weight: 700;
  color: #0d0d1a;
  margin: 0 0 24px;
}

.rooms-grid {
  display: grid;
  grid-template-columns: 1fr;
  gap: 20px;
  margin-bottom: 28px;
}


.state-box {
  text-align: center;
  padding: 48px 0;
  color: #666;
}

.state-box.error {
  color: #c0392b;
}

.pagination {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 16px;
}

.page-info {
  font-size: 0.875rem;
  color: #555;
  min-width: 90px;
  text-align: center;
}

/* Filter bar */
.filter-bar {
  background: #fff;
  border-radius: 12px;
  padding: 16px;
  margin-bottom: 24px;
  box-shadow: 0 1px 6px rgba(0, 0, 0, 0.07);
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.filter-fields {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.filter-field label {
  display: block;
  font-size: 0.78rem;
  font-weight: 600;
  color: #555;
  margin-bottom: 4px;
}

.filter-actions {
  display: flex;
  gap: 8px;
}

.filter-error {
  color: #c0392b;
  font-size: 0.8rem;
  margin: 0;
}

.filter-active {
  font-size: 0.82rem;
  color: #1a56db;
  margin: 0;
  font-weight: 500;
}

/* Modal */
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
  .rooms-grid {
    grid-template-columns: 1fr 1fr;
  }

  /* Last card alone on an odd row → centered, desktop only */
  .rooms-grid > :last-child:nth-child(odd):not(:first-child) {
    grid-column: 1 / -1;
    max-width: 50%;
    margin: 0 auto;
  }

  .filter-bar {
    flex-direction: row;
    align-items: flex-end;
    flex-wrap: wrap;
  }

  .filter-fields {
    flex-direction: row;
    flex: 1;
  }

  .filter-field {
    flex: 1;
  }

  .date-fields {
    flex-direction: row;
  }

  .date-field {
    flex: 1;
  }
}
</style>
