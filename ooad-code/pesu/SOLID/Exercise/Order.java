import java.util.ArrayList;
import java.util.List;

class Order {
    private List<Item> items = new ArrayList<>();
    private double totalPrice;

    public void addItem(String name, double price) {
        Item item = new Item(name, price);
        items.add(item);
    }

    public double calculateTotal() {
        totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
