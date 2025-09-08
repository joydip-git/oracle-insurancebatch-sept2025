package com.oracle.database;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.oracle.database.models.Product;
import com.oracle.database.repository.ProductRepository;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        ProductRepository repository = new ProductRepository();

        //fetching all products
        getProducts(repository);

        //fetch a single product
        getProduct(scanner, repository);

        //add a new product
        addProduct(scanner, repository);

        //update an existing product
        updateProduct(scanner, repository);

        //delete an existong product
        deleteProduct(scanner, repository);

        scanner.close();
    }

    private static void deleteProduct(Scanner scanner, ProductRepository repository)
            throws ClassNotFoundException, SQLException {
        System.out.print("enter id of the product to delete: ");
        int id = scanner.nextInt();
        boolean status = repository.delete(id);
        System.out.println(status ? "deleted" : "failed");
    }

    private static void updateProduct(Scanner scanner, ProductRepository repository)
            throws ClassNotFoundException, SQLException {
        System.out.print("enter id: ");
        int id = scanner.nextInt();
        boolean status = repository.update(id,
                new Product(3, "new book from paul cohelo", id, "the alchemist", 899, LocalDate.of(2025, 9, 8)));
        System.out.println(status ? "updated" : "failed");
    }

    private static void addProduct(Scanner scanner, ProductRepository repository)
            throws ClassNotFoundException, SQLException {
        System.out.print("enter id: ");
        int id = scanner.nextInt();

        System.out.print("name: ");
        String name = scanner.next();

        scanner.nextLine();
        
        System.out.print("price: ");
        double price = scanner.nextDouble();
        System.out.print("description: ");
        String description = scanner.nextLine();
        //scanner.next();
        System.out.print("release date[in yyyy-mm-dd format]: ");
        LocalDate date = LocalDate.parse(scanner.next(),
                DateTimeFormatter.ISO_LOCAL_DATE);
        scanner.nextLine();
        System.out.print("category id: ");
        int cid = scanner.nextInt();
        Product product = new Product(cid, description, id, name, price, date);
        boolean status = repository.insert(product);
        System.out.println(status ? "added" : "failed");
    }

    private static void getProduct(Scanner scanner, ProductRepository repository)
            throws ClassNotFoundException, SQLException {
        System.out.println("enter product id: ");
        int pid = scanner.nextInt();
        Product product = repository.get(pid);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("no product found...");
        }
    }

    private static void getProducts(ProductRepository repository) throws ClassNotFoundException, SQLException {
        List<Product> products = repository.getAll();
        if (products != null && !products.isEmpty()) {
            // Consumer<Product> printProduct = (p) -> System.out.println(p);
            // products.forEach(printProduct);
            products.forEach((p) -> System.out.println(p));
        } else {
            System.out.println("no products found...");
        }
    }
}
