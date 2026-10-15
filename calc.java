import java.util.Scanner;

class Calculator{
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }
    public int mul(int a, int b){
        return a*b;
    }
    public int div(int a, int b){
        if (b==0){
            System.out.println("Division by Zero error");
            return -1;
        }
        return a/b;
    }

    public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter first number: ");
    int a = scan.nextInt();
    System.out.println("Enter second number: ");
    int b = scan.nextInt();
    System.out.println("Select Addition(A), Subtraction(S), Multiplication(M) or Division(D)");
    char c = scan.next().charAt(0);
    scan.close();

    Calculator calci = new Calculator();
    double res = 0;
    if(c == 'A'){
        res = calci.add(a, b);
    }
    else if(c == 'S'){
        res = calci.sub(a, b);
    }
    else if(c == 'M'){
        res = calci.mul(a, b);
    }
    else if(c == 'D'){
        res = calci.div(a, b);
    }

    System.out.println(res);
    }
}

