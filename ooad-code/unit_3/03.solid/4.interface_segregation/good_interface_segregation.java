// Good design:
// By breaking down the fat interfaces into smaller interfaces, classes can choose which interfaces
// to implement
// The OldPrinter class can only print and fax hence it implements the Printable and Faxable interfaces
// The NewPrinter class can onlu print and scan hence it implements the Printable and Scanable interfaces
// No clasess are forced to implement methods that do not belong in the class
interface Printable {
    void print();
}

interface Scanable {
    void scan();
}

interface Faxable {
    void fax();
}

class OldPrinter implements Printable, Faxable {
    public void print() {
        System.out.println("Printing document...");
    }

    public void fax() {
        System.out.println("Faxing document...");
    }
}

class NewPrinter implements Printable, Scanable {
    public void print() {
        System.out.println("Printing document...");
    }

    public void scan() {
        System.out.println("Scanning document...");
    }
}

class GoodInterfaceSegregation {
    public static void main(String args[]) {
        OldPrinter m = new OldPrinter();
        m.print();
        m.fax();

        NewPrinter n = new NewPrinter();
        n.print();
        n.scan();
    }
}
