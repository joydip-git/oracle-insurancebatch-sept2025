public class Runner extends Thread {

    @Override
    public void run() {
        System.out.println("Runner thread id: " + Thread.currentThread().threadId());
        
        for (int i = 0; i < 5; i++) {
            System.out.println("in runner. value: " + i);
        }
    }
}
