// 1. The Stable Interface (The "Protection")
// This defines a fixed contract that the rest of the system relies on.
interface TaxCalculator {
    double calculateTax(double amount);
}

// 2. Concrete Implementation A (Variation 1)
class USATaxCalculator implements TaxCalculator {
    public double calculateTax(double amount) {
        return amount * 0.07; // 7% USA Tax logic
    }
}

// 3. Concrete Implementation B (Variation 2)
class CanadaTaxCalculator implements TaxCalculator {
    public double calculateTax(double amount) {
        return amount * 0.12; // 12% Canada Tax logic
    }
}

// 4. The Core System (Protected from changes in tax logic)
class Sale {
    private double amount;
    private TaxCalculator taxCalculator; // Programmed to the interface

    public Sale(double amount, TaxCalculator taxCalculator) {
        this.amount = amount;
        this.taxCalculator = taxCalculator;
    }

    public double getTotal() {
        return amount + taxCalculator.calculateTax(amount);
    }
}

// 5. Demonstration
public class ProtectedVariationDemo {
    public static void main(String[] args) {
        // We can switch tax strategies without changing the Sale class.
        TaxCalculator usaTax = new USATaxCalculator();
        Sale sale1 = new Sale(100.0, usaTax);
        System.out.println("Total with USA Tax: " + sale1.getTotal());

        TaxCalculator canadaTax = new CanadaTaxCalculator();
        Sale sale2 = new Sale(100.0, canadaTax);
        System.out.println("Total with Canada Tax: " + sale2.getTotal());
    }
}
