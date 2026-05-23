<template>
  <ion-header :translucent="true">
    <ion-toolbar>
      <ion-title router-link="/" class="logo">HOTEL HASI</ion-title>
      <ion-buttons slot="end">
        <ion-menu-button />
      </ion-buttons>
    </ion-toolbar>
  </ion-header>
</template>

<script setup lang="ts">
import { IonHeader, IonToolbar, IonTitle, IonButtons, IonMenuButton } from '@ionic/vue';
</script>

<style scoped>
.logo {
  cursor: pointer;
  font-weight: 700;
  letter-spacing: 1px;
}
</style>
