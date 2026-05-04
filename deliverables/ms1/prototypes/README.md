# MS1-03 — UI Prototypes & Wireframes

Arbeits- und Anleitungsmappe für das Backlog-Item `MS1-03-ui-prototypes.md`.
Stil: **Lo-Fi Wireframes** (Graustufen, Outline, Platzhaltertext).
Tooling: **claude.ai** (Artifacts, ggf. `claude.ai/design`).

## Inhalt dieses Ordners

| Datei | Zweck |
|---|---|
| `README.md` | Diese Anleitung + Schritt-für-Schritt-Workflow |
| `00-briefing.md` | Kontext-Block, der **am Anfang jedes claude.ai-Chats** eingefügt wird |
| `01-design-system-prompt.md` | Prompt für das Atomic-Design-Foundation-Artifact |
| `02-screen-prompts.md` | Prompts für U1–U5 (ein Block pro User Story) |
| `screens/` | Ziel-Ordner für die exportierten PNG-Screenshots (anlegen) |

---

## Schritt-für-Schritt-Anleitung

### Schritt 0 — Vorbereitung (5 min)

1. `00-briefing.md` öffnen und durchlesen.
2. Wenn ihr den Hotelnamen, einen Slogan oder eine Stimmung anpassen wollt: jetzt im Briefing ändern. Alle weiteren Schritte arbeiten mit dieser Datei als Single Source of Truth.
3. Im `prototypes/`-Ordner einen Unterordner `screens/` anlegen.

### Schritt 1 — Design System erzeugen (20 min)

1. Auf [claude.ai](https://claude.ai) anmelden, **neuen Chat** öffnen. (Modell: aktuelle Sonnet- oder Opus-Variante. `claude.ai/design` ist eine alternative Oberfläche, die direkt auf Design-Artifacts optimiert ist – für diesen Schritt ideal.)
2. Inhalt von `00-briefing.md` als ersten Prompt einfügen.
3. **Direkt darunter** den Prompt aus `01-design-system-prompt.md` einfügen und absenden.
4. Es entsteht ein HTML-Artifact mit allen Atomen + Basis-Molecules.
5. Iterieren mit Folge-Prompts wie:
   - *"Mach die Buttons noch eckiger und entfern alle Schatten – soll wie Wireframe aussehen."*
   - *"Füge eine Empty-State-Komponente und einen Toast hinzu."*
6. **Screenshot** (375 px breit) → `screens/00-design-system.png`.

### Schritt 2 — Screens pro User Story (60–90 min)

**Wichtig:** Pro User Story einen **frischen Chat** öffnen. Dadurch bleibt der Kontext überschaubar und Claude vermischt nicht versehentlich Komponenten verschiedener Screens.

Pro User Story:

1. Neuer Chat → `00-briefing.md` einfügen.
2. Den passenden Block aus `02-screen-prompts.md` darunter einfügen (z. B. den U1-Block).
3. Absenden. Das HTML-Artifact zeigt **Mobile (375)**, **Tablet (768)** und **Desktop (1024)** nebeneinander.
4. Iterieren – typische Folge-Prompts:
   - *"Zeig zusätzlich den Empty-State und den Error-State als eigene Frames."*
   - *"Variante B: Date-Range-Picker als horizontaler Stepper."*
5. Im Browser: F12 → Device-Toolbar → 375 / 768 / 1024 px → jeweils Screenshot.
6. Speichern als `screens/U1-landing-mobile.png`, `screens/U1-landing-desktop.png` etc.

Reihenfolge der User Stories:

- **U1** Landing, Imprint, About
- **U2** Room-Listing + Pagination + Empty/Error
- **U3** Period-Selection (2–3 Varianten!) + Availability-Feedback
- **U4** Booking-Form → Review → Confirmation, Error- und Validation-States
- **U5** Erweiterte Confirmation, Anfahrt/Kontakt, Print-Layout (`@media print`)
