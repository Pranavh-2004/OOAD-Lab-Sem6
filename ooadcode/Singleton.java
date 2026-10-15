// Implementation of Singleton pattern in Java

public class Singleton 
{
    private static Singleton instance;

    private Singleton() 
    {
        // Initialization code, if needed
    }

    // Static method to get the instance
    public static Singleton getInstance() 
    {
        if (instance == null) 
        {
            instance = new Singleton();
        }
        return instance;
    }
}