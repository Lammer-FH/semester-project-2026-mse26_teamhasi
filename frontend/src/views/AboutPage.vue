<template>
  <ion-page class="about-page">
    <site-header />

    <ion-content :fullscreen="true">

      <section class="content-section">
        <h1>About Hotel Hasi</h1>
        <img src="/images/about.jpg" alt="Hotel Hasi" class="section-image" />
        <p>
          Hotel Hasi is a boutique hotel located in the heart of Vienna's 20th district.
          Since opening in 2010, we have welcomed guests from around the world with
          warm Austrian hospitality and a commitment to quality.
        </p>
        <p>
          Our 24 individually designed rooms blend classic Viennese elegance with
          modern comforts. Whether you are visiting for business or leisure, we ensure
          every stay is memorable.
        </p>
      </section>

      <section class="content-section alt-bg">
        <h2>Our Philosophy</h2>
        <p>
          We believe that a great hotel stay is about more than just a room. It is about
          the quality of the welcome, the comfort of your surroundings, and the ease
          with which you can explore everything Vienna has to offer.
        </p>
        <p>
          Our team is dedicated to making your stay as comfortable and enjoyable as
          possible — from recommendations for local restaurants to arranging transport
          to Vienna International Airport.
        </p>
      </section>

      <section class="content-section">
        <h2>Location</h2>
        <img src="/images/hero.jpg" alt="Hotel location" class="section-image" />
        <p>
          We are situated at Technikumstraße 1, just a short walk from the Handelskai
          U-Bahn station. The city centre, Prater, and Donauinsel are all within easy reach.
        </p>
        <div class="contact-grid">
          <span class="contact-label">ADDRESS</span>
          <span class="contact-value">Technikumstraße 1, 1200 Wien</span>
          <span class="contact-label">TEL</span>
          <a href="tel:+4312345678" class="contact-value">+43 1 234 5678</a>
          <span class="contact-label">E-MAIL</span>
          <a href="mailto:kontakt@hotel-hasi.at" class="contact-value">kontakt@hotel-hasi.at</a>
        </div>
      </section>

      <site-footer />
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonContent } from '@ionic/vue';
import SiteHeader from '@/components/organisms/SiteHeader.vue';
import SiteFooter from '@/components/organisms/SiteFooter.vue';
</script>

<style scoped>
.content-section {
  padding: 28px 20px;
  background-color: #ffffff;
}

.alt-bg {
  background-color: #f0f0f3;
}

.content-section h1 {
  font-size: 1.8rem;
  font-weight: 700;
  margin: 0 0 16px;
  color: #0d0d1a;
}

.content-section h2 {
  font-size: 1.4rem;
  font-weight: 700;
  margin: 0 0 12px;
  color: #0d0d1a;
}

.section-image {
  width: 100%;
  max-width: 480px;
  aspect-ratio: 16 / 9;
  object-fit: cover;
  border-radius: 8px;
  margin-bottom: 16px;
  display: block;
}

.content-section p {
  color: #111111;
  line-height: 1.6;
  margin: 0 0 12px;
}

.contact-grid {
  display: grid;
  grid-template-columns: auto 1fr;
  gap: 10px 16px;
  margin-top: 16px;
  align-items: center;
}

.contact-label {
  font-size: 0.75rem;
  font-weight: 800;
  letter-spacing: 0.8px;
  color: #111111;
}

.contact-value {
  color: #111111;
  font-size: 1rem;
  text-decoration: none;
}
</style>

<style>
.about-page ion-content {
  --background: #ffffff;
  --color: #111111;
}
</style>