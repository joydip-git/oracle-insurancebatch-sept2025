public class TextMessageService implements MessageService{

    @Override
    public String sendMessage(String message) {
        return message + " sent via text message";
    }
    
}
