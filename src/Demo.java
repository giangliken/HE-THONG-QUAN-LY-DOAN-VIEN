import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LoginSystem login = new LoginSystem();
        DoanVien dv = new DoanVien();
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("----------- HE THONG QUAN LY DOAN VIEN ----------- ");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            // Kiểm tra kiểu dữ liệu của đầu vào
            while (true) {
                try {
                    System.out.print("Nhap lua chon: ");
                    choice = sc.nextInt();
                    break; // Thoát vòng lặp nếu nhập đúng kiểu dữ liệu
                } catch (InputMismatchException e) {
                    System.out.println("Du lieu dau vao khong hop le. Vui long nhap kieu du lieu so nguyen!");
                    sc.next(); // Xóa đầu vào không hợp lệ
                }
            }

            if (choice == 1) {
                if (login.initializeUsersFromFile("./src/accounts.txt") == 1) {
                    dv.menu();
                }
            } else if (choice == 2) {
                System.out.println("Dang phat trien!");
                login.pressEnterToContinue();
            } else if (choice != 0) {
                System.out.println("Lua chon " + choice + " khong co chuc nang!");
                login.pressEnterToContinue();
            }
            login.clearScreen();
        } while (choice != 0);
    }

}
