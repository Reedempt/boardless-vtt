# VTT (Masă Virtuală) Multi-Sistem

O Masă Virtuală (VTT) ușoară, puternică și multi-platformă, concepută pentru jocuri de rol (RPG), de la sisteme mainstream precum D&D și Pathfinder până la produse indie de nișă. Construită cu accent pe performanță ridicată, proprietate completă asupra datelor și accesibilitate extremă a hardware-ului.

---

## 🚀 Prezentare generală și viziune a proiectului

Scopul acestei VTT este de a reduce decalajul dintre mediile desktop high-end și dispozitivele mobile ieftine. Software-ul este conceput să ruleze fără probleme pe întregul spectru hardware:

* **Gamă mobilă țintă**: Optimizat pentru a rula perfect pe dispozitive Android low-end (smartphone-uri și tablete sub 200 €), precum și pe hardware premium Apple iOS/iPadOS.
* **Ecosisteme desktop**: Suport nativ complet pentru Windows, macOS și Linux (orice distribuție).

### 🛠️ Stack tehnic

* **Limbaj și framework**: Kotlin Multiplatform (KMP) + Compose Multiplatform pentru interfață utilizator și logică de business 100% partajate pe mobil și desktop.
* **Stocare locală**: SQLDelight pentru o gestionare rapidă, sigură pentru tipuri și multiplatformă a bazelor de date încorporate.
* **Mediu de dezvoltare**: Suită JetBrains (IntelliJ IDEA + DataGrip).

---

## 🔒 Politică de confidențialitate, securitate a datelor și monetizare

Acest software este construit în jurul principiilor de bază ale confidențialității utilizatorilor, proprietății depline asupra datelor și transparenței absolute:

* **Arhitectură 100% offline și locală**: Sistemul funcționează complet offline. Toate datele, compendiile, campaniile și fișele de personaje sunt salvate exclusiv într-o bază de date locală securizată pe dispozitivul dvs. fizic.
* **Zero sincronizare în cloud și fără urmărire cu terți**: Software-ul nu încarcă datele dvs. personale pe niciun server extern și nici nu distribuie sau vinde informațiile dvs. către terți.
* **Notificare de autentificare**: Datele personale sunt utilizate exclusiv pentru a genera datele de conectare la profilul local (e-mail și parolă). Deoarece nu există o bază de date centralizată în cloud, **pierderea parolei sau a e-mailului înregistrat înseamnă pierderea permanentă a accesului la contul local și la date**. Nu există o funcție de server de „resetare parolă”.
* **Fără reclame, telemetrie sau bloatware**: Codul sursă este public și vizibil de oricine de pe GitHub pentru a garanta absența completă a adware-ului, bloatware-ului, scripturilor de urmărire, telemetriei ascunse sau reclamelor înșelătoare.
* **Fără microtranzacții**: Software-ul nu include microtranzacții, achiziții în aplicație, paywall-uri sau mecanici de joc deblocabile cu plată de niciun fel.

---

## 🏗️ Ecrane și roluri de joc

#### 🔐 Autentificare

* Ecran de conectare universală pentru sesiunile de campanie locale.

#### 👑 Ecran Dungeon Master (DM)

* **Universal Compendium**: Un browser de documentație integrat, ultra-rapid, care încarcă adaptiv manualele în funcție de sistemul de joc activ.
* **Gestionarea manualelor**: Suport pentru stocarea manuală locală, citirea datelor direct din memoria internă, unități USB externe sau carduri MicroSD.
* **Tablou de bord al campaniei**: Prezentare generală a campaniei, Dice Roller digital, Fișe NPC și creatori de obiecte personalizate care injectează conținut în baza de date fără a modifica baza de date cu reguli principale.
* **Centru de aprobare**: Centru de notificări în timp real pentru a aproba sau respinge modificările fișei de personaj solicitate de jucători.

#### ⚔️ Ecran jucător

* **Fișă de personaj interactivă**: Fișe de personaj complet interactive, editabile, cu un Dice Roller încorporat.
* **Acces la Reguli Țintă**: Acces direct la manualele de joc filtrate strict pentru mecanicile orientate către jucător (Abilități, Vrăji, Talente, Condiții de Status, Rase și Clase).
* **Motor de Sincronizare și Alertă**: Orice modificare structurală adusă fișei de personaj declanșează automat o alertă către DM, în așteptarea aprobării înainte de a deveni permanentă.

---

## 📄 Licență

Acest proiect este protejat și licențiat sub **Licența Strictă PolyForm 1.0.0**.

### ⚠️ Doar Utilizare Necomercială și Restricționată

* **Permis**: Puteți utiliza acest software liber pentru hobby-uri personale, cercetare academică, studiu sau campanii non-profit.
* **Interzis**: **Nu puteți** utiliza acest software sau codul său sursă în scopuri comerciale, monetizare sau în cadrul unei companii.
* **Interzis**: Modificarea și redistribuirea acestui cod de către terți sunt **strict interzise**. Doar autorul original deține drepturile de distribuție și modificare.

Pentru detalii legale complete, vă rugăm să citiți fișierul oficial [LICENSE.md](./LICENSE.md) din directorul rădăcină.

### 🌐 Localizări ale licențelor

Pentru a ajuta dezvoltatorii din întreaga lume să înțeleagă aceste restricții, traducerile oferite prin curtoazie sunt disponibile în folderul [<./Localization/License/>](<./Localization/License/>):

* 🇮🇹 [Italiano (Italiană)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [Engleză (Copie de referință)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Franceză (Franceză)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Spaniolă (Spaniolă)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Germană (germană)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (chineză)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (chineză)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (japoneză)](<./Localization/License/LICENSE.ja.md>)
* ...și [multe alte limbi](./LICENSE.md).

*Notă: versiunea oficială în limba engleză din directorul rădăcină este singurul text obligatoriu din punct de vedere legal.*
