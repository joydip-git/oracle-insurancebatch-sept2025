public class JsonDataReader extends DataReader {
    public JsonDataReader() {

    }

    public JsonDataReader(String path) {
        super(path);
    }

    @Override
    public String readData() {
        return "Json file data";
    }
}
