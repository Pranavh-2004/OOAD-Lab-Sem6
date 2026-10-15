package Lab9.q2;

// Director: orchestrates the construction sequence
public class TravelDirector {
    private ItineraryBuilder builder;

    public void setBuilder(ItineraryBuilder builder) {
        this.builder = builder;
    }

    public void constructItinerary() {
        builder.createNewItinerary();
        builder.buildHotel();
        builder.buildTransport();
        builder.buildMealPlan();
        builder.buildSightseeing();
        builder.buildCost();
    }

    public Itinerary getItinerary() {
        return builder.getItinerary();
    }
}
