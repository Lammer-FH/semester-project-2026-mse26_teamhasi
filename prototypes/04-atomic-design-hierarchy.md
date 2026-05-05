# Atomic Design Hierarchie

Erfüllt REQ-010, REQ-069 und das Acceptance-Kriterium *"Atomic Design hierarchy identified (atoms, molecules, organisms)"*.

Diese Hierarchie ist die verbindliche Komponenten-Karte für die Implementierung in MS2 (Vue 3 + Ionic). Jede Komponente, die in den Wireframes auftaucht, ist hier eingeordnet.

## Atoms

Kleinste, nicht weiter zerlegbare UI-Bausteine.

| Atom | Verwendet in (Stories) | Notiz |
|---|---|---|
| Button (Primary) | U1, U2, U3, U4, U5 | CTA „Verfügbarkeit prüfen", „Buchung abschließen" |
| Button (Secondary) | U2, U4 | „Zurück", „Abbrechen" |
| Button (Ghost) | U1 | Footer-Links als Buttons |
| Button (Icon-Only) | U2, U3 | Pagination-Pfeile, Calendar-Navigation |
| Input (Text) | U4 | Vor- und Nachname |
| Input (Email) | U4 | E-Mail + Bestätigung |
| Input (Date) | U3 | Anreise / Abreise |
| Input (Number) | U2 | Personenzahl-Filter |
| Toggle / Switch | U4 | Frühstück Ja/Nein |
| Checkbox | — | Reserviert für AGB-Akzept (optional) |
| Radio | U3 | Variant-Auswahl (intern), Frühstücks-Optionen |
| Slider | U3 (Variante C) | Aufenthaltsdauer |
| Label | überall | Form-Labels |
| Helper-Text | U4 | Hinweise unter Feldern |
| Error-Text | U4 | Validation-Messages |
| Badge | U2 | Extras-Tags |
| Icon (Placeholder) | U2, U5 | WLAN, Frühstück, TV, Map-Pin |
| Image-Placeholder | U1, U2, U5 | Hero, Room-Cards, Confirmation |
| Link | U1, U5 | Footer, Bearbeiten-Links |
| Divider | überall | Section-Trenner |
| Loader / Spinner | U2, U3, U4 | Loading-Feedback |
| Avatar-Placeholder | U1 | About-Team |

## Molecules

Funktionale Kombinationen aus Atomen.

| Molecule | Aus Atomen | Verwendet in |
|---|---|---|
| Form-Field | Label + Input + Helper-/Error-Text | U4 |
| Card | Image + Title + Body + Action-Slot | U1, U5 |
| Room-Card (horizontal) | Image + Title + Body + Badges + Button | U2 |
| Room-Card (vertikal) | Image + Title + Body + Badges + Button | U2 |
| Pagination | Icon-Buttons + Number-Buttons | U2 |
| Breadcrumb | Links + Trenner | U2, U4, U5 |
| Date-Range-Picker A (Calendar) | Inputs + Calendar-Grid + Buttons | U3 |
| Date-Range-Picker B (Stepper) | Inputs + Stepper + Buttons | U3 |
| Date-Range-Picker C (Slider) | Input + Slider + Output | U3 |
| Toast / Banner | Icon + Text + ggf. Button | U2, U3, U4 |
| Modal / Dialog | Header + Body + Footer | U3 |
| Empty-State | Icon + Headline + Body + CTA | U2 |
| Loading-Skeleton | Boxes + Lines | U2, U4 |
| Stepper | Steps mit Labels | U4 |
| Search/Filter-Bar | Inputs + Buttons | U2 |
| Booking-Summary | Card + KV-List | U4, U5 |

## Organisms

Eigenständige UI-Bereiche, kombinieren mehrere Molecules.

| Organism | Aus Molecules / Atomen | Verwendet in |
|---|---|---|
| Site-Header | Logo + Nav-Links + Burger | überall |
| Site-Footer | Link-Listen + Kontakt-Block | überall |
| Hero | Image + Headline + CTA | U1 (Landing) |
| Room-List | mehrere Room-Cards + Pagination | U2 |
| Filter-Panel | Filter-Bar + Date-Picker | U2 |
| Availability-Dialog | Date-Picker (A/B/C) + Feedback-Banner | U3 |
| Booking-Form | Stepper + Form-Fields + Booking-Summary | U4 |
| Booking-Review | Stepper + Read-only-Daten + Booking-Summary | U4 |
| Confirmation-Card | Banner + KV-List + Buttons | U4 (kurz) |
| Confirmation-Detail | Sections (Buchung/Zimmer/Daten/Anfahrt/Kontakt) | U5 |
| Print-Layout | Confirmation-Detail ohne Header/Footer | U5 |
| Directions-Block | Map-Placeholder + Anfahrtstext | U5 |

## Templates

Layout-Skelette ohne konkrete Inhalte.

| Template | Slots | Stories |
|---|---|---|
| Default-Page | Header / Main / Footer | U1, U2, U3, U4, U5 |
| Form-Page | Header / Main (Form + Sidebar Summary) / Footer | U4 |
| Confirmation-Page | Header / Main (mehrere Sections) / Footer | U5 |
| Print-Page | Reduzierter Header / Main / Reduzierter Footer | U5 |

## Pages

Konkrete Instanzen mit echten Daten / Routen.

| Page | Route | Template | Stories |
|---|---|---|---|
| Landing | `/` | Default-Page | U1 |
| About | `/about` | Default-Page | U1 |
| Imprint | `/imprint` | Default-Page | U1 |
| Rooms | `/rooms` | Default-Page | U2 |
| Booking-Form | `/booking` | Form-Page | U4 |
| Booking-Review | `/booking/review` | Form-Page | U4 |
| Booking-Confirmation | `/booking/confirmation/:id` | Default-Page | U4 |
| Booking-Detail | `/bookings/:id` | Confirmation-Page | U5 |
| Booking-Print | `/bookings/:id/print` | Print-Page | U5 |

## Mapping zu Vue/Ionic-Komponenten (Vorgriff für MS2)

- Atoms → großteils Ionic-Components (`ion-button`, `ion-input`, `ion-toggle`) oder eigene `Hsi*Atom`-Komponenten.
- Molecules → eigene Komponenten unter `src/components/molecules/`.
- Organisms → unter `src/components/organisms/`.
- Templates → Layout-Komponenten in `src/layouts/`.
- Pages → Vue-Routen in `src/views/` mit Pinia-Stores für U3 (Availability) und U4 (Booking).
