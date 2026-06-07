<template>
  <div class="location-map">
    <iframe
      :src="embedSrc"
      :title="title"
      loading="lazy"
      referrerpolicy="no-referrer-when-downgrade"
      class="map-iframe"
    />
    <img
      v-if="printSrc"
      :src="printSrc"
      :alt="title"
      class="map-print"
    />
    <a class="location-map__link" :href="linkHref" target="_blank" rel="noreferrer">
      {{ linkLabel }}
    </a>
  </div>
</template>

<script setup lang="ts">
withDefaults(
  defineProps<{
    embedSrc: string;
    linkHref: string;
    title: string;
    linkLabel?: string;
    printSrc?: string;
  }>(),
  {
    linkLabel: 'Open in OpenStreetMap',
    printSrc: undefined,
  },
);
</script>

<style scoped>
.location-map {
  width: 100%;
  height: 220px;
  background: #dde0e8;
  border-radius: 8px;
  overflow: hidden;
  position: relative;
}

.location-map iframe {
  width: 100%;
  height: 100%;
  border: 0;
  display: block;
}

.map-print {
  display: none;
}

.location-map__link {
  position: absolute;
  left: 12px;
  bottom: 12px;
  background: rgba(255, 255, 255, 0.95);
  color: #111;
  text-decoration: none;
  font-size: 0.8rem;
  font-weight: 600;
  padding: 6px 10px;
  border-radius: 999px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.12);
}

@media print {
  .location-map { display: none; }
}
</style>
