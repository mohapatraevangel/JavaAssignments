package Day1;
import java.util.Scanner;

public class NextDate {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter day: ");
            int day = scanner.nextInt();
            System.out.print("Enter month: ");
            int month = scanner.nextInt();
            System.out.print("Enter year: ");
            int year = scanner.nextInt();

            System.out.println("Today's date: " + day + "/" + month + "/" + year);

            int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            day++;

            if (day > daysInMonth[month - 1]) {
                day = 1;
                month++;
                // If the month exceeds 12, reset to January and increment the year
                if (month > 12) {
                    month = 1;
                    year++;
                }
            }
            System.out.println("Next date: " + day + "/" + month + "/" + year);
        }
    }
