import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DoanPhi extends DoanVien {
    private int maDoanPhi;
    private Ngay ngayDongPhi;
    private String tenDoanPhi;
    private double soTien;
    private String noiDung;
    private List<DoanPhi> danhSachDoanPhi;
    private String tenDoanVien;

    public DoanPhi() {
        danhSachDoanPhi = new ArrayList<>(); // Khoi tao danh sach o day
    }

    // Constructor
    public DoanPhi(int maDoanVien, String hoTen, Ngay ngaySinh, String gioiTinh, String diaChi, String soDienThoai,
                   String eMail, Ngay ngayVaoDoan, String chucVuDoan, String lopHoc, int maDoanPhi, Ngay ngayDongPhi,
                   String tenDoanPhi, double soTien, String noiDung) {
        super(maDoanVien, hoTen, ngaySinh, gioiTinh, diaChi, soDienThoai, eMail, ngayVaoDoan, chucVuDoan, lopHoc);
        this.maDoanPhi = maDoanPhi;
        this.ngayDongPhi = ngayDongPhi;
        this.tenDoanPhi = tenDoanPhi;
        this.soTien = soTien;
        this.noiDung = noiDung;
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

    public int getMaDoanPhi() {
        return maDoanPhi;
    }

    public Ngay getNgayDongPhi() {
        return ngayDongPhi;
    }

    public void setNgayDongPhi(Ngay ngayDongPhi) {
        this.ngayDongPhi = ngayDongPhi;
    }

    public String getTenDoanPhi() {
        return tenDoanPhi;
    }

    public void setTenDoanPhi(String tenDoanPhi) {
        this.tenDoanPhi = tenDoanPhi;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public List<DoanPhi> getDanhSachDoanPhi() {
        return danhSachDoanPhi;
    }

    public void setDanhSachDoanPhi(List<DoanPhi> danhSachDoanPhi) {
        this.danhSachDoanPhi = danhSachDoanPhi;
    }

    public String getTenDoanVien() {
        return tenDoanVien;
    }

    public void setTenDoanVien(String tenDoanVien) {
        this.tenDoanVien = tenDoanVien;
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
    public void input() {
        Scanner sc = new Scanner(System.in);
        boolean hopLe = false;
        do {
            try {
                System.out.print("Nhap ma doan vien de cap nhat doan phi (Toi da 10 so): ");
                String input = sc.nextLine();

                // Kiem tra do dai cua chuoi nhap lieu
                if (input.length() <= 10) {
                    this.maDoanVien = Integer.parseInt(input);

                    // Kiem tra su ton tai cua ma doan vien
                    if (checkMaDoanVien(maDoanVien)) {
                        System.out.println("THEM HOAT DONG DOAN VIEN CHO: " + getTenDoanVien(maDoanVien));

                        // Nhap thong tin hoat dong
                        inputHoatDong(sc);

                        hopLe = true;
                    } else {
                        System.out.println("Ma doan vien khong ton tai trong danh sach.");
                    }
                    continue;
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
                System.out.print("Nhap ma doan phi (Toi da 10 so): ");
                String input = sc.nextLine();

                // Kiem tra do dai cua chuoi nhap lieu
                if (input.length() <= 10) {
                    this.maDoanPhi = Integer.parseInt(input);
                    hopLe = true;
                } else {
                    System.out.println("Ma doan phi nhap vao chi toi da 10 so. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ma doan phi phai la mot so nguyen. Vui long nhap lai.");
            }
        } while (!hopLe);

        // Nhap ten doan phi
        do {
            System.out.print("Nhap ten doan phi (Toi da 30 ky tu): ");
            this.tenDoanPhi = sc.nextLine();
            if (this.tenDoanPhi.length() > 30)
                System.out.println("Ten hoat dong nhap qua dai. Nhap lai!");
        } while (this.tenDoanPhi.length() > 30);

        // Nhap ngay dong phi
        hopLe = false;
        while (!hopLe) {
            try {
                System.out.print("Nhap ngay/thang/nam dong phi: ");
                String ngayDongPhiStr = sc.nextLine();
                this.ngayDongPhi = new Ngay(ngayDongPhiStr);
                hopLe = this.ngayDongPhi.isValidDate(ngayDongPhiStr);
            } catch (Exception e) {
                System.out.println("Nhap ngay theo dung dinh dang dd/mm/yyyy.");
            }
        }

        // Nhap so tien
        System.out.print("Nhap so tien: ");
        this.soTien = Double.parseDouble(sc.nextLine());
        // Nhap noi dung doan phi
        do {
            System.out.print("Nhap noi dung doan phi (Toi da 50 ky tu): ");
            this.noiDung = sc.nextLine();
            if (this.noiDung.length() > 50) {
                System.out.println("Noi dung doan phi nhap qua dai. Nhap lai!");
            }
        } while (this.noiDung.length() > 50);

    }

// Add a new activity to the list
public void themDoanPhi() {
    input(); // Capture details of the new activity
    // Create a new DoanPhi object
    DoanPhi newDoanPhi = new DoanPhi(maDoanVien, tenDoanVien, ngayDongPhi, tenDoanPhi, noiDung, noiDung, noiDung, ngayDongPhi, noiDung, noiDung, maDoanPhi, ngayDongPhi, noiDung, soTien, noiDung);
    // Add the new DoanPhi object to the list
    danhSachDoanPhi.add(newDoanPhi);
}


    @Override
    public void output() {
        System.out.printf("%-10d %-10d %-30s %-30s %02d/%02d/%4d %.3f %-50s\n", maDoanPhi, this.maDoanVien, this.tenDoanVien, tenDoanPhi, ngayDongPhi.getDay(), ngayDongPhi.getMonth(), ngayDongPhi.getYear(), soTien, noiDung);
    }

    public void xuatDanhSachDoanPhi(String tenTep) {
        List<DoanPhi> danhSachDoanPhi = docDanhSachDoanPhiTuTep(tenTep);
    
        if (danhSachDoanPhi.isEmpty()) {
            System.out.println("Danh sach doan phi trong.");
            return;
        }
    
        System.out.println("Danh sach doan phi:");
        System.out.printf("%-10s %-10s %-30s %-30s %-12s %-10s %-50s\n",
                "Ma Doan Phi", "Ma Doan Vien", "Ten Doan Vien", "Ten Doan Phi", "Ngay Dong", "So Tien", "Noi Dung");
    
        for (DoanPhi doanPhi : danhSachDoanPhi) {
            System.out.printf("%-10d %-10d %-30s %-30s %02d/%02d/%4d %.3f %-50s\n",
                    doanPhi.getMaDoanPhi(), doanPhi.getMaDoanVien(), doanPhi.getTenDoanVien(), doanPhi.getTenDoanPhi(),
                    doanPhi.getNgayDongPhi().getDay(), doanPhi.getNgayDongPhi().getMonth(), doanPhi.getNgayDongPhi().getYear(),
                    doanPhi.getSoTien(), doanPhi.getNoiDung());
        }
    }
    
    

// Write activity information to the end of a .txt file
public void ghiDanhSachVaoTep(String tenTep) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tenTep, true))) {
        for (DoanPhi doanPhi : danhSachDoanPhi) {
            // Convert DoanPhi object to string representation
            String doanPhiString = doanPhi.getMaDoanPhi() + ":" +
                                   doanPhi.getMaDoanVien() + ":" +
                                   doanPhi.getTenDoanVien() + ":" +
                                   doanPhi.getTenDoanPhi() + ":" +
                                   doanPhi.getNgayDongPhi().getDay()+"/"+doanPhi.getNgayDongPhi().getMonth()+"/"+doanPhi.getNgayDongPhi().getYear() + ":" +
                                   doanPhi.getSoTien() + ":" +
                                   doanPhi.getNoiDung();
            // Write the string representation to the file
            writer.write(doanPhiString);
            writer.newLine(); // Add a new line after each activity
        }
        System.out.println("Them hoat dong thanh cong!");
    } catch (IOException e) {
        System.out.println("Da xay ra loi khi them hoat dong vao tep tin.");
        e.printStackTrace();
    }
}

    
private boolean kiemTraTonTaiMaDoanPhi(int maDoanPhi) {
    for (DoanPhi doanPhi : danhSachDoanPhi) {
        if (doanPhi.getMaDoanPhi() == maDoanPhi) {
            return true; // Ma doan phi ton tai trong danh sach
        }
    }
    return false; // Ma doan phi khong ton tai trong danh sach
}

public void suaThongTinDoanPhi(int maDoanPhi) {
    // Tim kiem doan phi trong danh sach
    DoanPhi doanPhiCanSua = null;
    for (DoanPhi doanPhi : danhSachDoanPhi) {
        if (doanPhi.getMaDoanPhi() == maDoanPhi) {
            doanPhiCanSua = doanPhi;
            break;
        }
    }

    if (doanPhiCanSua == null) {
        System.out.println("Khong tim thay doan phi co ma " + maDoanPhi + " de sua.");
        return;
    }

    Scanner sc = new Scanner(System.in);

    // Hien thi thong tin cua doan phi can sua
    System.out.println("Thong tin doan phi can sua:");
    doanPhiCanSua.output();

    // Nhap thong tin moi tu nguoi dung
    System.out.println("Nhap thong tin moi:");

    // Cap nhat thong tin moi
    System.out.print("Nhap ten moi cua doan phi: ");
    String tenDoanPhiMoi = sc.nextLine();
    doanPhiCanSua.setTenDoanPhi(tenDoanPhiMoi);

    System.out.print("Nhap ngay moi dong doan phi (dd/mm/yyyy): ");
    String ngayDongPhiMoiStr = sc.nextLine();
    Ngay ngayDongPhiMoi = new Ngay(ngayDongPhiMoiStr);
    doanPhiCanSua.setNgayDongPhi(ngayDongPhiMoi);

    System.out.print("Nhap so tien moi: ");
    double soTienMoi = Double.parseDouble(sc.nextLine());
    doanPhiCanSua.setSoTien(soTienMoi);

    System.out.print("Nhap noi dung moi cua doan phi: ");
    String noiDungMoi = sc.nextLine();
    doanPhiCanSua.setNoiDung(noiDungMoi);

    System.out.println("Thong tin doan phi sau khi sua:");
    doanPhiCanSua.output();

    // Cap nhat danh sach doan phi vao tep tin
    ghiDanhSachVaoTep("./src/DanhSachDoanPhi.txt");
    System.out.println("Sua thong tin doan phi thanh cong!");
}



    public void timKiemDoanPhi() {
        List<DoanPhi> danhSachDoanPhi = docDanhSachDoanPhiTuTep("./src/DanhSachDoanPhi.txt");
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("----------- TIM KIEM DOAN PHI ---------- ");
            System.out.println("1. Tim doan phi theo ma doan phi");
            System.out.println("2. Tim doan phi theo ten doan phi");
            System.out.println("3. Tim doan phi theo ngay dong phi");
            System.out.println("4. Tim doan phi theo so tien dong");
            System.out.println("5. Tim doan phi theo noi dung");
            System.out.println("0. Quay lai menu chinh");
            try {
                System.out.print("Nhap lua chon: ");
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Lua chon phai la mot so nguyen. Vui long nhap lai.");
                sc.next(); // Consume the invalid input
                pressEnterToContinue();
            }
            switch (choice) {
                case 0: {
                    return;
                }
                case 1: {
                    timDoanPhiTheoMaDoanPhi();
                    break;
                }
                case 2: {
                    timDoanPhiTheoTenDoanPhi();
                    break;
                }
                case 3: {
                    timDoanPhiTheoNgayDongPhi();
                    break;
                }
                case 4: {
                    timDoanPhiTheoSoTien();
                    break;
                }
                case 5: {
                    timDoanPhiTheoNoiDung();
                    break;
                }
                default: {
                    System.out.println("Lua chon " + choice + " khong hop le. Vui long chon lai.");
                }
            }
            pressEnterToContinue();
            clearScreen();
        } while (choice != 0);
    }
    
    private void timDoanPhiTheoMaDoanPhi() {
        List<DoanPhi> danhSachDoanPhi = docDanhSachDoanPhiTuTep("./src/DanhSachDoanPhi.txt");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma doan phi can tim: ");
        int maDoanPhi = sc.nextInt();
        for (DoanPhi doanPhi : danhSachDoanPhi) {
            if (doanPhi.getMaDoanPhi() == maDoanPhi) {
                System.out.println("Thong tin doan phi:");
                doanPhi.output();
                return;
            }
        }
        System.out.println("Khong tim thay doan phi voi ma doan phi " + maDoanPhi);
    }

    private DoanPhi timDoanPhiTheoID(int ma){
        List<DoanPhi> danhSachDoanPhi = docDanhSachDoanPhiTuTep("./src/DanhSachDoanPhi.txt");
        for (DoanPhi doanPhi : danhSachDoanPhi) {
            if (doanPhi.getMaDoanPhi() == ma) {
                return doanPhi;
            }
        }
        return null;
    }
    
    private void timDoanPhiTheoTenDoanPhi() {
        List<DoanPhi> danhSachDoanPhi = docDanhSachDoanPhiTuTep("./src/DanhSachDoanPhi.txt");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten doan phi can tim: ");
        String tenDoanPhi = sc.nextLine();
        boolean found = false;
        for (DoanPhi doanPhi : danhSachDoanPhi) {
            if (doanPhi.getTenDoanPhi().equalsIgnoreCase(tenDoanPhi)) {
                System.out.println("Thong tin doan phi:");
                doanPhi.output();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay doan phi voi ten doan phi " + tenDoanPhi);
        }
    }
    
    private void timDoanPhiTheoNgayDongPhi() {
        List<DoanPhi> danhSachDoanPhi = docDanhSachDoanPhiTuTep("./src/DanhSachDoanPhi.txt");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ngay dong phi can tim (dd/mm/yyyy): ");
        String ngayDongPhiStr = sc.nextLine();
        boolean found = false;
        for (DoanPhi doanPhi : danhSachDoanPhi) {
            if (doanPhi.getNgayDongPhi().toString().equals(ngayDongPhiStr)) {
                System.out.println("Thong tin doan phi:");
                doanPhi.output();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay doan phi voi ngay dong phi " + ngayDongPhiStr);
        }
    }
    
    private void timDoanPhiTheoSoTien() {
        List<DoanPhi> danhSachDoanPhi = docDanhSachDoanPhiTuTep("./src/DanhSachDoanPhi.txt");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tien dong phi can tim: ");
        double soTien = sc.nextDouble();
        boolean found = false;
        for (DoanPhi doanPhi : danhSachDoanPhi) {
            if (doanPhi.getSoTien() == soTien) {
                System.out.println("Thong tin doan phi:");
                doanPhi.output();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay doan phi voi so tien dong phi " + soTien);
        }
    }
    
    private void timDoanPhiTheoNoiDung() {
        List<DoanPhi> danhSachDoanPhi = docDanhSachDoanPhiTuTep("./src/DanhSachDoanPhi.txt");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap noi dung can tim: ");
        String noiDung = sc.nextLine();
        boolean found = false;
        for (DoanPhi doanPhi : danhSachDoanPhi) {
            if (doanPhi.getNoiDung().equalsIgnoreCase(noiDung)) {
                System.out.println("Thong tin doan phi:");
                doanPhi.output();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay doan phi voi noi dung " + noiDung);
        }
    }
    

    public void xoaDoanPhi(int maDoanPhi) {
        // Doc danh sach doan phi tu file
        List<DoanPhi> danhSachDoanPhi = docDanhSachDoanPhiTuTep("./src/DanhSachDoanPhi.txt");
        
        // Tim vi tri cua doan phi can xoa trong danh sach
        int index = -1;
        for (int i = 0; i < danhSachDoanPhi.size(); i++) {
            if (danhSachDoanPhi.get(i).getMaDoanPhi() == maDoanPhi) {
                index = i;
                break;
            }
        }
        
        // Kiem tra xem doan phi co ton tai khong
        if (index != -1) {
            // Xoa doan phi khoi danh sach
            danhSachDoanPhi.remove(index);
        } else {
            System.out.println("Khong tim thay doan phi co ma " + maDoanPhi + " de xoa.");
        }
    }
    

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("----------- QUAN LY HOAT DONG DOAN VIEN ---------- ");
            System.out.println("1. In danh sach doan phi cua doan vien");
            System.out.println("2. Them doan phi moi cho doan vien");
            System.out.println("3. Sua thong tin doan phi cho doan vien");
            System.out.println("4. Tim kiem thong tin doan phi doan vien");
            System.out.println("5: Xoa doan phi");
            System.out.println("0. Thoat");
            try {
                System.out.print("Nhap lua chon: ");
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Lua chon phai la mot so nguyen. Vui long nhap lai.");
                sc.next(); // Consume the invalid input
                pressEnterToContinue();
            }
            switch (choice) {
                case 0: {
                    pressEnterToContinue();
                }
                break;
                case 1: {
                    xuatDanhSachDoanPhi("./src/DanhSachDoanPhi.txt");
                    pressEnterToContinue();
                }
                break;
                case 2: {
                    DoanPhi dp = new DoanPhi();
                    dp.themDoanPhi();
                    dp.ghiDanhSachVaoTep("./src/DanhSachDoanPhi.txt");
                    pressEnterToContinue();
                }
                break;
                case 3: {
                    List<DoanPhi> danhSachDoanPhi = docDanhSachDoanPhiTuTep("./src/DanhSachDoanPhi.txt");
                    suaThongTinDoanPhi(1234);
                    pressEnterToContinue();
                }
                break;
                case 4: {
                    timKiemDoanPhi();
                    pressEnterToContinue();
                }
                break;
                // case 5: {
                //     DoanPhi dp = new DoanPhi();
                //     System.out.println("Nhap ma doan phi can xoa: ");
                //     int ma = sc.nextInt();
                //     dp.xoaDoanPhi(ma);
                //     pressEnterToContinue();
                // }
                // break;
                default: {
                    System.out.println("Lua chon " + choice + " khong co chuc nang. Chon lai!");
                }
            }
            clearScreen();
        } while (choice != 0);
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

    public List<DoanPhi> docDanhSachDoanPhiTuTep(String tenTep) {
        List<DoanPhi> danhSachDoanPhi = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(tenTep))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 7) {
                    int maDoanPhi = Integer.parseInt(parts[0].trim());
                    int maDoanVien = Integer.parseInt(parts[1].trim());
                    String tenDoanVien = parts[2].trim();
                    String tenDoanPhi = parts[3].trim();
                    String ngayDongPhiStr = parts[4].trim();
                    Ngay ngayDongPhi = new Ngay(ngayDongPhiStr); // Can trien khai lop Ngay tuong ung
                    double soTien = Double.parseDouble(parts[5].trim().replace(",", "."));
                    String noiDung = parts[6].trim();
        
                    // Tao mot doi tuong DoanPhi va them vao danh sach
                    DoanPhi doanPhi = new DoanPhi(maDoanVien, tenDoanVien, ngayDongPhi, tenDoanPhi, noiDung, noiDung, noiDung, ngayDongPhi, noiDung, noiDung, maDoanVien, ngayDongPhi, noiDung, soTien, noiDung);
                    doanPhi.setMaDoanPhi(maDoanPhi); // Can them phuong thuc setter cho maDoanPhi trong lop DoanPhi
                    danhSachDoanPhi.add(doanPhi);
                }
            }
            System.out.println("Doc danh sach doan phi tu tep thanh cong!");
        } catch (IOException e) {
            System.err.println("Loi khi doc file: " + e.getMessage());
        }
        return danhSachDoanPhi;
    }
    
    
    

    private void setMaDoanPhi(int maDoanPhi) {
        this.maDoanPhi = maDoanPhi;
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
}
