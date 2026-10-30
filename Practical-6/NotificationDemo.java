interface Notification { void send(String message); }
class EmailNotification implements Notification {
    public void send(String message) { System.out.println("Email: " + message); }
}
class SmsNotification implements Notification {
    public void send(String message) { System.out.println("SMS: " + message); }
}
public class NotificationDemo {
    public static void main(String[] args) {
        Notification[] channels = {new EmailNotification(), new SmsNotification()};
        for (Notification channel : channels) channel.send("Your order has shipped.");
    }
}
