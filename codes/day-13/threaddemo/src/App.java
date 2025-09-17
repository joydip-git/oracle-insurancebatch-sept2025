public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Main thread id: " + Thread.currentThread().threadId());
        Runner runner = new Runner();
        runner.start();
        //runner.join();
        for (int i = 0; i < 5; i++) {
            System.out.println("in main. value: " + i);
        }
    }
}
