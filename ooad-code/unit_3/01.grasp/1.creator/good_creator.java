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
    private List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    // Good design:
    // Order class has total control over the OrderItem, hence it is creating the order object
    public void addItem(String productName, int quantity, double price) {
        items.add(new OrderItem(productName, quantity, price));
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item: items) {
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

class GoodCreator {
    public static void main(String args[]) {
        Order order = new Order();

        order.addItem("Laptop", 1, 1000);
        order.addItem("Mouse", 2, 100);

        order.showOrder();
    }
}
