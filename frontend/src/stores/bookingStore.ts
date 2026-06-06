import {defineStore} from 'pinia';
import {ref} from 'vue';
import type {OrderResponseDto} from '@/generated/model';
import {createOrder} from '@/api/roomsApi';

export const useBookingStore = defineStore('booking', () => {
	const firstName = ref('');
	const lastName = ref('');
	const email = ref('');
	const confirmEmail = ref('');
	const hasBreakfast = ref(false);

	const submitting = ref(false);
	const submitError = ref<string | null>(null);
	const submitErrorCode = ref<string | null>(null);
	const confirmedOrder = ref<OrderResponseDto | null>(null);

	function resetForm() {
		firstName.value = '';
		lastName.value = '';
		email.value = '';
		confirmEmail.value = '';
		hasBreakfast.value = false;
		submitting.value = false;
		submitError.value = null;
		submitErrorCode.value = null;
		confirmedOrder.value = null;
	}

	async function submitBooking(roomId: number, bookingStart: string, bookingEnd: string): Promise<boolean> {
		submitting.value = true;
		submitError.value = null;
		submitErrorCode.value = null;
		confirmedOrder.value = null;

		try {
			const res = await createOrder({
				roomId,
				bookingStart,
				bookingEnd,
				hasBreakfast: hasBreakfast.value,
				user: {
					username: email.value,
					firstName: firstName.value,
					lastName: lastName.value,
					email: email.value,
				},
			});
			confirmedOrder.value = res.data;
			return true;
		} catch (err: any) {
			const code = err.response?.data?.code ?? null;
			const message = err.response?.data?.message ?? null;
			submitErrorCode.value = code;

			if (code === 'ROOM_NOT_AVAILABLE') {
				submitError.value = message ?? 'This room is not available for the selected dates.';
			} else if (code === 'ROOM_NOT_FOUND') {
				submitError.value = message ?? 'The selected room could not be found.';
			} else if (code === 'VALIDATION_ERROR') {
				submitError.value = message ?? 'Please check your booking details.';
			} else {
				submitError.value = 'Booking failed. Please try again.';
			}
			return false;
		} finally {
			submitting.value = false;
		}
	}

	return {
		firstName, lastName, email, confirmEmail, hasBreakfast,
		submitting, submitError, submitErrorCode, confirmedOrder,
		resetForm, submitBooking,
	};
});
