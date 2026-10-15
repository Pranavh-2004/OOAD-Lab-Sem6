// === Q4: FACADE PATTERN ===
// Provides a single simplified interface to a complex subsystem

// Subsystem classes - complex, many methods
class AuthService {
    public void login(String user) {
        System.out.println("[AuthService] User logged in: " + user);
    }
    public void logout(String user) {
        System.out.println("[AuthService] User logged out: " + user);
    }
}

class ProductService {
    public void selectProduct(String product) {
        System.out.println("[ProductService] Product selected: " + product);
    }
    public void checkStock(String product) {
        System.out.println("[ProductService] Stock available for: " + product);
    }
}

class PaymentService {
    public void makePayment(double amount) {
        System.out.println("[PaymentService] Payment of Rs." + amount + " processed successfully.");
    }
    public void sendInvoice(String user) {
        System.out.println("[PaymentService] Invoice sent to: " + user);
    }
}

class OrderService {
    public void placeOrder(String product) {
        System.out.println("[OrderService] Order placed for: " + product);
    }
    public void trackOrder(String orderId) {
        System.out.println("[OrderService] Tracking order: " + orderId + " - Status: Shipped");
    }
}

// Facade - hides complexity behind one simple method
class ECommerceFacade {
    private AuthService auth;
    private ProductService product;
    private PaymentService payment;
    private OrderService order;

    public ECommerceFacade() {
        this.auth = new AuthService();
        this.product = new ProductService();
        this.payment = new PaymentService();
        this.order = new OrderService();
    }

    // Single entry point - coordinates all subsystems internally
    public void completePurchase(String user, String productName, double amount) {
        System.out.println("--- Starting Purchase for " + user + " ---");
        auth.login(user);
        product.checkStock(productName);
        product.selectProduct(productName);
        payment.makePayment(amount);
        payment.sendInvoice(user);
        order.placeOrder(productName);
        order.trackOrder("ORD-" + System.currentTimeMillis() % 10000);
        auth.logout(user);
        System.out.println("--- Purchase Complete ---\n");
    }
}

// Client - uses only the facade, unaware of subsystem complexity
public class ECommerceFacadeDemo {
    public static void main(String[] args) {
        System.out.println("=== E-Commerce Platform - Facade Pattern ===\n");

        ECommerceFacade facade = new ECommerceFacade();

        facade.completePurchase("Pranav", "Laptop", 75999.00);
        facade.completePurchase("Alice",  "Headphones", 2999.00);
    }
}
