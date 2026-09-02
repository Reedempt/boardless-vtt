# Multi-System VTT (Virtuellt bordsspel)

En lätt, kraftfull och multiplattforms virtuell bordsspel (VTT) designad för rollspel (RPG) från mainstream-system som D&D och Pathfinder till nischade indieprodukter. Byggd med fokus på hög prestanda, fullständigt dataägande och extrem hårdvarutillgänglighet.

---

## 🚀 Projektöversikt och vision

Målet med denna VTT är att överbrygga klyftan mellan avancerade skrivbordsmiljöer och mobila budgetenheter. Programvaran är konstruerad för att köras smidigt över hela hårdvaruspektrumet:

* **Målgrupp för mobila enheter**: Optimerad för att köras felfritt på enklare Android-enheter (smartphones och surfplattor under €200), samt premium Apple iOS/iPadOS-hårdvara.
* **Skrivbordsekosystem**: Fullständigt inbyggt stöd för Windows, macOS och Linux (alla distributioner).

### 🛠️ Tech Stack

* **Språk och ramverk**: Kotlin Multiplatform (KMP) + Compose Multiplatform för 100 % delat användargränssnitt och affärslogik över mobil och dator.
* **Lokal lagring**: SQLDelight för snabb, typsäker, multiplattforms inbäddad databashantering.
* **Utvecklingsmiljö**: JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Sekretess-, datasäkerhets- och intäktspolicy

Denna programvara är byggd kring kärnprinciperna för användarsekretess, fullständigt dataägande och absolut transparens:

* **100 % offline- och lokal arkitektur**: Systemet fungerar helt offline. All data, kompendier, kampanjer och teckenblad sparas exklusivt i en säker lokal databas på din fysiska enhet.
* **Noll molnsynkronisering och ingen spårning från tredje part**: Programvaran laddar inte upp dina personuppgifter till någon extern server och distribuerar eller säljer inte din information till tredje part.
* **Autentiseringsmeddelande**: Personuppgifter används enbart för att generera din lokala profilinloggning (e-postadress och lösenord). Eftersom det inte finns någon centraliserad molndatabas, **innebär förlust av ditt lösenord eller registrerade e-postadress att du förlorar åtkomst till ditt lokala konto och dina data permanent**. Det finns ingen serverfunktion för att "återställa lösenord".
* **Inga annonser, telemetri eller bloatware**: Källkoden är offentlig och synlig för alla på GitHub för att garantera fullständig frånvaro av adware, bloatware, spårningsskript, dold telemetri eller vilseledande reklam.
* **Inga mikrotransaktioner**: Programvaran har inga mikrotransaktioner, köp i appen, betalväggar eller betalda upplåsbara spelmekaniker av något slag.

---

## 🏗️ Spelskärmar och roller

#### 🔐 Autentisering

* Universell inloggningsskärm för lokala kampanjsessioner.

#### 👑 Dungeon Master (DM)-skärm

* **Universell kompendium**: En integrerad, ultrasnabb dokumentationswebbläsare som adaptivt laddar manualer beroende på det aktiva spelsystemet.
* **Manualhantering**: Stöd för lokal manuallagring, läsning av data direkt från intern lagring, externa USB-enheter eller MicroSD-kort.
* **Kampanjöversikt**: Kampanjöversikt, digital tärningsrulle, NPC-ark och skapare av anpassade föremål som injicerar innehåll i databasen utan att ändra huvudregeldatabasen.
* **Godkännandecenter**: Notifieringsnav i realtid för att godkänna eller neka ändringar av karaktärsark som begärs av spelare.

#### ⚔️ Spelarskärm

* **Interaktiv karaktärsark**: Helt interaktiva, redigerbara karaktärsark med en inbyggd tärningsrulle.
* **Riktad regelåtkomst**: Direktåtkomst till spelmanualer filtrerade strikt för spelarorienterade mekaniker (förmågor, trollformler, prestationer, statusvillkor, raser och klasser).
* **Synkroniserings- och varningsmotor**: Alla strukturella ändringar som görs i karaktärsbladet utlöser automatiskt en varning till spelledaren, i väntan på godkännande innan de blir permanenta.

---

## 📄 Licens

Detta projekt är skyddat och licensierat under **PolyForm Strict License 1.0.0**.

### ⚠️ Endast icke-kommersiell och begränsad användning

* **Tillåtet**: Du kan använda denna programvara fritt för personliga hobbyer, akademisk forskning, studier eller ideella kampanjer.
* **Förbjudet**: Du **får inte** använda denna programvara eller dess källkod för kommersiella ändamål, intäktsgenerering eller inom ett företag.
* **Förbjudet**: Modifiering och omdistribution av denna kod av tredje part är **strängt förbjuden**. Endast den ursprungliga författaren har distributions- och modifieringsrättigheter.

För fullständig juridisk information, vänligen läs den officiella [LICENSE.md](./LICENSE.md)-filen i rotkatalogen.

### 🌐 Licenslokaliseringar

För att hjälpa utvecklare runt om i världen att förstå dessa begränsningar finns översättningar tillgängliga i mappen [<./Localization/License/>](<./Localization/License/>):

* 🇮🇹 [Italiano (Italienska)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [Engelska (Referenskopia)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Franska (Franska)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Spanska (Spanska)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Tyska (tyska)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (kinesiska)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (kinesiska)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (japanska)](<./Localization/License/LICENSE.ja.md>)
* ...och [många andra språk](./LICENSE.md).

*Obs: Den officiella engelska versionen i rotkatalogen är den enda juridiskt bindande texten.*
