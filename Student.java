import java.util.Arrays;

public class Student {

    private int rollNo;
    private String name;
    private int[] marks;
    private int total;
    private double average;
    private String grade;

    // Constructor
    public Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        calculateResult();
    }

    // Calculate total, average and grade
    private void calculateResult() {
        total = 0;

        for (int m : marks) {
            total += m;
        }

        average = total / 5.0;

        if (average >= 90)
            grade = "A+";
        else if (average >= 75)
            grade = "A";
        else if (average >= 60)
            grade = "B";
        else if (average >= 50)
            grade = "C";
        else
            grade = "Fail";
    }

    public boolean isFailed() {
        return grade.equals("Fail");
    }

    // Convert object to file string
    public String toFileString() {
        return rollNo + "," + name + "," +
                marks[0] + "," + marks[1] + "," +
                marks[2] + "," + marks[3] + "," + marks[4];
    }

    // Convert file string to object
    public static Student fromFileString(String line) {
        String[] data = line.split(",");
        int roll = Integer.parseInt(data[0]);
        String name = data[1];

        int[] marks = new int[5];
        for (int i = 0; i < 5; i++) {
            marks[i] = Integer.parseInt(data[i + 2]);
        }

        return new Student(roll, name, marks);
    }

    // Method Overloading
    public void display() {
        System.out.println("-----------------------------");
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Total   : " + total);
        System.out.println("Average : " + average);
        System.out.println("Grade   : " + grade);
    }

    public void display(boolean showMarks) {
        display();
        if (showMarks) {
            System.out.println("Marks   : " + Arrays.toString(marks));
        }
    }
}
