<template>
  <ion-page class="home-page">
    <site-header/>

    <ion-content :fullscreen="true">

      <!-- Hero -->
      <section class="hero">
        <img src="/images/hero.jpg" alt="Hotel Hasi" class="hero-image"/>
        <div class="hero-overlay">
          <div class="hero-body">
            <h1>Hotel Hasi</h1>
            <p>Your perfect stay in the heart of Vienna. Comfort, elegance, and warm hospitality await you.</p>
            <ion-button router-link="/rooms" class="cta">
              View Our Rooms
            </ion-button>
          </div>
        </div>
      </section>

      <!-- About preview -->
      <section class="content-section">
        <div class="container">
          <h2>About the Hotel</h2>
          <div class="about-layout">
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

          <div v-if="store.featuredLoading" class="rooms-loading">
            <ion-spinner name="crescent"/>
          </div>

          <div v-else-if="store.featuredError" class="rooms-error">
            <p>{{ store.featuredError }}</p>
          </div>

          <div v-else class="rooms-grid">
            <router-link
                v-for="room in featuredRooms"
                :key="room.id"
                :to="`/rooms?room=${room.id}`"
                class="preview-card"
            >
              <room-media :room="room" hoverable/>
              <div class="preview-info">
                <room-meta-row :room="room" compact price-prefix="from €"/>
              </div>
            </router-link>
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
            <span class="contact-value">Höchstädtplatz 1, 1200 Wien</span>
            <span class="contact-label">TEL</span>
            <a href="tel:+4312345678" class="contact-value">+43 1 234 5678</a>
            <span class="contact-label">E-MAIL</span>
            <a href="mailto:kontakt@hotel-hasi.at" class="contact-value">kontakt@hotel-hasi.at</a>
          </div>
          <location-map
              title="Hotel Hasi location on OpenStreetMap"
              embed-src="https://www.openstreetmap.org/export/embed.html?bbox=16.371%2C48.236%2C16.381%2C48.243&layer=mapnik&marker=48.239378%2C16.376495"
              link-href="https://www.openstreetmap.org/?mlat=48.239378&mlon=16.376495#map=19/48.239378/16.376495"
          />
        </div>
      </section>

      <site-footer/>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import {computed} from 'vue';
import {IonButton, IonContent, IonPage, IonSpinner, onIonViewWillEnter} from '@ionic/vue';
import SiteHeader from '@/components/organisms/SiteHeader.vue';
import SiteFooter from '@/components/organisms/SiteFooter.vue';
import LocationMap from '@/components/organisms/LocationMap.vue';
import RoomMedia from '@/components/molecules/RoomMedia.vue';
import RoomMetaRow from '@/components/molecules/RoomMetaRow.vue';
import {useRoomStore} from '@/stores/roomStore';

const store = useRoomStore();

// Pick the first 5 rooms with distinct cover images
const featuredRooms = computed(() => {
  const seen = new Set<string>();
  const result = [];
  for (const room of store.featured) {
    const cover = room.roomType?.media?.[0]?.path ?? `__none_${room.id}`;
    if (!seen.has(cover)) {
      seen.add(cover);
      result.push(room);
      if (result.length === 4) break;
    }
  }
  return result;
});

// Only fetches on first visit — subsequent navigations use cached data
onIonViewWillEnter(() => store.fetchFeatured());
</script>

<style>
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
  --background: #e5e5e5;
  --color: #111111;
  --border-color: #111111;
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

/* About */
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

/* Rooms grid */
.rooms-loading,
.rooms-error {
  text-align: center;
  padding: 32px 0;
  color: #666;
}

.rooms-grid {
  display: grid;
  grid-template-columns: 1fr;
  gap: 16px;
  margin-bottom: 20px;
}

/* Preview card link */
.preview-card {
  display: block;
  text-decoration: none;
  background: white;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.07);
  transition: box-shadow 0.2s ease, transform 0.2s ease;
}

.preview-card:hover {
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.13);
  transform: translateY(-2px);
}

.preview-info {
  padding: 10px 14px 12px;
}

.rooms-link {
  --border-color: #111111;
  --color: #111111;
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
