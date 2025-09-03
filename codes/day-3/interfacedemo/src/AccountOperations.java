public interface AccountOperations {
    int openAccount(String name);

    boolean closeAccount(int accountId);
}
