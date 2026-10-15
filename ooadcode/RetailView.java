// The view part

// RetailView.java
public class RetailView 
{
    public void displayCart(ProductMVC[] items, int count, double total) 
    {
        System.out.println("=== RETAIL CHECKOUT ===");
        for (int i = 0; i < count; i++) 
        {
            System.out.println("Item: " + items[i].getName() + 
					" | Price: $" + items[i].getPrice());
        }
        System.out.println("=======================");
        System.out.println("TOTAL DUE: $" + total);
    }
}
