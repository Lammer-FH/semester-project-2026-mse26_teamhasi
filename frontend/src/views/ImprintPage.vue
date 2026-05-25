<template>
  <ion-page>
    <site-header />

    <ion-content :fullscreen="true">

      <section class="content-section">
        <h1>Imprint</h1>

        <h2>Operator</h2>
        <p>
          Hotel Hasi GmbH<br>
          Technikumstraße 1<br>
          1200 Wien<br>
          Austria
        </p>

        <h2>Contact</h2>
        <p>
          Tel: <a href="tel:+4312345678">+43 1 234 5678</a><br>
          E-Mail: <a href="mailto:kontakt@hotel-hasi.at">kontakt@hotel-hasi.at</a>
        </p>

        <h2>Company Registration</h2>
        <p>
          Commercial Register: FN 123456 a<br>
          Commercial Court: Handelsgericht Wien<br>
          VAT Number: ATU12345678
        </p>

        <h2>Regulatory Authority</h2>
        <p>
          Magistrat der Stadt Wien<br>
          Gewerbebehörde
        </p>

        <h2>Disclaimer</h2>
        <p>
          Despite careful content control, we assume no liability for the content of external links.
          The operators of linked pages are solely responsible for their content.
        </p>

        <h2>Copyright</h2>
        <p>
          All content on this website — including texts, images, and graphics — is protected by copyright.
          Reproduction or use without prior written consent is not permitted.
        </p>
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

.content-section h1 {
  font-size: 1.8rem;
  font-weight: 700;
  margin: 0 0 24px;
  color: #0d0d1a;
}

.content-section h2 {
  font-size: 1rem;
  font-weight: 700;
  margin: 20px 0 6px;
  color: #0d0d1a;
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

.content-section p {
  color: #111111;
  line-height: 1.6;
  margin: 0;
}

.content-section a {
  color: #111111;
  text-decoration: none;
}
</style>
