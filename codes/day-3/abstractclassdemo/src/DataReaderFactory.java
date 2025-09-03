public class DataReaderFactory {
    private int choice = 1;

    public DataReaderFactory() {

    }

    public DataReaderFactory(int choice) {
        this.choice = choice;
    }

    public DataReader createDataReader(String path) {
        DataReader reader;
        switch (choice) {
            case 1:
                reader = new TextFileDataReader(path);
                break;

            case 2:
                reader = new OracleDbDataReader(path);
                break;

            case 3:
                reader = new JsonDataReader(path);
                break;

            default:
                reader = null;
                break;
        }
        return reader;
    }
}
