import java.util.ArrayList;
import java.util.List;

// Intrinsic data shared across many shelf items
enum ProductType 
{
    LAPTOP("Electronics", "High-performance laptop"),
    PHONE("Electronics", "Latest smartphone"),
    CHAIR("Furniture", "Ergonomic office chair");

    private final String category;
    private final String description;

    ProductType(String category, String description) 
    {
        this.category = category;
        this.description = description;
    }

    public void display(String serialNumber, double price) 
    {
        System.out.println("Product: " + this.name() + " [" + category + "] | Desc: " 	+ description + " | Serial: " + serialNumber + " | Price: $" + price);
    }
}

// Extrinsic states
class ShelfItem 
{
    private final String serialNumber; // Unique (Extrinsic)
    private final double price;        // Unique (Extrinsic)
    private final ProductType type;    // Shared (Flyweight)

    public ShelfItem(String serialNumber, double price, ProductType type) 
    {
        this.serialNumber = serialNumber;
        this.price = price;
        this.type = type;
    }

    public void showDetails() 
    {
        type.display(serialNumber, price);
    }
}


public class RetailDemoFlyweight 
{
    public static void main(String[] args) 
    {
        List<ShelfItem> inventory = new ArrayList<>();

        // Creating 5 laptops but only sharing ONE ProductType.LAPTOP instance
        for (int i = 1; i <= 5; i++) 
        {
            inventory.add(new ShelfItem("SN-LAP-" + i, 999.99, ProductType.LAPTOP));
        }

        // Creating 5 phones sharing ONE ProductType.PHONE instance
        for (int i = 1; i <= 5; i++) 
	{
            inventory.add(new ShelfItem("SN-PHN-" + i, 499.99, ProductType.PHONE));
        }

        // Display inventory
        for (ShelfItem item : inventory) 
	{
            item.showDetails();
        }
    }
}


