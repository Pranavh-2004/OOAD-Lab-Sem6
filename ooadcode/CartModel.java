// CartModel.java
public class CartModel 
{
    private ProductMVC[] items;
    private int itemCount;

    public CartModel(int capacity) 
    {
        this.items = new ProductMVC[capacity]; // Fixed-size array
        this.itemCount = 0;
    }

    public boolean addItem(ProductMVC product) 
    {
        if (itemCount < items.length) 
        {
            items[itemCount] = product;
            itemCount++;
            return true;
        }
        return false; // Cart full logic
    }

    public double calculateTotal() 
    {
        double total = 0;
        for (int i = 0; i < itemCount; i++) 
        {
            total += items[i].getPrice();
        }
        return total;
    }

    public ProductMVC[] getItems() 
    { 
        return items; 
    }
    public int getItemCount() 
    { 
        return itemCount; 
    }
}
