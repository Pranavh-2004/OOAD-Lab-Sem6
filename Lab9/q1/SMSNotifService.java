package Lab9.q1;

// Singleton: SMS Notif Service
public class SMSNotifService implements NotifService {
    private static SMSNotifService instance;

    private SMSNotifService() {}

    public static SMSNotifService getInstance() {
        if (instance == null) {
            instance = new SMSNotifService();
        }
        return instance;
    }

    @Override
    public void send(String recipient, String message) {
        System.out.println("[SMS] To: " + recipient + " | Message: " + message);
    }
}
