/*
import ProductMVC.*;
import CartModel.*;
import RetailView.*;
import RetailController.*;
*/

// The main program
public class RetailMVC 
{
    public static void main(String[] args) 
    {
        // Initialize Components
        CartModel model = new CartModel(5); // Capacity of 5 items
        RetailView view = new RetailView();
        RetailController controller = new RetailController(model, view);

        // Simulate Retail Actions
        ProductMVC laptop = new ProductMVC("Laptop", 999.99);
        ProductMVC mouse = new ProductMVC("Wireless Mouse", 25.50);

        controller.addToCart(laptop);
        controller.addToCart(mouse);
    }
}

