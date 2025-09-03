public class App {
    public static void main(String[] args) throws Exception {
        BankingService bankingService = new BankingService();
        int accountId = bankingService.openAccount("joydip");
        System.out.println(accountId);
    }
}
