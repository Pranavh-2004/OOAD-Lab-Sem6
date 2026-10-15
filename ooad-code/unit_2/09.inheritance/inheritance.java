class A
{
    int aval;

    A() {
        System.out.println("Default constructor of A called");
        this.aval = 1;
    }

    A(int v) {
        System.out.println("Non default constructor of A called");
        this.aval = v;
    }

    void print_greeting() {
        System.out.println("Hello from class A");
    }
}

class B extends A
{
    int bval;

    B() {
        super(20);
        System.out.println("Default constructor of B called");
        this.bval = 1;
    }

    B(int v) {
        System.out.println("Non default constructor of B called");
        this.bval = v;
    }

    @Override
    void print_greeting() {
        System.out.println("Hello from class B");
    }

    void print_all_greetings() {
        super.print_greeting();
        this.print_greeting();
    }
}

class Inheritance
{
    public static void main(String args[]) {
        A a = new A();
        B b = new B();
        A c = new B();

        System.out.println("a.aval = " + a.aval);
        System.out.println("b.bval = " + b.bval);
        System.out.println("b.aval = " + b.aval);
        b.print_greeting();
        b.print_all_greetings();
        c.print_greeting();
    }
}
