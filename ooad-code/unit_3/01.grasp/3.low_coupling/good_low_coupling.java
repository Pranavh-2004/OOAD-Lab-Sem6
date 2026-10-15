// Good design:
// SavingsAccount and CurrentAccount implement the Account interface and the BankSystem class depends
// on the interface and not the concrete classes, hence there is lose coupling between the BankSystem
// and the two account classes
interface Account {
    void calculateInterest();
}

class SavingsAccount implements Account {
    public void calculateInterest() {
        System.out.println("Calculating savings account interest");
    }
}

class CurrentAccount implements Account {
    public void calculateInterest() {
        System.out.println("Calculating current account interest");
    }
}

class BankSystem {
    Account savings;
    Account current;

    public BankSystem() {
        savings = new SavingsAccount();
        current = new CurrentAccount();
    }

    void processSavingsAccount() {
        savings.calculateInterest();
    }

    void processCurrentAccount() {
        current.calculateInterest();
    }
}

class GoodLowCoupling {
    public static void main(String args[]) {
        BankSystem bank = new BankSystem();

        bank.processSavingsAccount();
        bank.processCurrentAccount();
    }
}
