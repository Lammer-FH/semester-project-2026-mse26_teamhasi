<template>
  <div class="filter-bar">
    <div class="filter-fields">
      <div class="filter-field">
        <label>Check-in</label>
        <ion-input type="date" :min="today" v-model="checkInValue" fill="outline" />
      </div>
      <div class="filter-field">
        <label>Check-out</label>
        <ion-input type="date" :min="checkInValue || today" v-model="checkOutValue" fill="outline" />
      </div>
    </div>
    <div class="filter-actions">
      <ion-button color="primary" :disabled="!checkInValue || !checkOutValue" @click="$emit('search')">
        Search
      </ion-button>
      <ion-button v-if="isFiltered" fill="outline" color="primary" @click="$emit('clear')">
        Clear
      </ion-button>
    </div>
    <p v-if="error" class="filter-error">{{ error }}</p>
    <p v-if="isFiltered" class="filter-active">
      Showing available rooms for {{ checkIn }} → {{ checkOut }}
    </p>
  </div>
</template>

<script setup lang="ts">
import { computed } from 'vue';
import { IonButton, IonInput } from '@ionic/vue';

const props = defineProps<{
  today: string;
  checkIn: string;
  checkOut: string;
  isFiltered: boolean;
  error: string;
}>();

const emit = defineEmits<{
  'update:checkIn': [value: string];
  'update:checkOut': [value: string];
  search: [];
  clear: [];
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

@media (min-width: 640px) {
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
}
</style>