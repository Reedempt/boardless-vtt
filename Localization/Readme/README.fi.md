# Monijärjestelmä-VTT (Virtual Tabletop)

Kevyt, tehokas ja monialustainen virtuaalipöytäpeli (VTT), joka on suunniteltu roolipeleihin (RPG) valtavirran järjestelmistä, kuten D&D ja Pathfinder, aina indie-tuotteisiin. Se on rakennettu keskittyen korkeaan suorituskykyyn, täydelliseen datan omistajuuteen ja äärimmäiseen laitteiston saavutettavuuteen.

---

## 🚀 Projektin yleiskatsaus ja visio

Tämän VTT:n tavoitteena on kuroa umpeen kuilua huippuluokan työpöytäympäristöjen ja budjettiluokan mobiililaitteiden välillä. Ohjelmisto on suunniteltu toimimaan sujuvasti koko laitteistovalikoimassa:

* **Kohdemobiilivalikoima**: Optimoitu toimimaan moitteettomasti edullisilla Android-laitteilla (älypuhelimet ja tabletit alle 200 €) sekä premium-luokan Apple iOS/iPadOS-laitteistolla.
* **Työpöytäekosysteemit**: Täysi natiivituki Windowsille, macOS:lle ja Linuxille (kaikille jakeluille).

### 🛠️ Teknologiapino

* **Kieli ja kehys**: Kotlin Multiplatform (KMP) + Compose Multiplatform 100 % jaettuun käyttöliittymään ja liiketoimintalogiikkaan mobiili- ja työpöytäversioissa.
* **Paikallinen tallennustila**: SQLDelight nopeaan, tyyppiturvalliseen ja monialustaiseen upotettuun tietokannan hallintaan.
* **Kehitysympäristö**: JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Tietosuoja-, tietoturva- ja kaupallistamiskäytäntö

Tämä ohjelmisto on rakennettu käyttäjän yksityisyyden, täyden tiedon omistajuuden ja ehdottoman läpinäkyvyyden ydinperiaatteiden ympärille:

* **100 % offline- ja paikallinen arkkitehtuuri**: Järjestelmä toimii kokonaan offline-tilassa. Kaikki tiedot, koosteet, kampanjat ja hahmolomakkeet tallennetaan yksinomaan suojattuun paikalliseen tietokantaan fyysisellä laitteellasi.
* **Ei pilvisynkronointia eikä kolmannen osapuolen seurantaa**: Ohjelmisto ei lataa henkilötietojasi millekään ulkoiselle palvelimelle eikä jaa tai myy tietojasi kolmansille osapuolille.
* **Todennusilmoitus**: Henkilötietoja käytetään ainoastaan ​​paikallisen profiilisi kirjautumistunnuksen (sähköpostiosoite ja salasana) luomiseen. Koska keskitettyä pilvitietokantaa ei ole, **salasanan tai rekisteröidyn sähköpostiosoitteen menettäminen tarkoittaa paikallisen tilisi ja tietojesi pysyvää menettämistä**. Palvelimella ei ole salasanan palautustoimintoa.
* **Ei mainoksia, telemetriaa tai bloatware-ohjelmia**: Lähdekoodi on julkinen ja kuka tahansa GitHubissa voi tarkastella sitä, jotta voimme taata täydellisen poissaolon mainosohjelmista, bloatware-ohjelmista, seurantaskripteistä, piilotetuista telemetrioista tai harhaanjohtavista mainoksista.
* **Ei mikrotransaktioita**: Ohjelmisto ei sisällä mikrotransaktioita, sovelluksen sisäisiä ostoksia, maksumuureja tai minkäänlaisia ​​maksullisia avattavia pelimekaniikkoja.

---

## 🏗️ Pelinäytöt ja roolit

#### 🔐 Todennus

* Yleinen kirjautumisnäyttö paikallisille kampanjaistunnoille.

#### 👑 Dungeon Master (DM) -näyttö

* **Yleinen kooste**: Integroitu, erittäin nopea dokumentaatioselain, joka lataa käyttöohjeet mukautuvasti aktiivisen pelijärjestelmän mukaan.
* **Ohjeiden hallinta**: Tuki paikalliselle käyttöohjeiden tallennukselle, tietojen lukeminen suoraan sisäisestä tallennustilasta, ulkoisista USB-asemista tai MicroSD-korteista.
* **Kampanjan kojelauta**: Kampanjan yleiskatsaus, digitaalinen nopparulla, NPC-arkit ja mukautettujen esineiden luontityökalut, jotka lisäävät sisältöä tietokantaan muuttamatta pääsääntötietokantaa.
* **Hyväksyntäkeskus**: Reaaliaikainen ilmoituskeskus pelaajien pyytämien hahmoarkkien muutosten hyväksymiseen tai hylkäämiseen.

#### ⚔️ Pelaajan näyttö

* **Interaktiivinen hahmoarkki**: Täysin interaktiiviset, muokattavat hahmoarkit, joissa on sisäänrakennettu nopparulla. * **Kohdennettujen sääntöjen käyttöoikeus**: Suora pääsy pelin käyttöohjeisiin, jotka on suodatettu tiukasti pelaajakohtaisille mekaniikoille (kyvyt, loitsut, kyvyt, tilaehdot, rodut ja luokat).
* **Synkronointi- ja hälytysmoottori**: Kaikki hahmolomakkeeseen tehdyt rakenteelliset muutokset laukaisevat automaattisesti hälytyksen pelinjohtajalle. Muutokset odottavat hyväksyntää ennen kuin niistä tulee pysyviä.

---

## 📄 Lisenssi

Tämä projekti on suojattu ja lisensoitu **PolyForm Strict License 1.0.0** -lisenssillä.

### ⚠️ Vain ei-kaupalliseen ja rajoitettuun käyttöön

* **Sallittu**: Voit käyttää tätä ohjelmistoa vapaasti henkilökohtaisiin harrastuksiin, akateemiseen tutkimukseen, opiskeluun tai voittoa tavoittelemattomiin kampanjoihin.
* **Kielletty**: Et **voi** käyttää tätä ohjelmistoa tai sen lähdekoodia mihinkään kaupalliseen tarkoitukseen, rahaksi tekemiseen tai yrityksen sisällä.
* **Kielletty**: Kolmannen osapuolen tekemä tämän koodin muokkaus ja jakelu on **ehdottomasti kielletty**. Vain alkuperäisellä tekijällä on jakelu- ja muokkausoikeudet.

Täydelliset lakiasiat löytyvät virallisesta [LICENSE.md](./LICENSE.md)-tiedostosta juurihakemistosta.

### 🌐 Lisenssien lokalisoinnit

Jotta kehittäjät ympäri maailmaa ymmärtäisivät nämä rajoitukset, kansiossa [<./Localization/License/>](<./Localization/License/>) on saatavilla kohteliaita käännöksiä:

* 🇮🇹 [Italiano (italia)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [Englanti (viitekappale)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Français (ranska)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Español (espanja)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Deutsch (saksa) (saksa)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (kiina)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (kiina)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (japani)](<./Localization/License/LICENSE.ja.md>)
* ...ja [monilla muilla kielillä](./LICENSE.md).

*Huomaa: virallinen englanninkielinen versio juurihakemistossa on ainoa laillisesti sitova teksti.*
