// Product interface
interface Dish 
{
    void prepare();
    void serve();
}

// Concrete products
class Pizza implements Dish 
{
    @Override
    public void prepare() 
    {
        System.out.println("Preparing pizza...");
    }

    @Override
    public void serve() 
    {
        System.out.println("Serving pizza...");
    }
}

class Sushi implements Dish 
{
    @Override
    public void prepare() 
    {
        System.out.println("Preparing sushi...");
    }

    @Override
    public void serve() 
    {
        System.out.println("Serving sushi...");
    }
}

// Factory interface
interface DishFactory 
{
    Dish createDish();
}

// Concrete factories
class PizzaFactory implements DishFactory 
{
    @Override
    public Dish createDish() 
    {
        return new Pizza();
    }
}

class SushiFactory implements DishFactory 
{
    @Override
    public Dish createDish() 
    {
        return new Sushi();
    }
}

// The client code
public class DemoFactory
{
    public static void main(String[] args) 
    {
        // Order a pizza using the PizzaFactory
        DishFactory pizzaFactory = new PizzaFactory();
        Dish pizza = pizzaFactory.createDish();
        pizza.prepare();
        pizza.serve();

        // Order sushi using the SushiFactory
        DishFactory sushiFactory = new SushiFactory();
        Dish sushi = sushiFactory.createDish();
        sushi.prepare();
        sushi.serve();
    }
}