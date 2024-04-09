import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class LoginSystem {

    private static HashMap<String, String> users = new HashMap<>();

    public void input() {
        initializeUsersFromFile("./src/accounts.txt");
        System.out.println("Welcome to the Login System!");

    }

        // Login system
        public int initializeUsersFromFile(String filename) {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Nhap username: ");
                String username = scanner.nextLine().trim();
                System.out.print("Nhap password: ");
                String password = scanner.nextLine().trim();
                String line;
                boolean found = false;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String savedUsername = parts[0].trim();
                        String savedPassword = parts[1].trim();
                        if (savedUsername.equals(username) && savedPassword.equals(password)) {
                            found = true;
                            break;
                        }
                    }
                }
                if (found) {
                    System.out.println("Dang tien hanh dang nhap...");
                    for (int i = 0; i <= 100; i += 10) {
                        try {
                            Thread.sleep(200); // Delay 100 milliseconds
                            System.out.print("\rProgress: " + i + "%");
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                    System.out.println("\nDang nhap thanh cong!");
                    
                    pressEnterToContinue();
                    clearScreen();
                    return 1;
                } else {
                    for (int i = 0; i <= 100; i += 10) {
                        try {
                            Thread.sleep(200); // Delay 100 milliseconds
                            System.out.print("\rProgress: " + i + "%");
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("");
                    clearScreen();
                    System.out.println("Loi dang nhap: username hoac password khong dung!");
                    pressEnterToContinue();
                    return 0;
                }
            } catch (IOException e) {
                System.out.println("Đã xảy ra lỗi khi đọc tập tin.");
                e.printStackTrace();
            }
            return 0;
        }

        // Phương thức để xóa màn hình
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

    // Phương thức để dừng màn hình
    public static void pressEnterToContinue() {
        System.out.println("\nPress Enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
