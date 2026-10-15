import java.util.Scanner;

interface Outputable {
    void output(Inputable i);

    default void oInfo() {
        System.out.println("Outputable implements Outputable");
    }
}

interface Inputable {
    void input();

    default void iInfo() {
        System.out.println("Inputable implements Inputable");
    }
}

class Addition implements Outputable, Inputable {
    private int a;
    private int b;

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        this.a = scanner.nextInt();

        System.out.print("Enter second integer: ");
        this.b = scanner.nextInt();

        scanner.close();
    }

    public void output() {
        System.out.println(this.toString());
    }

    public void oInfo() {
        System.out.println("Addition implements Outputable");
    }

    public String toString() {
        return a + " + " + b + " = " + (a + b);
    }
}

class Interfaces {
    public static void main(String args[]) {
        Addition a = new Addition();

        Inputable inp = a;
        inp.input();

        Outputable oup = a;
        oup.output();

        a.iInfo();
        a.oInfo();

        System.out.println(a);
    }
}
