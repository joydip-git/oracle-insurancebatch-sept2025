import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws Exception {
        int choice = 2;
        switch (choice) {
            case 1 -> {
                DataManager<String> stringManager = new StringDataManager(
                        new StringDataRespository());
                System.out.println(stringManager.fetchData());
            }
            case 2 -> {
                DataManager<Product> productManager = new ProductDataManager(
                        new ProductDataRepository());
                System.out.println(productManager.fetchData());
            }
            default -> {
                System.out.println("wrong choice");
            }
        }

        Factory factory = new Factory();
        try {
            DataRespository<String> repo = (DataRespository<String>) factory.create(DataRespository.class,
                    StringDataRespository.class);
            System.out.println("string data:" + repo.getData());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
