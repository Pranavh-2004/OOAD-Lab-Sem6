// Good design:
// The point of future changes is the addition of new type of account
// Hence a stable interface Account is added to make sure that addition of a new type of account in
// the future does not affect other parts of the system.
interface Account {
    double calculateInterest();
}

class SavingsAccount implements Account {
    private double balance;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    public double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount implements Account {
    private double balance;

    public CurrentAccount(double balance) {
        this.balance = balance;
    }

    public double calculateInterest() {
        return balance * 0.02;
    }
}

class BankSystem {
    public void printInterest(Account acc) {
        System.out.println("Interest = " + acc.calculateInterest());
    }
}

class GoodProtectedVariation {
    public static void main(String args[]) {
        BankSystem bank = new BankSystem();

        Account acc = new SavingsAccount(1000);
        bank.printInterest(acc);

        acc = new CurrentAccount(1000);
        bank.printInterest(acc);
    }
}
