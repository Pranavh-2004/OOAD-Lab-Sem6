// BAD CODE

// Vehicle.java

public interface Vehicle 
{
    void setPrice(double price);
    void setColor(String color);
    void start();
    void stop();
    void fly();
}

// Car.java
public class Car implements Vehicle 
{
    double price;
    String color;
    @Override
    public void setPrice(double price) 
    {
        this.price = price;
    }
    @Override
    public void setColor(String color) 
    {
        this.color=color;
    }
    @Override
    public void start(){}
    @Override
    public void stop(){}
    @Override
    public void fly(){}    
}



// GOOD CODE
// Vehicle.java
public interface Vehicle 
{
     void setPrice(double price);
     void setColor(String color);
}

// Movable.java
public interface Movable 
{
    void start();
    void stop();
}

// Flyable.java
public interface Flyable 
{
    void fly();
}


// Implementation
// Car.java

public class Car implements Vehicle, Movable 
{
    double price;
    String color;
​
    @Override
    public void setPrice(double price) 
    {
​
        this.price = price;
    }
    @Override
    public void setColor(String color) 
    {
​
        this.color=color;
    }
    @Override
    public void start()
    {
        // Implementation
    }
    @Override
    public void stop()
    {
        // Implementation
    }
}


// Aeroplane.java
public class Aeroplane implements Vehicle, Movable, Flyable 
{
    double price;
    String color;
​
    @Override
    public void setPrice(double price) 
    {
​
        this.price = price;
    }
​
    @Override
    public void setColor(String color) 
    {
     this.color=color;
    }
    @Override
    public void start()
    {
        // Implementation
    }
    @Override
    public void stop()
    {
        // Implementation
    }
    @Override
    public void fly()
    {
        // Implementation
    }
}
