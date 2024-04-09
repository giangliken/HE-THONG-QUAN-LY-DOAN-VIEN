<a name="br1"></a> 

Nhóm tác giả: NHÓM 5 - TOWKTEAM

**MỤC LỤC**

**LỜI NÓI ĐẦU........................................................................................................................................................1**

**LỜI CAM ĐOAN...................................................................................................................................................2**

**THÔNG TIN THÀNH VIÊN NHÓM “TOWKTEAM” VÀ MỨC ĐỘ ĐÓNG GÓP.....................................2**

**THÔNG TIN CHUNG...........................................................................................................................................2**

**MÔ TẢ CHỨC NĂNG.......................................................................................................................................... 3**

**I. SƠ ĐỒ LỚP.................................................................................................................................................. 3**

**II. MÔ TẢ CHI TIẾT......................................................................................................................................4**

**Lớp LoginSystem.java...............................................................................................................................4**

**Lớp DoanVien.java....................................................................................................................................4**

**Lớp HoatDongDoanVien.java...................................................................................................................6**

**Lớp DoanPhi.java...................................................................................................................................... 8**

**Lớp Ngay.java........................................................................................................................................... 8**

**Lớp Demo.java...........................................................................................................................................9**

**LỜI NÓI ĐẦU**

Trong thời đại công nghệ phát triển như hiện nay, việc sử dụng phần mềm để quản lý các hoạt động và thông tin

của đoàn viên đã trở thành một phần quan trọng trong việc tổ chức và hoạt động của các tổ chức đoàn thể. Đồ

án này ra đời với mục tiêu tạo ra một ứng dụng phần mềm quản lý đoàn viên bằng ngôn ngữ lập trình Java, giúp

các tổ chức đoàn thể và sinh viên dễ dàng quản lý thông tin và hoạt động của mình một cách hiệu quả và tiện

lợi.

Phần mềm quản lý đoàn viên được phát triển dựa trên nền tảng công nghệ Java, một ngôn ngữ lập trình phổ

biến và mạnh mẽ, có khả năng tương thích và di động cao. Điều này cho phép ứng dụng có thể chạy trên nhiều

nền tảng khác nhau mà không gặp phải vấn đề về tính tương thích.

Trong quá trình phát triển, chúng tôi đã tập trung vào việc xây dựng một hệ thống quản lý đoàn viên toàn diện,

bao gồm các tính năng như quản lý thông tin cá nhân của đoàn viên, hoạt động đoàn viên, đoàn phí, cũng như

các tính năng khác như bảo mật thông tin và tương tác.

Đồ án này không chỉ là sự kết hợp giữa kiến thức lập trình và quản lý dự án mà còn là sự cam kết của chúng tôi

đối với việc ứng dụng công nghệ để giải quyết các vấn đề thực tiễn trong xã hội. Chúng tôi hy vọng rằng ứng

dụng của chúng tôi sẽ mang lại giá trị và tiện ích cho cộng đồng đoàn viên cũng như các tổ chức quản lý đoàn

viên.

Chân thành cảm ơn sự quan tâm và hỗ trợ của mọi người đối với dự án của chúng tôi.

Trang 1



<a name="br2"></a> 

Nhóm tác giả: NHÓM 5 - TOWKTEAM

**LỜI CAM ĐOAN**

Chúng tôi, nhóm phát triển dự án quản lý đoàn viên bằng Java, cam kết với sự hoàn thiện và chất lượng của dự

án. Dưới đây là những cam kết của chúng tôi:

1\. **Cam kết về chất lượng**: Chúng tôi cam kết phát triển và triển khai dự án với chất lượng cao nhất có thể.

Mọi đoạn mã được viết sẽ được kiểm tra kỹ lưỡng để đảm bảo tính ổn định, an toàn và bảo mật của ứng

dụng.

2\. **Cam kết về tiến độ**: Chúng tôi cam kết hoàn thành dự án theo tiến độ đã đề ra. Chúng tôi sẽ làm việc

chăm chỉ và cố gắng hết sức để đảm bảo rằng mọi phần của dự án được hoàn thành đúng hạn.

3\. **Cam kết về tương tác và phản hồi**: Chúng tôi cam kết lắng nghe ý kiến và phản hồi từ người dùng và

các bên liên quan. Mọi góp ý và yêu cầu sẽ được đánh giá và tích hợp vào dự án một cách linh hoạt và

hiệu quả.

4\. **Cam kết về bảo mật thông tin**: Chúng tôi cam kết bảo vệ thông tin cá nhân của người dùng và đảm bảo

rằng dự án của chúng tôi tuân thủ các quy định và tiêu chuẩn về bảo mật dữ liệu.

5\. **Cam kết về hỗ trợ sau triển khai**: Sau khi dự án được triển khai, chúng tôi sẽ tiếp tục cung cấp hỗ trợ

và bảo trì để đảm bảo rằng ứng dụng hoạt động một cách trơn tru và hiệu quả.

**THÔNG TIN THÀNH VIÊN NHÓM**

***“TOWKTEAM”* VÀ MỨC ĐỘ ĐÓNG GÓP**

*Số thứ tự Họ và tên*

*Mã số sinh viên Mô tả công việc*

*Trưởng nhóm, thiết kế sơ đồ lớp, lên ý*

*Tiến độ*

*1*

*Nguyễn Trường Giang 2280600761*

*tưởng, thiết kế giao diện, giám sát tiến độ 100%*

*làm việc, lập trình lớp login và lớp demo.*

*2*

*3*

*4*

*Phạm Tiến Đồng*

*Phạm Mạnh Phi*

*Dương Minh Tiến*

*2280600704*

*2280602336*

*2280603211*

*Lập trình lớp DoanVien.java*

*Lập trình lớp HoatDongDoanVien.java*

*Lập trình lớp DoanPhi.java*

*100%*

*100%*

*100%*

**THÔNG TIN CHUNG**

**I. LÝ DO CHỌN ĐỀ TÀI “QUẢN LÝ ĐOÀN VIÊN”.**

1\. **Nhu cầu thực tiễn**: Đoàn viên là một phần không thể thiếu trong cộng đồng sinh viên và xã hội. Quản

lý thông tin của đoàn viên đóng vai trò quan trọng trong việc tổ chức hoạt động, tương tác và tạo ra môi

trường hỗ trợ cho sự phát triển cá nhân của từng thành viên.

2\. **Tính ứng dụng cao**: Một hệ thống quản lý đoàn viên có thể được áp dụng rộng rãi trong các tổ chức, từ

các tổ chức sinh viên đến các tổ chức tình nguyện và doanh nghiệp xã hội. Do đó, việc phát triển một

phần mềm quản lý đoàn viên mang lại giá trị thực tiễn và tiềm năng kinh doanh.

Trang 2



<a name="br3"></a> 

Nhóm tác giả: NHÓM 5 - TOWKTEAM

3\. **Hỗ trợ quản lý hiệu quả**: Một ứng dụng quản lý đoàn viên có thể giúp tổ chức quản lý thông tin cá

nhân, tài liệu, hoạt động và giao tiếp một cách hiệu quả hơn. Điều này giúp tối ưu hóa quá trình tổ chức

hoạt động và tạo ra một môi trường làm việc tích cực.

4\. **Thách thức trong quản lý truyền thống**: Phương pháp quản lý đoàn viên truyền thống thường gặp

phải nhiều thách thức như việc lưu trữ thông tin, theo dõi hoạt động và tương tác với đoàn viên. Một ứng

dụng phần mềm có thể giải quyết những thách thức này một cách hiệu quả và nhanh chóng.

5\. **Thúc đẩy sự đổi mới công nghệ trong quản lý tổ chức**: Việc áp dụng công nghệ vào quản lý tổ chức,

đặc biệt là trong việc quản lý đoàn viên, không chỉ giúp cải thiện hiệu suất mà còn thúc đẩy sự đổi mới

và phát triển trong cộng đồng.

**MÔ TẢ CHỨC NĂNG**

**I. SƠ ĐỒ LỚP**

Trang 3



<a name="br4"></a> 

Nhóm tác giả: NHÓM 5 - TOWKTEAM

**II. MÔ TẢ CHI TIẾT**

**Lớp LoginSystem.java**

**1. Thuộc tính:**

\-

**Users:** Một đối tượng HashMap<String, String> để lưu trữ thông tin đăng nhập của người dùng, với tên

đăng nhập làm khóa và mật khẩu làm giá trị.

**2. Phương thức:**

\-

input():

○ Gọi phương thức initializeUsersFromFile() để tải thông tin người dùng từ file.

○ In ra thông báo chào mừng "Welcome to the Login System!".

initializeUsersFromFile(String filename):

\-

○ Đọc thông tin người dùng từ file và lưu vào HashMap users.

○ Yêu cầu người dùng nhập username và password.

○ Đối chiếu thông tin nhập vào với dữ liệu lưu trong HashMap users.

○ Nếu khớp, báo đăng nhập thành công, hiển thị tiến trình và yêu cầu nhấn Enter để tiếp tục.

○ Nếu không khớp, báo lỗi đăng nhập và yêu cầu nhấn Enter để tiếp tục.

○ Trả về 1 nếu đăng nhập thành công, 0 nếu không thành công hoặc có lỗi.

clearScreen(): Xóa màn hình console

\-

\-

pressEnterToContinue(): Dừng chương trình và hiển thị thông báo "Nhấn Enter để tiếp tục"

**Tóm tắt:**

\-

\-

Lớp LoginSystem triển khai chức năng đăng nhập cơ bản.

Thông tin người dùng được lưu trữ trong file "accounts.txt" với định dạng username:password mỗi

dòng.

\-

Chương trình đọc thông tin từ file, đối chiếu với thông tin nhập vào và hiển thị kết quả đăng nhập.

**Lớp DoanVien.java**

**1. Các thuộc tính:**

\-

\-

\-

\-

\-

\-

\-

\-

maDoanVien: Lưu trữ mã đoàn viên ( kiểu int).

hoTen: Lưu trữ họ tên đoàn viên (kiểu String).

ngaySinh: Lưu trữ ngày sinh của đoàn viên (kiểu Ngay - giả sử đã có lớp Ngay để xử lý ngày tháng).

gioiTinh: Lưu trữ giới tính của đoàn viên (kiểu String - "Nam" hoặc "Nu").

diaChi: Lưu trữ địa chỉ của đoàn viên (kiểu String).

soDienThoai: Lưu trữ số điện thoại của đoàn viên (kiểu String).

eMail: Lưu trữ email của đoàn viên (kiểu String).

ngayVaoDoan: Lưu trữ ngày vào đoàn của đoàn viên (kiểu Ngay - giả sử đã có lớp Ngay để xử lý ngày

tháng).

\-

\-

chucVuDoan: Lưu trữ chức vụ trong đoàn của đoàn viên (kiểu String).

lopHoc: Lưu trữ lớp học của đoàn viên (kiểu String).

Trang 4



<a name="br5"></a> 

Nhóm tác giả: NHÓM 5 - TOWKTEAM

\-

danhSachDoanVien: Lưu trữ danh sách các đoàn viên (kiểu List<DoanVien>).

**2. Các phương thức:**

\-

\-

DoanVien(): Hàm khởi tạo mặc định, khởi tạo danh sách đoàn viên rỗng.

DoanVien(int maDoanVien, String hoTen, Ngay ngaySinh, String gioiTinh, String diaChi, String

soDienThoai, String eMail, Ngay ngayVaoDoan, String chucVuDoan, String lopHoc): Hàm khởi tạo đầy

đủ với các tham số.

\-

\-

\-

\-

getMaDoanVien(): Trả về mã đoàn viên.

setMaDoanVien(int maDoanVien): Thiết lập mã đoàn viên.

Các phương thức get và set tương tự cho các thuộc tính khác.

input(): Phương thức này dùng để nhập thông tin cho một đoàn viên mới. Nó thực hiện các kiểm tra để

đảm bảo dữ liệu nhập vào hợp lệ (số điện thoại chỉ chứa số, email đúng định dạng, ngày sinh đúng định

dạng dd/mm/yyyy,...)

**Lưu ý:**

\-

Code này phụ thuộc vào lớp Ngay để xử lý ngày tháng. Lớp Ngay không được cung cấp trong đoạn code

này.

\-

\-

Phương thức timDoanVienTheoID để tìm đoàn viên theo mã cũng không được cung cấp trong đoạn

code này.

menu: Hàm này hiển thị menu cho người dùng với các tùy chọn để quản lý đoàn viên. Các tùy chọn này

bao gồm:

a. Xem tất cả đoàn viên

b. Thêm đoàn viên mới

c. Chỉnh sửa thông tin đoàn viên

d. Tìm kiếm đoàn viên

e. Quản lý hoạt động đoàn viên

f. Quản lý phí đoàn

g. Xóa đoàn viên

h. Thoát chương trình

\-

\-

\-

readDoanVienFromFile: Hàm này đọc danh sách đoàn viên từ một tệp văn bản. Nó phân tích từng dòng

trong tệp, trích xuất thông tin đoàn viên và tạo các đối tượng DoanVien.

writeDoanVienToFile: Hàm này ghi danh sách đoàn viên vào một tệp văn bản. Nó lặp qua danh sách và

ghi thông tin của từng đoàn viên vào một dòng riêng biệt trong tệp.

suaThongTinDoanVien: Hàm này cho phép chỉnh sửa thông tin cho một đoàn viên cụ thể. Nó yêu cầu

người dùng nhập ID của đoàn viên cần chỉnh sửa. Nếu tìm thấy đoàn viên, nó sẽ hiển thị một menu khác

với các tùy chọn để chỉnh sửa các trường cụ thể như tên, ngày sinh, v.v. Các thay đổi được thực hiện

bằng cách tạo một đối tượng DoanVien mới với thông tin cập nhật, xóa đoàn viên cũ khỏi danh sách và

thêm đoàn viên mới. Cuối cùng, danh sách cập nhật được ghi lại vào tệp.

timDoanVienTheoID: Hàm này tìm kiếm một đoàn viên trong danh sách theo ID. Nó lặp qua danh sách

và so sánh ID cho đến khi tìm thấy kết quả phù hợp.

\-

\-

xoaDoanVien: Hàm này xóa một đoàn viên khỏi danh sách theo ID. Nó tìm thấy đoàn viên bằng cách sử

dụng timDoanVienTheoID và sau đó xóa nó khỏi danh sách. Danh sách cập nhật sau đó được ghi lại vào

tệp.

Trang 5



<a name="br6"></a> 

Nhóm tác giả: NHÓM 5 - TOWKTEAM

\-

\-

\-

DoanVien mới với thông tin cập nhật, xóa đoàn viên cũ khỏi danh sách và thêm đoàn viên mới. Cuối

cùng, danh sách cập nhật được ghi lại vào file.

timDoanVienTheoTen: Hàm này tìm kiếm đoàn viên theo tên. Nó duyệt danh sách và in thông tin của

các đoàn viên có tên khớp với tên tìm kiếm.

timDoanVienTheoNgaySinh, timDoanVienTheoNgayVaoDoan: Tương tự như timDoanVienTheoTen,

các hàm này tìm kiếm đoàn viên theo ngày sinh và ngày vào đoàn.

\-

\-

timDoanVienTheoSDT, timDoanVientheoeMail: Tìm kiếm đoàn viên theo số điện thoại và email.

timDoanVienTheoLopHoc: Hàm này tìm kiếm đoàn viên theo lớp học. Nó duyệt danh sách và in thông

tin của các đoàn viên có lớp học khớp với lớp học tìm kiếm.

\-

timDoanVien: Hàm chính để tìm kiếm đoàn viên. Nó cho phép người dùng chọn lựa tìm kiếm theo ID,

tên, ngày sinh, ngày vào đoàn, số điện thoại, email hoặc lớp học.

\-

\-

\-

\-

xoaDoanVien: Hàm này xóa một đoàn viên khỏi danh sách theo đối tượng DoanVien cung cấp.

output: Hàm này xuất thông tin của một đối tượng DoanVien ra màn hình theo định dạng bảng.

clearScreen: Hàm này xóa màn hình console (chỉ hoạt động trên Windows và Linux).

pressEnterToContinue: Hàm tạm dừng chương trình và chờ người dùng nhấn Enter để tiếp tục.

**Luồng chương trình:**

1\. Chương trình khởi chạy và gọi hàm menu để hiển thị tùy chọn cho người dùng.

2\. Người dùng chọn một chức năng mong muốn (ví dụ: xem danh sách, thêm mới, tìm kiếm, ...).

3\. Dựa trên lựa chọn của người dùng, chương trình gọi hàm tương ứng để thực hiện chức năng đó.

4\. Sau khi thực hiện xong chức năng, chương trình quay lại bước 1 để hiển thị menu và chờ người dùng

chọn tiếp.

5\. Chương trình chỉ dừng khi người dùng chọn chức năng thoát (có mã là 0).

**Tóm lược:**

Đây là chương trình quản lý danh sách đoàn viên đơn giản. Nó cho phép người dùng thêm, xem, sửa, tìm kiếm

và xóa đoàn viên. Dữ liệu đoàn viên được lưu trữ trong một file văn bản. Chương trình chưa đầy đủ tính năng,

thiếu phần quản lý hoạt động đoàn viên và quản lý phí đoàn.

**Lớp HoatDongDoanVien.java**

**Các thành phần chính:**

**1. Thuộc tính:**

○ maHoatDong: Mã số hoạt động.

○ maDoanVien: Mã số đoàn viên tham gia hoạt động.

○ tenDoanVien: Tên đoàn viên tham gia hoạt động.

○ tenHoatDong: Tên hoạt động.

○ ngayToChuc: Ngày tổ chức hoạt động (đối tượng Ngay).

○ diaDiem: Địa điểm tổ chức hoạt động.

○ noiDung: Nội dung hoạt động.

○ danhSachHoatDong: List lưu trữ thông tin các hoạt động dưới dạng chuỗi.

**2. Phương thức khởi tạo:**

● Phương thức get/set: Cho phép truy cập và thay đổi giá trị của các thuộc tính.

Trang 6



<a name="br7"></a> 

Nhóm tác giả: NHÓM 5 - TOWKTEAM

● Phương thức getTenDoanVien(int maDoanVien): Lấy tên đoàn viên dựa trên mã đoàn viên từ file danh

sách đoàn viên.

● Phương thức themHoatDong(): Thêm một hoạt động mới vào danh sách, bao gồm:

○ Nhập thông tin hoạt động từ người dùng.

○ Định dạng thông tin thành chuỗi và thêm vào danh sách danhSachHoatDong.

● Phương thức hienThiHoatDong(): Hiển thị danh sách các hoạt động đoàn của đoàn viên.

● Phương thức xoaHoatDong(List<HoatDongDoanVien> danhSachHoatDong, int maHoatDong):

○ Tìm kiếm hoạt động có mã tương ứng trong danh sách.

○ Nếu tìm thấy, xóa hoạt động đó khỏi danh sách và cập nhật file lưu trữ.

● Phương thức capNhatDanhSachHoatDong(String tenTep, List<HoatDongDoanVien>

danhSachHoatDong):

○ Ghi danh sách hoạt động đã cập nhật vào file với định dạng quy định.

● Phương thức input(): Xử lý nhập liệu từ người dùng để tạo hoạt động mới:

○ Xác thực sự tồn tại của mã đoàn viên và định dạng đầu vào.

○ Gọi inputHoatDong(sc) để lấy chi tiết hoạt động cụ thể.

● Phương thức inputHoatDong(Scanner sc): Nhắc người dùng nhập và xác thực chi tiết hoạt động:

○ Tên hoạt động (giới hạn 30 ký tự).

○ Ngày hoạt động (sử dụng đối tượng Ngay và xác thực định dạng).

○ Địa điểm hoạt động (giới hạn 30 ký tự).

○ Nội dung hoạt động (giới hạn 50 ký tự).

● Phương thức tĩnh readFile(String tenTep): Đọc thông tin hoạt động từ file:

○ Phân tích từng dòng và tạo đối tượng HoatDongDoanVien.

○ Xác thực định dạng dữ liệu và xử lý các lỗi tiềm ẩn.

○ Trả về danh sách các đối tượng HoatDongDoanVien.

● Phương thức tĩnh readDoanVienFromFile(String filename): Đọc thông tin đoàn viên từ file:

○ Phân tích từng dòng và tạo đối tượng DoanVien.

○ Xác thực định dạng dữ liệu và xử lý các lỗi tiềm ẩn.

○ Trả về danh sách các đối tượng DoanVien.

● Phương thức checkMaDoanVien(int maDoanVien): Kiểm tra xem mã đoàn viên có tồn tại trong file dữ

liệu đoàn viên hay không.

● output(): Định dạng và in thông tin về một hoạt động ra màn hình.

● clearScreen(): Xóa màn hình console (phụ thuộc vào nền tảng).

● pressEnterToContinue(): Tạm dừng chương trình cho đến khi người dùng nhấn Enter.

● xuatDSHoatDong(): Đọc danh sách hoạt động từ tệp, hiển thị từng hoạt động bằng output() và hiển thị

tổng số hoạt động.

● timHoatDongTheoID(int maHoatDong): Tìm kiếm hoạt động theo mã trong danh sách và trả về đối

tượng HoatDongDoanVien tương ứng hoặc null nếu không tìm thấy.

● timTenDoanVienTheoMaHoatDong(int maHoatDong): Tìm kiếm tên đoàn viên theo mã hoạt động và

trả về tên dưới dạng chuỗi, hoặc null nếu không tìm thấy.

● timKiemHoatDong(): Cung cấp menu tìm kiếm hoạt động dựa trên các tiêu chí:

○ Mã

○ Tên đoàn viên

○ Tên hoạt động

○ Ngày

Trang 7



<a name="br8"></a> 

Nhóm tác giả: NHÓM 5 - TOWKTEAM

○ Địa điểm

○ Mỗi tùy chọn sử dụng vòng lặp để duyệt qua danh sách hoạt động và hiển thị các hoạt động phù

hợp bằng output().

● suaThongTinHoatDong(): Cho phép chỉnh sửa thông tin cho hoạt động hiện có:

○ Hỏi người dùng mã hoạt động.

○ Nếu tìm thấy mã, hiển thị menu chọn trường để chỉnh sửa (mã, tên, ngày, địa điểm, mô tả).

○ Dựa trên lựa chọn của người dùng, hỏi giá trị mới và cập nhật trường tương ứng trong đối tượng

HoatDongDoanVien.

**Lớp DoanPhi.java**

**1. Lớp chính:**

● DoanPhi: Biểu diễn khoản đóng phí đoàn viên, kế thừa lớp DoanVien (đoàn viên). Lưu trữ thông tin như

mã phí, ngày đóng, tên phí, số tiền, nội dung và danh sách các khoản phí.

● Ngay: Biểu diễn ngày tháng (không có trong đoạn mã).

● DoanVien: Biểu diễn đoàn viên (không có trong đoạn mã).

**2. Phương thức chính:**

● input(): Yêu cầu nhập mã đoàn viên, xác minh sự tồn tại và sau đó gọi inputHoatDong() để thu thập

thông tin chi tiết về khoản phí.

● inputHoatDong(): Thu thập mã phí, tên, ngày đóng và nội dung với xác thực đầu vào.

● readDoanVienFromFile(String filename): Đọc thông tin đoàn viên từ tệp và trả lại danh sách các đối

tượng DoanVien.

● clearScreen(): Xóa màn hình console dựa trên hệ điều hành.

● pressEnterToContinue(): Yêu cầu người dùng nhấn Enter để tiếp tục.

**Lớp Ngay.java**

**1. Thuộc tính:**

● day: Tiếp số nguyên để lưu trữ ngày trong tháng (1-31).

● month: Tiếp số nguyên để lưu trữ tháng trong năm (1-12).

● year: Tiếp số nguyên để lưu trữ năm dương lịch.

**2. Phương thức khởi tạo:**

● Ngay(): Không có tham số, khởi tạo giá trị mặc định cho các thuộc tính.

● Ngay(String dateStr): Nhận một chuỗi ngày tháng dưới dạng dd/mm/yyyy, sau đó phân tích chuỗi, gán

giá trị cho các thuộc tính (day, month, year). Kiểm tra tính hợp lệ của ngày tháng trước khi gán.

**3. Phương thức kiểm tra và truy cập:**

● isValidDate(String dateStr): Kiểm tra xem chuỗi ngày tháng truyền vào có hợp lệ không. Trả về true nếu

hợp lệ và false nếu không.

● getDay(), getMonth(), getYear(): Lấy giá trị của các thuộc tính day, month, year tương ứng.

Trang 8



<a name="br9"></a> 

Nhóm tác giả: NHÓM 5 - TOWKTEAM

● setDay(int day), setMonth(int month), setYear(int year): Thiết lập giá trị cho các thuộc tính day, month,

year tương ứng.

**4. Phương thức hỗ trợ:**

● isLeapYear(int year): Kiểm tra xem năm truyền vào có phải là năm nhuận không. Trả về true nếu là năm

nhuận và false nếu không.

**5. Phương thức tĩnh:**

● clearScreen(): Xóa màn hình console tùy theo hệ điều hành (Windows hoặc các hệ điều hành khác).

● pressEnterToContinue(): Dừng chương trình và hiển thị thông báo "Nhấn Enter để tiếp tục", chờ người

dùng nhấn Enter mới tiếp tục.

**Lớp Demo.java**

● Thuộc tính:

1\. sc: Đối tượng Scanner để đọc dữ liệu nhập vào từ bàn phím.

● Phương thức chính (main):

1\. Khởi tạo các đối tượng:

\-

\-

\-

login: Đối tượng LoginSystem để quản lý đăng nhập.

dv: Đối tượng DoanVien (chưa được khởi tạo nội dung).

choice: Biến nguyên lưu trữ lựa chọn của người dùng.

2\. Lặp (do-while) cho đến khi người dùng chọn thoát (choice != 0):

● Hiển thị menu chính:

ー Đăng nhập (Login)

ー Đăng ký (Register - đang phát triển)

ー Thoát (Exit)

● Kiểm tra dữ liệu nhập vào:

○ Sử dụng vòng lặp while để đảm bảo người dùng nhập số nguyên hợp lệ.

○ Trong vòng lặp while:

ー Yêu cầu nhập lựa chọn.

ー Bắt lỗi InputMismatchException nếu người dùng nhập dữ liệu không phải

số nguyên.

ー Xóa bỏ dữ liệu đầu vào không hợp lệ bằng sc.next().

● Xử lý lựa chọn:

○ Nếu choice == 1 (Đăng nhập):

ー Gọi phương thức initializeUsersFromFile của đối tượng login để thực hiện

đăng nhập.

一 Nếu đăng nhập thành công (trả về 1), hiển thị menu quản lý đoàn

viên của đối tượng dv.

○ Nếu choice == 2 (Đăng ký):

ー Hiển thị thông báo "Đang phát triển!".

Trang 9



<a name="br10"></a> 

Nhóm tác giả: NHÓM 5 - TOWKTEAM

ー Gọi phương thức pressEnterToContinue của đối tượng login để chờ người

dùng nhấn Enter.

○ Nếu choice khác 1, 2, 0:

ー Hiển thị thông báo lựa chọn không hợp lệ.

ー Gọi phương thức pressEnterToContinue của đối tượng login để chờ người

dùng nhấn Enter.

● Xóa màn hình console bằng phương thức clearScreen của đối tượng login.

**Tóm tắt:**

● Lớp Demo điều phối chương trình quản lý đoàn viên.

● Người dùng tương tác với chương trình qua menu chính.

● Chương trình hiện tại chỉ hỗ trợ chức năng đăng nhập và thông báo chức năng đăng ký đang phát triển.

● Sử dụng các phương thức của lớp LoginSystem để quản lý đăng nhập và các phương thức hỗ trợ để

tương tác với người dùng (nhấn Enter, xóa màn hình).

**HẾT**

Trang 10

