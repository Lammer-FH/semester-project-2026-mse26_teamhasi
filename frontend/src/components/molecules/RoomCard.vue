<template>
    <div class="room-card">
        <div class="room-image-wrap">
            <img v-if="room.media.length"
                 :src="room.media[0].path"
                 :alt="room.media[0].alt_text"
                 class="room-image"
                 loading="lazy" />
            <div v-else class="room-image-placeholder" />
        </div>

        <div class="room-body">
            <div class="room-header">
                <h3 class="room-name">{{ room.name }}</h3>
                <span class="room-price">€{{ room.price_per_night.toFixed(2) }}<small>/night</small></span>
            </div>

            <p class="room-description">{{ room.description }}</p>

            <div v-if="room.extras.length" class="room-extras">
                <span v-for="extra in room.extras" :key="extra.name" class="extra-chip" :title="extra.name">
                    <component :is="iconMap[extra.icon_key] ?? BIconStar" class="extra-icon" />
                    <span class="extra-label">{{ extra.name }}</span>
                </span>
            </div>

            <div class="room-footer">
                <span class="room-capacity">
                    <BIconPeople class="capacity-icon" />
                    {{ room.capacity }} guest{{ room.capacity !== 1 ? 's' : '' }}
                </span>
                <ion-button size="small" color="primary" @click="$emit('check-availability', room.id)">
                    Check Availability
                </ion-button>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
    import type { Component } from 'vue';
    import { IonButton } from '@ionic/vue';
    import {
        BIconWifi,
        BIconCupHot,
        BIconSafe,
        BIconDoorOpen,
        BIconDroplet,
        BIconWater,
        BIconGeoAlt,
        BIconBuildings,
        BIconPeople,
        BIconStar,
    } from 'bootstrap-icons-vue';
    import type { Room } from '@/api/roomApi';

    defineProps<{ room: Room }>();
    defineEmits<{ 'check-availability': [roomId: number] }>();

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
    .room-card {
        background: #fff;
        border-radius: 12px;
        overflow: hidden;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08);
        display: flex;
        flex-direction: column;
    }

    /* Fixed aspect-ratio box: any image dimension crops to 16:9 */
    .room-image-wrap {
        width: 100%;
        aspect-ratio: 16 / 9;
        overflow: hidden;
        background: #e8e8ee;
        flex-shrink: 0;
    }

    .room-image {
        width: 100%;
        height: 100%;
        object-fit: cover;
        object-position: center;
        display: block;
        transition: transform 0.3s ease;
    }

    .room-card:hover .room-image {
        transform: scale(1.03);
    }

    .room-image-placeholder {
        width: 100%;
        height: 100%;
        background: #dde0e8;
    }

    .room-body {
        padding: 16px;
        display: flex;
        flex-direction: column;
        gap: 10px;
        flex: 1;
    }

    .room-header {
        display: flex;
        justify-content: space-between;
        align-items: flex-start;
        gap: 8px;
    }

    .room-name {
        font-size: 1.05rem;
        font-weight: 700;
        color: #0d0d1a;
        margin: 0;
        line-height: 1.3;
    }

    .room-price {
        font-size: 1rem;
        font-weight: 700;
        color: #1a56db;
        white-space: nowrap;
        flex-shrink: 0;
    }

        .room-price small {
            font-size: 0.72rem;
            font-weight: 400;
            color: #666;
        }

    .room-description {
        font-size: 0.875rem;
        color: #444;
        line-height: 1.5;
        margin: 0;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
        overflow: hidden;
    }

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