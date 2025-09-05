
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        // original source of data
        List<Integer> numbers = List.of(3, 1, 5, 6, 4, 9, 7, 0, 8);

        // creating a stream
        Stream<Integer> numberStream = numbers.stream();

        // 1. ordering/sorting them in acsending order
        // numberStream.sorted();
        Comparator<Integer> compareNumbers = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }

        };
        Stream<Integer> sortedNumbers = numberStream.sorted(compareNumbers);

        // 2. filtering the even numbers
        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t % 2 == 0;
            }

        };
        Stream<Integer> evenNumbers = sortedNumbers.filter(isEven);

        // List<Integer> result = evenNumbers.toList();
        Consumer<Integer> printNumber = new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }

        };
        evenNumbers.forEach(printNumber);
    }
}
