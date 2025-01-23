package Day1;
import java.util.Scanner;
public class gradesAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[] grades = new int[numStudents];
        int total = 0;

        for (int i = 0; i < numStudents; i++) {
            int grade;
            do {
                System.out.print("Enter the grade for student " + (i + 1) + ": ");
                grade = scanner.nextInt();

                if (grade < 0 || grade > 100) {
                    System.out.println("Invalid grade, try again...");
                }
            } while (grade < 0 || grade > 100);

            grades[i] = grade;
            total += grade;
        }
        double average = total / (double) numStudents;
        System.out.println("The average is: " + average);
    }
}
