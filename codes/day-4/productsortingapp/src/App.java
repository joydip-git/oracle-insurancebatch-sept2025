
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product(2, "dell xps 15", "new 15 inch laptop from dell", 120000));
        products.add(new Product(1, "one plus 13", "new phone from one plus", 78000));
        products.add(new Product(3, "Alchmist", "new book from paul cohelo", 699));

        //1.
        //Since Product class implemented Comparable<T>, the following will work
        //Collections.sort(products);
        
        //or
        // Since ProductComparer implements Comparator<T>, the following will work
        //2.a.       
        Product.ProductComparator pc = new Product.ProductComparator(3);
        Collections.sort(products, pc);

        // or
        //2.b.
        // products.sort(pc);

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
