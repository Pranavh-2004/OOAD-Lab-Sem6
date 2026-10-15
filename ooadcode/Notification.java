public interface Notification {
    void sendAlert(String message);
}

class EmailNotification implements Notification {
    public void sendAlert(String message) {
        System.out.println("Email: " + message);
    }
}

class SMSNotification implements Notification {
    public void sendAlert(String message) {
        System.out.println("SMS: " + message);
    }
}

class PushNotification implements Notification {
    public void sendAlert(String message) {
        System.out.println("Push: " + message);
    }
}