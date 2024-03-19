package Encaplsulation.lab._03_ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;


    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);

    }

    public int getAge() {
        return this.age;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");

        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if (salary < 460.0) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void increaseSalary(double percent) {
        if (this.getAge() < 30) {
            this.setSalary(this.salary + this.salary * percent / 200);

        } else {

            this.setSalary(this.salary + this.salary * percent / 100);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva",
                this.firstName,
                this.lastName,
                this.salary);
    }
}
