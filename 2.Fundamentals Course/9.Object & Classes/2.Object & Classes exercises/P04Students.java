package fundamentals.P19.ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Students {
    public static class Student {
        String name;
        String lastName;
        double grade;

        public Student(String name, String lastName, double grade) {
            this.name = name;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;
        }


        @Override
        public String toString() {
            return String.format("%s %s: %.2f", name, lastName, grade);
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        List<Student> studentsList = new ArrayList<>();

        for (int i = 1; i <= numberOfStudents; i++) {
            String[] inputArr = scanner.nextLine().split(" ");
            String firstName = inputArr[0];
            String lastName = inputArr[1];
            double grade = Double.parseDouble(inputArr[2]);

            Student currentStudent = new Student(firstName, lastName, grade);

            studentsList.add(currentStudent);

        }

        studentsList.sort((a, b) -> Double.compare(b.getGrade(), a.getGrade()));

        for (Student student : studentsList) {
            System.out.println(student.toString());
        }
    }
}
