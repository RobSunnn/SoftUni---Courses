import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.students = new ArrayList<>();
        this.capacity = capacity;

    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {

        if (this.students.size() + 1 > this.capacity) {

            return "No seats in the university";
        } else {
            if (this.students.contains(student)) {

                return "Student is already in the university";
            } else {

                this.students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            }
        }
    }

    public String dismissStudent(Student student) {
        if (this.students.contains(student)) {
            this.students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }

        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        Student studentToReturn = null;
        for (Student student : this.students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                studentToReturn = student;
            }
        }
        return studentToReturn;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : this.students) {

            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s"
                            , student.getFirstName(), student.getLastName(), student.getBestSubject()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
