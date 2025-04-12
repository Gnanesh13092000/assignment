package Day4;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import Day4.generator.UserNameGenerator;
import Day4.model.Employee;
import Day4.model.User;
import Day4.util.PasswordUtil;

public class Main {

	public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", "Doe", 101, LocalDate.of(1990, 5, 21), 2500, "HR"),
                new Employee("Jane", "Smith", 102, LocalDate.of(1985, 7, 12), 1800, "Finance"),
                new Employee("Jim", "Beam", 103, LocalDate.of(1992, 3, 15), 2200, "IT")
        );

        Consumer<Employee> printEmployee = System.out::println;
        Predicate<Employee> highSalary = emp -> emp.salary > 2000;
        BiPredicate<Employee, Double> isSalaryAbove = (emp, threshold) -> emp.salary > threshold;

        System.out.println("Employees with salary > 2000:");
        employees.stream()
                .filter(highSalary)
                .forEach(printEmployee);

        Supplier<String> passwordSupplier = PasswordUtil.getPasswordSupplier();

        UserNameGenerator userNameGenerator = (first, last, year, id) ->
                first + last + year + id;

        Function<Employee, User> employeeToUser = emp -> {
            String userName = userNameGenerator.generate(emp.firstName, emp.lastName, emp.getYearOfBirth(), emp.id);
            String password = passwordSupplier.get();
            return new User(emp.id, userName, password);
        };

        List<User> users = employees.stream()
                .map(employeeToUser)
                .collect(Collectors.toList());

        System.out.println("\nGenerated Users:");
        users.forEach(System.out::println);

        System.out.println("\nEmployees sorted by month of birth:");
        employees.sort((e1, e2) -> Integer.compare(e1.dateOfBirth.getMonthValue(), e2.dateOfBirth.getMonthValue()));
        employees.forEach(printEmployee);

        Thread empThread = new Thread(() -> {
            System.out.println("\n[Thread] Employees:");
            employees.forEach(printEmployee);
        });

        Thread userThread = new Thread(() -> {
            System.out.println("\n[Thread] Users:");
            users.forEach(System.out::println);
        });

        empThread.start();
        userThread.start();
    }
}
