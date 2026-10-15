// Controller part
// RetailController.java
public class RetailController 
{
    private CartModel model;
    private RetailView view;

    public RetailController(CartModel model, RetailView view) 
    {
        this.model = model;
        this.view = view;
    }

    public void addToCart(ProductMVC product) 
    {
        if (model.addItem(product)) 
        {
            updateView();
        } 
        else 
       {
            System.out.println("Error: Cart is full!");
        }
    }

    public void updateView() 
    {
        view.displayCart(model.getItems(), model.getItemCount(), 
				model.calculateTotal());
    }
}

