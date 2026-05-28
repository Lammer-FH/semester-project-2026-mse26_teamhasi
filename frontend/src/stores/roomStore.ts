import {defineStore} from 'pinia';
import {ref} from 'vue';
import type {PaginationDto, RoomDto} from '@/generated/model';
import {getRooms} from '@/api/roomsApi';

export const useRoomStore = defineStore('rooms', () => {
	const rooms = ref<RoomDto[]>([]);
	const pagination = ref<PaginationDto | null>(null);
	const loading = ref(false);
	const error = ref<string | null>(null);

	async function fetchRooms(limit: number, offset = 0, checkIn?: string, checkOut?: string) {
		loading.value = true;
		error.value = null;
		try {
			const res = await getRooms({limit, offset, bookingStart: checkIn, bookingEnd: checkOut});
			rooms.value = res.data.data ?? [];
			pagination.value = res.data.pagination ?? null;
		} catch {
			error.value = 'Failed to load rooms. Please try again.';
		} finally {
			loading.value = false;
		}
	}

	// Featured rooms for the home page — fetched once and cached
	const featured = ref<RoomDto[]>([]);
	const featuredLoading = ref(false);
	const featuredError = ref<string | null>(null);

	async function fetchFeatured() {
		if (featured.value.length > 0) return;
		featuredLoading.value = true;
		featuredError.value = null;
		try {
			const res = await getRooms({limit: 15, offset: 0});
			featured.value = res.data.data ?? [];
		} catch {
			featuredError.value = 'Failed to load rooms.';
		} finally {
			featuredLoading.value = false;
		}
	}

	return {
		rooms, pagination, loading, error, fetchRooms,
		featured, featuredLoading, featuredError, fetchFeatured,
	};
});
