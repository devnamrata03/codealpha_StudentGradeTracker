import java.util.ArrayList;
import java.util.Scanner;

// Student class to store name and marks
class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

// Main class
public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("🎓 Welcome to Student Grade Tracker 🎓");
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        // Input loop
        for (int i = 0; i < n; i++) {
            sc.nextLine(); // consume newline
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();
            System.out.print("Enter marks of " + name + ": ");
            double marks = sc.nextDouble();

            students.add(new Student(name, marks));
        }

        // Initialize variables for calculation
        double total = 0, highest = Double.MIN_VALUE, lowest = Double.MAX_VALUE;
        String highestName = "", lowestName = "";

        // Loop to calculate total, highest, lowest
        for (Student s : students) {
            total += s.marks;
            if (s.marks > highest) {
                highest = s.marks;
                highestName = s.name;
            }
            if (s.marks < lowest) {
                lowest = s.marks;
                lowestName = s.name;
            }
        }

        double average = total / students.size();

        // Output summary
        System.out.println("\n📋 Grade Summary:");
        for (Student s : students) {
            System.out.println("Student: " + s.name + " | Marks: " + s.marks);
        }

        System.out.println("\n📊 Statistics:");
        System.out.println("Average Marks: " + average);
        System.out.println("Highest Marks: " + highest + " by " + highestName);
        System.out.println("Lowest Marks: " + lowest + " by " + lowestName);
    }
}
