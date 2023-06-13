package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() + 1 <= this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }

        return false;
    }

    public Employee getOldestEmployee() {
        Employee employeeToReturn = null;
        int age = -1;

        for (Employee employee : this.employees) {
            if (employee.getAge() > age) {
                age = employee.getAge();
                employeeToReturn = employee;
            }
        }
        return employeeToReturn;
    }

    public Employee getEmployee(String name) {
        Employee employeeToReturn = null;
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                employeeToReturn = employee;
            }
        }
        return employeeToReturn;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:", getName())).append(System.lineSeparator());
        for (Employee employee : this.employees) {
            sb.append(employee).append(System.lineSeparator());
        }

        return sb.toString();
    }

}
