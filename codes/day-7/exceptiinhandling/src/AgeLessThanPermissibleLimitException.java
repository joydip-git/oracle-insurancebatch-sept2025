// public class AgeLessThanPermissibleLimitException extends Exception {
//     public AgeLessThanPermissibleLimitException() {
//         super("age less than permissible limit of 18");
//     }

//     public AgeLessThanPermissibleLimitException(String message) {
//         super(message);
//     }
// }

public class AgeLessThanPermissibleLimitException extends Exception {
    private final String errorMesssage;

    public AgeLessThanPermissibleLimitException() {
        errorMesssage = "age less than permissible limit of 18";
    }

    public AgeLessThanPermissibleLimitException(String message) {
        errorMesssage = message;
    }

    @Override
    public String getMessage() {
        return errorMesssage;
    }
}