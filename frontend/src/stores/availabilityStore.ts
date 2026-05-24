import { defineStore } from 'pinia';
import { ref } from 'vue';
import { checkRoomAvailability, type RoomAvailability } from '@/api/roomApi';

export const useAvailabilityStore = defineStore('availability', () => {
  const checkIn = ref('');
  const checkOut = ref('');
  const selectedRoomId = ref<number | null>(null);
  const result = ref<RoomAvailability | null>(null);
  const loading = ref(false);
  const error = ref<string | null>(null);

  async function checkAvailability(roomId: number) {
    if (!checkIn.value || !checkOut.value) return;
    loading.value = true;
    error.value = null;
    result.value = null;
    selectedRoomId.value = roomId;
    try {
      const res = await checkRoomAvailability(roomId, checkIn.value, checkOut.value);
      result.value = res.data;
    } catch {
      error.value = 'Failed to check availability. Please try again.';
    } finally {
      loading.value = false;
    }
  }

  function reset() {
    result.value = null;
    error.value = null;
    selectedRoomId.value = null;
  }

  return { checkIn, checkOut, selectedRoomId, result, loading, error, checkAvailability, reset };
});
