// Model part of the code

// Product.java
public class ProductMVC 
{
    private String name;
    private double price;

    public ProductMVC(String name, double price) 
    {
        this.name = name;
        this.price = price;
    }

    public String getName() 
    { 
        return name; 
    }
    public double getPrice() 
    { 
        return price; 
    }
}
