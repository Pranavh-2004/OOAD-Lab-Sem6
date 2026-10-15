/*
Creator - assigns object creation responsibility to the class that 
    aggregates or closely uses the created object.
    
Order creates OrderItem because it contains and manages it.
*/
import java.util.ArrayList;
import java.util.List;

class OrderItem {
    private String productName;
    private int quantity;
    private double price;

    // add Constructor
    public OrderItem(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotal() {
        //should return the sub total ie  quantity * price;
        return quantity * price;
    }

   // Override toString
   @Override
   public String toString() {
       return productName + " x " + quantity + " @ $" + price + " = $" + getTotal();
   }
}

class Order {
    private List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    // GRASP Creator applied here
    public void addItem(String productName, int quantity, double price) {
//        order item creation
        OrderItem item = new OrderItem(productName, quantity, price);
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            //calc subtotal
            total += item.getTotal();
        }
        return total;
    }

    public void showOrder() 
	{
        for (OrderItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total = $" + calculateTotal());
    }
}

public class CreatorDemo {
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem("Laptop", 1, 1000);
        order.addItem("Mouse", 2, 25);
        order.showOrder();
    }
}