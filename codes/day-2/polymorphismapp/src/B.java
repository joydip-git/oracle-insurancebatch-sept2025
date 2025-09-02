public class B extends A {
    private String data;

    public B() {
        super();
    }

    public B(String name, String data) {
        super(name);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String print() {
        return getName() + ", Data: " + data;
    }
}
