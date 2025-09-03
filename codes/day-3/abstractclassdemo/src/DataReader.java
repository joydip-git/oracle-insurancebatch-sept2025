public abstract class DataReader implements Reader, SourcePath {
    private String sourcePath;

    public DataReader() {

    }

    public DataReader(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    @Override
    public abstract String readData();

    @Override
    public void setPath(String path) {
        this.sourcePath = path;
    }

    @Override
    public String getPath() {
        return sourcePath;
    }
}
