abstract class S {
    int x = 10;
    int y = 20;

    void display() {
        System.out.println("x = " + x + " y = " + y);
    }

    abstract int sum();
}

class A extends S {
    int a = 30;

    void display() {
        System.out.println("a = " + a + " x = " + x + " y = " + y);
    }

    int sum() {
        return a + x + y;
    }
}

class B extends S {
    int b = 40;

    void display() {
        System.out.println("b = " + b + " x = " + x + " y = " + y);
    }

    int sum() {
        return b + x + y;
    }
}

class C extends S {
    int c;

    int sum() {
        return c + x + y;
    }
}

class Abstract {
    public static void main(String args[]) {
        A a = new A();
        a.display();
        System.out.println("sum = " + a.sum() + "\n");

        B b = new B();
        b.display();
        System.out.println("sum = " + b.sum() + "\n");

        /// Dynamic Method Dispatch
        S c = new C();
        c.display();
        System.out.println("sum = " + c.sum() + "\n");
    }
}
