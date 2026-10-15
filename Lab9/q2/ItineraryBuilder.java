package Lab9.q2;

// Abstract Builder
public abstract class ItineraryBuilder {
    protected Itinerary itinerary;
    // All builders access config via Singleton — no new ConfigManager()
    protected ConfigManager config = ConfigManager.getInstance();

    public void createNewItinerary() {
        itinerary = new Itinerary();
    }

    public abstract void buildHotel();
    public abstract void buildTransport();
    public abstract void buildMealPlan();
    public abstract void buildSightseeing();
    public abstract void buildCost();

    public Itinerary getItinerary() {
        return itinerary;
    }
}
