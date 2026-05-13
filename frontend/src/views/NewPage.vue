<template>
    <ion-page>
        <ion-header :translucent="true">
            <ion-toolbar>
                <ion-buttons slot="start">
                    <ion-back-button default-href="/"></ion-back-button>
                </ion-buttons>
                <ion-title>New</ion-title>
            </ion-toolbar>
        </ion-header>

        <ion-content ref="content">
            <ion-button @click="scrollToBottom">Scroll to Bottom</ion-button>

            <!-- Add lots of content to make scrolling possible -->
            <ion-item v-for="i in 50" :key="i">
                <ion-label>Item {{ i }}</ion-label>
            </ion-item>
        </ion-content>
    </ion-page>
</template>

<script setup lang="ts">
import {
  IonBackButton,
  IonButtons,
  IonButton,
  IonContent,
  IonHeader,
  IonIcon,
  IonItem,
  IonLabel,
  IonPage,
  IonTitle,
  IonToolbar,
} from '@ionic/vue';
import { heart, logoIonic } from 'ionicons/icons';
import { ref } from 'vue';

const content = ref();

const scrollToBottom = () => {
  content.value.$el.scrollToBottom(300);
};
</script>