import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface Product {
    String getName();
    double getPrice();
    void displayDetails();
}

class Electronics implements Product {
    private String name;
    private double price;
    private int warranty;

    Electronics(String name, double price, int warranty) {
        this.name = name;
        this.price = price;
        this.warranty = warranty;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Category: Electronics");
        System.out.println("Name: " + name);
        System.out.printf("Price: %.2f%n", price);
        System.out.println("Warranty: " + warranty + " months");
    }
}

class Grocery implements Product {
    private String name;
    private double price;
    private String expiryDate;

    Grocery(String name, double price, String expiryDate) {
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Category: Grocery");
        System.out.println("Name: " + name);
        System.out.printf("Price: %.2f%n", price);
        System.out.println("Expiry Date: " + expiryDate);
    }
}

class Clothing implements Product {
    private String name;
    private double price;
    private String size;

    Clothing(String name, double price, String size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Category: Clothing");
        System.out.println("Name: " + name);
        System.out.printf("Price: %.2f%n", price);
        System.out.println("Size: " + size);
    }
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();
        String name = sc.next();
        double price = sc.nextDouble();

        Product product = null;

        if (choice == 1) {
            int warranty = sc.nextInt();
            product = new Electronics(name, price, warranty);
        } else if (choice == 2) {
            String expiryDate = sc.next();
            product = new Grocery(name, price, expiryDate);
        } else if (choice == 3) {
            String size = sc.next();
            product = new Clothing(name, price, size);
        } else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }
        product.displayDetails();
        sc.close();
    }
}