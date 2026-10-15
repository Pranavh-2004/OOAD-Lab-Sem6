// Bad design:
// Does not use polymorphism to dispatch payment processing for different types
// Uses strings to determine which payment processing to perform
class PaymentProcessor {
    public void processPayment(String paymentType) {
        if (paymentType.equals("CreditCard")) {
            System.out.println("Processing credit card payment...");
        }
        else if (paymentType.equals("UPI")) {
            System.out.println("Processing UPI payment...");
        }
        else {
            System.out.println("Unknown payment type");
        }
    }
}

class BadPolymorphism {
    public static void main(String args[]) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.processPayment("CreditCard");
        processor.processPayment("UPI");
        processor.processPayment("...");
    }
}
