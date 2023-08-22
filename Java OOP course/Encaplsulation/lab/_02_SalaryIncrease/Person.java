package Encaplsulation.lab._02_SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return this.age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() > 30) {
            setSalary(this.salary + this.salary * bonus / 100);
        } else {
            setSalary(this.salary + this.salary * bonus / 200);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva",
                this.firstName,
                this.lastName,
                this.salary);
    }
}
