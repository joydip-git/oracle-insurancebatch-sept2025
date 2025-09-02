public class A {
    private String name;

    public A() {

    }

    public A(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String print() {
        return "Name: " + name;
    }
}
