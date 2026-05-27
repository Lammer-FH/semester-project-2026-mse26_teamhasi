<template>
  <div v-if="visible" class="pagination">
    <span class="page-info">{{ pageLabel }}</span>
    <ion-buttons>
      <ion-button :disabled="prevDisabled" @click="$emit('prev')">
        Previous
      </ion-button>
      <ion-button :disabled="nextDisabled" @click="$emit('next')">
        Next
      </ion-button>
    </ion-buttons>
  </div>
</template>

<script setup lang="ts">
import { IonButton, IonButtons } from '@ionic/vue';

defineProps<{
  pageLabel: string;
  prevDisabled: boolean;
  nextDisabled: boolean;
  visible?: boolean;
}>();

defineEmits<{
  prev: [];
  next: [];
}>();
</script>

<style scoped>
.pagination {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
}

.page-info {
  font-size: 0.875rem;
  color: #555;
  min-width: 90px;
  text-align: center;
}
</style>