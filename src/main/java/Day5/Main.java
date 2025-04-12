package Day5;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import Day4.model.Employee;

public class Main {

	public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", "Doe", 101, LocalDate.of(1990, 5, 21), 2500, "HR"),
                new Employee("Jane", "Smith", 102, LocalDate.of(2023, 7, 12), 1800, "Finance"),
                new Employee("Jim", "Beam", 103, LocalDate.of(1992, 3, 15), 2200, "IT"),
                new Employee("Alice", "Wonder", 104, LocalDate.of(2023, 6, 18), 2700, "Finance")
        );

        System.out.println(" First Names of Employees Joined in 2023:");
        EmployeeService.printFirstNamesJoinedInYear(employees, 2023);

        System.out.println("\n Salary Stats for Finance Department:");
        EmployeeService.printSalaryStatsForDepartment(employees, "Finance");

        System.out.println("\n Sorted Employees by First Name (Excluding HR):");
        EmployeeService.printEmployeesSortedByFirstNameExcludingHR(employees);

        System.out.println("\n Incrementing Salary in Finance by 10%...");
        EmployeeService.incrementSalaryByDepartment(employees, "Finance", 10);
        employees.forEach(System.out::println);

        System.out.println("\n 50 Odd Numbers After 100:");
        EmployeeService.print50OddNumbersAfter100();

        System.out.println("\n Comma-Separated First Names Sorted by DOB:");
        EmployeeService.printCommaSeparatedFirstNamesSortedByDOB(employees);
    }
}
