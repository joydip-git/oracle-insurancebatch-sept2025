public interface Calculator {
    int calculate(int a, int b);

    // default implementation of the calculate method provided by the interface
    // itself (through a inner class)
    class Implementation implements Calculator {

        @Override
        public int calculate(int a, int b) {
            return a + b;
        }

    }
}
