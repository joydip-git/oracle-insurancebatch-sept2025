public class EmailService implements MessageService {
    
    @Override
    public String sendMessage(String message) {
        return message + " sent via email";
    }
}
