# Multi-System VTT (Virtual Tabletop)

Ein schlanker, leistungsstarker und plattformübergreifender virtueller Spieltisch (VTT) für Rollenspiele (RPGs) – von Mainstream-Systemen wie D&D und Pathfinder bis hin zu Nischen-Indie-Titeln. Entwickelt mit Fokus auf hohe Performance, vollständige Datenkontrolle und optimale Hardwarekompatibilität.

---

## 🚀 Projektübersicht & Vision

Ziel dieses VTT ist es, die Lücke zwischen leistungsstarken Desktop-Umgebungen und günstigen Mobilgeräten zu schließen. Die Software ist für einen reibungslosen Betrieb auf allen Hardware-Plattformen optimiert:

* **Zielgruppe Mobilgeräte**: Optimiert für die einwandfreie Funktion auf günstigen Android-Geräten (Smartphones und Tablets unter 200 €) sowie auf Premium-Geräten von Apple (iOS/iPadOS).
* **Desktop-Systeme**: Volle native Unterstützung für Windows, macOS und Linux (alle Distributionen).

### 🛠️ Technologie-Stack

* **Sprache & Framework**: Kotlin Multiplatform (KMP) + Compose Multiplatform für 100 % gemeinsame Benutzeroberfläche und Geschäftslogik auf Mobilgeräten und Desktop-Computern.
* **Lokaler Speicher**: SQLDelight für schnelles, typsicheres und plattformübergreifendes Datenbankmanagement.
* **Entwicklungsumgebung**: JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Datenschutz, Datensicherheit & Monetarisierungsrichtlinie

Diese Software basiert auf den Grundprinzipien des Datenschutzes, der vollen Datenhoheit und absoluter Transparenz:

* **100 % Offline- & Lokale Architektur**: Das System funktioniert vollständig offline. Alle Daten, Kompendien, Kampagnen und Charakterbögen werden ausschließlich in einer sicheren lokalen Datenbank auf Ihrem Gerät gespeichert.
* **Keine Cloud-Synchronisierung & kein Tracking durch Dritte**: Die Software lädt Ihre persönlichen Daten nicht auf externe Server hoch und gibt Ihre Informationen nicht an Dritte weiter.
* **Hinweis zur Authentifizierung**: Ihre persönlichen Daten werden ausschließlich zur Generierung Ihres lokalen Profil-Logins (E-Mail-Adresse und Passwort) verwendet. Da keine zentrale Cloud-Datenbank existiert, **führt der Verlust Ihres Passworts oder Ihrer registrierten E-Mail-Adresse zum dauerhaften Verlust des Zugriffs auf Ihr lokales Konto und Ihre Daten**. Es gibt keine Funktion zum Zurücksetzen des Passworts.
* **Keine Werbung, Telemetrie oder Bloatware**: Der Quellcode ist öffentlich und für jeden auf GitHub einsehbar, um die vollständige Abwesenheit von Adware, Bloatware, Tracking-Skripten, versteckter Telemetrie oder irreführender Werbung zu gewährleisten.
* **Keine Mikrotransaktionen**: Die Software enthält keine Mikrotransaktionen, In-App-Käufe, Paywalls oder kostenpflichtige, freischaltbare Spielmechaniken jeglicher Art.

---

## 🏗️ Spielbildschirme & Rollen

#### 🔐 Authentifizierung

* Universeller Anmeldebildschirm für lokale Kampagnensitzungen.

#### 👑 Spielleiterbildschirm (DM)

* **Universelles Kompendium**: Ein integrierter, ultraschneller Dokumentationsbrowser, der Handbücher je nach aktivem Spielsystem adaptiv lädt.
* **Handbuchverwaltung**: Unterstützung für die lokale Speicherung von Handbüchern, direktes Lesen von Daten vom internen Speicher, externen USB-Laufwerken oder microSD-Karten.
* **Kampagnen-Dashboard**: Kampagnenübersicht, digitaler Würfelgenerator, NSC-Bögen und benutzerdefinierte Gegenstandsgeneratoren, die Inhalte in die Datenbank einfügen, ohne die Master-Regeldatenbank zu verändern.
* **Genehmigungszentrum**: Benachrichtigungszentrale in Echtzeit zur Genehmigung oder Ablehnung von Charakterbogenänderungen, die von Spielern angefordert werden.

#### ⚔️ Spielerbildschirm

* **Interaktiver Charakterbogen**: Vollständig interaktive, bearbeitbare Charakterbögen mit integriertem Würfelgenerator.
* **Gezielter Regelzugriff**: Direkter Zugriff auf Spielhandbücher, gefiltert nach spielerrelevanten Mechaniken (Fähigkeiten, Zauber, Talente, Statuszustände, Völker und Klassen).
* **Synchronisierungs- und Benachrichtigungssystem**: Jede strukturelle Änderung am Charakterbogen löst automatisch eine Benachrichtigung an den Spielleiter aus, die vor der endgültigen Änderung dessen Genehmigung benötigt.

---

## 📄 Lizenz

Dieses Projekt ist unter der **PolyForm Strict License 1.0.0** geschützt und lizenziert.

### ⚠️ Nur für nichtkommerzielle und eingeschränkte Nutzung

* **Erlaubt**: Sie dürfen diese Software frei für private Hobbys, akademische Forschung, Studien oder gemeinnützige Projekte verwenden.
* **Verboten**: Sie dürfen diese Software oder ihren Quellcode nicht für kommerzielle Zwecke, zur Monetarisierung oder innerhalb eines Unternehmens verwenden.
* **Verboten**: Die Änderung und Weitergabe dieses Codes durch Dritte ist strengstens untersagt. Ausschließlich der ursprüngliche Autor besitzt die Rechte zur Verbreitung und Bearbeitung.

Die vollständigen rechtlichen Details finden Sie in der offiziellen Lizenzdatei [LICENSE.md](./LICENSE.md) im Stammverzeichnis.

### 🌐 Lizenzlokalisierungen
Um Entwicklern weltweit das Verständnis dieser Bestimmungen zu erleichtern, stehen Übersetzungen im Ordner [<./Localization/License/>](<./Localization/License/>) zur Verfügung:

* 🇮🇹 [Italiano (Italienisch)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [English (Referenzversion)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Français (Französisch)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Español (Spanisch)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Deutsch (Deutsch)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (Chinesisch)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (Chinesisch)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (Japanisch)](<./Localization/License/LICENSE.ja.md>)
* ...und [viele andere Sprachen](./LICENSE.md).

*Hinweis: Die offizielle englische Version im Stammverzeichnis ist die einzig rechtsverbindliche Fassung.*
