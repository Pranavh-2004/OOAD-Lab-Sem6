
// Existing interface (Target)
interface Payment {
    void pay(double amount);
}

// Existing implementation
class CardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}

// Existing Banking System
class BankingSystem {
    private Payment payment;

    public BankingSystem(Payment payment) {
        this.payment = payment;
    }

    public void makePayment(double amount) {
        payment.pay(amount);
    }
}
/*
// Main (Before UPI)
public class MainApp {
    public static void main(String[] args) {
        Payment card = new CardPayment();
        BankingSystem bank = new BankingSystem(card);

        bank.makePayment(2000);
    }
}
*/

//New Third Party UPI service
// Adaptee (3rd-party class - cannot modify)
class UpiService {
    public void sendMoney( double amount) {
        System.out.println("Paid using UPI " + amount);
    }
}
// Adapter
class UpiAdapter implements Payment {
    private UpiService upiService;


    public UpiAdapter(UpiService upiService) {
        this.upiService = upiService;

    }

    @Override
    public void pay(double amount) {
        // Convert request to UPI format
        upiService.sendMoney(amount);
    }
}

public class MainApp {
    public static void main(String[] args) {

        // Existing system unchanged
        Payment card = new CardPayment();
        BankingSystem bank = new BankingSystem(card);

        bank.makePayment(2000);
    
        System.out.println("----- Using UPI -----");

        // New UPI integration using Adapter
        Payment upiPayment = new UpiAdapter(new UpiService());
        BankingSystem bank2 = new BankingSystem(upiPayment);
        bank2.makePayment(3000);
    }
}
