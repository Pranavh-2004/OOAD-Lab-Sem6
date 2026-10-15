// Bad design:
// SavingsAccount and CurrentAccount are made as concrete classes that are used directly in the
// BankSystem class, hence there is tight coupling between the BankSystem class and the two account
// classes
class SavingsAccount {
    public void calculateInterest() {
        System.out.println("Calculating savings account interest");
    }
}

class CurrentAccount {
    public void calculateInterest() {
        System.out.println("Calculating current account interest");
    }
}

class BankSystem {
    private SavingsAccount savings;
    private CurrentAccount current;

    public BankSystem() {
        savings = new SavingsAccount();
        current = new CurrentAccount();
    }

    public void processSavingsAccount() {
        savings.calculateInterest();
    }

    public void processCurrentAccount() {
        current.calculateInterest();
    }
}

class BadLowCoupling {
    public static void main(String args[]) {
        BankSystem bank = new BankSystem();
        bank.processSavingsAccount();
        bank.processCurrentAccount();
    }
}
