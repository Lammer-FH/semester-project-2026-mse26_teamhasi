<template>
  <div v-if="extras.length" class="room-extras">
    <span v-for="extra in extras" :key="`${extra.iconKey}-${extra.name}`" class="extra-chip" :title="extra.name">
      <component :is="iconMap[extra.iconKey ?? ''] ?? BIconStar" class="extra-icon" />
      <span class="extra-label">{{ extra.name }}</span>
    </span>
  </div>
</template>

<script setup lang="ts">
import type { Component } from 'vue';
import {
  BIconWifi,
  BIconCupHot,
  BIconSafe,
  BIconDoorOpen,
  BIconDroplet,
  BIconWater,
  BIconGeoAlt,
  BIconBuildings,
  BIconStar,
} from 'bootstrap-icons-vue';
import type { RoomExtraDto } from '@/generated/model';

defineProps<{ extras: RoomExtraDto[] }>();

const iconMap: Record<string, Component> = {
  wifi: BIconWifi,
  minibar: BIconCupHot,
  safe: BIconSafe,
  balcony: BIconDoorOpen,
  bathtub: BIconDroplet,
  seaview: BIconWater,
  mountain: BIconGeoAlt,
  cityview: BIconBuildings,
};
</script>

<style scoped>
.room-extras {
  display: flex;
  flex-wrap: wrap;
  gap: 6px;
}

.extra-chip {
  display: inline-flex;
  align-items: center;
  gap: 5px;
  background: #f0f0f3;
  border-radius: 6px;
  padding: 3px 9px;
  font-size: 0.75rem;
  color: #333;
}

.extra-icon {
  font-size: 0.85rem;
  color: #555;
  flex-shrink: 0;
}
</style>
