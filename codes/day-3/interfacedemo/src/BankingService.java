
import java.util.Random;

public class BankingService implements AccountOperations, TransactionOperations, LoanOperations {

    @Override
    public int openAccount(String name) {
        return new Random().nextInt(0, 1000);
    }

    @Override
    public boolean closeAccount(int accountId) {
        return true;
    }

    @Override
    public double Credit(double amount) {
        return 0;
    }

    @Override
    public void debit(double amount) {

    }

    @Override
    public boolean applyForLoan() {
        return true;
    }

    @Override
    public boolean approveLoan() {
        return true;
    }
}
