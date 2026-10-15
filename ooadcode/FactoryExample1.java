// Define an interface
interface Notification 
{
    void notifyUser();
}

// Implement concrete classes
class EmailNotification implements Notification 
{
    public void notifyUser() 
    {
        System.out.println("Sending an Email Notification");
    }
}

class SMSNotification implements Notification 
{
    public void notifyUser() 
    {
        System.out.println("Sending an SMS Notification");
    }
}

class PushNotification implements Notification 
{
    public void notifyUser() 
    {
        System.out.println("Sending a Push Notification");
    }
}

// Create factory class
class NotificationFactory 
{

    public Notification createNotification(String type) 
    {
        if (type == null || type.isEmpty()) 
            return null;
        switch (type.toLowerCase()) 
        {
            case "sms":
                return new SMSNotification();
            case "email":
                return new EmailNotification();
            case "push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }

}

// Use it in client code
public class FactoryExample1 
{
    public static void main(String[] args) 
    {
        NotificationFactory factory = new NotificationFactory();

        Notification notification = factory.createNotification("email");
        notification.notifyUser();

        notification = factory.createNotification("sms");
        notification.notifyUser();
    }
}