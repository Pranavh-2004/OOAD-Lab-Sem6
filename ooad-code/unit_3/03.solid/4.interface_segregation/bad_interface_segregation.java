// Bad design:
// Both the OldPrinter and NewPrinter class implements the Machine interface
// But the OldPrinter class can not implement the scan method and the NewPrinter class can not implement the fax method
// The Machine interface is fat
// Classes are force to impelement methods that do not belong in the class
interface Machine {
    void print();
    void scan();
    void fax();
}

class OldPrinter implements Machine {
    public void print() {
        System.out.println("Printing document...");
    }

    public void scan() {
        throw new UnsupportedOperationException("Can not scan");
    }

    public void fax() {
        System.out.println("Faxing document...");
    }
}

class NewPrinter implements Machine {
    public void print() {
        System.out.println("Printing document...");
    }

    public void scan() {
        System.out.println("Scanning document...");
    }

    public void fax() {
        throw new UnsupportedOperationException("Can not fax");
    }
}

class BadInterfaceSegregation {
    public static void main(String args[]) {
        Machine m = new OldPrinter();
        m.print();
        m.fax();

        m = new NewPrinter();
        m.print();
        m.scan();
    }
}
