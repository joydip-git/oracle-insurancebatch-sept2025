package utils;

import java.util.Scanner;

import models.Developer;
import models.Employee;
import models.Hr;

public class Utility {
    private final static Scanner scanner = new Scanner(System.in);

    public static int getStorageCapacity() {
        System.out.print("Enter no of records: ");
        return scanner.nextInt();
    }

    public static void saveEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            printMenu();
            int choice = getChoice();
            Employee employee = createEmployee(choice);
            employees[i] = employee;
        }
    }

    public static void dispose() {
        scanner.close();
    }

    public static void printEmployeeSalary(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.calculateSalary();
                System.out.println("Salary of " + employee.getName() + ", a/an " + employee.getClass().getSimpleName()
                        + " is: " + employee.getTotalPayment());
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Developer\n2. Hr");
    }

    private static int getChoice() {
        System.out.println("\nEnter choice[1/2]: ");
        return scanner.nextInt();
    }

    private static Employee createEmployee(int choice) {
        Employee employee;

        System.out.println("\nenter id: ");
        int id = scanner.nextInt();

        System.out.println("enter name:");
        String name = scanner.next();

        System.out.println("enter basic:");
        double basic = scanner.nextDouble();

        System.out.println("enter da:");
        double da = scanner.nextDouble();

        System.out.println("enter hra:");
        double hra = scanner.nextDouble();

        switch (choice) {
            case 1:
                System.out.println("enter incentive:");
                double incentive = scanner.nextDouble();
                employee = new Developer(id, name, basic, da, hra, incentive);
                break;

            case 2:
                System.out.println("enter gratuity:");
                double gratuity = scanner.nextDouble();
                employee = new Hr(id, name, basic, da, hra, gratuity);
                break;

            default:
                employee = null;
                break;
        }
        return employee;
    }
}
