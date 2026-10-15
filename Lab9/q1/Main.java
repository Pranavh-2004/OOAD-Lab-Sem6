package Lab9.q1;

public class Main {
    public static void main(String[] args) {
        // Factory selects service at runtime; each service is a Singleton
        NotifService mailService = NotifFactory.getService("MAIL");
        mailService.send("alice@example.com", "Your order has been placed.");

        NotifService smsService = NotifFactory.getService("SMS");
        smsService.send("+919876543210", "OTP: 482910");

        NotifService pushService = NotifFactory.getService("PUSH");
        pushService.send("device-token-xyz", "Flash sale starts now!");

        // Verify Singleton: same instance returned on second call
        NotifService mailService2 = NotifFactory.getService("MAIL");
        System.out.println("\nSingleton check (MAIL same instance): " + (mailService == mailService2));

        NotifService smsService2 = NotifFactory.getService("SMS");
        System.out.println("Singleton check (SMS same instance):  " + (smsService == smsService2));
    }
}
