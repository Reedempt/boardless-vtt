# VTT me Shumë Sisteme (Tabletë Virtuale)

Një Tabletë Virtuale (VTT) e lehtë, e fuqishme dhe me shumë platforma, e projektuar për lojëra me role (RPG) duke filluar nga sistemet kryesore si D&D dhe Pathfinder deri te produktet e specializuara indie. Ndërtuar me fokus në performancë të lartë, pronësi të plotë të të dhënave dhe aksesueshmëri ekstreme të harduerit.

---

## 🚀 Përmbledhje dhe Vizion i Projektit

Qëllimi i këtij VTT është të kapërcejë hendekun midis mjediseve desktop të nivelit të lartë dhe pajisjeve mobile me buxhet të ulët. Softueri është projektuar për të funksionuar pa probleme në të gjithë spektrin e harduerit:

* **Gama e Synuar Mobile**: I optimizuar për të funksionuar pa probleme në pajisjet Android të nivelit të ulët (smartphone dhe tableta nën 200 €), si dhe në harduerin premium Apple iOS/iPadOS.
* **Ekosisteme Desktopi**: Mbështetje e plotë native për Windows, macOS dhe Linux (çdo shpërndarje).

### 🛠️ Tech Stack

* **Gjuha dhe Korniza**: Kotlin Multiplatform (KMP) + Compose Multiplatform për 100% ndërfaqe përdoruesi dhe logjikë biznesi të përbashkët në celular dhe desktop.
* **Ruajtje Lokale**: SQLDelight për menaxhim të shpejtë, të sigurt për llojet e të dhënave dhe shumëplatformësh të integruar.
* **Mjedisi i Zhvillimit**: JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Politika e Privatësisë, Sigurisë së të Dhënave dhe Monetizimit

Ky softuer është ndërtuar rreth parimeve kryesore të privatësisë së përdoruesit, pronësisë së plotë të të dhënave dhe transparencës absolute:

* **100% Arkitekturë Jashtë Linje dhe Lokale**: Sistemi funksionon tërësisht jashtë linje. Të gjitha të dhënat, përmbledhjet, fushatat dhe fletët e karaktereve ruhen ekskluzivisht brenda një baze të dhënash të sigurt lokale në pajisjen tuaj fizike.
* **Zero Sinkronizim i Reve dhe Pa Gjurmim nga Palët e Treta**: Softueri nuk i ngarkon të dhënat tuaja personale në ndonjë server të jashtëm, as nuk shpërndan ose shet informacionin tuaj palëve të treta.
* **Njoftim për Autentifikimin**: Të dhënat personale përdoren vetëm për të gjeneruar hyrjen në profilin tuaj lokal (email dhe fjalëkalim). Meqenëse nuk ka një bazë të dhënash të centralizuar në cloud, **humbja e fjalëkalimit ose e emailit të regjistruar do të thotë humbje e përhershme e aksesit në llogarinë dhe të dhënat tuaja lokale**. Nuk ka funksion serveri "rivendos fjalëkalimin".
* **Pa reklama, telemetri ose bloatware**: Kodi burimor është publik dhe i shikueshëm nga kushdo në GitHub për të garantuar mungesën e plotë të adware, bloatware, skripteve të gjurmimit, telemetrisë së fshehur ose reklamave mashtruese.
* **Pa mikrotransaksione**: Softueri nuk përmban mikrotransaksione, blerje brenda aplikacionit, mure pagese ose mekanika lojërash të zhbllokueshme me pagesë të çdo lloji.

---

## 🏗️ Ekranet dhe Rolet e Lojës

#### 🔐 Autentifikimi

* Ekrani Universal i Hyrjes për seancat lokale të fushatës.

#### 👑 Ekrani Master i Dungeon (DM)

* **Universal Compendium**: Një shfletues dokumentacioni i integruar dhe ultra i shpejtë që ngarkon manualet në mënyrë adaptive në varësi të sistemit aktiv të lojës.
* **Menaxhimi Manual**: Mbështetje për ruajtjen manuale lokale, leximin e të dhënave direkt nga ruajtja e brendshme, disqet USB të jashtme ose kartat MicroSD.
* **Paneli i Fushatës**: Përmbledhje e fushatës, Rrotullues Zaresh dixhital, Fletë NPC dhe krijues të artikujve të personalizuar që injektojnë përmbajtje në bazën e të dhënave pa ndryshuar bazën e të dhënave të rregullave kryesore.
* **Qendra e Miratimit**: Qendër njoftimesh në kohë reale për të miratuar ose refuzuar modifikimet e fletës së personazheve të kërkuara nga lojtarët.

#### ⚔️ Ekrani i Lojtarit

* **Fletë Interaktive e Personazheve**: Fletë personazhesh plotësisht interaktive dhe të modifikueshme me një Rrotull Zaresh të integruar.
* **Qasje e Synuar në Rregulla**: Qasje e drejtpërdrejtë në manualet e lojës të filtruara në mënyrë strikte për mekanikat që përballen me lojtarin (Aftësi, Magji, Bëma, Kushtet e Statusit, Garat dhe Klasat).
* **Motori i Sinkronizimit dhe Alarmit**: Çdo ndryshim strukturor i bërë në fletën e personazheve shkakton automatikisht një alarm për DM, në pritje të miratimit përpara se të bëhet i përhershëm.

---

## 📄 Licencë

Ky projekt është i mbrojtur dhe i licencuar sipas **Licencës Strikte PolyForm 1.0.0**.

### ⚠️ Vetëm Përdorim Jo-Komercial dhe i Kufizuar

* **Lejohet**: Mund ta përdorni këtë softuer lirisht për hobi personale, kërkime akademike, studime ose fushata jofitimprurëse.
* **I Ndaluar**: Ju **nuk mund** ta përdorni këtë softuer ose kodin e tij burimor për qëllime komerciale, fitim parash ose brenda një kompanie.
* **I Ndaluar**: Modifikimi dhe rishpërndarja e këtij kodi nga palët e treta janë **rreptësisht të ndaluara**. Vetëm autori origjinal mban të drejtat e shpërndarjes dhe modifikimit.

Për detaje të plota ligjore, ju lutemi lexoni skedarin zyrtar [LICENSE.md](./LICENSE.md) në direktorinë rrënjë.

### 🌐 Lokalizimet e Licencave

Për të ndihmuar zhvilluesit në mbarë botën të kuptojnë këto kufizime, përkthimet e mirësjelljes janë të disponueshme në dosjen [<./Localization/License/>](<./Localization/License/>):

* 🇮🇹 [Italisht (Italisht)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [Anglisht (Kopje Reference)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Frëngjisht (Frëngjisht)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Spanjisht (Spanjisht)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Gjermanisht (Gjermanisht)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (Kinez)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (Kinez)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (Japonisht)](<./Localization/License/LICENSE.ja.md>)
* ...dhe [shumë gjuhë të tjera](./LICENSE.md).

*Shënim: Versioni zyrtar në anglisht në direktorinë rrënjë është i vetmi tekst ligjërisht i detyrueshëm.*
