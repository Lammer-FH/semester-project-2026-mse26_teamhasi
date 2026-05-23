<template>
  <ion-app>
    <ion-menu content-id="main-content" side="end">
      <ion-header>
        <ion-toolbar>
          <ion-title>Hotel Hasi</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-content>
        <ion-list lines="none">
          <ion-item button router-link="/" @click="menuController.close()">
            <ion-label>Home</ion-label>
          </ion-item>
          <ion-item button router-link="/rooms" @click="menuController.close()">
            <ion-label>Rooms</ion-label>
          </ion-item>
          <ion-item button router-link="/about" @click="menuController.close()">
            <ion-label>About</ion-label>
          </ion-item>
          <ion-item button router-link="/imprint" @click="menuController.close()">
            <ion-label>Imprint</ion-label>
          </ion-item>
        </ion-list>
      </ion-content>
    </ion-menu>
    <ion-router-outlet id="main-content" />
  </ion-app>
</template>

<script setup lang="ts">
import {
  IonApp, IonRouterOutlet, IonMenu, IonHeader, IonToolbar, IonTitle,
  IonContent, IonList, IonItem, IonLabel, menuController,
} from '@ionic/vue';
</script>
