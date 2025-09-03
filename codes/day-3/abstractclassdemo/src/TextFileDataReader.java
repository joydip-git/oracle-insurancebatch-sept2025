public class TextFileDataReader extends DataReader {
    public TextFileDataReader() {
    }

    public TextFileDataReader(String path) {
        super(path);
    }

    @Override
    public String readData() {
        return "file data";
    }
}
