// Main class directly handles business logic
public class ViolateController {
    public static void main(String[] args) {
        // Simulating a user action: placing an order
        String customerName = "Anand";
        String product = "Laptop";
        int quantity = 2;

        // Main class is doing business logic itself (violation!)
        double price = 50000;
        double total = price * quantity;

        System.out.println("Order placed by " + customerName);
        System.out.println("Product: " + product);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + total);
    }
}