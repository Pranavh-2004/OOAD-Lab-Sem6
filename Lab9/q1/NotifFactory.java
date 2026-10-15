package Lab9.q1;

// Factory: dynamically selects notif type at runtime
public class NotifFactory {
    public static NotifService getService(String type) {
        switch (type.toUpperCase()) {
            case "MAIL": return MailNotifService.getInstance();
            case "SMS":  return SMSNotifService.getInstance();
            case "PUSH": return PushNotifService.getInstance();
            default: throw new IllegalArgumentException("Unknown notif type: " + type);
        }
    }
}
