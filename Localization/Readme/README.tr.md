# Çoklu Sistem Sanal Masaüstü (VTT)

D&D ve Pathfinder gibi ana akım sistemlerden niş bağımsız ürünlere kadar rol yapma oyunları (RPG'ler) için tasarlanmış, hafif, güçlü ve çok platformlu bir Sanal Masaüstü (VTT). Yüksek performans, tam veri sahipliği ve son derece donanım erişilebilirliğine odaklanılarak geliştirilmiştir.

---

## 🚀 Proje Genel Bakışı ve Vizyonu

Bu VTT'nin amacı, üst düzey masaüstü ortamları ile bütçe dostu mobil cihazlar arasındaki boşluğu kapatmaktır. Yazılım, tüm donanım yelpazesinde sorunsuz çalışacak şekilde tasarlanmıştır:

* **Hedef Mobil Cihaz Aralığı**: Düşük fiyatlı Android cihazlarda (200 €'nun altındaki akıllı telefonlar ve tabletler) ve üst düzey Apple iOS/iPadOS donanımında kusursuz çalışacak şekilde optimize edilmiştir.
* **Masaüstü Ekosistemleri**: Windows, macOS ve Linux (herhangi bir dağıtım) için tam yerel destek.

### 🛠️ Teknoloji Yığını

* **Dil ve Çerçeve**: Mobil ve masaüstü cihazlarda %100 paylaşılan kullanıcı arayüzü ve iş mantığı için Kotlin Multiplatform (KMP) + Compose Multiplatform.
* **Yerel Depolama**: Hızlı, tür güvenli, çok platformlu gömülü veritabanı yönetimi için SQLDelight.
* **Geliştirme Ortamı**: JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Gizlilik, Veri Güvenliği ve Para Kazanma Politikası

Bu yazılım, kullanıcı gizliliği, tam veri sahipliği ve mutlak şeffaflık temel ilkeleri üzerine kurulmuştur:

* **%100 Çevrimdışı ve Yerel Mimari**: Sistem tamamen çevrimdışı çalışır. Tüm veriler, özetler, kampanyalar ve karakter sayfaları, fiziksel cihazınızdaki güvenli bir yerel veritabanında saklanır.
* **Sıfır Bulut Senkronizasyonu ve Üçüncü Taraf İzleme Yok**: Yazılım, kişisel verilerinizi herhangi bir harici sunucuya yüklemez, bilgilerinizi üçüncü taraflara dağıtmaz veya satmaz. * **Kimlik Doğrulama Bildirimi**: Kişisel veriler yalnızca yerel profil girişinizi (e-posta ve şifre) oluşturmak için kullanılır. Merkezi bir bulut veritabanı olmadığı için, **şifrenizi veya kayıtlı e-postanızı kaybetmeniz, yerel hesabınıza ve verilerinize erişiminizi kalıcı olarak kaybetmeniz anlamına gelir**. "Şifre sıfırlama" sunucu işlevi yoktur.
* **Reklam, Telemetri veya Gereksiz Yazılım Yok**: Kaynak kodu herkese açık ve GitHub'da herkes tarafından görüntülenebilir; bu, reklam yazılımı, gereksiz yazılım, izleme komut dosyaları, gizli telemetri veya yanıltıcı reklamların tamamen yokluğunu garanti eder.
* **Mikro İşlem Yok**: Yazılımda hiçbir mikro işlem, uygulama içi satın alma, ödeme duvarı veya herhangi bir türde ücretli oyun mekaniği bulunmamaktadır.

---

## 🏗️ Oyun Ekranları ve Roller

#### 🔐 Kimlik Doğrulama

* Yerel kampanya oturumları için Evrensel Giriş Ekranı.

#### 👑 Zindan Ustası (DM) Ekranı

* **Evrensel Derleme**: Aktif oyun sistemine bağlı olarak kılavuzları uyarlanabilir şekilde yükleyen entegre, ultra hızlı bir dokümantasyon tarayıcısı.
* **Kılavuz Yönetimi**: Yerel kılavuz depolama desteği, verileri doğrudan dahili depolamadan, harici USB sürücülerden veya MicroSD kartlardan okuma.
* **Kampanya Kontrol Paneli**: Kampanya genel bakışı, dijital Zar Atıcı, NPC Sayfaları ve ana kural veritabanını değiştirmeden veritabanına içerik ekleyen özel öğe oluşturucular.
* **Onay Merkezi**: Oyuncular tarafından istenen karakter sayfası değişikliklerini onaylamak veya reddetmek için gerçek zamanlı bildirim merkezi.

#### ⚔️ Oyuncu Ekranı

* **Etkileşimli Karakter Sayfası**: Dahili Zar Atıcıya sahip, tamamen etkileşimli, düzenlenebilir karakter sayfaları.
* **Hedefli Kurallara Erişim**: Oyuncuya yönelik mekaniklere (Yetenekler, Büyüler, Nitelikler, Durum Koşulları, Irklar ve Sınıflar) özel olarak filtrelenmiş oyun kılavuzlarına doğrudan erişim.
* **Senkronizasyon ve Uyarı Motoru**: Karakter sayfasında yapılan herhangi bir yapısal değişiklik, kalıcı hale gelmeden önce onay bekleyen bir uyarıyı otomatik olarak DM'ye gönderir.

---

## 📄 Lisans

Bu proje, **PolyForm Strict License 1.0.0** kapsamında korunmaktadır ve lisanslanmıştır.

### ⚠️ Ticari Olmayan ve Sınırlı Kullanım

* **İzin Verilen**: Bu yazılımı kişisel hobileriniz, akademik araştırmalarınız, çalışmalarınız veya kar amacı gütmeyen kampanyalarınız için özgürce kullanabilirsiniz.
* **Yasaklanan**: Bu yazılımı veya kaynak kodunu herhangi bir ticari amaçla, para kazanmak için veya bir şirket içinde **kullanamazsınız**.
* **Yasaklanmıştır**: Bu kodun üçüncü şahıslar tarafından değiştirilmesi ve yeniden dağıtılması **kesinlikle yasaktır**. Dağıtım ve değiştirme hakları yalnızca orijinal yazara aittir.

Tüm yasal ayrıntılar için lütfen kök dizindeki resmi [LICENSE.md](./LICENSE.md) dosyasını okuyun.

### 🌐 Lisans Yerelleştirmeleri

Dünya genelindeki geliştiricilerin bu kısıtlamaları anlamalarına yardımcı olmak için, [<./Localization/License/>](<./Localization/License/>) klasöründe nezaket çevirileri mevcuttur:

* 🇮🇹 [Italiano (İtalyanca)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [English (Reference Copy)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Français (Fransızca)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Español (İspanyolca)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Almanca (Almanca)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (Çince)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (Çince)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (Japonca)](<./Localization/License/LICENSE.ja.md>)
* ...ve [diğer birçok dil](./LICENSE.md).

*Not: Kök dizindeki resmi İngilizce sürüm, yasal olarak bağlayıcı tek metindir.*
