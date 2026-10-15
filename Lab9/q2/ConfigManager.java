package Lab9.q2;

// Singleton Config Manager — no direct instantiation via new allowed outside this class
public class ConfigManager {
    private static ConfigManager instance;

    private double defaultBudgetLimit;
    private String travelPolicy;
    private double discountRate;

    private ConfigManager() {
        // Default global settings
        this.defaultBudgetLimit = 100000.0;
        this.travelPolicy = "Standard travel insurance required for all itineraries.";
        this.discountRate = 0.10; // 10% discount
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public double getDefaultBudgetLimit() { return defaultBudgetLimit; }
    public String getTravelPolicy()       { return travelPolicy; }
    public double getDiscountRate()       { return discountRate; }

    @Override
    public String toString() {
        return "ConfigManager{budgetLimit=" + defaultBudgetLimit
                + ", policy='" + travelPolicy + "', discount=" + (discountRate * 100) + "%}";
    }
}
