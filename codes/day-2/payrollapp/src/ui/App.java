package ui;

import models.Employee;
import utils.Utility;

public class App {
    public static void main(String[] args) throws Exception {

        int count = Utility.getStorageCapacity();
        Employee[] employees = new Employee[count];
        Utility.saveEmployees(employees);
        Utility.printEmployeeSalary(employees);
    }
}
