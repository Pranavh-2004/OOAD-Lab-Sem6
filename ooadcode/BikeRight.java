public class BikeRight 
{

    // Constructor with a condition to exit early
    BikeRight(boolean skip) 
   {
        if (skip) 
        {
            System.out.println("Constructor exited early");
            return; // Ends constructor execution here
        }

        System.out.println("Constructor continues...");
        // More initialization logic can go here
        System.out.println("Bike object initialized successfully");
    }

    public static void main(String[] args) 
    {
        System.out.println("Creating first bike (skip = true):");
        BikeRight bike1 = new BikeRight(true);  // Constructor will exit early

        System.out.println("\nCreating second bike (skip = false):");
        BikeRight bike2 = new BikeRight(false); // Constructor will continue
    }
}