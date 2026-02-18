// Menu-driven Student Result Processing System

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ResultManager manager = new ResultManager();
        int choice;

        do {
            System.out.println("\n===== STUDENT RESULT PROCESSING =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Failed Students");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    manager.addStudent(sc);
                    break;

                case 2:
                    manager.viewAllStudents();
                    break;

                case 3:
                    manager.viewFailedStudents();
                    break;

                case 4:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}

