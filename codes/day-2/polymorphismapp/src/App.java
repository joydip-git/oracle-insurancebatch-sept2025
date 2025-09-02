public class App {
    public static void main(String[] args) throws Exception {
        add(12, 13);
        add(12, 13, 12345678789L);
    }

    static void add(int a, int b) {
        System.out.println(a + b);
    }

    static void add(int a, int b, int c) {
        System.out.println(a + b + c);
    }

    static void add(int a, int b, long c) {
        System.out.println(a + b + c);
    }

    static void add(int a, long b, int c) {
        System.out.println(a + b + c);
    }
}
