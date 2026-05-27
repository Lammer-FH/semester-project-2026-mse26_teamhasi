import { defineStore } from 'pinia';
import { ref } from 'vue';
import { getRooms, type Room, type Pagination } from '@/api/roomApi';

export const useRoomStore = defineStore('rooms', () => {
  const rooms = ref<Room[]>([]);
  const pagination = ref<Pagination | null>(null);
  const loading = ref(false);
  const error = ref<string | null>(null);

  async function fetchRooms(limit: number, offset = 0, checkIn?: string, checkOut?: string) {
    loading.value = true;
    error.value = null;
    try {
      const res = await getRooms({ limit, offset, check_in: checkIn, check_out: checkOut });
      rooms.value = res.data.data;
      pagination.value = res.data.pagination;
    } catch {
      error.value = 'Failed to load rooms. Please try again.';
    } finally {
      loading.value = false;
    }
  }

  // Featured rooms for the home page — fetched once and cached
  const featured = ref<Room[]>([]);
  const featuredLoading = ref(false);
  const featuredError = ref<string | null>(null);

  async function fetchFeatured() {
    if (featured.value.length > 0) return;
    featuredLoading.value = true;
    featuredError.value = null;
    try {
      const res = await getRooms({ limit: 15, offset: 0 });
      featured.value = res.data.data;
    } catch {
      featuredError.value = 'Failed to load rooms.';
    } finally {
      featuredLoading.value = false;
    }
  }

  return { rooms, pagination, loading, error, fetchRooms, featured, featuredLoading, featuredError, fetchFeatured };
});
