# Prompts pro User Story

> **Anleitung:** Pro User Story einen **frischen Chat** in claude.ai öffnen.
> Reihenfolge im Chat: 1) `00-briefing.md` einfügen, 2) den passenden Block unten einfügen, 3) absenden, 4) iterieren, 5) Screenshots machen.

---

## U1 — Hotel präsentieren (Landing / Imprint / About)

```
Erstelle ein HTML-Artifact mit Lo-Fi-Wireframes für die statischen Seiten der Hotel-Website. Bitte drei Frames (Mobile 375 / Tablet 768 / Desktop 1280) im selben Dokument, untereinander gestapelt, jeweils mit Caption.

Inhalt pro Seite:

A) Landing-Page
- Top-Nav mit Logo "Hotel Hasi" links, Navigation [Rooms / About / Imprint] rechts (Mobile: Burger).
- Hero-Bereich: großer Image-Placeholder + Headline "[Hotel Name]" + Subline + Primary-CTA "Verfügbarkeit prüfen".
- Section "Über das Hotel" — kurzer Beschreibungstext + Image-Placeholder rechts.
- Section "Unsere Zimmer" — drei kleine Room-Card-Vorschauen + Link "Alle Zimmer anzeigen".
- Section "Kontakt" — Adresse, Telefon, E-Mail, kleines Map-Placeholder-Bild.
- Footer mit drei Spalten.

B) Imprint
- Top-Nav, dann reine Textseite mit Headline "Impressum" und Pflichtangaben (alles als Lorem-Ipsum-Platzhalter).

C) About
- Top-Nav, Headline "Über uns", abwechselnd Text + Image-Placeholder, am Ende Team-Sektion mit drei Avatar-Placeholdern.

Mobile-First: Single-Column. Tablet: zwei Spalten ab Section "Über das Hotel". Desktop: Hero mit Text links / Bild rechts, Sections in 12-Spalten-Grid.

Strikt Graustufen, 1-px-Outlines, keine Schatten. Lorem-Ipsum als Fülltext.

Acceptance: REQ-001 bis REQ-010.
```

---

## U2 — Zimmer-Übersicht & Pagination

```
Erstelle ein HTML-Artifact mit Lo-Fi-Wireframes für die Zimmer-Übersichtsseite. Drei Frames (Mobile / Tablet / Desktop) plus zusätzliche Frames für Empty- und Error-State.

Default-State (Frame jeweils Mobile/Tablet/Desktop):
- Top-Nav, Breadcrumb "Home › Zimmer".
- H1 "Unsere Zimmer" + Subtitle.
- Filter-Leiste (Platzhalter: Datum, Personenzahl) — auf Mobile als zusammenklappbarer Block, ab Tablet als Inline-Form.
- Liste mit 5 Room-Cards (max. 5 auf Seite 1).
- Jede Room-Card hat: Image-Placeholder (variabel groß — eine Karte explizit höher/breiter als die anderen, um zu zeigen, dass das Layout das verkraftet), Titel, kurze Beschreibung, Extras-Reihe (3–5 Icons mit Beschriftung wie "WLAN", "Frühstück", "TV"), CTA "Zimmer ansehen".
- Pagination unten: ‹ 1 2 3 … ›, aktive Seite "1".
- Frame mit ungerader Anzahl (z. B. 3 Karten) zeigen, dass das Layout dabei NICHT bricht.

Empty-State-Frame:
- Empty-State-Komponente mit Icon-Placeholder, Headline "Keine Zimmer gefunden", Body, Reset-CTA.

Error-State-Frame:
- Banner oben "Zimmer konnten nicht geladen werden" + Retry-Button. Darunter Skeleton-Loader.

Mobile-First: 1 Karte pro Reihe. Tablet: 2 Karten. Desktop: 2 große horizontale Karten oder 3 vertikale, beide Varianten kurz nebeneinander zeigen.

Strikt Graustufen, 1-px-Outlines.

Acceptance: REQ-011 bis REQ-023.
```

---

## U3 — Verfügbarkeitsabfrage (3 Varianten)

```
Erstelle ein HTML-Artifact mit Lo-Fi-Wireframes für die Verfügbarkeitsabfrage. WICHTIG: drei Design-Varianten A, B, C nebeneinander, jeweils in Mobile + Desktop.

Variante A — Klassischer Calendar-Range-Picker
- Modal, das nach Klick auf "Verfügbarkeit prüfen" öffnet.
- Zwei Monate nebeneinander (Desktop) bzw. ein Monat (Mobile) mit Vor/Zurück-Pfeilen.
- Range-Selection mit hervorgehobenen Tagen.

Variante B — Stepper (Anreise / Abreise getrennt)
- Schritt 1: Anreise wählen (Liste/Datum-Picker).
- Schritt 2: Abreise wählen.
- Schritt 3: Zusammenfassung + "Prüfen"-CTA.
- Auf Mobile als full-screen Wizard, auf Desktop als Inline-Stepper.

Variante C — "Stay length" Slider
- Single-Date-Picker für Anreise.
- Slider 1–14 Nächte für Aufenthaltsdauer.
- Live-Update der Abreise rechts daneben.

Für JEDE Variante zusätzlich folgende Feedback-States als eigene kleine Frames:
- Verfügbar → Grünliches Banner (in Graustufen-Stil mit Häkchen-Symbol) + "Weiter zur Buchung"-CTA.
- Nicht verfügbar → Banner mit "Leider belegt" + Vorschlag alternativer Zeiträume (Liste).
- Fehler → Banner "Verfügbarkeit konnte nicht geprüft werden" + Retry.
- Loading → Skeleton-Boxes statt Banner.

Layout-Regel: Varianten A / B / C in drei großen Sektionen untereinander, jede Sektion hat eine eigene "Mobile / Desktop / States"-Reihe.

Strikt Graustufen, 1-px-Outlines, einzige Akzentfarbe Blau für aktiven Zustand und Primary-CTA.

Acceptance: REQ-024 bis REQ-032, insbesondere REQ-028 (innovative Periodendefinition).
```

---

## U4 — Buchung (Form / Review / Confirmation)

```
Erstelle ein HTML-Artifact mit Lo-Fi-Wireframes für den Buchungsfluss. Drei Schritte: Form, Review, Confirmation. Pro Schritt drei Frames (Mobile / Tablet / Desktop) sowie zusätzliche Frames für Validation- und Error-States.

Globaler Stepper oben auf jeder Seite: [1 Daten] – [2 Review] – [3 Bestätigung], aktiver Schritt hervorgehoben.

Schritt 1 — Buchungsformular
- Zusammenfassung des gewählten Zimmers (kleine Card mit Bild, Titel, Periode, Preis-Platzhalter) als Sticky-Sidebar (Desktop) bzw. Collapsible-Block (Mobile).
- Form-Felder:
  - Vorname (Text, required)
  - Nachname (Text, required)
  - E-Mail (Email, required)
  - E-Mail-Bestätigung (Email, required, muss matchen)
  - Frühstück (Toggle Ja/Nein, default Nein)
- Helper-Texte unter den E-Mail-Feldern.
- Primary-CTA "Weiter zur Übersicht".
- Zusätzlicher Frame: Form mit Validation-Errors sichtbar (E-Mail invalid + E-Mails matchen nicht + Vorname leer).

Schritt 2 — Review
- Alle eingegebenen Daten lesbar dargestellt mit "Bearbeiten"-Link je Block.
- Zimmer-Zusammenfassung darüber.
- Primary-CTA "Buchung abschließen", Secondary "Zurück".

Schritt 3 — Confirmation (Kurz-Version)
- Erfolgs-Banner "Vielen Dank, [Vorname]!" mit Häkchen-Icon-Placeholder.
- Buchungs-ID (Platzhalter `BK-12345`).
- Ausblick: "Sie erhalten die ausführliche Bestätigung per E-Mail / siehe nächste Seite (U5)".

Zusätzlicher Error-Frame:
- Banner "Buchung konnte nicht abgeschlossen werden" + Retry + Hinweis, dass keine Belastung erfolgt ist.

Mobile-First: Single-Column-Form, Sticky-Summary unten als Bottom-Sheet. Desktop: Form links 2/3, Summary rechts 1/3.

Acceptance: REQ-033 bis REQ-049.
```

---

## U5 — Erweiterte Confirmation, Anfahrt, Print

```
Erstelle ein HTML-Artifact mit Lo-Fi-Wireframes für die erweiterte Buchungsbestätigung. Drei Frames (Mobile / Tablet / Desktop) plus EINEN zusätzlichen Frame für das Print-Layout.

Inhalt der erweiterten Confirmation:
- Header mit Logo + Buchungs-ID + Datum.
- Section "Ihre Buchung" — Buchungsperiode (von/bis), Anzahl Nächte, Frühstück Ja/Nein.
- Section "Ihr Zimmer" — Image-Placeholder, Zimmer-Titel, Beschreibung, Extras mit Icons.
- Section "Ihre Daten" — Vorname, Nachname, E-Mail.
- Section "Anfahrt" — Adresse, Map-Placeholder (großes Box mit Kreuz), Wegbeschreibung als Liste, Hinweise zu Bahn-Verbindungen.
- Section "Kontakt" — Telefon, E-Mail, Öffnungszeiten Rezeption.
- Action-Bar unten: "Drucken", "Als PDF speichern", "Zurück zur Startseite".

Print-Frame:
- Eigener Frame, der zeigt, wie das Layout im Druck aussieht (A4 Hochformat 210 × 297 mm, im Artifact als 794 × 1123 px Box dargestellt).
- Action-Bar, Top-Nav und Footer entfallen im Print.
- Logo + Buchungs-ID oben.
- Sections kompakt untereinander, einspaltig, gut lesbar bei Schwarzweiß-Druck.
- Im CSS-Block: `@media print` mit `body { background:white; } [data-no-print] { display:none; }`. Print-Frame zeigt das Ergebnis.

Mobile-First: alle Sections gestapelt. Desktop: zweispaltig "Buchung/Zimmer/Daten" links, "Anfahrt/Kontakt" rechts.

Strikt Graustufen.

Acceptance: REQ-050 bis REQ-059, insbesondere REQ-057 (druckfreundliches A4-Layout).
```

---

## Iterations-Prompts (für jeden Chat einsetzbar)

```
Mach den Look noch wireframe-iger: alle Schatten weg, Outlines auf 1 px, Text durch graue Balken ersetzen, wo es um Layout geht.
```

```
Füge Annotations hinzu: kleine Pfeile mit Text, die auf wichtige Atome/Molecules zeigen und benennen ("Atom: Button-Primary", "Molecule: Form-Field").
```

```
Erzeuge eine zusätzliche Sektion "Component-Map" am Ende des Artifacts, die jede genutzte Komponente nach Atomic-Design-Ebene auflistet.
```

```
Speichere das Artifact so, dass jeder Frame einzeln per "Drucken" als sauberer Screenshot abgegriffen werden kann (klare Außenränder, fixe Breite pro Frame).
```
