package Lab9.q1;

// Singleton: Mail Notif Service
public class MailNotifService implements NotifService {
    private static MailNotifService instance;

    private MailNotifService() {}

    public static MailNotifService getInstance() {
        if (instance == null) {
            instance = new MailNotifService();
        }
        return instance;
    }

    @Override
    public void send(String recipient, String message) {
        System.out.println("[MAIL] To: " + recipient + " | Message: " + message);
    }
}
