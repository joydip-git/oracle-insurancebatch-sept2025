public class App {
    public static void main(String[] args) throws Exception {

        //1. using the default implementation of the inner class of the interface
        // Calculator.Implementation impl = new Calculator.Implementation();
        Calculator calculator = new Calculator.Implementation();
        System.out.println(calculator.calculate(12, 13));


        // 2.a. using the anonymous type (local inner class of the method) - non-generic interface
        Calculator subtractor = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a - b;
            }

        };

        System.out.println(subtractor.calculate(12, 3));

        // 2.b. using the anonymous type (local inner class of the method) - generic interface
        GenericCalculator<Integer> multiplier = new GenericCalculator<>() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                return a * b;
            }

        };
        System.out.println(multiplier.calculate(12, 3));
    }
}
