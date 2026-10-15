public class BikeReturn 
{

    String modelName;  // instance variable
    int speed;

    // Parameterized constructor
    BikeReturn(String model, int sp) 
    {
        modelName = model;
        return;
        speed = sp;
    }

    public static void main(String[] args) 
    {
        // Pass parameter while creating the Bike object
        BikeReturn myBike = new BikeReturn("Mountain Bike", 20);
        System.out.println("Bike object created! Model: " + myBike.modelName);
        System.out.println("Speed of the Bike is " + myBike.speed);
    }
}