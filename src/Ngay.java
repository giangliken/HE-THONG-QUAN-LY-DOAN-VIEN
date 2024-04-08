import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Ngay {
     private int day, month, year;
 
     // Constructors
     public Ngay() {}
 
     // Constructor chap nhan chuoi dai dien cho ngay thang
     public Ngay(String dateStr) {
         String[] parts = dateStr.split("/");
         if (parts.length == 3) {
             this.day = Integer.parseInt(parts[0]);
             this.month = Integer.parseInt(parts[1]);
             this.year = Integer.parseInt(parts[2]);
         } else {
             // Xu ly loi neu chuoi khong dung dinh dang
             System.out.println("Dinh dang ngay thang khong hop le!");
             
         }
     }
 
     // Getters va Setters
     public int getDay() {
         return day;
     }
 
     public void setDay(int day) {
         this.day = day;
     }
 
     public int getMonth() {
         return month;
     }
 
     public void setMonth(int month) {
         this.month = month;
     }
 
     public int getYear() {
         return year;
     }
 
     public void setYear(int year) {
         this.year = year;
     }

     public boolean isValidDate(String dateStr) {
        try {
            String[] parts = dateStr.split("/");
            if (parts.length == 3) {
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);
    
                // Check if the month is within valid range (1 to 12)
                if (month < 1 || month > 12) {
                    return false;
                }
    
                // Check if the day is within valid range for the given month and year
                int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                if (month == 2 && isLeapYear(year)) {
                    daysInMonth[1] = 29; // February has 29 days in a leap year
                }
                if (day < 1 || day > daysInMonth[month - 1]) {
                    return false;
                }
    
                // All checks passed, the date is valid
                return true;
            } else {
                // Invalid format
                return false;
            }
        } catch (NumberFormatException e) {
            // Error parsing integers
            return false;
        }
    }
    
    // Helper method to check if a year is a leap year
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
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
 