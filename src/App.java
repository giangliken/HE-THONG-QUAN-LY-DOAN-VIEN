import java.util.List;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        // HoatDongDoanVien hddv = new HoatDongDoanVien();
        // hddv.themHoatDong();
        // hddv.ghiDanhSachVaoTep("./src/DanhSachHoatDong.txt");
        
         // Goi phuong thuc doc hoat dong tu tep tin
         List<HoatDongDoanVien> danhSachHoatDong = HoatDongDoanVien.readFile("./src/DanhSachHoatDong.txt");
         System.out.println("So luong: "+ danhSachHoatDong.size());
         // Kiem tra danh sach hoat dong da duoc doc chua
         if (danhSachHoatDong != null) {
             // In danh sach hoat dong ra man hinh
             for (HoatDongDoanVien hoatDong : danhSachHoatDong) {
                if (hoatDong.getMaHoatDong() == 3000)
                 hoatDong.output();
             }
             
         } else {
             System.out.println("Khong the doc danh sach hoat dong tu tep tin.");
         }
     }

     

    
}
