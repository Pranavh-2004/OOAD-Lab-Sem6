// Abstract Factory
interface FurnitureFactory 
{
    Chair createChair();  // Method to create a Chair
    Table createTable();  // Method to create a Table
}


// Abstract Products
// Chair :

interface Chair 
{
    void sitOn();  // Common functionality for all chairs
}


// Table :

interface Table 
{
    void use();    // Common functionality for all tables
}

// Concrete Products
// Modern Chair :

// Concrete implementation of Modern Chair
class ModernChair implements Chair 
{
    @Override
    public void sitOn() 
    {
        System.out.println("Sitting on a modern chair!");
    }
}

// Modern Table :

// Concrete implementation of Modern Table
class ModernTable implements Table 
{
    @Override
    public void use() 
    {
        System.out.println("Using a modern table!");
    }
}

// Victorian Chair :

// Concrete implementation of Victorian Chair
class VictorianChair implements Chair 
{
    @Override
    public void sitOn() 
    {
        System.out.println("Sitting on a Victorian chair!");
    }
}

// Victorian Table :

// Concrete implementation of Victorian Table
class VictorianTable implements Table 
{
    @Override
    public void use() 
    {
        System.out.println("Using a victorian table!");
    }
}


// Concrete Factories
// Modern Furniture Factory :

// Factory for creating modern furniture
class ModernFurnitureFactory implements FurnitureFactory 
{
    @Override
    public Chair createChair() 
    {
        return new ModernChair(); // Create a modern chair
    }

    @Override
    public Table createTable() 
    {
        return new ModernTable(); // Create a modern table
    }
}

// Victorian Furniture Factory :

class VictorianFurnitureFactory implements FurnitureFactory 
{
    @Override
    public Chair createChair() 
    {
        return new VictorianChair();
    }

    @Override
    public Table createTable() 
    {
        return new VictorianTable();
    }
}

// Client Code
public class AbsFactMain 
{
    public static void main(String[] args) 
    {
        // Create modern furniture using the ModernFurnitureFactory
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        Table modernTable = modernFactory.createTable();

        // Use the modern furniture
        modernChair.sitOn();
        modernTable.use();

        // Create Victorian furniture using the VictorianFurnitureFactory
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        Chair victorianChair = victorianFactory.createChair();
        Table victorianTable = victorianFactory.createTable();

        // Use the Victorian furniture
        victorianChair.sitOn();
        victorianTable.use();
    }
}
