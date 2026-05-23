<template>
  <ion-page class="home-page">
    <site-header />

    <ion-content :fullscreen="true">

      <!-- Hero -->
      <section class="hero">
        <img src="/images/hero.jpg" alt="Hotel Hasi" class="hero-image" />
        <div class="hero-overlay">
          <div class="hero-body">
            <h1>Hotel Hasi</h1>
            <p>Your perfect stay in the heart of Vienna. Comfort, elegance, and warm hospitality await you.</p>
            <ion-button router-link="/rooms" class="cta">
              Check Availability
            </ion-button>
          </div>
        </div>
      </section>

      <!-- About preview -->
      <section class="content-section">
        <div class="container">
          <h2>About the Hotel</h2>
          <div class="about-layout">
            <img src="/images/about.jpg" alt="About Hotel Hasi" class="section-image" />
            <div class="about-text">
              <p>
                Hotel Hasi is a boutique hotel nestled in the vibrant 20th district of Vienna.
                Founded in 2010, we pride ourselves on offering an intimate atmosphere, personalized
                service, and beautifully appointed rooms — all within easy reach of the city's best attractions.
              </p>
              <router-link to="/about" class="text-link">Learn more →</router-link>
            </div>
          </div>
        </div>
      </section>

      <!-- Rooms preview -->
      <section class="content-section alt-bg">
        <div class="container">
          <h2>Our Rooms</h2>
          <div class="rooms-grid">
            <div class="room-card">
              <img src="/images/room1.jpg" alt="Superior Double Room" class="room-image" />
              <p class="room-title">Superior Double Room</p>
            </div>
            <div class="room-card">
              <img src="/images/room2.jpg" alt="Deluxe Suite" class="room-image" />
              <p class="room-title">Deluxe Suite</p>
            </div>
          </div>
          <ion-button router-link="/rooms" fill="outline" class="rooms-link">
            View All Rooms
          </ion-button>
        </div>
      </section>

      <!-- Contact -->
      <section class="content-section">
        <div class="container">
          <h2>Contact</h2>
          <div class="contact-grid">
            <span class="contact-label">ADDRESS</span>
            <span class="contact-value">Technikumstraße 1, 1200 Wien</span>
            <span class="contact-label">TEL</span>
            <a href="tel:+4312345678" class="contact-value">+43 1 234 5678</a>
            <span class="contact-label">E-MAIL</span>
            <a href="mailto:kontakt@hotel-hasi.at" class="contact-value">kontakt@hotel-hasi.at</a>
          </div>
          <div class="map-placeholder">Map</div>
        </div>
      </section>

      <site-footer />
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonContent, IonButton } from '@ionic/vue';
import SiteHeader from '@/components/organisms/SiteHeader.vue';
import SiteFooter from '@/components/organisms/SiteFooter.vue';
</script>

<style>
/* unscoped: overrides Ionic's ion-content background globally on this page */
.home-page ion-content {
  --background: #ffffff;
  --color: #111111;
}
</style>

<style scoped>
/* Hero */
.hero {
  position: relative;
  height: 480px;
  overflow: hidden;
}

.hero-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  object-position: center;
  display: block;
}

.hero-overlay {
  position: absolute;
  inset: 0;
  background: linear-gradient(to top, rgba(10, 10, 30, 0.85) 0%, rgba(10, 10, 30, 0.3) 60%, transparent 100%);
  display: flex;
  align-items: flex-end;
}

.hero-body {
  padding: 32px 24px;
  color: white;
  width: 100%;
  max-width: 640px;
}

.hero-body h1 {
  font-size: 2.2rem;
  font-weight: 700;
  margin: 0 0 10px;
}

.hero-body p {
  color: rgba(255, 255, 255, 0.88);
  line-height: 1.6;
  margin: 0 0 20px;
  font-size: 1rem;
}

.cta {
  --background: #e2a84b;
  --color: #1a1a2e;
  --border-radius: 8px;
  font-weight: 600;
}

/* Sections */
.content-section {
  padding: 40px 20px;
  background-color: #ffffff;
}

.alt-bg {
  background-color: #f0f0f3;
}

.container {
  max-width: 800px;
  margin: 0 auto;
}

.content-section h2 {
  font-size: 1.5rem;
  font-weight: 700;
  margin: 0 0 20px;
  color: #0d0d1a;
}

/* About layout: stacked on mobile, side-by-side on desktop */
.about-layout {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.section-image {
  width: 100%;
  aspect-ratio: 4 / 3;
  object-fit: cover;
  border-radius: 10px;
  display: block;
}

.about-text p {
  color: #111;
  line-height: 1.7;
  margin: 0 0 14px;
  font-size: 1rem;
}

.text-link {
  color: #1a56db;
  text-decoration: underline;
  font-weight: 600;
}

/* Room cards: 1 column mobile, 2 columns desktop */
.rooms-grid {
  display: grid;
  grid-template-columns: 1fr;
  gap: 16px;
  margin-bottom: 20px;
}

.room-card {
  background: white;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 2px 8px rgba(0,0,0,0.07);
}

.room-image {
  width: 100%;
  aspect-ratio: 16 / 9;
  object-fit: cover;
  display: block;
}

.room-title {
  font-weight: 600;
  color: #0d0d1a;
  margin: 10px 14px 12px;
}

.rooms-link {
  --border-color: #0d0d1a;
  --color: #0d0d1a;
  --border-radius: 8px;
}

/* Contact */
.contact-grid {
  display: grid;
  grid-template-columns: auto 1fr;
  gap: 10px 16px;
  margin-bottom: 20px;
  align-items: center;
}

.contact-label {
  font-size: 0.75rem;
  font-weight: 800;
  letter-spacing: 0.8px;
  color: #111;
}

.contact-value {
  color: #111;
  font-size: 1rem;
  text-decoration: none;
}

.map-placeholder {
  width: 100%;
  height: 180px;
  background: #dde0e8;
  border-radius: 8px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #999;
  font-size: 0.9rem;
}

/* Desktop */
@media (min-width: 768px) {
  .hero {
    height: 560px;
  }

  .about-layout {
    flex-direction: row;
    align-items: flex-start;
    gap: 32px;
  }

  .section-image {
    width: 340px;
    flex-shrink: 0;
  }

  .rooms-grid {
    grid-template-columns: 1fr 1fr;
  }
}
</style>