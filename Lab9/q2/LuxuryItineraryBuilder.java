package Lab9.q2;

// Concrete Builder: Luxury
public class LuxuryItineraryBuilder extends ItineraryBuilder {

    @Override
    public void buildHotel() {
        itinerary.setHotelType("5-Star Resort");
    }

    @Override
    public void buildTransport() {
        itinerary.setTransportMode("Private Jet + Limousine");
    }

    @Override
    public void buildMealPlan() {
        itinerary.setMealPlan("All-Inclusive Gourmet Dining");
    }

    @Override
    public void buildSightseeing() {
        itinerary.setSightseeingOptions("Private guided tours + helicopter rides");
    }

    @Override
    public void buildCost() {
        double base = 80000.0;
        // Apply discount from Singleton config — no new ConfigManager()
        double discount = base * config.getDiscountRate();
        itinerary.setTotalCost(base - discount);
    }
}
