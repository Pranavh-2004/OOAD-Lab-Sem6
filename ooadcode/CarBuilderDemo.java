class Car 
{
    private final String vendor;
    private final String model;
    private final String color;
    private final int year;
    private final double powerHP;
    private double fuel = 0; // Can be modified after construction

    // Private constructor, only accessible by the builder
    private Car(Builder builder) 
    {
        this.vendor = builder.vendor;
        this.model = builder.model;
        this.color = builder.color;
        this.year = builder.year;
        this.powerHP = builder.powerHP;
    }

    // Getters
    public String getVendor() 
    { 
        return vendor; 
    }
    public String getModel() 
    { 
       return model; 
    }
    public String getColor() 
    { 
        return color; 
    }
    public int getYear() 
    { 
        return year; 
    }
    public double getPowerHP() 
    { 
        return powerHP; 
    }
    public double getFuel() 
    { 
        return fuel; 
    }

    @Override
    public String toString() 
    {
        return "Car{" +
                "vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", powerHP=" + powerHP +
                ", fuel=" + fuel +
                '}';
    }

    // --- Inner Builder Class ---
    public static class Builder 
    {
        // Mandatory parameters (can be passed to the Builder constructor)
        private final String vendor;
        private final String model;

        // Optional parameters (with default values or null)
        private String color = "White";
        private int year = 2024;
        private double powerHP = 100.0;

        // Builder constructor with mandatory fields
        public Builder(String vendor, String model) 
        {
            this.vendor = vendor;
            this.model = model;
        }

        // Setter methods that return the Builder instance for chaining
        public Builder setColor(String color) 
        {
            this.color = color;
            return this;
        }

        public Builder setYear(int year) 
        {
            this.year = year;
            return this;
        }

        public Builder setPowerHP(double powerHP) 
        {
            this.powerHP = powerHP;
            return this;
        }

        // The final build method that creates the Car object
        public Car build() 
        {
            // Optional validation logic can be placed here
            if (powerHP <= 0) 
            {
                throw new IllegalStateException("Power must be positive");
            }
            return new Car(this);
        }
    }
}

public class CarBuilderDemo 
{
    public static void main(String[] args) 
    {
        // Create a car using the builder pattern with method chaining
        Car car = new Car.Builder("BMW", "X5")
                .setColor("Blue")
                .setYear(2023)
                .setPowerHP(300.0)
                .build();

        System.out.println(car);

        // Create a car with only mandatory fields and default optionals
        Car defaultCar = new Car.Builder("Toyota", "Corolla").build();
        System.out.println(defaultCar);
    }
}
