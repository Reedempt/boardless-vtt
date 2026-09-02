# Bàn chơi ảo đa hệ thống (VTT)

Một Bàn chơi ảo (VTT) nhẹ, mạnh mẽ và đa nền tảng được thiết kế cho các trò chơi nhập vai (RPG) từ các hệ thống phổ biến như D&D và Pathfinder đến các sản phẩm độc lập chuyên biệt. Được xây dựng với trọng tâm là hiệu suất cao, quyền sở hữu dữ liệu hoàn toàn và khả năng truy cập phần cứng tối đa.

---

## 🚀 Tổng quan và Tầm nhìn Dự án

Mục tiêu của VTT này là thu hẹp khoảng cách giữa môi trường máy tính để bàn cao cấp và các thiết bị di động giá rẻ. Phần mềm được thiết kế để chạy mượt mà trên toàn bộ phổ phần cứng:

* **Phạm vi thiết bị di động mục tiêu**: Được tối ưu hóa để chạy hoàn hảo trên các thiết bị Android cấp thấp (điện thoại thông minh và máy tính bảng dưới 200 €), cũng như phần cứng Apple iOS/iPadOS cao cấp.
* **Hệ sinh thái máy tính để bàn**: Hỗ trợ đầy đủ các hệ điều hành Windows, macOS và Linux (bất kỳ bản phân phối nào).

### 🛠️ Công nghệ sử dụng

* **Ngôn ngữ & Khung phần mềm**: Kotlin Multiplatform (KMP) + Compose Multiplatform cho giao diện người dùng và logic nghiệp vụ được chia sẻ 100% trên thiết bị di động và máy tính để bàn.
* **Lưu trữ cục bộ**: SQLDelight để quản lý cơ sở dữ liệu nhúng đa nền tảng nhanh chóng, an toàn kiểu dữ liệu.
* **Môi trường phát triển**: JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Chính sách về Quyền riêng tư, Bảo mật Dữ liệu & Kiếm tiền

Phần mềm này được xây dựng dựa trên các nguyên tắc cốt lõi về quyền riêng tư của người dùng, quyền sở hữu dữ liệu đầy đủ và tính minh bạch tuyệt đối:

* **Kiến trúc 100% Ngoại tuyến & Cục bộ**: Hệ thống hoạt động hoàn toàn ngoại tuyến. Tất cả dữ liệu, tài liệu tham khảo, chiến dịch và bảng nhân vật đều được lưu trữ độc quyền trong cơ sở dữ liệu cục bộ an toàn trên thiết bị vật lý của bạn.
* **Không đồng bộ hóa đám mây & Không theo dõi bởi bên thứ ba**: Phần mềm không tải dữ liệu cá nhân của bạn lên bất kỳ máy chủ bên ngoài nào, cũng như không phân phối hoặc bán thông tin của bạn cho bên thứ ba.
* **Thông báo xác thực**: Dữ liệu cá nhân chỉ được sử dụng để tạo thông tin đăng nhập hồ sơ cục bộ của bạn (email và mật khẩu). Vì không có cơ sở dữ liệu đám mây tập trung, **việc mất mật khẩu hoặc email đã đăng ký có nghĩa là bạn sẽ mất quyền truy cập vào tài khoản và dữ liệu cục bộ của mình vĩnh viễn**. Không có chức năng "đặt lại mật khẩu" trên máy chủ.
* **Không có quảng cáo, thu thập dữ liệu hoặc phần mềm không cần thiết**: Mã nguồn được công khai và bất kỳ ai cũng có thể xem trên GitHub để đảm bảo hoàn toàn không có phần mềm quảng cáo, phần mềm không cần thiết, tập lệnh theo dõi, thu thập dữ liệu ẩn hoặc quảng cáo gây hiểu nhầm.
* **Không có giao dịch nhỏ**: Phần mềm không có giao dịch nhỏ, mua hàng trong ứng dụng, tường phí hoặc cơ chế trò chơi có thể mở khóa bằng phí dưới bất kỳ hình thức nào.

---

## 🏗️ Màn hình trò chơi & Vai trò

#### 🔐 Xác thực
* Màn hình đăng nhập chung cho các phiên chiến dịch cục bộ.

#### 👑 Màn hình Quản trò (DM)

* **Bảng tổng hợp chung**: Trình duyệt tài liệu tích hợp, cực nhanh, tự động tải hướng dẫn tùy thuộc vào hệ thống trò chơi đang hoạt động.
* **Quản lý hướng dẫn**: Hỗ trợ lưu trữ hướng dẫn cục bộ, đọc dữ liệu trực tiếp từ bộ nhớ trong, ổ USB ngoài hoặc thẻ MicroSD.
* **Bảng điều khiển chiến dịch**: Tổng quan chiến dịch, công cụ tung xúc xắc kỹ thuật số, bảng NPC và công cụ tạo vật phẩm tùy chỉnh, chèn nội dung vào cơ sở dữ liệu mà không làm thay đổi cơ sở dữ liệu quy tắc chính.
* **Trung tâm phê duyệt**: Trung tâm thông báo thời gian thực để phê duyệt hoặc từ chối các sửa đổi bảng nhân vật do người chơi yêu cầu.

#### ⚔️ Màn hình người chơi

* **Bảng nhân vật tương tác**: Bảng nhân vật hoàn toàn tương tác, có thể chỉnh sửa với công cụ tung xúc xắc tích hợp.
* **Truy cập luật chơi có mục tiêu**: Truy cập trực tiếp vào sách hướng dẫn trò chơi được lọc nghiêm ngặt cho các cơ chế dành cho người chơi (Khả năng, Phép thuật, Kỹ năng, Trạng thái, Chủng tộc và Lớp nhân vật).
* **Công cụ đồng bộ hóa & cảnh báo**: Bất kỳ thay đổi cấu trúc nào được thực hiện đối với bảng nhân vật sẽ tự động kích hoạt cảnh báo cho DM, chờ phê duyệt trước khi có hiệu lực vĩnh viễn.

---

## 📄 Giấy phép

Dự án này được bảo vệ và cấp phép theo **Giấy phép PolyForm Strict 1.0.0**.

### ⚠️ Chỉ sử dụng phi thương mại & có hạn chế

* **Được phép**: Bạn có thể sử dụng phần mềm này một cách tự do cho sở thích cá nhân, nghiên cứu học thuật, học tập hoặc các chiến dịch phi lợi nhuận.
* **Bị cấm**: Bạn **không được phép** sử dụng phần mềm này hoặc mã nguồn của nó cho bất kỳ mục đích thương mại, kiếm tiền hoặc trong phạm vi công ty nào.
* **Bị cấm**: Việc sửa đổi và phân phối lại mã này bởi bên thứ ba **bị nghiêm cấm**. Chỉ tác giả gốc mới có quyền phân phối và sửa đổi.

Để biết đầy đủ các chi tiết pháp lý, vui lòng đọc tệp [LICENSE.md](./LICENSE.md) chính thức trong thư mục gốc.

### 🌐 Bản dịch Giấy phép
Để giúp các nhà phát triển trên toàn thế giới hiểu rõ những hạn chế này, các bản dịch tham khảo có sẵn trong thư mục [<./Localization/License/>](<./Localization/License/>):

* 🇮🇹 [Italiano (Tiếng Ý)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [English (Bản tham khảo)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Français (Tiếng Pháp)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Español (Tiếng Tây Ban Nha)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Tiếng Đức (tiếng Đức)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (tiếng Trung)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (tiếng Trung)](<./Localization/Lilicense/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (tiếng Nhật)](<./Localization/License/LICENSE.ja.md>)
* ...và [nhiều ngôn ngữ khác](./LICENSE.md).

*Lưu ý: Phiên bản tiếng Anh chính thức trong thư mục gốc là văn bản ràng buộc về mặt pháp lý duy nhất.*
