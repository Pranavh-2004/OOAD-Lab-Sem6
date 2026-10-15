 interface PaymentMethod {
    void pay(double amount);
}
class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid rupees " + amount + " using PayPal");
    }
}
 class UpiPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid rupees " + amount + " using UPI");
    }
}
 class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid rupees " + amount + " using Credit Card");
    }
}


 class PaymentFactory {

    public static PaymentMethod getPaymentMethod(String type) {

        if (type == null) {
            throw new IllegalArgumentException("Payment type cannot be null");
        }

        switch (type.toLowerCase()) {
            case "creditcard":
                return new CreditCardPayment();
            case "paypal":
                return new PayPalPayment();
            case "upi":
                return new UpiPayment();
            default:
                throw new IllegalArgumentException("Invalid payment type: " + type);
        }
    }
}


 class factory {
    public static void main(String[] args) {

        PaymentMethod payment1 = PaymentFactory.getPaymentMethod("creditcard");
        payment1.pay(500);

        PaymentMethod payment2 = PaymentFactory.getPaymentMethod("upi");
        payment2.pay(300);

        PaymentMethod payment3 = PaymentFactory.getPaymentMethod("paypal");
        payment3.pay(700);
    }
}
