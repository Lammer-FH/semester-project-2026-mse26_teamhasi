# Briefing für claude.ai — Hotel-Website Prototyp (Lo-Fi)

> **Anleitung:** Diesen kompletten Block (vom horizontalen Strich an) am Anfang **jedes** claude.ai-Chats einfügen, dann den jeweiligen Screen-/System-Prompt anhängen.

---

Du hilfst mir, Lo-Fi-Wireframes für eine Hotel-Website als HTML-Artifacts zu erstellen.
Die Wireframes dienen als Vorlage für die spätere Implementierung mit Vue 3 + Ionic + Atomic Design.

## Kontext

- **Projekt:** Hotelbuchungs-Website (akademisches Semesterprojekt)
- **Hotelname (Platzhalter):** *Hotel Hasi* — kleines Boutique-Hotel, warme Stimmung, „weniger ist mehr"
- **Tech-Stack (für Implementierung später):** Vue 3, Ionic, Pinia, Axios; Backend Spring Boot + MySQL
- **Architektur-Vorgabe:** Atomic Design (Atoms → Molecules → Organisms → Templates → Pages)
- **Zielgruppe:** Reisende, die ein Zimmer suchen und buchen wollen
- **Performance-Erwartung:** ~100 Besucher/Tag

## Stil-Vorgaben (sehr wichtig — bitte strikt einhalten)

- **Lo-Fi Wireframe-Look**, NICHT High-Fidelity-Mockup.
- Nur Graustufen: `#FFFFFF`, `#F5F5F5`, `#E0E0E0`, `#9E9E9E`, `#424242`, `#000000`. **Keine** weiteren Farben.
- Genau **eine Akzentfarbe** für interaktive States/Primary-CTA: schlichtes Blau `#1976D2` (sparsam einsetzen).
- 1 px durchgezogene Outlines in `#9E9E9E`. Bei Image-Placeholdern: Box mit diagonalem Kreuz.
- Keine Schatten, keine Gradients, keine Hintergrundbilder, keine Animationen.
- Lorem-ipsum-Text oder Platzhalter wie `[Hotel Name]`, `[Room Title]`. Keine ausgedachten Marketing-Texte.
- Schrift: System-Sans (z. B. `system-ui, -apple-system, sans-serif`). Eine Schriftfamilie, drei Größen: 12 / 16 / 24 px.
- Spacing-Skala: 4 / 8 / 16 / 24 / 32 px.

## Responsive-Anforderung

Jedes Artifact zeigt drei Frames **nebeneinander** im selben HTML-Dokument:

- **Mobile** 375 × 800 px
- **Tablet** 768 × 1024 px
- **Desktop** 1280 × 900 px

Frames mit Caption ("Mobile / Tablet / Desktop") und sichtbarer Außen-Outline.
**Mobile-first**: das Mobile-Frame ist der Maßstab für Inhalt und Hierarchie, Tablet/Desktop ergänzen.

## States, die immer mitzudenken sind

Bei jeder Seite mit dynamischem Inhalt zusätzliche Frames für:

- **Loading** (Skeleton-Boxes)
- **Empty** (kein Ergebnis / nichts gebucht / etc.)
- **Error** (API down / Validation fehlgeschlagen)

## User Stories (kompakt, mit zugehörigen Requirements)

- **U1 — Hotel präsentieren** (REQ-001 … REQ-010): Statische Seiten Landing, Imprint, About. Hotel-Beschreibung, Bilder, durchgängige Hauptnavigation. Lesbar auf Mobile **und** Desktop.
- **U2 — Zimmer-Übersicht** (REQ-011 … REQ-023): Liste aller Zimmer mit Bild, Titel, Beschreibung, Extras (mit Icons). Max. 5 Zimmer auf erster Seite, Pagination ab Seite 2. Layout muss bei ungerader Anzahl gut aussehen. Bilder mit variablen Größen flexibel.
- **U3 — Verfügbarkeit prüfen** (REQ-024 … REQ-032): Datums-Dialog für Zeitraumauswahl, klares Verfügbarkeits-Feedback, Fehlerbehandlung. Innovativer Ansatz für Periodendefinition gewünscht — ich brauche **2–3 Design-Varianten**.
- **U4 — Buchen** (REQ-033 … REQ-049): Buchungsformular (Vorname, Nachname, E-Mail, E-Mail-Bestätigung, Frühstück Ja/Nein), Validierung (gültige E-Mail, Match), Review-Schritt mit Edit-Möglichkeit, Bestätigungsanzeige. Fehlerfälle dem User klar zeigen.
- **U5 — Erweiterte Bestätigung** (REQ-050 … REQ-059): Erweiterte Confirmation mit Buchungsperiode, Zimmerdetails inkl. Bild, Gastdaten, Anfahrt mit Reisehinweisen (z. B. Bahn), Kontaktoptionen. **Druckfreundliches A4-Layout** als separater Frame.

## Format des Outputs

Ein einziges HTML-File pro Artifact. Aufbau:

```
<header>Titel des Screens, kurze Beschreibung</header>
<section data-frame="mobile">…</section>
<section data-frame="tablet">…</section>
<section data-frame="desktop">…</section>
<section data-state="empty">…</section>      ← falls relevant
<section data-state="error">…</section>      ← falls relevant
```

Frames vertikal gestapelt, jeweils zentriert, mit Caption darüber. Untereinander, damit ich pro Frame einen sauberen Screenshot machen kann.

## Was ich anschließend tue

Ich öffne das Artifact, mache pro Frame einen Screenshot, speichere die PNGs und packe alles zu einer PDF-Abgabe zusammen. Halte die Frames also so, dass sie als einzelne Bilder funktionieren (klare Begrenzung, keine Überlappungen, keine "off-canvas"-Inhalte).

---
