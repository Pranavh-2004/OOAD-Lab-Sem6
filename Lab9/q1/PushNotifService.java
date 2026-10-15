package Lab9.q1;

// Singleton: Push Notif Service
public class PushNotifService implements NotifService {
    private static PushNotifService instance;

    private PushNotifService() {}

    public static PushNotifService getInstance() {
        if (instance == null) {
            instance = new PushNotifService();
        }
        return instance;
    }

    @Override
    public void send(String recipient, String message) {
        System.out.println("[PUSH] To: " + recipient + " | Message: " + message);
    }
}
