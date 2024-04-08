import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.regex.*;


public class DoanVien {
     protected int maDoanVien;
     protected String hoTen;
     protected Ngay ngaySinh;
     protected String gioiTinh;
     protected String diaChi;
     protected String soDienThoai;
     protected String eMail;
     protected Ngay ngayVaoDoan;
     protected String chucVuDoan;
     protected String lopHoc;
     protected List<DoanVien> danhSachDoanVien; // Danh sach doan vien

     public DoanVien() {
          danhSachDoanVien = new ArrayList<>();
     }

     public DoanVien(int maDoanVien, String hoTen, Ngay ngaySinh, String gioiTinh, String diaChi, String soDienThoai,
               String eMail, Ngay ngayVaoDoan, String chucVuDoan, String lopHoc) {
          this.maDoanVien = maDoanVien;
          this.hoTen = hoTen;
          this.ngaySinh = ngaySinh;
          this.gioiTinh = gioiTinh;
          this.diaChi = diaChi;
          this.soDienThoai = soDienThoai;
          this.eMail = eMail;
          this.ngayVaoDoan = ngayVaoDoan;
          this.chucVuDoan = chucVuDoan;
          this.lopHoc = lopHoc;
     }

     public int getMaDoanVien() {
        return maDoanVien;
    }

    public void setMaDoanVien(int maDoanVien) {
        this.maDoanVien = maDoanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Ngay getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Ngay ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Ngay getNgayVaoDoan() {
        return ngayVaoDoan;
    }

    public void setNgayVaoDoan(Ngay ngayVaoDoan) {
        this.ngayVaoDoan = ngayVaoDoan;
    }

    public String getChucVuDoan() {
        return chucVuDoan;
    }

    public void setChucVuDoan(String chucVuDoan) {
        this.chucVuDoan = chucVuDoan;
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public List<DoanVien> getDanhSachDoanVien() {
        return danhSachDoanVien;
    }

    public void setDanhSachDoanVien(List<DoanVien> danhSachDoanVien) {
        this.danhSachDoanVien = danhSachDoanVien;
    }

    public void input(){
          Scanner sc = new Scanner(System.in);
          boolean hople = false;
          while (!hople) {
            try {
                System.out.print("Nhap ma doan vien: ");
                this.maDoanVien = sc.nextInt();
                sc.nextLine(); // Đọc bỏ kí tự xuống dòng
        
                DoanVien dv = timDoanVienTheoID(danhSachDoanVien, this.maDoanVien);
                if (dv != null) {
                    System.out.println("MA DOAN VIEN DA CO TRONG DANH SACH DOAN VIEN");
                } else {
                    hople = true; // Nếu mã không tồn tại thì thoát khỏi vòng lặp
                    
          String hoTen;
          do{
            System.out.print("Nhap ho ten (Toi da 30 ky tu): ");
            hoTen = sc.nextLine();
            if (hoTen.length() > 30){
                System.out.println("Ten nhap qua dai. Vui long nhap lai.");
            }
          }while(hoTen.length() > 30);
          
          this.hoTen = hoTen;
      
          hople = false;
          while(!hople){
            try{
                System.out.print("Nhap ngay sinh (dd/mm/yyyy): ");
                String ngaySinhStr = sc.nextLine();
                this.ngaySinh = new Ngay(ngaySinhStr); // Gia su ban da co lop Ngay de xu ly ngay thang
                hople = this.ngaySinh.isValidDate(ngaySinhStr);
            }catch (Exception e) {
                System.out.println("Nhap ngay theo dung dinh dang dd/mm/yyyy.");
            }
          }

          hople = false;
          while(!hople){
            System.out.print("Nhap gioi tinh (Nam / Nu): ");
            this.gioiTinh = sc.nextLine();
            if (this.gioiTinh.equalsIgnoreCase("Nam") || this.gioiTinh.equalsIgnoreCase("Nu"))
            {
                hople = true;
            }
            else
            {
                System.out.println("Gioi tinh phai la 'Nam' hoac 'Nu'. Nhap lai!");
            }
          }

          String diaChi;
          do{
            System.out.print("Nhap dia chi (Toi da 30 ky tu): ");
            diaChi = sc.nextLine();
            if (diaChi.length() > 30){
                System.out.println("Dia chi nhap qua dai. Vui long nhap lai.");
            }
          } while(diaChi.length() > 30);
          this.diaChi = diaChi;
      
          boolean hopLe = false;
          Pattern pattern_sdt = Pattern.compile("^[0-9]+$");
          while (!hopLe) {
              System.out.print("Nhap so dien thoai: ");
              String soDienThoaiStr = sc.nextLine();
              Matcher matcher = pattern_sdt.matcher(soDienThoaiStr); // Use pattern_sdt here
              if (matcher.matches()) {
                  this.soDienThoai = soDienThoaiStr;
                  hopLe = true; // Set hopLe to true if the input format is valid
              } else {
                  System.out.println("So dien thoai khong hop le. Chi nhap chuoi gom cac so tu 0 den 9. Vui long nhap lai!");
              }
          }
          
      
          //nhap du lieu cho truong eMail co gang buoc du lieu
          hopLe = false;
          Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
          while (!hopLe) {
              System.out.print("Nhap email: ");
              this.eMail = sc.nextLine();
              Matcher matcher = pattern.matcher(this.eMail);
              if (matcher.matches()) {
                  hopLe = true; // Set hopLe to true if the email format is valid
              } else {
                  System.out.println("Email khong hop le. Vui long nhap lai!");
              }
          }
          
      
          hople = false;
          while(!hople){
            try{
                System.out.print("Nhap ngay vao doan (dd/mm/yyyy): ");
                String ngayVaoDoanStr = sc.nextLine();
                this.ngayVaoDoan = new Ngay(ngayVaoDoanStr); // Gia su ban da co lop Ngay de xu ly ngay thang
                hople = this.ngayVaoDoan.isValidDate(ngayVaoDoanStr);
            }catch (Exception e) {
                System.out.println("Nhap ngay theo dung dinh dang dd/mm/yyyy.");
            }
          }
      
          String chucVu;
          do{
            System.out.print("Nhap chuc vu doan: (Toi da 20 ky tu): ");
            chucVu = sc.nextLine();
            if (chucVu.length() > 20){
                System.out.println("Chuc vu nhap qua dai. Vui long nhap lai.");
            }
          } while(chucVu.length() > 20);
          this.chucVuDoan = chucVu;
      
          String lopHoc;
          do{
            System.out.print("Nhap lop hoc (Toi da 10 ky tu): ");
            lopHoc = sc.nextLine();
            if(lopHoc.length() > 10){
                System.out.println("Lop hoc nhap qua dai. Vui long nhap lai.");
            }
          } while(lopHoc.length() > 10);
          this.lopHoc = lopHoc;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lua chon phai la mot so nguyen. Vui long nhap lai.");
                sc.next(); // Tiêu thụ đầu vào không hợp lệ
            }
        }
        
      }
      

      public void menu(){
          Scanner sc = new Scanner(System.in);
          int choice = -1;
          do {
            System.out.println("----------- HE THONG QUAN LY DOAN VIEN ----------- ");
            System.out.println("1. In tat ca doan vien");
            System.out.println("2. Them doan vien moi");
            System.out.println("3. Sua thong tin doan vien");
            System.out.println("4. Tim kiem doan vien");
            System.out.println("5. Hoat dong doan vien");
            System.out.println("6: Doan phi");
            System.out.println("7: Xoa doan vien");
            System.out.println("0. Thoat");
            try{
                System.out.print("Nhap lua chon: ");
                choice = sc.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Lua chon phai la mot so nguyen. Vui long nhap lai.");
                sc.next(); // Consume the invalid input
                pressEnterToContinue();
            }
            switch (choice) {
               case 0: 
               {
                pressEnterToContinue(); 
               } break;
               case 1:
               {
                    danhSachDoanVien = readDoanVienFromFile("./src/DanhSachDoanVien.txt");
                    // In danh sach doan vien
                    for (DoanVien dv : danhSachDoanVien) {
                         dv.output();
                    }
                    System.out.println("So luong doan vien: "+ danhSachDoanVien.size());
                    pressEnterToContinue();
               } break;
               case 2:
               {
                    input();
                    danhSachDoanVien.add(this);
                    writeDoanVienToFile("./src/DanhSachDoanVien.txt", danhSachDoanVien);
                    System.out.println("Them thanh cong!");
                    pressEnterToContinue();
               } break;
               case 3:
               {
                suaThongTinDoanVien();
                pressEnterToContinue();
               } break;
               case 4:
               {
                timDoanVien(danhSachDoanVien);
               } break;
               case 5:
               {
                HoatDongDoanVien hd = new HoatDongDoanVien();
                hd.menu();

               } break;
               case 6:
               {
                DoanPhi dp = new DoanPhi();
                dp.menu();
               } break;
               case 7:
               {
                System.out.print("Nhap ma doan vien can xoa: ");
                int id = sc.nextInt();
                DoanVien dv = timDoanVienTheoID(danhSachDoanVien, id);
                if (dv != null) {
                    xoaDoanVien(danhSachDoanVien, dv);
                    writeDoanVienToFile("./src/DanhSachDoanVien.txt", danhSachDoanVien);
                    System.out.println("Da xoa doan vien co ma " + id + " khoi danh sach.");
                    pressEnterToContinue();
                } else {
                    System.out.println("Khong tim thay doan vien co ma " + id + " trong danh sach.");
                    pressEnterToContinue();
                }
               } break;
               default: 
               {
                System.out.println("Lua chon "+choice+ " khong co chuc nang. Chon lai!");
                pressEnterToContinue();
               } break;
                    
            }
            clearScreen();
        } while (choice != 0);
      }
     
    // Phuong thuc de doc danh sach doan vien tu file va tra ve mot danh sach cac doan vien
    public static List<DoanVien> readDoanVienFromFile(String filename) {
        List<DoanVien> danhSachDoanVien = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 10) { // Kiem tra xem moi dong co du thong tin cua mot doan vien khong
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

    // Phuong thuc de ghi danh sach doan vien vao file "DanhSachDoanVien.txt" va tiep tuc ghi vao cuoi file
    public void writeDoanVienToFile(String filename, List<DoanVien> danhSachDoanVien) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (DoanVien dv : danhSachDoanVien) {
                String line = dv.maDoanVien + ":" + dv.hoTen + ":" + dv.ngaySinh.getDay()+"/"+dv.ngaySinh.getMonth()+"/"+dv.ngaySinh.getYear() + ":" +
                        dv.gioiTinh + ":" + dv.diaChi + ":" + dv.soDienThoai + ":" + dv.eMail + ":" +
                        dv.ngayVaoDoan.getDay()+"/"+dv.ngayVaoDoan.getMonth()+"/"+dv.ngayVaoDoan.getYear() + ":" + dv.chucVuDoan + ":" + dv.lopHoc;
                bw.write(line);
                bw.newLine();
            }
            //System.out.println("Danh sach doan vien da duoc ghi vao file DanhSachDoanVien.txt");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    //Phuong thuc sua thong tin doan vien
    public void suaThongTinDoanVien(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap ma doan vien can sua: ");
    int idcansua = sc.nextInt();
    DoanVien dv = timDoanVienTheoID(danhSachDoanVien, idcansua);
    DoanVien dvdasua = new DoanVien();
    if (dv != null){
        int choice = -1;
        do
        {
            clearScreen();
            System.out.println("BAN CAN SUA THONG TIN GI CUA DOAN VIEN :" + dv.getHoTen());
            System.out.println("1: Ma doan vien");
            System.out.println("2: Ten doan vien");
            System.out.println("3: Ngay/thang/nam sinh");
            System.out.println("4: Gioi tinh");
            System.out.println("5: Dia chi:");
            System.out.println("6: So dien thoai");
            System.out.println("7: eMail");
            System.out.println("8: Ngay/thang/nam vao doan");
            System.out.println("9: Chuc vu");
            System.out.println("10: Lop hoc");
            System.out.println("0: Thoat!");
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
            }
            
            switch(choice){
                case 0: 
                {
                    break;
                }
                case 1:
                {
                    sc.nextLine();
                    System.out.print("Nhap ma doan vien: ");
                    int maDoanVien = 0; // Khoi tao gia tri mac dinh cho ma doan vien
                    boolean hopLe = false; // Bien kiem tra tinh hop le cua du lieu nhap vao
                    
                    do {
                        try {
                            String input = sc.nextLine(); // Nhan du lieu nhap vao duoi dang chuoi
                            maDoanVien = Integer.parseInt(input); // Chuyen doi chuoi thanh so nguyen
                            hopLe = true; // Gan gia tri true cho bien hopLe neu khong co ngoai le phat sinh
                        } catch (NumberFormatException e) {
                            // Xu ly ngoai le khi chuoi khong the chuyen doi thanh so nguyen
                            System.out.println("Ma doan vien phai la mot so nguyen. Vui long nhap lai:");
                            System.out.print("Nhap ma doan vien: ");
                        }
                    } while (!hopLe);
                    
                    dv.setMaDoanVien(maDoanVien); // Gan gia tri ma doan vien cho doi tuong DoanVien
                    
                    dvdasua = dv;
                    xoaDoanVien(danhSachDoanVien, dv);
                    danhSachDoanVien.add(dvdasua);
                    writeDoanVienToFile("./src/DanhSachDoanVien.txt", danhSachDoanVien);
                    System.out.println("Da sua thong tin!");
                }; break;
                case 2:
                {
                    sc.nextLine();
                    System.out.print("Nhap ho ten: ");
                    dv.setHoTen(sc.nextLine());
                    dvdasua = dv;
                    xoaDoanVien(danhSachDoanVien, dv);
                    danhSachDoanVien.add(dvdasua);
                    writeDoanVienToFile("./src/DanhSachDoanVien.txt", danhSachDoanVien);
                    System.out.println("Da sua thong tin!");
                }; break;
                case 3:
                {
                    sc.nextLine();
                    System.out.print("Nhap ngay/thang/nam sinh: ");
                    String ngay = sc.nextLine();
                    Ngay dngay = new Ngay(ngay);
                    dv.setNgaySinh(dngay);
                    dvdasua = dv;
                    xoaDoanVien(danhSachDoanVien, dv);
                    danhSachDoanVien.add(dvdasua);
                    writeDoanVienToFile("./src/DanhSachDoanVien.txt", danhSachDoanVien);
                    System.out.println("Da sua thong tin!");
                }; break;
                case 4:
                {
                    sc.nextLine();
                    System.out.print("Nhap gioi tinh: ");
                    dv.setGioiTinh(sc.nextLine());
                    dvdasua = dv;
                    xoaDoanVien(danhSachDoanVien, dv);
                    danhSachDoanVien.add(dvdasua);
                    writeDoanVienToFile("./src/DanhSachDoanVien.txt", danhSachDoanVien);
                    System.out.println("Da sua thong tin!");
                }; break;
                case 5:
                {
                    sc.nextLine();
                    System.out.print("Nhap dia chi: ");
                    dv.setDiaChi(sc.nextLine());
                    dvdasua = dv;
                    xoaDoanVien(danhSachDoanVien, dv);
                    danhSachDoanVien.add(dvdasua);
                    writeDoanVienToFile("./src/DanhSachDoanVien.txt", danhSachDoanVien);
                    System.out.println("Da sua thong tin!");
                }; break;
                case 6:
                {
                    sc.nextLine();
                    System.out.print("Nhap so dien thoai: ");
                    dv.setSoDienThoai(sc.nextLine());
                    dvdasua = dv;
                    xoaDoanVien(danhSachDoanVien, dv);
                    danhSachDoanVien.add(dvdasua);
                    writeDoanVienToFile("./src/DanhSachDoanVien.txt", danhSachDoanVien);
                    System.out.println("Da sua thong tin!");
                }; break;
                case 7:
                {
                    sc.nextLine();
                    System.out.print("Nhap eMail: ");
                    dv.seteMail(sc.nextLine());
                    dvdasua = dv;
                    xoaDoanVien(danhSachDoanVien, dv);
                    danhSachDoanVien.add(dvdasua);
                    writeDoanVienToFile("./src/DanhSachDoanVien.txt", danhSachDoanVien);
                    System.out.println("Da sua thong tin!");
                }; break;
                case 8:
                {
                    sc.nextLine();
                    System.out.print("Nhap ngay/thang/nam vao doan: ");
                    String ngay = sc.nextLine();
                    Ngay dngay = new Ngay(ngay);
                    dv.setNgayVaoDoan(dngay);
                    dvdasua = dv;
                    xoaDoanVien(danhSachDoanVien, dv);
                    danhSachDoanVien.add(dvdasua);
                    writeDoanVienToFile("./src/DanhSachDoanVien.txt", danhSachDoanVien);
                    System.out.println("Da sua thong tin!");
                }; break;
                case 9:
                {
                    sc.nextLine();
                    System.out.print("Nhap chuc vu: ");
                    dv.setChucVuDoan(sc.nextLine());
                    dvdasua = dv;
                    xoaDoanVien(danhSachDoanVien, dv);
                    danhSachDoanVien.add(dvdasua);
                    writeDoanVienToFile("./src/DanhSachDoanVien.txt", danhSachDoanVien);
                    System.out.println("Da sua thong tin!");
                }; break;
                case 10:
                {
                    sc.nextLine();
                    System.out.print("Nhap lop hoc: ");
                    dv.setLopHoc(sc.nextLine());
                    dvdasua = dv;
                    xoaDoanVien(danhSachDoanVien, dv);
                    danhSachDoanVien.add(dvdasua);
                    writeDoanVienToFile("./src/DanhSachDoanVien.txt", danhSachDoanVien);
                    System.out.println("Da sua thong tin!");
                }; break;
                default: 
                {
                    System.out.println("Lua chon "+ choice+" khong co chuc nang!. Chon lai!");
                    pressEnterToContinue();
                }
            }
            pressEnterToContinue();
        } while(choice != 0);

    }
    else 
    {
        System.out.println("Khong tim thay doan vien co ma "+ idcansua+" de sua thong tin!");
    }
 }

    // Phuong thuc tim doan vien trong danh sach theo ID
    public DoanVien timDoanVienTheoID(List<DoanVien> danhSach, int id) {
        for(DoanVien dv: danhSachDoanVien)
        {
            if (dv.maDoanVien == id)
                return dv;
        }
        return null;
    }

    //Phuong thuc tim doan vien trong danh sach theo ten
    public int timDoanVienTheoTen(List<DoanVien> danhSach, String ten) {
        int timthay = 0;
        for (DoanVien dv : danhSach) {
            if (dv.getHoTen().equals(ten)) {
                dv.output();
                timthay++;
            }
        }
        return timthay;
    }

    //Phuong thuc tim doan vien trong danh sach theo ngay/thang/nam sinh
    public int timDoanVienTheoNgaySinh(List<DoanVien> danhSach, Ngay d) {
        int timthay = 0;
        for (DoanVien dv : danhSach) {
            if (dv.getNgaySinh().getDay() == d.getDay() && dv.getNgaySinh().getMonth() == d.getMonth() && dv.getNgaySinh().getYear() == d.getYear()) {
                dv.output();
                timthay++;
            }
        }
        return timthay;
    }

    //Phuong thuc tim doan vien trong danh sach theo ngay/thang/nam vao doan
    public int timDoanVienTheoNgayVaoDoan(List<DoanVien> danhSach, Ngay d){
        int timthay = 0;
        for(DoanVien dv: danhSach){
            if (dv.getNgayVaoDoan().getDay() == d.getDay() && dv.getNgayVaoDoan().getMonth() == d.getMonth() && dv.getNgayVaoDoan().getYear() == d.getYear()) {
                dv.output();
                timthay++;
            }
        }
        return timthay;
    }

    //Phuong thuc tim doan vien trong danh sach theo so dien thoai
    public DoanVien timDoanVienTheoSDT(List<DoanVien> danhSach, String sdt){
        for(DoanVien dv: danhSachDoanVien){
            if (dv.getSoDienThoai().equals(sdt))
                return dv;
        }
        return null;
    }

    //Phuong thuc tim doan vien theo eMail
    public DoanVien timDoanVientheoeMail(List<DoanVien> danhSach, String eMail){
        for(DoanVien dv: danhSachDoanVien){
            if (dv.geteMail().equals(eMail))
                return dv;
        }
        return null;
    }

    //Phuong thuc tim doan vien theo Lop Hoc
    public int timDoanVienTheoLopHoc(List<DoanVien> danhSach, String lop){
        int timthay = 0;
        for(DoanVien dv: danhSachDoanVien){
            if (dv.getLopHoc().equals(lop))
            {
                dv.output();
                timthay++;
            }
        }
        return timthay;
    }

    

    //Phuong thuc tim doan vien trong danh sach
    public void timDoanVien(List<DoanVien> danhSach){
        danhSachDoanVien = readDoanVienFromFile("./src/DanhSachDoanVien.txt");
        if (danhSachDoanVien != null){
            Scanner sc = new Scanner(System.in);
            int choice = -1 ;
            do{
                System.out.println("------------------ TIM DOAN VIEN ------------------ ");
                System.out.println("1: Tim doan vien theo ma doan vien");
                System.out.println("2: Tim doan vien theo ten doan vien");
                System.out.println("3: Tim doan vien theo/ngay/thang nam sinh");
                System.out.println("4: Tim doan vien theo ngay/thang/nam vao doan");
                System.out.println("5: Tim doan vien theo so dien thoai");
                System.out.println("6: Tim doan vien theo eMail");
                System.out.println("7: Tim doan vien theo lop hoc");
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
                }
                switch(choice){
                    case 0:{
                        pressEnterToContinue();
                    } break;
                    case 1:
                    {
                        System.out.print("Nhap ma doan vien can tim (Toi da 10 ky tu):  ");
                        int id = sc.nextInt();
                        DoanVien dv = timDoanVienTheoID(danhSachDoanVien, id);
                        if (dv != null){
                            System.out.println("DA TIM THAY DOAN VIEN CO MA "+ id);
                            dv.output();
                            pressEnterToContinue();
                        }
                        else{
                            System.out.println("KHONG TIM THAY DOAN VIEN CO MA "+id);
                            pressEnterToContinue();
                        }
                    } break;
                    case 2: {
                        //danhSachDoanVien = readDoanVienFromFile("./src/DanhSachDoanVien.txt");
                        sc.nextLine();
                        System.out.print("Nhap ten doan vien can tim: ");
                        String ten = sc.nextLine();
                        int foundCount = timDoanVienTheoTen(danhSachDoanVien, ten);
                        if (foundCount != 0) {
                            System.out.println("DA TIM THAY " + foundCount + " DOAN VIEN CO TEN '" + ten+"'");
                        } else {
                            System.out.println("KHONG TIM THAY DOAN VIEN CO TEN '" +ten+ "'");
                        }
                        pressEnterToContinue();
                    } break;      
                    case 3: 
                    {
                        sc.nextLine();
                        hople = false;
                        Ngay ngaySinh = null; // Declare outside the try block
                        while (!hople) {
                            try {
                                System.out.print("Nhap ngay thang/nam/sinh cua doan vien can tim (dd/MM/yyyy): ");
                                String ngaySinhStr = sc.nextLine();
                                ngaySinh = new Ngay(ngaySinhStr); // Initialize inside the try block
                                hople = ngaySinh.isValidDate(ngaySinhStr);
                            } catch (Exception e) {
                                System.out.println("Nhap ngay theo dung dinh dang dd/mm/yyyy.");
                            }
                        }
                    
                        int foundCount = timDoanVienTheoNgaySinh(danhSachDoanVien, ngaySinh);
                        if (foundCount != 0) {
                            System.out.printf("DA TIM THAY %d DOAN VIEN CO NGAY SINH %02d/%02d/%04d\n", foundCount, ngaySinh.getDay(), ngaySinh.getMonth(), ngaySinh.getYear());
                        } else {
                            System.out.printf("KHONG TIM THAY DOAN VIEN CO NGAY SINH %02d/%02d/%04d\n", ngaySinh.getDay(), ngaySinh.getMonth(), ngaySinh.getYear());
                        }
                        pressEnterToContinue();
                    } break;    
                    case 4:
                    {
                        sc.nextLine();
                        hople = false;
                        Ngay ngayVaoDoan = null;
                        while(!hople){
                            try{
                                System.out.println("Nhap ngay/thang/nam vao doan cua doan vien can tim (dd/mm/yyy): ");
                                String ngayVaoDoanStr = sc.nextLine();
                                ngayVaoDoan = new Ngay(ngayVaoDoanStr);
                                hople = ngayVaoDoan.isValidDate(ngayVaoDoanStr);
                            } catch (Exception e) {
                                System.out.println("Nhap ngay theo dung dinh dang dd/mm/yyyy.");
                            }
                        }
                        int foundCount = timDoanVienTheoNgayVaoDoan(danhSachDoanVien, ngayVaoDoan);
                        if (foundCount != 0){
                            System.out.printf("DA TIM THAY %d DOAN VIEN CO NGAY VAO DOAN %02d/%2d/%4d\n",foundCount,ngayVaoDoan.getDay(),ngayVaoDoan.getMonth(),ngayVaoDoan.getYear());
                        } else{
                            System.out.printf("KHONG TIM THAY %d DOAN VIEN CO NGAY VAO DOAN %02d/%2d/%4d\n",foundCount,ngayVaoDoan.getDay(),ngayVaoDoan.getMonth(),ngayVaoDoan.getYear());

                        }
                        pressEnterToContinue();
                    } break; 
                    case 5:
                    {
                        sc.nextLine();
                        System.out.print("Nhap SDT doan vien can tim: ");
                        String sdt = sc.nextLine();
                        DoanVien dv = timDoanVienTheoSDT(danhSachDoanVien, sdt);
                        if (dv != null){
                            System.out.println("DA TIM THAY DOAN VIEN CO SDT "+ sdt);
                            dv.output();
                            pressEnterToContinue();
                        }
                        else{
                            System.out.println("KHONG TIM THAY DOAN VIEN CO SDT "+ sdt);
                            pressEnterToContinue();
                        }
                    } break;                       
                    case 6:
                    {
                        sc.nextLine();
                        System.out.println("Nhap eMail doan vien can tim: ");
                        String eMail = sc.nextLine();
                        DoanVien dv = timDoanVientheoeMail(danhSachDoanVien, eMail);
                        if (dv != null){
                            System.out.println("DA TIM THAY DOAN VIEN CO EMAIL "+ eMail);
                            dv.output();
                            pressEnterToContinue();
                        }
                        else{
                            System.out.println("KHONG TIM THAY DOAN VIEN CO EMAIL "+eMail);
                            pressEnterToContinue();
                        }
                    } break;
                    case 7:
                    {
                        sc.nextLine();
                        System.out.println("Nhap lop hoc cua doan vien can tim: ");
                        String lop = sc.nextLine();
                        int foundCount = timDoanVienTheoLopHoc(danhSachDoanVien, lop);
                        if (foundCount != 0){
                            System.out.println("DA TIM THAY "+ foundCount+" DOAN VIEN CO LOP HOC '"+lop+"'");
                        } else{
                            System.out.println("KHONG TIM THAY "+ foundCount+" DOAN VIEN CO LOP HOC '"+lop+"'");
                        }
                        pressEnterToContinue();
                    } break;
                    default:{
                        System.out.println("Lua chon "+choice+" khong co chuc nang");
                        pressEnterToContinue();
                    }
                }
                clearScreen();
            } while(choice != 0);
        }

    }

    public boolean xoaDoanVien(List<DoanVien> danhSach, DoanVien doanVienCanXoa){
        return danhSach.remove(doanVienCanXoa);
    }
    //xuat thong tin doan vien
    public void output() {
        System.out.printf("%-10d %-30s %02d/%02d/%4d %-8s %-30s %-10s    %-30s %02d/%02d/%4d %-10s %-10s\n",this.maDoanVien,this.hoTen,this.ngaySinh.getDay(),this.ngaySinh.getMonth(),this.ngaySinh.getYear(),this.gioiTinh,this.diaChi,this.soDienThoai,this.eMail,this.ngayVaoDoan.getDay(),this.ngayVaoDoan.getMonth(),this.ngayVaoDoan.getYear(),this.chucVuDoan,this.lopHoc);
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

          public int maHoatDong() {
               // TODO Auto-generated method stub
               throw new UnsupportedOperationException("Unimplemented method 'maHoatDong'");
          }
}
