// Domain class
class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() { return balance; }
}

// UI Class
class BadController {
    public static void main(String args[]) {
        // Bad design:
        // The UI class directly interacts with the domain classes and performs critical business operations
        // This increases the coupling between the client code(UI) and the backend code(Domain)
        Account acc = new Account(1000);
        acc.deposit(500);
        System.out.println("Balance = " + acc.getBalance());
    }
}
