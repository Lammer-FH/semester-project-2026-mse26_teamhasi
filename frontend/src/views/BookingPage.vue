<template>
  <ion-page>
    <site-header />

    <ion-content :fullscreen="true" class="booking-content">
      <div class="container">

        <div v-if="!roomId || !checkIn || !checkOut" class="state-box error">
          <p>Invalid booking link. Please go back and select a room.</p>
          <ion-button router-link="/rooms" fill="outline" color="primary" size="small">
            Browse Rooms
          </ion-button>
        </div>

        <div v-else-if="roomLoading" class="state-box">
          <ion-spinner name="crescent" />
          <p>Loading room details…</p>
        </div>

        <div v-else-if="!room" class="state-box error">
          <p>Room not found. Please go back and try again.</p>
          <ion-button router-link="/rooms" fill="outline" color="primary" size="small">
            Browse Rooms
          </ion-button>
        </div>

        <template v-else>
          <booking-form
            v-if="currentStep === 1"
            :room="room"
            :check-in="checkIn"
            :check-out="checkOut"
            @submit="onFormSubmit"
          />

          <booking-review
            v-else-if="currentStep === 2"
            :room="room"
            :check-in="checkIn"
            :check-out="checkOut"
            :submitting="bookingStore.submitting"
            :error="bookingStore.submitError"
            :error-code="bookingStore.submitErrorCode"
            @confirm="onConfirm"
            @back="currentStep = 1"
          />

          <booking-confirmation
            v-else-if="currentStep === 3 && bookingStore.confirmedOrder"
            :order="bookingStore.confirmedOrder"
            @done="router.push('/rooms')"
          />
        </template>

      </div>
      <site-footer />
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import {computed, ref} from 'vue';
import {useRoute, useRouter} from 'vue-router';
import {IonButton, IonContent, IonPage, IonSpinner, onIonViewWillEnter} from '@ionic/vue';
import SiteHeader from '@/components/organisms/SiteHeader.vue';
import SiteFooter from '@/components/organisms/SiteFooter.vue';
import BookingForm from '@/components/organisms/BookingForm.vue';
import BookingReview from '@/components/organisms/BookingReview.vue';
import BookingConfirmation from '@/components/organisms/BookingConfirmation.vue';
import {useRoomStore} from '@/stores/roomStore';
import {useBookingStore} from '@/stores/bookingStore';
import type {RoomDto} from '@/generated/model';

const route = useRoute();
const router = useRouter();
const roomStore = useRoomStore();
const bookingStore = useBookingStore();

const currentStep = ref<1 | 2 | 3>(1);
const roomLoading = ref(false);
const room = ref<RoomDto | null>(null);

const roomId = computed(() => {
  const v = Number(route.query.roomId);
  return isNaN(v) || v === 0 ? null : v;
});
const checkIn = computed(() => (route.query.checkIn as string) || '');
const checkOut = computed(() => (route.query.checkOut as string) || '');

onIonViewWillEnter(async () => {
  currentStep.value = 1;
  bookingStore.resetForm();
  room.value = null;

  if (!roomId.value) return;

  const cached = roomStore.featured.find(r => r.id === roomId.value)
    ?? roomStore.rooms.find(r => r.id === roomId.value);

  if (cached) {
    room.value = cached;
    return;
  }

  roomLoading.value = true;
  await roomStore.fetchFeatured();
  roomLoading.value = false;
  room.value = roomStore.featured.find(r => r.id === roomId.value) ?? null;
});

function onFormSubmit() {
  currentStep.value = 2;
}

async function onConfirm() {
  if (!roomId.value || !checkIn.value || !checkOut.value) return;
  const success = await bookingStore.submitBooking(roomId.value, checkIn.value, checkOut.value);
  if (success) currentStep.value = 3;
}
</script>

<style>
.booking-content {
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

.state-box {
  text-align: center;
  padding: 48px 0;
  color: #666;
}

.state-box.error { color: #c0392b; }
</style>
