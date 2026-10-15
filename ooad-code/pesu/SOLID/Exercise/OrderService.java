// ORDER SERVICE (DIP)

class OrderService {
    private Database database;

    public OrderService(Database database) {
        this.database = database;
    }

    public void placeOrder(Order order) {
        database.saveOrder(order);
    }
}