# VTT (Virtual Tabletop) Multi-Sistema

Un Virtual Tabletop (VTT) leggero, potente e multipiattaforma, progettato per giochi di ruolo (RPG) che spaziano dai sistemi più diffusi come D&D e Pathfinder ai prodotti indie di nicchia. Realizzato con particolare attenzione alle alte prestazioni, alla completa proprietà dei dati e all'estrema compatibilità hardware.

---

# 🚀 Panoramica e Visione del Progetto

L'obiettivo di questo VTT (Virtual Tabletop) è colmare il divario tra ambienti desktop di fascia alta e dispositivi mobili economici. Il software è progettato per funzionare senza problemi su tutto lo spettro hardware:

* **Gamma di dispositivi mobili di destinazione**: ottimizzato per funzionare perfettamente su dispositivi Android di fascia bassa (smartphone e tablet sotto i 200 €), nonché su hardware Apple iOS/iPadOS di fascia alta.
* **Ecosistemi desktop**: supporto nativo completo per Windows, macOS e Linux (qualsiasi distribuzione).

### 🛠️ Stack tecnologico

* **Linguaggio e framework**: Kotlin Multiplatform (KMP) + Compose Multiplatform per un'interfaccia utente e una logica di business condivise al 100% tra dispositivi mobili e desktop.
* **Archiviazione locale**: SQLDelight per una gestione di database embedded multipiattaforma veloce, con tipizzazione sicura.
* **Ambiente di sviluppo**: JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Informativa su privacy, sicurezza dei dati e monetizzazione

Questo software è costruito attorno ai principi fondamentali della privacy degli utenti, della piena proprietà dei dati e della trasparenza assoluta:

* **Architettura 100% offline e locale**: Il sistema funziona interamente offline. Tutti i dati, i compendi, le campagne e le schede dei personaggi vengono salvati esclusivamente in un database locale sicuro sul tuo dispositivo fisico.
* **Nessuna sincronizzazione cloud e nessun tracciamento di terze parti**: Il software non carica i tuoi dati personali su alcun server esterno, né distribuisce o vende le tue informazioni a terzi.
* **Avviso di autenticazione**: I dati personali vengono utilizzati esclusivamente per generare le credenziali di accesso al tuo profilo locale (email e password). Poiché non esiste un database cloud centralizzato, **la perdita della password o dell'email registrata comporta la perdita permanente dell'accesso al tuo account locale e ai tuoi dati**. Non è disponibile una funzione di "reimpostazione password" sul server.
* **Nessuna pubblicità, telemetria o bloatware**: il codice sorgente è pubblico e consultabile da chiunque su GitHub per garantire la completa assenza di adware, bloatware, script di tracciamento, telemetria nascosta o pubblicità ingannevole.
* **Nessuna microtransazione**: il software non presenta microtransazioni, acquisti in-app, contenuti a pagamento o meccaniche di gioco sbloccabili a pagamento di alcun tipo.

---

## 🏗️ Schermate di gioco e ruoli

#### 🔐 Autenticazione
* Schermata di accesso universale per sessioni locali.

#### 👑 Schermata del Dungeon Master (DM)

* **Compendio universale**: un browser di documentazione integrato e ultraveloce che carica i manuali in modo adattivo a seconda del sistema di gioco attivo.
* **Gestione manuali**: supporto per l'archiviazione locale dei manuali, lettura dei dati direttamente dalla memoria interna, da unità USB esterne o da schede MicroSD.
* **Dashboard della campagna**: panoramica della campagna, lancio di dadi digitale, schede PNG e creatori di oggetti personalizzati che inseriscono contenuti nel database senza modificare il database delle regole principali.
* **Centro approvazioni**: hub di notifiche in tempo reale per approvare o rifiutare le modifiche alle schede dei personaggi richieste dai giocatori.


#### ⚔️ Schermata del giocatore

* **Scheda personaggio interattiva**: Schede personaggio completamente interattive e modificabili con un lanciatore di dadi integrato.
* **Accesso mirato alle regole**: Accesso diretto ai manuali di gioco filtrati specificamente per le meccaniche di gioco dei giocatori (Abilità, Incantesimi, Talenti, Condizioni di stato, Razze e Classi).
* **Motore di sincronizzazione e notifica**: Qualsiasi modifica strutturale apportata alla scheda personaggio attiva automaticamente una notifica al DM, che dovrà essere approvata prima di diventare permanente.

---

## 📄 Licenza

Questo progetto è protetto e concesso in licenza secondo la **PolyForm Strict License 1.0.0**.

### ⚠️ Solo per uso non commerciale e limitato

* **Consentito**: È possibile utilizzare questo software liberamente per hobby personali, ricerca accademica, studio o campagne senza scopo di lucro.
* **Vietato**: **Non è consentito** utilizzare questo software o il suo codice sorgente per scopi commerciali, monetizzazione o all'interno di un'azienda.
* **Vietato**: La modifica e la ridistribuzione di questo codice da parte di terzi sono **severamente vietate**. Solo l'autore originale detiene i diritti di distribuzione e modifica.

Per i dettagli legali completi, si prega di leggere il file ufficiale [LICENSE.md](./LICENSE.md) nella directory principale.


### 🌐 Localizzazioni della licenza
Per aiutare gli sviluppatori di tutto il mondo a comprendere queste restrizioni, sono disponibili traduzioni di cortesia nella cartella [<./Localization/License/>](<./Localization/License/>):

* 🇮🇹 [Italiano (Italian)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [English (Reference Copy)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Français (French)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Español (Spanish)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Deutsch (Tedesco)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (cinese)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (cinese)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (giapponese)](<./Localization/License/LICENSE.ja.md>)
* ...e [molte altre lingue](./LICENSE.md).

*Nota: la versione ufficiale in inglese presente nella directory principale è l'unico testo legalmente vincolante.*
