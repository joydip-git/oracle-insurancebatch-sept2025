public class NotificationSender {
    private final MessageService notificationService;

    public NotificationSender(MessageService service) {
        this.notificationService = service;
    }

    public String sendNotification(String message) {
        return notificationService.sendMessage(message);
    }
}