# Multi-systeem VTT (Virtual Tabletop)

Een lichtgewicht, krachtige en multi-platform Virtual Tabletop (VTT) ontworpen voor rollenspellen (RPG's), variërend van mainstream systemen zoals D&D en Pathfinder tot niche indieproducten. Ontwikkeld met de focus op hoge prestaties, volledige data-eigendom en extreme hardware-toegankelijkheid.

---

## 🚀 Projectoverzicht & Visie

Het doel van deze VTT is om de kloof te overbruggen tussen hoogwaardige desktopomgevingen en budgetvriendelijke mobiele apparaten. De software is ontworpen om soepel te draaien op het gehele hardwarespectrum:

* **Doelgroep mobiele apparaten**: Geoptimaliseerd voor een vlekkeloze werking op low-end Android-apparaten (smartphones en tablets onder € 200), evenals premium Apple iOS/iPadOS-hardware.
* **Desktop-ecosystemen**: Volledige native ondersteuning voor Windows, macOS en Linux (elke distributie).

### 🛠️ Technologieën

* **Taal & Framework**: Kotlin Multiplatform (KMP) + Compose Multiplatform voor 100% gedeelde gebruikersinterface en bedrijfslogica voor mobiel en desktop.
* **Lokale opslag**: SQLDelight voor snel, typeveilig, multiplatform ingebed databasebeheer.
* **Ontwikkelomgeving**: JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Privacy-, gegevensbeveiligings- en monetisatiebeleid

Deze software is gebouwd rond de kernprincipes van gebruikersprivacy, volledig eigendom van gegevens en absolute transparantie:

* **100% offline & lokale architectuur**: Het systeem werkt volledig offline. Alle gegevens, compendia, campagnes en personagebladen worden uitsluitend opgeslagen in een beveiligde lokale database op uw fysieke apparaat.
* **Geen cloudsynchronisatie & geen tracking door derden**: De software uploadt uw persoonlijke gegevens niet naar een externe server en verspreidt of verkoopt uw ​​informatie niet aan derden.
* **Authenticatiebericht**: Persoonlijke gegevens worden uitsluitend gebruikt om uw lokale profiellogin (e-mailadres en wachtwoord) te genereren. Omdat er geen gecentraliseerde clouddatabase is, **betekent het verliezen van uw wachtwoord of geregistreerd e-mailadres dat u permanent de toegang tot uw lokale account en gegevens verliest**. Er is geen serverfunctie voor het resetten van wachtwoorden.
* **Geen advertenties, telemetrie of bloatware**: De broncode is openbaar en voor iedereen zichtbaar op GitHub om de volledige afwezigheid van adware, bloatware, tracking scripts, verborgen telemetrie of misleidende reclame te garanderen.
* **Geen microtransacties**: De software bevat geen microtransacties, in-app aankopen, betaalmuren of betaalde ontgrendelbare spelmechanismen van welke aard dan ook.

---

## 🏗️ Spelschermen & Rollen

#### 🔐 Authenticatie

* Universeel inlogscherm voor lokale campagnesessies.

#### 👑 Dungeon Master (DM) scherm

* **Universeel Compendium**: Een geïntegreerde, ultrasnelle documentatiebrowser die handleidingen adaptief laadt, afhankelijk van het actieve spelsysteem.
* **Handleidingbeheer**: Ondersteuning voor lokale opslag van handleidingen, waarbij gegevens direct worden gelezen vanuit intern geheugen, externe USB-drives of MicroSD-kaarten.
* **Campagnedashboard**: Campagneoverzicht, digitale dobbelsteenroller, NPC-bladen en tools voor het maken van aangepaste items die content in de database injecteren zonder de hoofdregelsdatabase te wijzigen.
* **Goedkeuringscentrum**: Realtime notificatiehub om door spelers aangevraagde wijzigingen aan personagebladen goed te keuren of af te wijzen.

#### ⚔️ Spelerscherm

* **Interactief personageblad**: Volledig interactieve, bewerkbare personagebladen met een ingebouwde dobbelsteenroller.
* **Gerichte toegang tot spelregels**: Directe toegang tot spelhandleidingen die strikt gefilterd zijn op spelmechanismen die direct van invloed zijn op de speler (vaardigheden, spreuken, talenten, statuscondities, rassen en klassen).
* **Synchronisatie- en waarschuwingssysteem**: Elke structurele wijziging aan het personageblad activeert automatisch een waarschuwing voor de spelleider, die deze pas na goedkeuring permanent maakt.

---

## 📄 Licentie

Dit project is beschermd en gelicentieerd onder de **PolyForm Strict License 1.0.0**.

### ⚠️ Alleen voor niet-commercieel en beperkt gebruik

* **Toegestaan**: U mag deze software vrij gebruiken voor persoonlijke hobby's, academisch onderzoek, studie of non-profitcampagnes.
* **Verboden**: U mag deze software of de broncode ervan **niet** gebruiken voor commerciële doeleinden, het genereren van inkomsten of binnen een bedrijf.
* **Verboden**: Wijziging en herdistributie van deze code door derden is **strikt verboden**. Alleen de oorspronkelijke auteur heeft de rechten voor distributie en wijziging.

Voor volledige juridische informatie kunt u het officiële [LICENSE.md](./LICENSE.md)-bestand in de hoofdmap raadplegen.

### 🌐 Lokalisaties van de licentie

Om ontwikkelaars wereldwijd te helpen deze beperkingen te begrijpen, zijn er vertalingen beschikbaar in de map [<./Localization/License/>](<./Localization/License/>):

* 🇮🇹 [Italiano (Italiaans)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [Engels (Referentie-exemplaar)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Français (Frans)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Español (Spaans)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Deutsch (Duits)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (Chinees)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (Chinees)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (Japans)](<./Localization/License/LICENSE.ja.md>)
* ...en [veel andere talen](./LICENSE.md).

*Opmerking: de officiële Engelse versie in de hoofdmap is de enige juridisch bindende tekst.*
