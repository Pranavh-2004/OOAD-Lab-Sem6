// Interfaces and Abstractions

// SRP: Each interface has one responsibility
interface Product {
    String getName();
    double getPrice();
}

interface Customer {
    String getName();
    void placeOrder(Order order);
}

// Concrete implementations
class Electronics implements Product {
    private String name;
    private double price;

    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

class RetailCustomer implements Customer {
    private String name;
    public RetailCustomer(String name) { this.name = name; }
    public String getName() { return name; }
    public void placeOrder(Order order) {
        System.out.println(name + " placed order: " + order);
    }
}

// Factory pattern
class ProductFactory {
    public static Product createProduct(String type, String name, double price) {
        if (type.equalsIgnoreCase("electronics")) {
            return new Electronics(name, price);
        }
        // Extendable for clothing, groceries, etc. (OCP)
        throw new IllegalArgumentException("Unknown product type");
    }
}

// Builder pattern
class Order {
    private Customer customer;
    private List<Product> products = new ArrayList<>();

    public void setCustomer(Customer customer) { this.customer = customer; }
    public void addProduct(Product product) { products.add(product); }

    @Override
    public String toString() {
        return "Order for " + customer.getName() + " with " + products.size() + " products.";
    }
}

class OrderBuilder {
    private Order order = new Order();

    public OrderBuilder setCustomer(Customer customer) {
        order.setCustomer(customer);
        return this;
    }

    public OrderBuilder addProduct(Product product) {
        order.addProduct(product);
        return this;
    }

    public Order build() {
        return order;
    }
}

// Client code

public class RetailDemo1 {
    public static void main(String[] args) {
        // Factory usage
        Product laptop = ProductFactory.createProduct("electronics", "Laptop", 75000);

        // Builder usage
        Customer customer = new RetailCustomer("Anand");
        Order order = new OrderBuilder()
                        .setCustomer(customer)
                        .addProduct(laptop)
                        .build();

        customer.placeOrder(order);
    }
}

