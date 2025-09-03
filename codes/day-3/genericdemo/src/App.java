
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        add(12, 13); // <-- calling add(T a, T b)
        // add("Archi", "Mehta"); <- not possible as parameters (T) should be of type
        add("Archi", "Mehta"); // <-- calling add(T1 a, T2 b) where T1 == T2
        // Number
        subtract(12, 3);
        LocalDate currentDate = LocalDate.now();
        LocalDate oldDate = LocalDate.of(2025, 8, 12);
        subtract(currentDate, oldDate);

        // can't use primitive type while typifing T
        // use Wrapper type
        NumberValueCollection<Integer> numbers = new NumberValueCollection<>();
        numbers.add(12);
        numbers.add(13);

        ObjectValueCollection<String> names = new ObjectValueCollection<>();
        names.add("Khushi");
        names.add("Bhuvanesh");
    }

    // T -> type parameter
    // both the arguments must be of similar type
    // T should be any of the following types
    // byte, double, float, int, long, and short (all them are of wrapper class
    // Nuumber)
    // generic method with constraint
    static <T extends Number> void add(T a, T b) {

    }

    // overloaded generic method
    // a and b can be of similar types (T1==T2) or dissimilar types (T1!= T2)
    static <T1 extends Object, T2 extends Object> void add(T1 a, T2 b) {

    }

    // generic method without constraint
    static <TInput> void subtract(TInput a, TInput b) {

    }
    // strongly typed methods
    // static void add(int a, int b) {

    // }

    // static void add(String a, String b) {

    // }

    // static void add(double a, double b) {

    // }

    // static void add(int a, long b) {

    // }
}
