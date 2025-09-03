
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("1. Text File\n2. Oracle Db\n3. Json File");
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter choice[1/2/3]: ");
        int choice = scanner.nextInt();

        // create a factory instance
        DataReaderFactory factory = new DataReaderFactory(choice);

        // tell the factory instance to create a DataReader type instance
        DataReader reader = factory.createDataReader("path");

        // fetch data using that DataReader type instance
        String data = reader.readData();

        // print data
        System.out.println(data);

        scanner.close();
    }
}
