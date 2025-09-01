import java.io.PrintStream;

public class App {
    static int compareValues(int x, int y) {
        int compRes = Integer.compare(x, y);
        return compRes;
    }

    public static void main(String[] args) throws Exception {
        PrintStream ps = System.out;
        ps.println("Hello, World!");

        int x = 100;
        int y = 200;

        // int compRes = compareValues(x, y);
        int compRes = Integer.compare(x, y);
        if (compRes > 0)
            ps.println("x is greater");

        Character ch = 'n';
        if (Character.isLowerCase(ch)) {
            ch = Character.toUpperCase(ch);
        }
        ps.println("Character value: " + ch);

        Float d = 3.14159f;
        ps.println("Float value: " + d);
    }
}
