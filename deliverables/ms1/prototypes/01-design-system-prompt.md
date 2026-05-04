# Prompt — Design System (Atomic Design Foundation)

> **Anleitung:** In claude.ai erst das `00-briefing.md` einfügen, dann diesen Block. Output: ein HTML-Artifact mit allen Atomen und Basis-Molecules.

---

Erstelle als HTML-Artifact ein Lo-Fi-Design-System für die Hotel-Website. Es muss alle Atome und Molecules zeigen, die in den Screens U1–U5 vorkommen werden. Ein einziges HTML-Dokument, alle Komponenten auf einer Seite, klar gegliedert in Sektionen.

## Sektionen

### 1. Tokens
- **Color**: 6 Graustufen + Akzent-Blau, jeweils als Swatch mit HEX-Wert
- **Spacing**: Skala 4 / 8 / 16 / 24 / 32 px, visualisiert als Boxen
- **Typography**: drei Größen (12 / 16 / 24 px) als Beispiele mit Label
- **Radius**: 0 px (alles eckig — Wireframe-Stil)
- **Border**: 1 px solid `#9E9E9E`, Beispiel-Box

### 2. Atoms
Jeweils mit Label und Variants (Default / Hover / Disabled, soweit sinnvoll):

- **Button** — Primary, Secondary, Ghost, Icon-Only
- **Input** — Text, Email, Date, Number, Disabled, Error (mit Hint-Text)
- **Checkbox** — unchecked / checked / disabled
- **Radio** — unchecked / checked / disabled
- **Toggle / Switch**
- **Label** + **Helper-Text** + **Error-Text**
- **Badge** — neutral, success, warning (alle in Graustufen + Akzent)
- **Icon-Placeholder** — kleines Quadrat mit Outline und einem zentrierten Buchstaben (`i`, `?`, `>`, `×`, `🛏`, `🚿`, `📶` etc. textuell als Platzhalter)
- **Image-Placeholder** — Box mit diagonalem Kreuz, drei Größen (S/M/L)
- **Link** — default, hover (unterstrichen)
- **Divider**
- **Loader / Spinner** — als statischer Kreis

### 3. Molecules
- **Form-Field** = Label + Input + Helper/Error
- **Card** = Image-Placeholder + Title + Body + Action-Slot
- **Room-Card** = horizontale + vertikale Variante (für Listing)
- **Pagination** = `‹ 1 2 3 …›`
- **Breadcrumb** = `Home › Rooms › Detail`
- **Date-Range-Picker** — drei Varianten **A / B / C** für U3:
  - A: Klassischer Two-Month-Calendar
  - B: Horizontaler Stepper (Anreise/Abreise als zwei separate Schritte)
  - C: "Stay length"-Slider + Start-Datum
- **Toast / Banner** — info, success, error
- **Modal / Dialog** — leerer Frame mit Header / Body / Footer
- **Empty-State** = Icon-Placeholder + Headline + Body + Optional CTA
- **Loading-Skeleton** — drei rechteckige animationslose Boxen
- **Stepper** — 3 Schritte horizontal (Form / Review / Confirmation)

### 4. Organisms (kompakt anreißen)
- **Header / Top-Nav** — Logo links, Menü rechts (Mobile als Burger)
- **Footer** — drei Spalten Kontakt / Links / Rechtliches
- **Section-Header** — H1 + Subtitle + Action

## Rendering

- Alles in einem HTML-File, komplette Komponenten-Bibliothek scrollbar untereinander.
- Pro Sektion eine 24 px große Überschrift, darunter ein 1-px-Divider.
- Komponenten in einem 16-px-Grid angeordnet.
- Maximal 1280 px breit, zentriert.
- Inline-CSS oder `<style>`-Block, kein externer Framework-Import.
