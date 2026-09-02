# Multi-System VTT (Virtual Tabletop)

En lett, kraftig og flerplattforms virtuell tabletop (VTT) designet for rollespill (RPG-er) som spenner fra vanlige systemer som D&D og Pathfinder til nisjebaserte indieprodukter. Bygget med fokus på høy ytelse, fullstendig dataeierskap og ekstrem maskinvaretilgjengelighet.

---

## 🚀 Prosjektoversikt og visjon

Målet med denne VTT-en er å bygge bro mellom avanserte skrivebordsmiljøer og budsjettvennlige mobile enheter. Programvaren er konstruert for å kjøre problemfritt på tvers av hele maskinvarespekteret:

* **Target Mobile Range**: Optimalisert for å kjøre feilfritt på Android-enheter i lavprissegmentet (smarttelefoner og nettbrett under €200), samt premium Apple iOS/iPadOS-maskinvare.
* **Desktop Ecosystems**: Full støtte for Windows, macOS og Linux (alle distribusjoner).

### 🛠️ Tech Stack

* **Språk og rammeverk**: Kotlin Multiplatform (KMP) + Compose Multiplatform for 100 % delt brukergrensesnitt og forretningslogikk på tvers av mobil og datamaskin.
* **Lokal lagring**: SQLDelight for rask, typesikker, multiplattform innebygd databaseadministrasjon.
* **Utviklingsmiljø**: JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Personvern, datasikkerhet og inntektsgenerering

Denne programvaren er bygget rundt kjerneprinsippene for brukerpersonvern, fullt dataeierskap og absolutt åpenhet:

* **100 % frakoblet og lokal arkitektur**: Systemet opererer helt frakoblet. Alle data, kompendier, kampanjer og tegnark lagres utelukkende i en sikker lokal database på din fysiske enhet.
* **Null skysynkronisering og ingen tredjepartssporing**: Programvaren laster ikke opp dine personlige data til noen ekstern server, og distribuerer eller selger heller ikke informasjonen din til tredjeparter.
* **Autentiseringsvarsel**: Personopplysninger brukes utelukkende til å generere din lokale profilpålogging (e-post og passord). Fordi det ikke finnes noen sentralisert skydatabase, **betyr det å miste passordet eller den registrerte e-posten at du mister tilgangen til din lokale konto og data permanent**. Det finnes ingen "tilbakestill passord"-serverfunksjon.
* **Ingen annonser, telemetri eller bloatware**: Kildekoden er offentlig og synlig for alle på GitHub for å garantere fullstendig fravær av adware, bloatware, sporingsskript, skjult telemetri eller villedende reklame.
* **Ingen mikrotransaksjoner**: Programvaren har ingen mikrotransaksjoner, kjøp i appen, betalingsmurer eller betalte opplåsbare spillmekanikker av noe slag.

---

## 🏗️ Spillskjermer og roller

#### 🔐 Autentisering

* Universell påloggingsskjerm for lokale kampanjeøkter.

#### 👑 Dungeon Master (DM)-skjerm

* **Universal Compendium**: En integrert, ultrarask dokumentasjonsnettleser som adaptivt laster inn manualer avhengig av det aktive spillsystemet.
* **Manuell administrasjon**: Støtte for lokal manuell lagring, lesing av data direkte fra intern lagring, eksterne USB-stasjoner eller MicroSD-kort.
* **Kampanjedashbord**: Kampanjeoversikt, digital terningkaster, NPC-ark og tilpassede gjenstandsskapere som injiserer innhold i databasen uten å endre hovedregeldatabasen.
* **Godkjenningssenter**: Sanntids varslingssenter for å godkjenne eller avslå endringer i karakterark som forespurt av spillere.

#### ⚔️ Spillerskjerm

* **Interaktiv karakterark**: Fullt interaktive, redigerbare karakterark med en innebygd terningkaster.
* **Målrettet regeltilgang**: Direkte tilgang til spillmanualer filtrert strengt for spillerorienterte mekanikker (evner, formler, bragder, statusforhold, løp og klasser).
* **Synkroniserings- og varslingsmotor**: Enhver strukturell endring i karakterarket utløser automatisk et varsel til DM-en, og venter på godkjenning før den blir permanent.

--

## 📄 Lisens

Dette prosjektet er beskyttet og lisensiert under **PolyForm Strict License 1.0.0**.

### ⚠️ Kun ikke-kommersiell og begrenset bruk

* **Tillatt**: Du kan bruke denne programvaren fritt til personlige hobbyer, akademisk forskning, studier eller ideelle kampanjer.
* **Forbudt**: Du **kan ikke** bruke denne programvaren eller kildekoden til kommersielle formål, inntektsgenerering eller innenfor et selskap.
* **Forbudt**: Tredjeparts modifisering og redistribusjon av denne koden er **strengt forbudt**. Kun den opprinnelige forfatteren har distribusjons- og modifikasjonsrettigheter.

For fullstendige juridiske detaljer, vennligst les den offisielle [LICENSE.md](./LICENSE.md)-filen i rotkatalogen.

### 🌐 Lisenslokaliseringer

For å hjelpe utviklere over hele verden med å forstå disse restriksjonene, er oversettelser tilgjengelige i mappen [<./Localization/License/>](<./Localization/License/>):

* 🇮🇹 [Italiano (Italiensk)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [Engelsk (Referansekopi)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Français (Fransk)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Español (Spansk)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Tysk (tysk)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (kinesisk)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (kinesisk)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (japansk)](<./Localization/License/LICENSE.ja.md>)
* ...og [mange andre språk](./LISENS.md).

*Merk: Den offisielle engelske versjonen i rotkatalogen er den eneste juridisk bindende teksten.*
