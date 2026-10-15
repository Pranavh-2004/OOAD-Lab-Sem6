class SavingsAccount {
    private double balance;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    public double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount {
    private double balance;

    public CurrentAccount(double balance) {
        this.balance = balance;
    }

    public double calculateInterest() {
        return balance * 0.02;
    }
}

// Bad design:
// The point of future changes is the addition of new type of account
// Since the BankSystem is tightly coupled with the different account classes, addition of a new account
// type in the future will affect the BankSystem class since there is no stable interface arround it
class BankSystem {
    public void printInterest(String accountType, double balance) {
        if (accountType.equals("Savings")) {
            SavingsAccount acc = new SavingsAccount(balance);
            System.out.println("Interest = " + acc.calculateInterest());
        }
        else if (accountType.equals("Current")) {
            CurrentAccount acc = new CurrentAccount(balance);
            System.out.println("Interest = " + acc.calculateInterest());
        }
    }
}

class BadProtectedVariation {
    public static void main(String args[]) {
        BankSystem bank = new BankSystem();

        bank.printInterest("Savings", 1000);
        bank.printInterest("Current", 1000);
    }
}
