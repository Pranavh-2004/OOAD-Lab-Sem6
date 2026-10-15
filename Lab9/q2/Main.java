package Lab9.q2;

public class Main {
    public static void main(String[] args) {
        // Access Singleton config (no new ConfigManager() anywhere)
        ConfigManager config = ConfigManager.getInstance();
        System.out.println("Global Config: " + config);
        System.out.println();

        TravelDirector director = new TravelDirector();

        // Build Luxury Itinerary
        System.out.println("=== Luxury Itinerary ===");
        ItineraryBuilder luxuryBuilder = new LuxuryItineraryBuilder();
        director.setBuilder(luxuryBuilder);
        director.constructItinerary();
        director.getItinerary().show();

        // Build Budget Itinerary
        System.out.println("=== Budget Itinerary ===");
        ItineraryBuilder budgetBuilder = new BudgetItineraryBuilder();
        director.setBuilder(budgetBuilder);
        director.constructItinerary();
        director.getItinerary().show();

        // Verify Singleton ConfigManager
        ConfigManager config2 = ConfigManager.getInstance();
        System.out.println("Singleton check (same ConfigManager): " + (config == config2));
    }
}
