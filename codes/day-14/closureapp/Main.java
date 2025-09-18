import java.util.function.Function;
import java.util.function.Predicate;

class Main {
    public static void main(String[] args) {
        Predicate<Integer> isEven = (num) -> num % 2 == 0;
        System.out.println(isEven.test(23));

        Function<String, String> greeting = (name) -> "Hello " + name;
        show(greeting, "ribha");
    }

    static void show(Function<String, String> lamda, String value) {
        System.out.println(lamda.apply(value));
    }
}