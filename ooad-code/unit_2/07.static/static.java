class Test
{
    /// static variable
    static int a = m1();
    static int b;
    int c = 2;

    /// static block
    static {
        System.out.println("Inside static block");
    }

    /// static method
    static int m1() {
        System.out.println("from m1");
        return 20;
    }

    /// non static method
    void m() {
        System.out.println("Value of c: " + c);
    }

    /// static method main
    public static void main(String args[]) {
        System.out.println("Value of a: " + a);
        System.out.println("Value of b: " + b);
        System.out.println("from main");

        (new Test()).m();
    }
}
