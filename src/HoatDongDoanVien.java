import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class HoatDongDoanVien extends DoanVien {

    private int maHoatDong;
    private int maDoanVien;
    private String tenDoanVien;
    private String tenHoatDong;
    private Ngay ngayToChuc;
    private String diaDiem;
    private String noiDung;
    private List<String> danhSachHoatDong;

    public HoatDongDoanVien() {
        danhSachHoatDong = new ArrayList<>();
    }

        public HoatDongDoanVien(int maDoanVien, String hoTen, Ngay ngaySinh, String gioiTinh, String diaChi, String soDienThoai,
        String eMail, Ngay ngayVaoDoan, String chucVuDoan, String lopHoc, int maHoatDong, String tenHoatDong,
        Ngay ngayToChuc, String diaDiem, String noiDung, List<HoatDongDoanVien> danhSachHoatDong2) {
    super(maDoanVien, hoTen, ngaySinh, gioiTinh, diaChi, soDienThoai, eMail, ngayVaoDoan, chucVuDoan, lopHoc);
    this.maHoatDong = maHoatDong;
    this.tenHoatDong = tenHoatDong;
    this.ngayToChuc = ngayToChuc;
    this.diaDiem = diaDiem;
    this.noiDung = noiDung;
    this.danhSachHoatDong = danhSachHoatDong;
    this.maDoanVien = maDoanVien;
    this.tenDoanVien = getTenDoanVien(maDoanVien); // Gan gia tri cho tenDoanVien
    }

     // Phuong thuc de lay ten doan vien tu ma doan vien
     private String getTenDoanVien(int maDoanVien) {
          List<DoanVien> danhSachDoanVien = readDoanVienFromFile("./src/DanhSachDoanVien.txt");
          for (DoanVien dv : danhSachDoanVien) {
          if (dv.getMaDoanVien() == maDoanVien) {
               return dv.getHoTen(); // Tra ve ten doan vien khi tim thay ma doan vien tuong ung
          }
          }
          return ""; // Tra ve chuoi rong neu khong tim thay ma doan vien trong danh sach
     }
     
    public int getMaHoatDong() {
        return maHoatDong;
    }

    public void setMaHoatDong(int maHoatDong) {
        this.maHoatDong = maHoatDong;
    }

    public void setMaDoanVien(int maDoanVien) {
        this.maDoanVien = maDoanVien;
    }

    public void setTenDoanVien(String tenDoanVien) {
        this.tenDoanVien = tenDoanVien;
    }

    public void setTenHoatDong(String tenHoatDong) {
        this.tenHoatDong = tenHoatDong;
    }

    public void setNgayToChuc(Ngay ngayToChuc) {
        this.ngayToChuc = ngayToChuc;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void setDanhSachHoatDong(List<String> danhSachHoatDong) {
        this.danhSachHoatDong = danhSachHoatDong;
    }

    public int getMaDoanVien() {
        return maDoanVien;
    }

    public String getTenDoanVien() {
        return tenDoanVien;
    }

    public String getTenHoatDong() {
        return tenHoatDong;
    }

    public Ngay getNgayToChuc() {
        return ngayToChuc;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public List<String> getDanhSachHoatDong() {
        return danhSachHoatDong;
    }

    // Add a new activity to the list
    public void themHoatDong() {
        input(); // Capture details of the new activity
        // Format activity details as a string and add to the list
        String activityDetails = String.format("%d:%d:%s:%s:%02d/%02d/%4d:%s:%s",
                maHoatDong, this.maDoanVien, getTenDoanVien(maDoanVien), tenHoatDong, ngayToChuc.getDay(), ngayToChuc.getMonth(), ngayToChuc.getYear(), diaDiem, noiDung);
        danhSachHoatDong.add(activityDetails);
    }

    // Output all activities
    public void hienThiHoatDong() {
        System.out.println("Danh sach hoat dong cua doan vien:");
        for (String hoatDong : danhSachHoatDong) {
            System.out.println(hoatDong);
        }
    }


    public static void xoaHoatDong(List<HoatDongDoanVien> danhSachHoatDong, int maHoatDong) {
        // Đọc danh sách hoạt động từ tệp tin
        boolean daXoa = false; // Biến để kiểm tra xem đã xóa hoạt động hay chưa
        // Tìm và xóa hoạt động có mã tương ứng
        Iterator<HoatDongDoanVien> iterator = danhSachHoatDong.iterator();
        while (iterator.hasNext()) {
            HoatDongDoanVien hd = iterator.next();
            if (hd.getMaHoatDong() == maHoatDong) {
                iterator.remove(); // Xóa hoạt động khỏi danh sách
                daXoa = true;
                System.out.println("Xoa hoat dong thanh cong!");
                break; // Thoát khỏi vòng lặp sau khi xóa
            }
        }
        if (!daXoa) {
            System.out.println("Khong tim thay hoat dong co ma " + maHoatDong);
        }
        // Ghi danh sách hoạt động đã cập nhật vào tệp tin
        capNhatDanhSachHoatDong("./src/DanhSachHoatDong.txt", danhSachHoatDong);
    }
    

    public static void capNhatDanhSachHoatDong(String tenTep, List<HoatDongDoanVien> danhSachHoatDong) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tenTep))) {
            for (HoatDongDoanVien hoatDong : danhSachHoatDong) {
                String activityDetails = String.format("%d:%d:%s:%s:%02d/%02d/%4d:%s:%s",
                        hoatDong.getMaHoatDong(), hoatDong.getMaDoanVien(), hoatDong.getTenDoanVien(), hoatDong.getTenHoatDong(),
                        hoatDong.getNgayToChuc().getDay(), hoatDong.getNgayToChuc().getMonth(), hoatDong.getNgayToChuc().getYear(),
                        hoatDong.getDiaDiem(), hoatDong.getNoiDung());
                writer.write(activityDetails); // Ghi thông tin hoạt động vào tệp tin
                writer.newLine(); // Thêm dòng mới sau mỗi hoạt động
            }
            System.out.println("Sua thong tin hoat dong thanh cong!");
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi sua thong tin hoat dong trong tep tin.");
            e.printStackTrace();
        }
    }
    
    
    

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        boolean hopLe = false;
        do {
            try {
                System.out.print("Nhap ma doan vien (Toi da 10 so): ");
                String input = sc.nextLine();
                
                // Kiểm tra độ dài của chuỗi nhập liệu
                if (input.length() <= 10) {
                    this.maDoanVien = Integer.parseInt(input);
                    //sc.nextLine(); // Đọc kí tự xuống dòng
                    
                    // Kiểm tra sự tồn tại của mã đoàn viên
                    if (checkMaDoanVien(maDoanVien)) {
                        System.out.println("THEM HOAT DONG DOAN VIEN CHO: " + getTenDoanVien(maDoanVien));
                        
                        // Nhap thong tin hoat dong
                        inputHoatDong(sc);
                        
                        hopLe = true;
                    } else {
                        System.out.println("Ma doan vien khong ton tai trong danh sach.");
                    } continue;
                } else {
                    System.out.println("Ma doan vien nhap vao chi toi da 10 so. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ma doan vien phai la mot so nguyen. Vui long nhap lai.");
            }
        } while (!hopLe);
        
        
    }

    private void inputHoatDong(Scanner sc) {
        boolean hopLe = false;
        do {
            try {
                System.out.print("Nhap ma hoat dong (Toi da 10 so): ");
                String input = sc.nextLine();
                
                // Kiểm tra độ dài của chuỗi nhập liệu
                if (input.length() <= 10) {
                    this.maHoatDong = Integer.parseInt(input);
                    //sc.nextLine(); // Đọc kí tự xuống dòng
                    hopLe = true;
                } else {
                    System.out.println("Ma doan vien nhap vao chi toi da 10 so. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ma doan vien phai la mot so nguyen. Vui long nhap lai.");
            }
        } while (!hopLe);
        
        // Nhap ten hoat dong
        do{
            System.out.print("Nhap ten hoat dong (Toi da 30 ky tu): ");
            this.tenHoatDong = sc.nextLine();
            if (this.tenHoatDong.length() > 30)
                System.out.println("Ten hoat dong nhap qua dai. Nhap lai!");
        } while(this.tenHoatDong.length() > 30);
        
        // Nhap ngay to chuc
        hopLe = false;
        while (!hopLe) {
            try {
                System.out.print("Nhap ngay/thang/nam to chuc: ");
                String ngayToChucStr = sc.nextLine();
                this.ngayToChuc = new Ngay(ngayToChucStr);
                hopLe = this.ngayToChuc.isValidDate(ngayToChucStr);
            } catch (Exception e) {
                System.out.println("Nhap ngay theo dung dinh dang dd/mm/yyyy.");
            }
        }

        // Nhap dia diem to chuc
        do{
            System.out.print("Nhap dia diem to chuc (Toi da 30 ky tu): ");
            this.diaDiem = sc.nextLine();
            if (this.diaDiem.length() > 30){
                System.out.println("Dia diem nhap qua dai. Nhap lai!");
            }
        } while(this.diaDiem.length() > 30);

        
        // Nhap noi dung hoat dong
        do{
            System.out.print("Nhap noi dung hoat dong (Toi da 50 ky tu): ");
            this.noiDung = sc.nextLine();
            if (this.noiDung.length() > 50){
                System.out.println("Noi dung nhap qua dai. Nhap lai!");
            }
        } while(this.noiDung.length() > 50);

    }
    

    // Write activity information to the end of a .txt file
    public void ghiDanhSachVaoTep(String tenTep) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tenTep, true))) {
            for (String hoatDong : danhSachHoatDong) {
                writer.write(hoatDong);
                writer.newLine(); // Add a new line after each activity
            }
            System.out.println("Them hoat dong thanh cong!");
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi them hoat dong vao tep tin.");
            e.printStackTrace();
        }
    }

    public static List<HoatDongDoanVien> readFile(String tenTep) {
        List<HoatDongDoanVien> danhSachHoatDong = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader(tenTep))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(":");
                if (parts.length == 7) { // Sua do dai cua mang parts thanh 7
                    try {
                        int maHoatDong = Integer.parseInt(parts[0].trim());
                        int maDoanVien = Integer.parseInt(parts[1].trim());
                        String tenDoanVien = parts[2].trim();
                        String tenHoatDong = parts[3].trim();
                        Ngay ngayToChuc = new Ngay(parts[4].trim());
                        String diaDiem = parts[5].trim();
                        String noiDung = parts[6].trim();
    
                        HoatDongDoanVien hoatDong = new HoatDongDoanVien(maDoanVien, tenHoatDong, ngayToChuc, noiDung, noiDung, noiDung, tenTep, ngayToChuc, line, tenDoanVien, maHoatDong, tenHoatDong, ngayToChuc, diaDiem, noiDung, danhSachHoatDong);
                        danhSachHoatDong.add(hoatDong);
                    } catch (NumberFormatException e) {
                        System.err.println("Loi dinh dang du lieu: " + line);
                    }
                } else {
                    System.err.println("Du lieu khong hop le: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Loi khi doc tep tin: " + e.getMessage());
        }
        return danhSachHoatDong;
    }

    // Read member information from a file and return a list of members
    public static List<DoanVien> readDoanVienFromFile(String filename) {
        List<DoanVien> danhSachDoanVien = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 10) {
                    int maDoanVien = Integer.parseInt(parts[0].trim());
                    String hoTen = parts[1].trim();
                    String dngaySinh = parts[2].trim();
                    Ngay ngaySinh = new Ngay(dngaySinh);
                    String gioiTinh = parts[3].trim();
                    String diaChi = parts[4].trim();
                    String soDienThoai = parts[5].trim();
                    String eMail = parts[6].trim();
                    String dngayVaoDoan = parts[7].trim();
                    Ngay ngayVaoDoan = new Ngay(dngayVaoDoan);
                    String chucVuDoan = parts[8].trim();
                    String lopHoc = parts[9].trim();

                    DoanVien dv = new DoanVien(maDoanVien, hoTen, ngaySinh, gioiTinh, diaChi, soDienThoai, eMail,
                            ngayVaoDoan, chucVuDoan, lopHoc);
                    danhSachDoanVien.add(dv);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return danhSachDoanVien;
    }

    
    // Check if the member ID exists in the list
    private boolean checkMaDoanVien(int maDoanVien) {
        List<DoanVien> danhSachDoanVien = readDoanVienFromFile("./src/DanhSachDoanVien.txt");
        for (DoanVien dv : danhSachDoanVien) {
            if (dv.getMaDoanVien() == maDoanVien) {
                return true; // The member ID exists
            }
        }
        return false; // The member ID does not exist
    }

    @Override
    public void output() {
     //    System.out.println("Ma hoat dong: " + maHoatDong);
     //    System.out.println("Ma doan vien: "+ this.maDoanVien);
     //    System.out.println("Ten doan vien: "+this.tenDoanVien);
     //    System.out.println("Ten hoat dong: " + tenHoatDong);
     //    System.out.printf("Ngay to chuc: %2d/%2d/%2d\n", ngayToChuc.getDay(), ngayToChuc.getMonth(), ngayToChuc.getYear());
     //    System.out.println("Dia diem: " + diaDiem);
     //    System.out.println("Noi dung: " + noiDung);
     //    System.out.println("-----------------------");
     System.out.printf("%-10d %-10d %-30s %-30s %02d/%02d/%4d %-30s %-50s\n",maHoatDong,this.maDoanVien,this.tenDoanVien,tenHoatDong,ngayToChuc.getDay(), ngayToChuc.getMonth(), ngayToChuc.getYear(),diaDiem,noiDung);
    }

            // Phuong thuc de xoa man hinh
            public static void clearScreen() {
               try {
                   if (System.getProperty("os.name").contains("Windows")) {
                       new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                   } else {
                       System.out.print("\033[H\033[2J");
                       System.out.flush();
                   }
               } catch (IOException | InterruptedException e) {
                   System.err.println("Error clearing screen: " + e.getMessage());
               }
           }
       
           // Phuong thuc de dung man hinh
           public static void pressEnterToContinue() {
               System.out.println("\nPress Enter to continue...");
               try {
                   System.in.read();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }

           public void xuatDSHoatDong(){
                List<HoatDongDoanVien> danhSachHoatDong = HoatDongDoanVien.readFile("./src/DanhSachHoatDong.txt");
                if (danhSachHoatDong != null) {
                    for (HoatDongDoanVien hoatDong : danhSachHoatDong) {
                        hoatDong.output();
                    }
                    System.out.println("So luong hoat dong: "+ danhSachHoatDong.size());
                } else {
                    System.out.println("Khong the doc danh sach hoat dong tu tep tin.");
                }
        }


    
        // Phương thức tim hoat dong doan vien theo ma hoat dong
        public HoatDongDoanVien timHoatDongTheoID(int maHoatDong) {
            List<HoatDongDoanVien> danhSachHoatDong = HoatDongDoanVien.readFile("./src/DanhSachHoatDong.txt");
            if (danhSachHoatDong != null) {
                for (HoatDongDoanVien hoatDong : danhSachHoatDong) {
                    if (hoatDong.getMaHoatDong() == maHoatDong) {
                        return hoatDong;
                    }
                }
            }
            return null;
        }

        
    //Phuong thuc tim ma doan vien theo ma hoat dong
    public String timTenDoanVienTheoMaHoatDong(int maHoatDong){
        List<HoatDongDoanVien> danhSachHoatDong = HoatDongDoanVien.readFile("./src/DanhSachHoatDong.txt");
        if (danhSachHoatDong != null){
            for(HoatDongDoanVien hoatDong: danhSachHoatDong){
                if (hoatDong.getMaHoatDong() == maHoatDong) {
                    return hoatDong.getTenDoanVien(maDoanVien); // Trả về tên đoàn viên tương ứng
                }
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
    
    //Phuong thuc tim kiem hoat dong doan vien
    public void timKiemHoatDong(){
        List<HoatDongDoanVien> danhSachHoatDong = readFile("./src/DanhSachHoatDong.txt");
        
        if (danhSachHoatDong != null)
        {
            Scanner sc = new Scanner(System.in);
            int choice = -1;
            do{
                System.out.println("------------- TIM HOAT DONG DOAN VIEN ------------- ");
                System.out.println("1: Tim hoat dong doan vien theo ma hoat dong");
                System.out.println("2: Tim hoat dong doan vien theo ten doan vien");
                System.out.println("3: Tim hoat dong doan vien theo ten hoat dong");
                System.out.println("4: Tim hoat dong doan vien theo ngay/thang/nam to chuc");
                System.out.println("5: Tim hoat dong doan vien theo dia diem");
                System.out.println("0: Thoat");
                boolean hople = false;
                while(!hople){
                    try{
                        System.out.print("Nhap lua chon: ");
                        choice = sc.nextInt();
                        hople = true;
                    }catch (InputMismatchException e) {
                        System.out.println("Lua chon phai la mot so nguyen. Vui long nhap lai.");
                        sc.next(); // Consume the invalid input
                    }
                    switch(choice){
                        case 0: {
                            pressEnterToContinue();
                        } break;
                        case 1:
                        {
                            System.out.print("Nhap ma hoat dong can tim: ");
                            int maHoatDong = sc.nextInt();
                            int dem = 0;
                            for(HoatDongDoanVien hd : danhSachHoatDong )
                                if (hd.getMaHoatDong() == maHoatDong){
                                    hd.output();
                                    dem++;
                                }
                            if (dem == 0){
                                System.out.println("Hoat dong co ma "+maHoatDong+" khong tim thay");
                            }
                            pressEnterToContinue();

                        } break;
                        case 2:
                        {
                            sc.nextLine();
                            System.out.print("Nhap ten cua doan vien can tim hoat dong: ");
                            String tenDoanVien = sc.nextLine();
                            int dem =0;
                            for(HoatDongDoanVien hd : danhSachHoatDong){
                                if (hd.getTenDoanVien().equals(tenDoanVien))
                                {
                                    hd.output();
                                    dem++;
                                }
                            }
                            if (dem !=0)
                                System.out.println("Tim thay "+ dem+ " hoat dong trong danh sach 'Hoat Dong Doan Vien' ");
                            else{
                                System.out.println("Khong tim thay hoat dong nao co ten doan vien '"+tenDoanVien+"'");
                            }
                            pressEnterToContinue();
                        } break;
                        case 3:
                        {
                            sc.nextLine();
                            System.out.print("Nhap ten hoat dong can tim: ");
                            String tenHoatDong = sc.nextLine();
                            int dem = 0;
                            for(HoatDongDoanVien hd: danhSachHoatDong){
                                if (hd.getTenHoatDong().equals(tenHoatDong)){
                                    hd.output();
                                    dem++;
                                }
                            }
                            if (dem !=0)
                                System.out.println("Tim thay "+ dem+ " hoat dong trong danh sach 'Hoat Dong Doan Vien' ");
                            else{
                                System.out.println("Khong tim thay hoat dong co ten '"+tenHoatDong+"'");
                            }
                            pressEnterToContinue();
                        } break;
                        case 4:
                        {
                            boolean hopLe = false;
                                    while (!hopLe) {
                                        sc.nextLine();
                                        System.out.print("Nhap ngay/thang/nam dien ra hoat dong can tim (dd/mm/yyyy):  ");
                                        String newNgayToChucStr = sc.nextLine();
                                        Ngay newNgayToChuc = new Ngay(newNgayToChucStr);
                                        hopLe = newNgayToChuc.isValidDate(newNgayToChucStr);
                                        if (hopLe) {
                                            //System.out.println("Da sua ngay dien ra hoat dong.");
                                        } else {
                                            System.out.println("Ngay dien ra hoat dong khong dung dinh dang. Vui long nhap lai.");
                                        }
                                        int dem = 0;
                                        for(HoatDongDoanVien hd : danhSachHoatDong){
                                            if (hd.getNgayToChuc().getDay() == newNgayToChuc.getDay() && hd.getNgayToChuc().getMonth() == newNgayToChuc.getMonth() && hd.getNgayToChuc().getYear() == newNgayToChuc.getYear()){
                                                hd.output();
                                                dem++;
                                            }
                                        }
                                        if (dem != 0){
                                            System.out.println("Tim thay "+dem+ " hoat dong trong danh dach 'Hoat Dong Doan Vien'");
                                        }
                                        else{
                                            System.out.printf("Khong tim thay hoat dong nao dien ra vao %02d/%02d/4d trong danh sach 'Hoat Dong Doan Vien'",newNgayToChuc.getDay(),newNgayToChuc.getMonth(),newNgayToChuc.getYear());
                                        }
                                    }
                                    pressEnterToContinue();
                        } break;
                        case 5:
                        {
                            sc.nextLine();
                            System.out.print("Nhap dia diem cua hoat dong can tim: ");
                            String diaDiem = sc.nextLine();
                            int dem = 0;
                            for(HoatDongDoanVien hd: danhSachHoatDong){
                                if (hd.getDiaDiem().equals(diaDiem)){
                                    hd.output();
                                    dem++;
                                }
                            }
                            if (dem !=0 ){
                                System.out.println("Da tim thay "+dem+" hoat dong trong danh sach 'Hoat Dong Doan Vien'");
                            }
                            else{
                                System.out.println("Khong tim thay hoat dong nao tai dia diem '"+diaDiem+"' trong danh sach 'Hoat Dong Doan Vien'");
                            }
                            pressEnterToContinue();
                        } break;
                        default:{
                            System.out.println("Lua chon "+choice+" khong co chuc nang");
                            pressEnterToContinue();
                        }
                    }
                }
                clearScreen();
            } while(choice != 0);


        }
    }

    // Phuong thuc sua thong tin hoat dong cho doan vien
    public void suaThongTinHoatDong() {
        List<HoatDongDoanVien> danhSachHoatDong = readFile("./src/DanhSachHoatDong.txt");
        Scanner sc = new Scanner(System.in);
        boolean hopLe = false;
        do {
            try {
                System.out.print("Nhap ma hoat dong (Toi da 10 so): ");
                int maHoatDong = Integer.parseInt(sc.nextLine());
                
                // Kiểm tra sự tồn tại của mã hoạt động
                HoatDongDoanVien hd = timHoatDongTheoID(maHoatDong);
                if (hd != null) {
                    int choice = -1;
                    do {
                        clearScreen();
                        System.out.println("BAN CAN SUA THONG TIN HOAT DONG GI CUA DOAN VIEN :" + hd.timTenDoanVienTheoMaHoatDong(maHoatDong));
                        System.out.println("1: Ma hoat dong");
                        System.out.println("2: Ten hoat dong");
                        System.out.println("3: Ngay/thang/nam dien ra hoat dong");
                        System.out.println("4: Dia diem dien ra hoat dong");
                        System.out.println("5: Noi dung hoat dong");
                        System.out.println("0: Thoat");
                        boolean hopLeNhap = false;
                        while (!hopLeNhap) {
                            try {
                                System.out.print("Nhap lua chon: ");
                                choice = Integer.parseInt(sc.nextLine());
                                hopLeNhap = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Lua chon phai la mot so nguyen. Vui long nhap lai.");
                            }
                        }
                        switch (choice) {
                            case 0:
                                break;
                            case 1: {
                                    boolean validInput = false;
                                    do {
                                        System.out.print("Nhap ma hoat dong moi (Toi da 10 so): ");
                                        String input = sc.nextLine();
                                        if (input.matches("\\d{1,10}")) { // Kiểm tra xem chuỗi nhập vào có chứa chỉ số và không quá 10 số
                                            int newMaHoatDong = Integer.parseInt(input);
                                            hd.setMaHoatDong(newMaHoatDong);
                                            System.out.println("Da sua ma hoat dong.");
                                            validInput = true;
                                        } else {
                                            System.out.println("Ma hoat dong phai la mot so nguyen co toi da 10 chu so. Vui long nhap lai.");
                                        }
                                    } while (!validInput);
                                    
                                }break;  
                                case 2: {
                                    boolean validInput = false;
                                    do {
                                        System.out.print("Nhap ten hoat dong moi (Toi da 30 ky tu): ");
                                        String newTenHoatDong = sc.nextLine();
                                        if (newTenHoatDong.length() <= 30) { // Kiểm tra xem độ dài của chuỗi nhập vào không vượt quá 30 ký tự
                                            hd.setTenHoatDong(newTenHoatDong);
                                            System.out.println("Da sua ten hoat dong.");
                                            validInput = true;
                                        } else {
                                            System.out.println("Ten hoat dong khong duoc vuot qua 30 ky tu. Vui long nhap lai.");
                                        }
                                    } while (!validInput);
                                    break;
                                }                                
                                case 3: {
                                    hopLe = false;
                                    while (!hopLe) {
                                        System.out.print("Nhap ngay/thang/nam dien ra hoat dong moi (dd/mm/yyyy): ");
                                        String newNgayToChucStr = sc.nextLine();
                                        Ngay newNgayToChuc = new Ngay(newNgayToChucStr);
                                        hd.setNgayToChuc(newNgayToChuc);
                                        hopLe = newNgayToChuc.isValidDate(newNgayToChucStr);
                                        if (hopLe) {
                                            System.out.println("Da sua ngay dien ra hoat dong.");
                                        } else {
                                            System.out.println("Ngay dien ra hoat dong khong dung dinh dang. Vui long nhap lai.");
                                        }
                                    }
                                    break;
                                }
                                
                            case 4: {
                                System.out.print("Nhap dia diem dien ra hoat dong moi: ");
                                String newDiaDiem = sc.nextLine();
                                hd.setDiaDiem(newDiaDiem);
                                System.out.println("Da sua dia diem dien ra hoat dong.");
                                break;
                            }
                            case 5: {
                                System.out.print("Nhap noi dung hoat dong moi: ");
                                String newNoiDung = sc.nextLine();
                                hd.setNoiDung(newNoiDung);
                                System.out.println("Da sua noi dung hoat dong.");
                                break;
                            }
                            default:
                                System.out.println("Lua chon " + choice + " khong co chuc nang!. Chon lai!");
                        }
                        pressEnterToContinue();
                    } while (choice != 0);
                    // Sau khi sua thong tin, cap nhat danh sach hoat dong trong bo nho
                    for (int i = 0; i < danhSachHoatDong.size(); i++) {
                        if (danhSachHoatDong.get(i).getMaHoatDong() == maHoatDong) {
                            danhSachHoatDong.set(i, hd);
                            break;
                        }
                    }
                    capNhatDanhSachHoatDong("./src/DanhSachHoatDong.txt", danhSachHoatDong);
                } else {
                    System.out.println("Khong tim thay hoat dong co ma " + maHoatDong + " de sua thong tin!");
                }
                hopLe = true;
            } catch (NumberFormatException e) {
                System.out.println("Ma hoat dong phai la mot so nguyen. Vui long nhap lai.");
            }
        } while (!hopLe);
    }
    


        
           public void menu(){
            Scanner sc = new Scanner(System.in);
            int choice = -1;
            do {
              System.out.println("----------- QUAN LY HOAT DONG DOAN VIEN ---------- ");
              System.out.println("1. In tat ca hoat dong doan vien");
              System.out.println("2. Them hoat dong moi cho doan vien");
              System.out.println("3. Sua thong tin hoat dong cho doan vien");
              System.out.println("4. Tim kiem hoat dong doan vien");
              System.out.println("5: Xoa hoat dong");
              System.out.println("0. Thoat");
              try{
                  System.out.print("Nhap lua chon: ");
                  choice = sc.nextInt();
              }catch (InputMismatchException e) {
                  System.out.println("Lua chon phai la mot so nguyen. Vui long nhap lai.");
                  sc.next(); // Consume the invalid input
                  pressEnterToContinue();
              }
              switch(choice){
                case 0:{
                    pressEnterToContinue();
                } break;
                case 1:
                {
                    xuatDSHoatDong();
                    pressEnterToContinue();
                } break;
                case 2:
                {
                    HoatDongDoanVien hddv = new HoatDongDoanVien();
                    hddv.themHoatDong();
                    hddv.ghiDanhSachVaoTep("./src/DanhSachHoatDong.txt");
                    pressEnterToContinue();
                } break;
                case 3:
                {
                    suaThongTinHoatDong();
                    pressEnterToContinue();
                } break;
                case 4:
                {
                    timKiemHoatDong();
                    pressEnterToContinue();
                } break;
                case 5: {
                    List<HoatDongDoanVien> danhSachHoatDong = readFile("./src/DanhSachHoatDong.txt");
                    boolean hople = false;
                    do {
                        sc.nextLine();
                        System.out.print("Nhap ma hoat dong can xoa (Toi da 10 so): ");
                        String input = sc.nextLine();
                        if (input.matches("\\d{1,10}")) { // Kiểm tra xem chuỗi nhập vào có chứa chỉ số và không quá 10 số
                            int newMaHoatDong = Integer.parseInt(input);
                            xoaHoatDong(danhSachHoatDong, newMaHoatDong);
                            System.out.println("Da xoa hoat dong co ma " + newMaHoatDong);
                            hople = true;
                        } else {
                            System.out.println("Ma hoat dong phai la mot so nguyen co toi da 10 chu so. Vui long nhap lai.");
                        }
                    } while (!hople);
                    pressEnterToContinue();
                } break;                
                default:
                {
                    System.out.println("Lua chon "+choice+" khong co chuc nang. Chon lai!");
                }
              }
              clearScreen();
          } while (choice != 0);
        }
}
