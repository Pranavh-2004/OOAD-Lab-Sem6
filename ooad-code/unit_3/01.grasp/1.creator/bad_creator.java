import java.util.ArrayList;
import java.util.List;

class OrderItem {
    private String productName;
    private int quantity;
    private double price;

    public OrderItem(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return productName + " x " + quantity + " = " + getTotal();
    }
}

class Order {
    private List<OrderItem> items = new ArrayList<>();

    // Bad design:
    // Order class has total control over the OrderItem, hence it should take the responsibility of
    // creating the order object
    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public void showOrder() {
        for (OrderItem item : items) {
            System.out.println(item);
        }
        System.out.println("-----------------");
        System.out.println("Total = " + calculateTotal());
    }
}

class BadCreator {
    public static void main(String args[]) {
        Order order = new Order();

        OrderItem item1 = new OrderItem("Laptop", 1, 1000);
        OrderItem item2 = new OrderItem("Mouse", 2, 100);

        order.addItem(item1);
        order.addItem(item2);

        order.showOrder();
    }
}
