package com.oracle.database;

import java.sql.SQLException;
import java.util.Scanner;

import com.oracle.database.models.Product;
import com.oracle.database.repository.ProductRepository;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ProductRepository repository = new ProductRepository();
        // List<Product> products = repository.getAll();
        // if (products != null && !products.isEmpty()) {
        //     // Consumer<Product> printProduct = (p) -> System.out.println(p);
        //     // products.forEach(printProduct);
        //     products.forEach((p) -> System.out.println(p));
        // } else {
        //     System.out.println("no products found...");
        // }

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter product id: ");
        int pid = scanner.nextInt();
        Product product = repository.get(pid);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("no product found...");
        }

        scanner.close();
    }
}
