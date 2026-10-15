class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }

    // Bad design:
    // The Account class not only has the responsibility of managing the balance but also to print
    // report and send emails, hence the cohesion of the class is low
    public void printReport() {
        System.out.println("Generating account report...");
    }

    public void sendEmailNotification() {
        System.out.println("Sending email notification...");
    }
}

class BadHighCohesion {
    public static void main(String args[]) {
        Account acc = new Account(1000);
        acc.deposit(500);
        acc.displayBalance();
        acc.printReport();
        acc.sendEmailNotification();
    }
}
