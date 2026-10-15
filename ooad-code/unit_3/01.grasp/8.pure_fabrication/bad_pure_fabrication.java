class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    // Bad design:
    // Domain object is doing the work of persistence
    // This decreases the cohesion of the Account class and increases the coupling of the database
    // and the domain classes
    public void saveToDatabase() {
        System.out.println("Saving balance " + balance + " to database");
    }
}

class BadPureFabrication {
    public static void main(String args[]) {
        Account acc = new Account(5000);
        acc.saveToDatabase();
    }
}
