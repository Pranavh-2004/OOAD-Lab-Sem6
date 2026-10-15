class Bank {
    public void processPayment() {
        System.out.println("Processing payment");
    }
}

// Bad design:
// Customer class directly interacts with the Bank class
class Customer {
    private Bank bank = new Bank();

    public void pay() {
        bank.processPayment();
    }
}

class BadIndirection {
    public static void main(String args[]) {
        Customer customer = new Customer();
        customer.pay();
    }
}
