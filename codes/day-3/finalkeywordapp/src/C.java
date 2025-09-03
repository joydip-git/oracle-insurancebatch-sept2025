public class C extends B {
    private String name;

    public C(int id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public final String printInfo() {

        return super.printInfo() + ", Name: " + name;
    }
}
