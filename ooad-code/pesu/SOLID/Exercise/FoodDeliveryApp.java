public class FoodDeliveryApp {
    public static void main(String[] args) {

        // Create user
        User user = new User("john", "john@email.com");

        // Create order
        Order order = new Order();
        order.addItem("Pizza", 250);
        order.addItem("Burger", 150);

        double total = order.calculateTotal();
        System.out.println("Total Price: ₹" + total);

        // Payment
        PaymentMethod paymentMethod = new CreditCardPayment();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(paymentMethod, total);

        // Delivery
        DeliveryService deliveryService = new DeliveryPerson();
        deliveryService.deliverOrder(order);

        // Notification
        NotificationService notificationService = new NotificationService();
        notificationService.sendOrderConfirmation(user, order);

        // Database
        Database db = new MySQLDatabase();
        OrderService orderService = new OrderService(db);
        orderService.placeOrder(order);
    }
}