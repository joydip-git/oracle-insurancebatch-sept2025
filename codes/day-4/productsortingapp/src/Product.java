
import java.util.Comparator;

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private double price;
    private String description;

    @Override
    public int compareTo(Product o) {
        return this.id - o.id;
    }

    public static class ProductComparator implements Comparator<Product> {

        private int sortChoice = 1;

        public ProductComparator() {
        }

        public ProductComparator(int choice) {
            sortChoice = choice;
        }

        @Override
        public int compare(Product o1, Product o2) {
            return switch (sortChoice) {
                case 1 -> Integer.compare(o1.id, o2.id);
                case 2 -> o1.name.compareTo(o2.name);
                case 3 -> Double.compare(o1.price, o2.price);
                default -> Integer.compare(o1.id, o2.id);
            };
        }
    }

    public Product() {
    }

    public Product(int id, String name, String description, double price) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
    }

}
