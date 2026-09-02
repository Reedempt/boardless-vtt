# Multi-System VTT (Virtual Tabletop)

Lekki, wydajny i wieloplatformowy Virtual Tabletop (VTT) przeznaczony do gier RPG, od popularnych systemów, takich jak D&D i Pathfinder, po niszowe produkcje niezależne. Zaprojektowany z naciskiem na wysoką wydajność, pełną kontrolę nad danymi i ekstremalną dostępność sprzętu.

---

## 🚀 Przegląd i wizja projektu

Celem tego VTT jest wypełnienie luki między środowiskami desktopowymi wysokiej klasy a niedrogimi urządzeniami mobilnymi. Oprogramowanie zostało zaprojektowane tak, aby płynnie działać na całym spektrum sprzętowym:

* **Docelowy zakres mobilny**: Zoptymalizowany pod kątem bezproblemowego działania na urządzeniach z systemem Android niższej klasy (smartfonach i tabletach poniżej 200 euro), a także na sprzęcie premium Apple iOS/iPadOS.
* **Ekosystemy desktopowe**: Pełne natywne wsparcie dla systemów Windows, macOS i Linux (dowolna dystrybucja).

### 🛠️ Stos technologiczny

* **Język i framework**: Kotlin Multiplatform (KMP) + Compose Multiplatform dla w 100% współdzielonego interfejsu użytkownika i logiki biznesowej na urządzeniach mobilnych i komputerach stacjonarnych.
* **Pamięć lokalna**: SQLDelight do szybkiego, bezpiecznego pod względem typów, wieloplatformowego zarządzania wbudowaną bazą danych.
* **Środowisko programistyczne**: JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Polityka prywatności, bezpieczeństwa danych i monetyzacji

To oprogramowanie zostało zbudowane w oparciu o podstawowe zasady prywatności użytkownika, pełnej własności danych i absolutnej przejrzystości:

* **100% offline i architektura lokalna**: System działa całkowicie offline. Wszystkie dane, kompendia, kampanie i karty postaci są zapisywane wyłącznie w bezpiecznej lokalnej bazie danych na Twoim urządzeniu fizycznym.
* **Brak synchronizacji w chmurze i śledzenia przez osoby trzecie**: Oprogramowanie nie przesyła danych osobowych na żaden serwer zewnętrzny, ani nie rozpowszechnia ani nie sprzedaje tych informacji osobom trzecim.
* **Informacja o uwierzytelnianiu**: Dane osobowe służą wyłącznie do generowania loginu do profilu lokalnego (adres e-mail i hasło). Ponieważ nie ma scentralizowanej bazy danych w chmurze, **utrata hasła lub zarejestrowanego adresu e-mail oznacza trwałą utratę dostępu do konta lokalnego i danych**. Nie ma funkcji resetowania hasła na serwerze.
* **Brak reklam, telemetrii i bloatware**: Kod źródłowy jest publiczny i dostępny dla każdego w serwisie GitHub, co gwarantuje całkowity brak adware, bloatware, skryptów śledzących, ukrytej telemetrii i mylących reklam.
* **Brak mikropłatności**: Oprogramowanie nie oferuje żadnych mikropłatności, zakupów w aplikacji, paywallów ani płatnych, odblokowywalnych mechanik gry.

---

## 🏗️ Ekrany gry i role

#### 🔐 Uwierzytelnianie

* Uniwersalny ekran logowania do lokalnych sesji kampanii.

#### 👑 Ekran Mistrza Gry (DM)

* **Uniwersalne Kompendium**: Zintegrowana, ultraszybka przeglądarka dokumentacji, która adaptacyjnie wczytuje instrukcje w zależności od aktywnego systemu gry.
* **Zarządzanie instrukcjami**: Obsługa lokalnego przechowywania instrukcji, odczyt danych bezpośrednio z pamięci wewnętrznej, zewnętrznych dysków USB lub kart MicroSD.
* **Pulpit kampanii**: Przegląd kampanii, cyfrowy rzut kośćmi, arkusze postaci niezależnych (NPC) i kreatory przedmiotów, które dodają zawartość do bazy danych bez zmiany głównej bazy zasad.
* **Centrum zatwierdzania**: Centrum powiadomień w czasie rzeczywistym umożliwiające zatwierdzanie lub odrzucanie modyfikacji arkusza postaci żądanych przez graczy.

#### ⚔️ Ekran gracza

* **Interaktywny arkusz postaci**: W pełni interaktywne, edytowalne arkusze postaci z wbudowanym rzutem kośćmi. * **Dostęp do zasad dla wybranych graczy**: Bezpośredni dostęp do instrukcji gry, filtrowanych ściśle pod kątem mechanik widocznych dla graczy (zdolności, zaklęcia, atuty, warunki statusu, rasy i klasy).
* **Silnik synchronizacji i alertów**: Każda zmiana strukturalna w karcie postaci automatycznie uruchamia alert dla Mistrza Gry, który oczekuje na zatwierdzenie, zanim stanie się trwała.

---

## 📄 Licencja

Ten projekt jest chroniony i licencjonowany na podstawie **licencji PolyForm Strict License 1.0.0**.

### ⚠️ Tylko do użytku niekomercyjnego i ograniczonego

* **Dozwolone**: Możesz swobodnie korzystać z tego oprogramowania w celach hobbystycznych, badań naukowych, studiów lub kampanii non-profit.
* **Zabronione**: Nie możesz **używac** tego oprogramowania ani jego kodu źródłowego do celów komercyjnych, monetyzacji ani w obrębie firmy.
* **Zabronione**: Modyfikacja i redystrybucja tego kodu przez osoby trzecie są **surowo zabronione**. Prawa do dystrybucji i modyfikacji przysługują wyłącznie oryginalnemu autorowi.

Aby uzyskać pełne informacje prawne, zapoznaj się z oficjalnym plikiem [LICENSE.md](./LICENSE.md) w katalogu głównym.

### 🌐 Lokalizacje licencji

Aby ułatwić programistom na całym świecie zrozumienie tych ograniczeń, w folderze [<./Localization/License/>](<./Localization/License/>) dostępne są tłumaczenia uprzejmościowe:

* 🇮🇹 [Italiano (włoski)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [angielski (kopia referencyjna)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Français (francuski)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Español (hiszpański)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Deutsch (niemiecki)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (chiński)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (chiński)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (japoński)](<./Localization/License/LICENSE.ja.md>)
* ...i [wiele innych języków](./LICENSE.md).

*Uwaga: Jedynym tekstem o wiążącej prawnie mocy jest oficjalna wersja angielska, znajdująca się w katalogu głównym.*
