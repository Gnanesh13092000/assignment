package Day5;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Day4.model.Employee;

public class EmployeeService {

	public static void printFirstNamesJoinedInYear(List<Employee> employees, int year) {
        employees.stream()
                .filter(emp -> emp.dateOfBirth.getYear() == year) // Replace with emp.dateOfJoining.getYear() if applicable
                .map(emp -> emp.firstName)
                .forEach(System.out::println);
    }

    public static void printSalaryStatsForDepartment(List<Employee> employees, String department) {
        DoubleSummaryStatistics stats = employees.stream()
                .filter(emp -> emp.dept.equalsIgnoreCase(department))
                .mapToDouble(emp -> emp.salary)
                .summaryStatistics();

        System.out.println("Stats for department " + department + ":");
        System.out.println("Count: " + stats.getCount());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());
    }

    public static void printEmployeesSortedByFirstNameExcludingHR(List<Employee> employees) {
        employees.stream()
                .filter(emp -> !emp.dept.equalsIgnoreCase("HR"))
                .sorted(Comparator.comparing(emp -> emp.firstName))
                .forEach(System.out::println);
    }

    public static void incrementSalaryByDepartment(List<Employee> employees, String department, double percentage) {
        employees.stream()
                .filter(emp -> emp.dept.equalsIgnoreCase(department))
                .forEach(emp -> emp.salary += emp.salary * (percentage / 100));
    }

    public static void print50OddNumbersAfter100() {
        Stream.iterate(101, n -> n + 2)
                .limit(50)
                .forEach(System.out::println);
    }

    public static void printCommaSeparatedFirstNamesSortedByDOB(List<Employee> employees) {
        String names = employees.stream()
                .sorted(Comparator.comparing(emp -> emp.dateOfBirth))
                .map(emp -> emp.firstName)
                .collect(Collectors.joining(", "));
        System.out.println(names);
    }
}
