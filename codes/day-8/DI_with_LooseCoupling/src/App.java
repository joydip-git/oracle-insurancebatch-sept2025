public class App {
    public static void main(String[] args) throws Exception {
        MessageService emailService = new EmailService();
        NotificationSender firstSender = new NotificationSender(emailService);
        String status = firstSender.sendNotification("Self study on DI...");
        System.out.println(status);
       
        MessageService textService = new TextMessageService();
        NotificationSender secondSender = new NotificationSender(textService);
        System.out.println(secondSender.sendNotification("Self study loose coupling"));
    }
}
