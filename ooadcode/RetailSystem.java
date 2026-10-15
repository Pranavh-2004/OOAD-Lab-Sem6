// Retail Order Processing Facade
// Subsystems:
// InventoryService → checks product availability
// PaymentService → processes payments
// ShippingService → arranges delivery
// Facade: RetailFacade → provides a simple placeOrder() method that hides 
// subsystem complexity.

// Sub system classes
// Inventory subsystem
class InventoryService 
{
    public boolean checkStock(String productId) 
    {
        System.out.println("Checking stock for product: " + productId);
        return true; // assume always available
    }
}

// Payment subsystem
class PaymentService 
{
    public void processPayment(String customerId, double amount) 
    {
        System.out.println("Processing payment of $" + amount + " for customer: " + customerId);
    }
}

// Shipping subsystem
class ShippingService 
{
    public void arrangeShipping(String productId, String customerId) 
    {
        System.out.println("Shipping arranged for product " + productId + " to customer " + customerId);
    }
}

// Facade class
// Facade class that simplifies order placement
class RetailFacade 
{
    private InventoryService inventory;
    private PaymentService payment;
    private ShippingService shipping;

    public RetailFacade() 
    {
        this.inventory = new InventoryService();
        this.payment = new PaymentService();
        this.shipping = new ShippingService();
    }

    public void placeOrder(String productId, String customerId, double amount) 
    {
        if (inventory.checkStock(productId)) 
        {
            payment.processPayment(customerId, amount);
            shipping.arrangeShipping(productId, customerId);
            System.out.println("Order placed successfully!");
        } 
        else 
        {
            System.out.println("Sorry, product is out of stock.");
        }
    }
}

// The client code
public class RetailSystem 
{
    public static void main(String[] args) 
    {
        RetailFacade facade = new RetailFacade();
        facade.placeOrder("PROD101", "CUST001", 250.00);
    }
}