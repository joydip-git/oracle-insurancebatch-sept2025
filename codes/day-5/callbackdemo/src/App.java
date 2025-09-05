
public class App {

    public static void main(String[] args) throws Exception {
        Calculator<Integer> addFn = new Calculator<>() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                return a + b;
            }
        };

        Calculator<Integer> subFn = (a, b) -> a - b;
        printResult(addFn);
        printResult(subFn);
    }

    static void printResult(Calculator<Integer> fnRef) {
        System.out.println(fnRef.calculate(12, 3));
    }
}
