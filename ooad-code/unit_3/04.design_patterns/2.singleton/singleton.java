class A {
    private static final A instance = new A();
    private A() {}

    public static A getInstance() {
        return instance;
    }

    public void say_hello() {
        System.out.println("Hello!");
    }
}

class Singleton {
    public static void main(String args[]) {
        A.getInstance().say_hello();
    }
}
