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

// Controller class
class AccountContorller {
    private Account account;

    public AccountContorller(Account account) {
        this.account = account;
    }

    public void depositMoney(double amount) {
        account.deposit(amount);
    }

    public double getBalance() {
        return account.getBalance();
    }
}

// UI class
public class GoodController {
    public static void main(String args[]) {
        // Good design:
        // The controller class decreases the coupling between the UI class and the domain class
        // The controller class is only responsible for calling the required methods of the domain class
        // when requests come from the UI class
        Account acc = new Account(1000);
        AccountContorller controller = new AccountContorller(acc);
        controller.deposit(500);
        System.out.println("Balance = " + controller.getBalance());
    }
}
