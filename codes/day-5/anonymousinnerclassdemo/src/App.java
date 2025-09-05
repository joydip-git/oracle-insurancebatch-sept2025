
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {

        // 1. using the default implementation of the inner class of the interface
        // Calculator.Implementation impl = new Calculator.Implementation();
        Calculator calculator = new Calculator.Implementation();
        System.out.println(calculator.calculate(12, 13));

        // 2.a. using the anonymous type (local inner class of the method) - non-generic
        // interface
        Calculator subtractor = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a - b;
            }

        };

        System.out.println(subtractor.calculate(12, 3));

        // 2.b. using the anonymous type (local inner class of the method) - generic
        // interface
        GenericCalculator<Integer> multiplier = new GenericCalculator<>() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                return a * b;
            }

        };
        System.out.println(multiplier.calculate(12, 3));

        Operations transactionOps = new Operations() {
            private double currentBalance = 5000;

            @Override
            public double credit(double amount) {
                currentBalance += amount;
                return currentBalance;
            }

            @Override
            public double debit(double amount) {
                currentBalance -= amount;
                return currentBalance;
            }

        };

        System.out.println(transactionOps.debit(1000));
        System.out.println(transactionOps.credit(2000));

        List<Integer> numbers = List.of(41, 12, 31, 24, 55);
        // the sort method mutates the collection and arranges the elements in ascending
        // order
        // Collections.sort(numbers);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        // numbers.sort(comparator);
        // Collections.sort(numbers, comparator);

        Stream<Integer> numberStream = numbers.stream();

        Stream<Integer> orderedStream = numberStream
                .sorted(comparator);

        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t % 2 == 0;
            }

        };

        // System.out.println("\nordered values\n");
        // orderedStream
        // .forEach(
        // new Consumer<Integer>() {
        // @Override
        // public void accept(Integer t) {
        // System.out.println(t);
        // }

        // });

        Stream<Integer> filteredStream = orderedStream
                .filter(isEven);
        Consumer<Integer> printNum = new Consumer<Integer>() {

            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }

        };

        System.out.println("\nfiletred even numbers\n");
        filteredStream
                .toList()
                .forEach(printNum);

        // for (int num : numbers) {
        // System.out.println(num);
        // }

    }
}
