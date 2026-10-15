interface Vehicle 
{
    void start();
    void stop();

    // Default method with implementation
    default void honk() 
    {
        System.out.println("Vehicle is honking: Beep! Beep!");
    }

    default void displayInfo() 
    {
        System.out.println("This is a vehicle");
    }
}

class Car implements Vehicle 
{
    @Override
    public void start() 
    {
        System.out.println("Car engine started");
    }

    @Override
    public void stop() 
    {
        System.out.println("Car engine stopped");
    }

    // honk() and displayInfo() are inherited from Vehicle
    // Can optionally override them if needed
}