// Implementation of Singleton pattern in Java

class Singleton 
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

public class DemoSingleton 
{
    public static void main(String[] args) 
    {
        // Get the Singleton instance
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance ();

	// To show both of these relate to the same instance
	System.out.println (singleton1.hashCode ());  // returns the hashcode for the object
	System.out.println (singleton2.hashCode ());


        // Use the Singleton
        // ...
    }
}