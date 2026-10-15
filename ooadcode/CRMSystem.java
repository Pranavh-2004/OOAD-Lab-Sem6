class Customer {
    private String id;
    private String name;
    private String email;
    private String phone;

    public Customer(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}

interface Notifiable {
    void notifyCustomer(Customer customer, String message);
}

interface Reportable {
    void generateReport();
}

interface NotificationChannel extends Notifiable {}

class EmailNotification implements NotificationChannel {
    @Override
    public void notifyCustomer(Customer customer, String message) {
        System.out.println("Email sent to " + customer.getEmail() + ": " + message);
    }
}

class SMSNotification implements NotificationChannel {
    @Override
    public void notifyCustomer(Customer customer, String message) {
        System.out.println("SMS sent to " + customer.getPhone() + ": " + message);
    }
}

interface CustomerRepository {
    void save(Customer customer);
    Customer find(String id);
}

class InMemoryCustomerRepository implements CustomerRepository {
    private java.util.Map<String, Customer> storage = new java.util.HashMap<>();

    @Override
    public void save(Customer customer) {
        storage.put(customer.getId(), customer);
    }

    @Override
    public Customer find(String id) {
        return storage.get(id);
    }
}

class CustomerNotifier {
    private NotificationChannel channel;

    public CustomerNotifier(NotificationChannel channel) {
        this.channel = channel;
    }

    public void sendNotification(Customer customer, String message) {
        channel.notifyCustomer(customer, message);
    }
}

class CRMService {
    private CustomerRepository repository;
    private CustomerNotifier notifier;

    public CRMService(CustomerRepository repository, CustomerNotifier notifier) {
        this.repository = repository;
        this.notifier = notifier;
    }

    public void addCustomer(Customer customer) {
        repository.save(customer);
        notifier.sendNotification(customer, "Welcome to our CRM system!");
    }

    public void contactCustomer(String id, String message) {
        Customer customer = repository.find(id);
        if (customer != null) {
            notifier.sendNotification(customer, message);
        } else {
            System.out.println("Customer not found!");
        }
    }
}

// --- Main Program ---
public class CRMSystem {
    public static void main(String[] args) {
        CustomerRepository repo = new InMemoryCustomerRepository();
        NotificationChannel channel = new EmailNotification(); 

        CustomerNotifier notifier = new CustomerNotifier(channel);
        CRMService service = new CRMService(repo, notifier);

        Customer cust1 = new Customer("C001", "Alice", "alice@example.com", "1234567890");
        Customer cust2 = new Customer("C002", "Bob", "bob@example.com", "9876543210");

        service.addCustomer(cust1);
        service.addCustomer(cust2);

        service.contactCustomer("C001", "We have a new offer for you!");
        service.contactCustomer("C002", "Your subscription is expiring soon.");
    }
}