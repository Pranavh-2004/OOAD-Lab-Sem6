class Bank {
    public void processPayment() {
        System.out.println("Processing payment");
    }
}

// Good design:
// The PaymentService class acts as an indirection between the Bank class and the Customer class
// The Customer class no longer depends on the Bank class, it depends on the PaymentService class
class PaymentService {
    private Bank bank = new Bank();

    public void makePayment() {
        bank.processPayment();
    }
}

class Customer {
    private PaymentService paymentService = new PaymentService();

    public void pay() {
        paymentService.makePayment();
    }
}

class GoodIndirection {
    public static void main(String args[]) {
        Customer customer = new Customer();
        customer.pay();
    }
}
