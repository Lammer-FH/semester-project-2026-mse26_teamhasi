<template>
  <div class="room-media" :class="{ 'room-media--hoverable': hoverable }">
    <img
      v-if="coverMedia"
      :src="coverMedia.path"
      :alt="coverMedia.alt_text || props.room.name"
      class="room-media__image"
      loading="lazy"
    />
    <div v-else class="room-media__placeholder" />
  </div>
</template>

<script setup lang="ts">
import { computed } from 'vue';
import type { Room } from '@/api/roomApi';

const props = withDefaults(defineProps<{ room: Room; hoverable?: boolean }>(), {
  hoverable: false,
});

const coverMedia = computed(() => props.room.media[0] ?? null);
</script>

<style scoped>
.room-media {
  width: 100%;
  aspect-ratio: 16 / 9;
  overflow: hidden;
  background: #e8e8ee;
  flex-shrink: 0;
}

.room-media--hoverable .room-media__image {
  transition: transform 0.3s ease;
}

.room-media--hoverable:hover .room-media__image {
  transform: scale(1.04);
}

.room-media__image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  object-position: center;
  display: block;
}

.room-media__placeholder {
  width: 100%;
  height: 100%;
  background: #dde0e8;
}
</style>