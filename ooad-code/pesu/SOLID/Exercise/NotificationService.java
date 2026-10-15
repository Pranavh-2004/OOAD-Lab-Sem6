class NotificationService {
    public void sendOrderConfirmation(User user, Order order) {
        System.out.println("Sending confirmation to " + user.getEmail());
        System.out.println("Order Total: ₹" + order.getTotalPrice());
    }
}