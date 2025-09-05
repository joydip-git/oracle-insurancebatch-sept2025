public class Outer {
    String name;
    static String data = "my data";

    // non-static member Inner class (can access all non-static/static data of the
    // outer class)
    public class Nested {
        public void print() {
            name = "anil";
            System.out.println("Name: " + name);
            System.out.println(data);
        }
    }

    // static member inner class (can access ONLY static data of the outer class)
    public static class StaticInner {
        public void show() {
            System.out.println("Name: " + data);
        }
    }
}
