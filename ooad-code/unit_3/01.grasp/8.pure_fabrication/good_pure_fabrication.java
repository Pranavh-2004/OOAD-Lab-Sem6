class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}

// Good design:
// AccountRepository is a fabricated class that is introduced to remove the responsibility of saving
// balance to the database from the Account class
// This increases the cohesion of the Account class and promotes loose coupling
class AccountRepository {
    public void save(Account account) {
        System.out.println("Savaing balance " + account.getBalance() + " to database");
    }
}

class GoodPureFabrication {
    public static void main(String args[]) {
        Account acc = new Account(5000);
        AccountRepository repo = new AccountRepository();
        repo.save(acc);
    }
}
