class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void displayBalance() {
        System.out.println("Balance = " + balance);
    }
}

// Good design:
// The Account class is only responsible for managing the account
// All other actions like printing report and sending notification is delegated to other classes
// like Reporter and Notifier
// This increases the cohesion of all the classes in the system
class Reporter {
    public static void printReport(Account account) {
        System.out.println("Generating account report...");
    }
}

class Notifier {
    public static void sendEmailNotification(Account account) {
        System.out.println("Sending email notification...");
    }
}

class GoodHighCohesion {
    public static void main(String args[]) {
        Account acc = new Account(1000);
        acc.deposit(500);
        acc.displayBalance();
        Reporter.printReport(acc);
        Notifier.sendEmailNotification(acc);
    }
}
