public class App {
    public static void main(String[] args) throws Exception {
        //   Calculator.Implementation impl = new Calculator.Implementation();
        Calculator calculator = new Calculator.Implementation();
        System.out.println(calculator.calculate(12, 13));

        Calculator subtractor = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a - b;
            }
            
        };
    }
}
