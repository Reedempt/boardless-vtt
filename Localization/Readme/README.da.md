# Multi-System VTT (Virtuel Tabletop)

En let, kraftfuld og multi-platform virtuel tabletop (VTT) designet til rollespil (RPG'er) lige fra mainstream-systemer som D&D og Pathfinder til niche-indieprodukter. Bygget med fokus på høj ydeevne, fuldstændig dataejerskab og ekstrem hardwaretilgængelighed.

---

## 🚀 Projektoversigt og vision

Målet med denne VTT er at bygge bro mellem avancerede desktopmiljøer og budgetvenlige mobile enheder. Softwaren er udviklet til at køre problemfrit på tværs af hele hardwarespektret:

* **Target Mobile Range**: Optimeret til at køre fejlfrit på low-end Android-enheder (smartphones og tablets under €200) samt premium Apple iOS/iPadOS-hardware.
* **Desktop-økosystemer**: Fuld native understøttelse af Windows, macOS og Linux (enhver distribution).

### 🛠️ Tech Stack

* **Sprog og rammeværk**: Kotlin Multiplatform (KMP) + Compose Multiplatform til 100% delt brugergrænseflade og forretningslogik på tværs af mobil og desktop.
* **Lokal lagring**: SQLDelight til hurtig, typesikker, multiplatform integreret databaseadministration.
* **Udviklingsmiljø**: JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Politik for privatliv, datasikkerhed og monetisering

Denne software er bygget op omkring kerneprincipperne om brugerprivatliv, fuldt dataejerskab og absolut gennemsigtighed:

* **100% offline og lokal arkitektur**: Systemet fungerer fuldstændig offline. Alle data, kompendier, kampagner og karakterark gemmes udelukkende i en sikker lokal database på din fysiske enhed.
* **Ingen cloud-synkronisering og ingen tredjepartssporing**: Softwaren uploader ikke dine personlige data til nogen ekstern server og distribuerer eller sælger heller ikke dine oplysninger til tredjeparter.
* **Godkendelsesmeddelelse**: Personlige data bruges udelukkende til at generere dit lokale profillogin (e-mail og adgangskode). Da der ikke er nogen centraliseret cloud-database, **betyder det, at du mister adgangen til din lokale konto og dine data permanent**, hvis du mister din adgangskode eller registrerede e-mail. Der er ingen serverfunktion til at "nulstille adgangskode".
* **Ingen annoncer, telemetri eller bloatware**: Kildekoden er offentlig og kan ses af alle på GitHub for at garantere fuldstændig fravær af adware, bloatware, tracking-scripts, skjult telemetri eller vildledende reklame.
* **Ingen mikrotransaktioner**: Softwaren indeholder ingen mikrotransaktioner, køb i appen, betalingsmure eller betalte spilmekanikker af nogen art, der kan låses op.

---

## 🏗️ Spilskærme og roller

#### 🔐 Godkendelse

* Universel loginskærm til lokale kampagnesessioner.

#### 👑 Dungeon Master (DM) skærm

* **Universal Compendium**: En integreret, ultrahurtig dokumentationsbrowser, der adaptivt indlæser manualer afhængigt af det aktive spilsystem.
* **Manuel administration**: Understøttelse af lokal manuel lagring, læsning af data direkte fra intern lagring, eksterne USB-drev eller MicroSD-kort.
* **Kampagne Dashboard**: Kampagneoversigt, digital terningkaster, NPC-ark og brugerdefinerede genstandsskabere, der indsætter indhold i databasen uden at ændre hovedregeldatabasen.
* **Godkendelsescenter**: Notifikationshub i realtid til at godkende eller afvise ændringer af karakterark, der anmodes af spillere.

#### ⚔️ Spillerskærm

* **Interaktivt karakterark**: Fuldt interaktive, redigerbare karakterark med en indbygget terningkaster.
* **Målrettet adgang til regler**: Direkte adgang til spilmanualer, der er filtreret udelukkende til spillerorienterede mekanikker (Evner, Besværgelser, Feats, Statusbetingelser, Racer og Klasser).
* **Synkroniserings- og alarmmotor**: Enhver strukturel ændring af karakterarket udløser automatisk en alarm til DM'en, der afventer godkendelse, før den bliver permanent.

--

## 📄 Licens

Dette projekt er beskyttet og licenseret under **PolyForm Strict License 1.0.0**.

### ⚠️ Kun ikke-kommerciel og begrænset brug

* **Tilladt**: Du kan bruge denne software frit til personlige hobbyer, akademisk forskning, studier eller non-profit kampagner.
* **Forbudt**: Du **må ikke** bruge denne software eller dens kildekode til kommercielle formål, monetisering eller inden for en virksomhed.
* **Forbudt**: Tredjepartsændringer og videredistribution af denne kode er **strengt forbudt**. Kun den oprindelige forfatter har distributions- og ændringsrettigheder.

For alle juridiske detaljer, læs venligst den officielle [LICENSE.md](./LICENSE.md) fil i rodmappen.

### 🌐 Licenslokaliseringer

For at hjælpe udviklere over hele verden med at forstå disse begrænsninger, er der tilgængelige oversættelser i mappen [<./Localization/License/>](<./Localization/License/>):

* 🇮🇹 [Italiano (Italiensk)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [Engelsk (Referencekopi)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Français (Fransk)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Español (Spansk)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Tysk (tysk)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (kinesisk)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (kinesisk)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (japansk)](<./Localization/License/LICENSE.ja.md>)
* ...og [mange andre sprog](./LICENSE.md).

*Bemærk: Den officielle engelske version i rodmappen er den eneste juridisk bindende tekst.*
