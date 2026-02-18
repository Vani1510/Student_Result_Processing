import java.io.*;
import java.util.Scanner;

public class ResultManager {

    private static final String FILE_NAME = "students.txt";

    public void addStudent(Scanner sc) {

        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            int[] marks = new int[5];

            String[] subjects = {"Maths", "Computer", "Physics", "Chemistry", "English"};

for (int i = 0; i < 5; i++) {
    System.out.print("Enter marks for " + subjects[i] + ": ");
    marks[i] = sc.nextInt();

    if (marks[i] < 0 || marks[i] > 100) {
        System.out.println("Invalid mark! Must be between 0 and 100.");
        return;
    }
}


            Student student = new Student(roll, name, marks);

            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
            bw.write(student.toFileString());
            bw.newLine();
            bw.close();

            System.out.println("Student saved successfully!");

        } catch (Exception e) {
            System.out.println("Error adding student.");
        }
    }

    public void viewAllStudents() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = br.readLine()) != null) {
                Student s = Student.fromFileString(line);
                s.display(true);
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("No records found.");
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }

    public void viewFailedStudents() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                Student s = Student.fromFileString(line);

                if (s.isFailed()) {
                    s.display();
                    found = true;
                }
            }

            if (!found)
                System.out.println("No failed students.");

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }
}
