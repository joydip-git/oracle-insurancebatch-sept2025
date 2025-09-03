public class OracleDbDataReader extends DataReader {
    public OracleDbDataReader() {
    }

    public OracleDbDataReader(String path) {
        super(path);
    }

    @Override
    public String readData() {
        return "db data";
    }
}
