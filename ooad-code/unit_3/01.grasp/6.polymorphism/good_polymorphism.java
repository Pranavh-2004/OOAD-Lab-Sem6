// Good design:
// Uses polymorphism to dispatch corrent payment processing function
interface Payment {
    void processPayment();
}

class CreditCardPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing credit card payment...");
    }
}

class UPIPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing UPI payment...");
    }
}

class GoodPolymorphism {
    public static void main(String args[]) {
        Payment payment = new CreditCardPayment();
        payment.processPayment();

        payment = new UPIPayment();
        payment.processPayment();
    }
}
