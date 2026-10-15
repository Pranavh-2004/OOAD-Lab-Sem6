import java.util.HashMap;
import java.util.Map;

//  MENU MANAGEMENT (ISP)

interface MenuManagement {
    void addMenuItem(Item item);
    void updateStock(Item item, int quantity);
}

interface Reporting {
    void generateMonthlyReport();
}

class SmallRestaurant implements MenuManagement {
    private Map<String, Integer> stock = new HashMap<>();

    public void addMenuItem(Item item) {
        stock.put(item.getName(), 10); // default stock
        System.out.println("Added item: " + item.getName());
    }

    public void updateStock(Item item, int quantity) {
        stock.put(item.getName(), quantity);
        System.out.println("Updated stock for " + item.getName() + ": " + quantity);
    }
}
