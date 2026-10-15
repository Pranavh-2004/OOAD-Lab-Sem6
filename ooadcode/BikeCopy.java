public class BikeCopy 
{

    String modelName;  // instance variable

    // Parameterized constructor
    BikeCopy(String model) 
    {
        modelName = model;
    }

    // Copy constructor
    BikeCopy(BikeCopy otherBike) 
    {
        modelName = otherBike.modelName;
    }

    public static void main(String[] args) 
    {
        // Create a Bike object using the parameterized constructor
        BikeCopy myBike = new BikeCopy("Mountain Bike");
        System.out.println("Bike object created! Model: " + myBike.modelName);

        // Create a copy of the existing Bike object using the copy constructor
        BikeCopy copiedBike = new BikeCopy (myBike);
        System.out.println("Copied Bike object created! Model: " + 								copiedBike.modelName);
    }
}