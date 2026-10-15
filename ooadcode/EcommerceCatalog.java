import java.util.ArrayList;

// Product class with attributes
class Product 
{
    private int id;
    private String name;
    private double price;

    // Constructor
    public Product(int id, String name, double price) 
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getId() 
    { 
        return id; 
    }
    public String getName() 
    { 
        return name; 
    }
    public double getPrice() 
    { 
        return price; 
    }

    // toString for display
    @Override
    public String toString() 
    {
        return "Product [ID=" + id + ", Name=" + name + ", Price=" + price + "]";
    }
}

public class EcommerceCatalog 
{
    public static void main(String[] args) 
    {
        // Create an ArrayList of Product objects
        ArrayList<Product> catalog = new ArrayList<>();

        // Add products
        catalog.add(new Product(101, "Laptop", 75000.00));
        catalog.add(new Product(102, "Smartphone", 35000.00));
        catalog.add(new Product(103, "Headphones", 2500.00));

        // Display catalog
        System.out.println("Product Catalog:");
        for (Product p : catalog) 
        {
            System.out.println(p);
        }

        // Remove a product
        catalog.removeIf(p -> p.getId() == 102); // remove Smartphone
        System.out.println("\nAfter removing Smartphone:");
        for (Product p : catalog) 
        {
            System.out.println(p);
        }

        // Search for a product
        String searchName = "Laptop";
        for (Product p : catalog) 
        {
            if (p.getName().equalsIgnoreCase(searchName)) 
            {
                System.out.println("\nFound: " + p);
            }
        }

        // Get catalog size
        System.out.println("\nTotal products: " + catalog.size());
    }
}