public class App {
    public static void main(String[] args) throws Exception {
        // create a factory instance
        DataReaderFactory factory = new DataReaderFactory(1);

        // tell the factory instance to create a DataReader type instance
        DataReader reader = factory.createDataReader("path");

        // fetch data using that DataReader type instance
        String data = reader.readData();

        // print data
        System.out.println(data);
    }
}
