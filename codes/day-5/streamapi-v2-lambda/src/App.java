
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class App {
    static void useFunctionalInterfaceandMethodRef() {
        // This anonymous inner class creation can be simplified by using lambda
        // expression
        Calculator<Integer> addFn = new Calculator<>() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                return a + b;
            }

        };

        System.out.println(addFn.calculate(12, 13));

        Calculator<Integer> subFn = (Integer a, Integer b) -> {
            return a - b;
        };
        System.out.println(subFn.calculate(13, 3));

        Calculator<Integer> multiplyFn = (a, b) -> a * b;
        System.out.println(multiplyFn.calculate(12, 3));

    }

    public static void main(String[] args) throws Exception {
        // useFunctionalInterfaceandMethodRef();
        // useStreamAPI();
        useStreamAPIMethodChaining();
    }

    static void useStreamAPI() {
        // original source of data
        List<Integer> numbers = List.of(3, 1, 5, 6, 4, 9, 7, 0, 8);

        // creating a stream
        Stream<Integer> numberStream = numbers.stream();

        // 1. ordering/sorting them in acsending order
        Comparator<Integer> compareNumbers = (a, b) -> a - b;
        // compareNumbers.compare(12, 13);
        Stream<Integer> sortedNumbers = numberStream.sorted(compareNumbers);

        // 2. filtering the even numbers
        Predicate<Integer> isEven = (t) -> t % 2 == 0;
        Stream<Integer> evenNumbers = sortedNumbers.filter(isEven);

        // List<Integer> result = evenNumbers.toList();
        Consumer<Integer> printNumber = (num) -> System.out.println(num);
        evenNumbers.forEach(printNumber);
    }

    static void useStreamAPIMethodChaining() {
        // original source of data
        List<Integer> numbers = List.of(3, 1, 5, 6, 4, 9, 7, 0, 8);

        // 1. ordering/sorting the numbers in acsending order
        // 2. filtering the even numbers from the sorted numbers
        // 3. print every even number
        Stream<Integer> numberStream = numbers.stream();
        numberStream
                .sorted((a, b) -> a - b)
                .filter((a) -> a % 2 == 0)
                .forEach((a) -> System.out.println(a));

    }
}
