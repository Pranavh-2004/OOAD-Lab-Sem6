import java.util.Scanner;

interface Outputable {
    void output();
}

interface Inputable {
    void input();
}

class Addition implements Outputable, Inputable{
    private int a;
    private int b;

    public void input(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first interger: ");
        this.a = scanner.nextInt();

        System.out.print("Enter second interger: ");
        this.b = scanner.nextInt();

        scanner.close();
    }

    public void output(){
        System.out.println("result is: "+ (a + b));
    }
}

class interfaces{
    public static void main(String[] args) {
     Addition a = new Addition();
     
     Inputable inp = a;
     inp.input();

     Outputable oup = a;
     oup.output();
    }
}

