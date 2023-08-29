package More.Exercise.ObjectAndClasses;


import java.util.*;
import java.util.stream.Collectors;

public class P01CompanyRoster {
    public static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email;
        private int age;

        public Employee(String name, double salary, String position, String department) {
            this.setName(name);
            this.setSalary(salary);
            this.setPosition(position);
            this.setDepartment(department);
            this.setEmail("n/a");
            this.setAge(-1);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static class Department {
        private String name;
        private List<Employee> employees;

        public Department(String name) {
            this.name = name;
            this.employees = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<Employee> getEmployees() {
            return employees;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        List<Department> departmentsList = new ArrayList<>();

        for (int i = 1; i <= numberOfEmployees; i++) {
            String[] data = scanner.nextLine().split(" ");
            String employeeName = data[0];
            double employeeSalary = Double.parseDouble(data[1]);
            String employeePosition = data[2];
            String employeeDepartment = data[3];

            Employee employee = new Employee(employeeName, employeeSalary, employeePosition, employeeDepartment);

            if (data.length == 5) {
                if (data[4].contains("@")) {
                    String employeeEmail = data[4];
                    employee.setEmail(employeeEmail);
                } else {
                    employee.setAge(Integer.parseInt(data[4]));
                }

            } else if (data.length == 6) {
                if (data[4].contains("@")) {
                    String employeeEmail = data[4];
                    int employeeAge = Integer.parseInt(data[5]);
                    employee.setEmail(employeeEmail);
                    employee.setAge(employeeAge);
                } else {
                    employee.setAge(Integer.parseInt(data[4]));
                    employee.setEmail(data[5]);
                }

            }

            Department department = new Department(employeeDepartment);

            int indexOfDepartmentIfDepartmentExist = -1;
            boolean isDepartmentInList = false;
            for (int j = 0; j < departmentsList.size(); j++) {
                Department d = departmentsList.get(j);
                if (d.getName().equals(employeeDepartment)) {
                    indexOfDepartmentIfDepartmentExist = j;
                    isDepartmentInList = true;
                    break;
                }
            }
            if (!isDepartmentInList) {
                departmentsList.add(department);
                int indexOfDep = -1;
                for (int k = 0; k < departmentsList.size(); k++) {
                    Department fromList = departmentsList.get(k);
                    if (fromList.getName().equals(department.getName())) {
                        indexOfDep = k;
                        break;
                    }
                }
                departmentsList.get(indexOfDep).getEmployees().add(employee);
            } else {
                departmentsList.get(indexOfDepartmentIfDepartmentExist).getEmployees().add(employee);
            }

        }

        Department departmentWithHighestAverageSalary = null;
        double average = 0.0;

        for (Department department : departmentsList) {
            double averageSalaryForDepartment = department.getEmployees()
                    .stream().mapToDouble(Employee::getSalary).average().getAsDouble();

            if (averageSalaryForDepartment > average) {
                departmentWithHighestAverageSalary = department;
                average = averageSalaryForDepartment;
            }
        }

        if (departmentWithHighestAverageSalary != null) {

            System.out.printf("Highest Average Salary: %s%n", departmentWithHighestAverageSalary.getName());
            List<Employee> employeesFromDepartment = departmentWithHighestAverageSalary.getEmployees().stream()
                    .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).collect(Collectors.toList());
            for (Employee employee : employeesFromDepartment) {
                System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
            }
        }


    }
}
