<template>
  <footer class="site-footer">
    <div class="footer-columns">
      <div class="footer-col">
        <h4>HOTEL</h4>
        <router-link to="/rooms">Rooms</router-link>
        <router-link to="/about">About</router-link>
        <router-link to="/imprint">Imprint</router-link>
      </div>
      <div class="footer-col">
        <h4>CONTACT</h4>
        <a href="tel:+4312345678">Tel · +43 1 234 5678</a>
        <a href="mailto:kontakt@hotel-hasi.at">Mail · kontakt@hotel-hasi.at</a>
      </div>
    </div>
    <div class="footer-copy">© Hotel Hasi · Technikumstraße 1, 1200 Wien</div>
  </footer>
</template>

<script setup lang="ts">
</script>

<style scoped>
.site-footer {
  background: #1a1a2e;
  color: #ccc;
  padding: 32px 24px 24px;
}

.footer-columns {
  display: flex;
  gap: 32px;
  flex-wrap: wrap;
  margin-bottom: 24px;
}

.footer-col {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.footer-col h4 {
  color: white;
  font-size: 0.75rem;
  font-weight: 700;
  letter-spacing: 1px;
  margin: 0 0 4px;
}

.footer-col a {
  color: #a0a0c0;
  text-decoration: none;
  font-size: 0.9rem;
}

.footer-col a:hover {
  color: white;
}

.footer-copy {
  font-size: 0.8rem;
  color: #666;
  border-top: 1px solid #2a2a4a;
  padding-top: 16px;
}
</style>
