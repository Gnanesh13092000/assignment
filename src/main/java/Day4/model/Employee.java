package Day4.model;

import java.time.LocalDate;

public class Employee {
    public String firstName;
    public String lastName;
    public int id;
    public LocalDate dateOfBirth;
    public double salary;
    public String dept;

    public Employee(String firstName, String lastName, int id, LocalDate dateOfBirth, double salary, String dept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.dept = dept;
    }

    public int getYearOfBirth() {
        return dateOfBirth.getYear();
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name=%s %s, dob=%s, salary=%.2f, dept=%s}",
                id, firstName, lastName, dateOfBirth, salary, dept);
    }
}
