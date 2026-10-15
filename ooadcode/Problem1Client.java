// Payment Method Interface
interface PaymentMethod {
   void processPayment(double amount);
}

// Concrete Payment Methods
class CreditCardPayment implements PaymentMethod {
   @Override
   public void processPayment(double amount) {
       System.out.println("Processing Credit Card payment of Rs." + amount);
   }
}

class UPIPayment implements PaymentMethod {
   @Override
   public void processPayment(double amount) {
       System.out.println("Processing UPI payment of Rs." + amount);
   }
}

class NetBankingPayment implements PaymentMethod {
   @Override
   public void processPayment(double amount) {
       System.out.println("Processing Net Banking payment of Rs." + amount);
   }
}

// Payment Factory
class PaymentFactory {
   public static PaymentMethod getPaymentMethod(String type) {
       switch (type.toUpperCase()) {
           case "CREDITCARD": return new CreditCardPayment();
           case "UPI": return new UPIPayment();
           case "NETBANKING": return new NetBankingPayment();
           default: throw new IllegalArgumentException("Unknown payment method type.");
       }
   }
}

// Singleton Payment Gateway Manager
class PaymentGatewayManager {
   private static PaymentGatewayManager instance;

   // Private constructor prevents instantiation from other classes
   private PaymentGatewayManager() {
       System.out.println("Payment Gateway Initialized.");
   }

   // Synchronized to handle multiple threads safely
   public static synchronized PaymentGatewayManager getInstance() {
       if (instance == null) {
           instance = new PaymentGatewayManager();
       }
       return instance;
   }

   public void processTransaction(String paymentType, double amount) {
       PaymentMethod method = PaymentFactory.getPaymentMethod(paymentType);
       System.out.println("Gateway routing transaction...");
       method.processPayment(amount);
       System.out.println("Transaction complete.\n");
   }
}

// Main Client Class
public class Problem1Client {
   public static void main(String[] args) {
       System.out.println("--- Starting Payment Processing System ---");
      
       // Both transactions use the EXACT same gateway instance
       PaymentGatewayManager gateway = PaymentGatewayManager.getInstance();
       gateway.processTransaction("UPI", 1500.00);
       gateway.processTransaction("CREDITCARD", 5000.50);
      
       // Verifying Singleton behavior
       PaymentGatewayManager anotherGatewayReference = PaymentGatewayManager.getInstance();
       System.out.println("Are both gateway references pointing to the same instance? " + (gateway == anotherGatewayReference));
      
       /* * WRITTEN EXPLANATION DELIVERABLE:
        * Scalability: The Factory Pattern allows new payment methods (e.g., Crypto) to be added without altering existing client code.
        * Centralized Control: The Singleton Manager ensures all transactions route through one bottleneck, preventing conflicting multiple instances and allowing easy global logging or rate-limiting.
        */
   }
}
