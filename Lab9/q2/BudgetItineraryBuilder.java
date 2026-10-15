package Lab9.q2;

// Concrete Builder: Budget
public class BudgetItineraryBuilder extends ItineraryBuilder {

    @Override
    public void buildHotel() {
        itinerary.setHotelType("2-Star Hostel / Budget Hotel");
    }

    @Override
    public void buildTransport() {
        itinerary.setTransportMode("Train + Local Bus");
    }

    @Override
    public void buildMealPlan() {
        itinerary.setMealPlan("Breakfast Only");
    }

    @Override
    public void buildSightseeing() {
        itinerary.setSightseeingOptions("Self-guided tours + public attractions");
    }

    @Override
    public void buildCost() {
        double base = 15000.0;
        // Apply discount from Singleton config — no new ConfigManager()
        double discount = base * config.getDiscountRate();
        itinerary.setTotalCost(base - discount);
    }
}
