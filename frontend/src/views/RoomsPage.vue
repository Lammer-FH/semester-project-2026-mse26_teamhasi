<template>
  <ion-page>
    <site-header />

    <ion-content :fullscreen="true" class="rooms-content">
      <div class="container">
        <h1 class="page-title">Our Rooms</h1>

        <date-range-filter
          :today="today"
          v-model:check-in="filterCheckIn"
          v-model:check-out="filterCheckOut"
          :is-filtered="isFiltered"
          :error="filterError"
          @search="search"
          @clear="clearFilter"
        />

        <!-- Loading -->
        <div v-if="store.loading" class="state-box">
          <ion-spinner name="crescent" />
          <p>Loading rooms…</p>
        </div>

        <!-- Error -->
        <div v-else-if="store.error" class="state-box error">
          <p>{{ store.error }}</p>
          <ion-button fill="outline" color="primary" size="small" @click="load">Retry</ion-button>
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

          <pagination-controls
            :visible="!!store.pagination"
            :page-label="pageLabel"
            :prev-disabled="currentOffset === 0"
            :next-disabled="!store.pagination?.next_offset"
            @prev="prev"
            @next="next"
          />
        </template>
      </div>

      <availability-modal
        :is-open="modalOpen"
        :selected-room-name="selectedRoomName"
        :today="today"
        v-model:check-in="avStore.checkIn"
        v-model:check-out="avStore.checkOut"
        :loading="avStore.loading"
        :result="avStore.result"
        :error="avStore.error"
        :date-error="dateError"
        @close="closeModal"
        @check="submitAvailability"
      />

      <site-footer />
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue';
import { useRoute } from 'vue-router';
import { IonPage, IonContent, IonButton, IonSpinner, onIonViewWillEnter } from '@ionic/vue';
import SiteHeader from '@/components/organisms/SiteHeader.vue';
import SiteFooter from '@/components/organisms/SiteFooter.vue';
import RoomCard from '@/components/molecules/RoomCard.vue';
import DateRangeFilter from '@/components/organisms/DateRangeFilter.vue';
import AvailabilityModal from '@/components/organisms/AvailabilityModal.vue';
import PaginationControls from '@/components/organisms/PaginationControls.vue';
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
}
</style>
