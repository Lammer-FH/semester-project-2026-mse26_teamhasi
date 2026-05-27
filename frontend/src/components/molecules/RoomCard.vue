<template>
  <div class="room-card">
    <room-media :room="room" hoverable />

    <div class="room-body">
      <room-meta-row :room="room" />

      <p class="room-description">{{ room.description }}</p>

      <room-extras-chips :extras="room.extras" />

      <div class="room-footer">
        <span class="room-capacity">
          <BIconPeople class="capacity-icon" />
          {{ room.capacity }} guest{{ room.capacity !== 1 ? 's' : '' }}
        </span>
        <ion-button size="small" color="primary" @click="emit('check-availability', room.id)">
          Check Availability
        </ion-button>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { IonButton } from '@ionic/vue';
import { BIconPeople } from 'bootstrap-icons-vue';
import type { Room } from '@/api/roomApi';
import RoomExtrasChips from '@/components/molecules/RoomExtrasChips.vue';
import RoomMedia from '@/components/molecules/RoomMedia.vue';
import RoomMetaRow from '@/components/molecules/RoomMetaRow.vue';

const props = defineProps<{ room: Room }>();
const emit = defineEmits<{ 'check-availability': [roomId: number] }>();

const room = props.room;
</script>

<style scoped>
.room-card {
  background: #fff;
  border-radius: 12px;
  overflow: hidden;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08);
  display: flex;
  flex-direction: column;
}

.room-body {
  padding: 16px;
  display: flex;
  flex-direction: column;
  gap: 10px;
  flex: 1;
}

.room-description {
  font-size: 0.875rem;
  color: #444;
  line-height: 1.5;
  margin: 0;
  line-clamp: 2;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow: hidden;
}

.room-footer {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: auto;
  padding-top: 4px;
}

.room-capacity {
  display: inline-flex;
  align-items: center;
  gap: 5px;
  font-size: 0.8rem;
  color: #666;
}

.capacity-icon {
  font-size: 1rem;
}
</style>