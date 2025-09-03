//public class B extends A {
public class B {
    // read-only
    final int id;

    // constant
    static final String COMPANY_NAME = "Oracle";

    public B(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // public void setId(int id) {
    // this.id = id;
    // }

    public String printInfo() {
        return "Id: " + id + ", Company: " + COMPANY_NAME;
    }
}
