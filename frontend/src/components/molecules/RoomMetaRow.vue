<template>
  <div class="room-meta-row" :class="{ 'room-meta-row--compact': compact }">
    <h3 class="room-meta-row__name">{{ room.name }}</h3>
    <span class="room-meta-row__price">
      {{ pricePrefix }}{{ room.price_per_night.toFixed(2) }}<small>{{ priceSuffix }}</small>
    </span>
  </div>
</template>

<script setup lang="ts">
import type { Room } from '@/api/roomApi';

withDefaults(
  defineProps<{
    room: Room;
    pricePrefix?: string;
    priceSuffix?: string;
    compact?: boolean;
  }>(),
  {
    pricePrefix: '€',
    priceSuffix: '/night',
    compact: false,
  },
);
</script>

<style scoped>
.room-meta-row {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  gap: 8px;
}

.room-meta-row__name {
  font-size: 1.05rem;
  font-weight: 700;
  color: #0d0d1a;
  margin: 0;
  line-height: 1.3;
}

.room-meta-row__price {
  font-size: 1rem;
  font-weight: 700;
  color: #1a56db;
  white-space: nowrap;
  flex-shrink: 0;
}

.room-meta-row__price small {
  font-size: 0.72rem;
  font-weight: 400;
  color: #666;
}

.room-meta-row--compact .room-meta-row__name {
  font-size: 0.95rem;
}

.room-meta-row--compact .room-meta-row__price {
  font-size: 0.8rem;
}

.room-meta-row--compact .room-meta-row__price small {
  font-size: 0.68rem;
}
</style>