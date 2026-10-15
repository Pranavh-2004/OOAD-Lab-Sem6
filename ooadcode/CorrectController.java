// Domain class
class Order {
    private String customerName;
    private String product;
    private int quantity;
    private double price;

    public Order(String customerName, String product, int quantity, double price) {
        this.customerName = customerName;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public double calculateTotal() {
        return price * quantity;
    }

    public void printOrder() {
        System.out.println("Order placed by " + customerName);
        System.out.println("Product: " + product);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + calculateTotal());
    }
}

// Controller class
class OrderController {
    public void placeOrder(String customerName, String product, int quantity, double price) {
        Order order = new Order(customerName, product, quantity, price);
        order.printOrder();
    }
}

// Main class (UI/entry point)
public class CorrectController {
    public static void main(String[] args) {
        OrderController controller = new OrderController();
        controller.placeOrder("Anand", "Laptop", 2, 50000);
    }
}