package Lab9.q2;

// Product class
public class Itinerary {
    private String hotelType;
    private String transportMode;
    private String mealPlan;
    private String sightseeingOptions;
    private double totalCost;

    public void setHotelType(String hotelType)             { this.hotelType = hotelType; }
    public void setTransportMode(String transportMode)     { this.transportMode = transportMode; }
    public void setMealPlan(String mealPlan)               { this.mealPlan = mealPlan; }
    public void setSightseeingOptions(String options)      { this.sightseeingOptions = options; }
    public void setTotalCost(double totalCost)             { this.totalCost = totalCost; }

    public void show() {
        System.out.println("--- Itinerary ---");
        System.out.println("Hotel       : " + hotelType);
        System.out.println("Transport   : " + transportMode);
        System.out.println("Meal Plan   : " + mealPlan);
        System.out.println("Sightseeing : " + sightseeingOptions);
        System.out.printf ("Total Cost  : Rs. %.2f%n", totalCost);
        System.out.println("-----------------");
    }
}
