import java.io.*;
import java.util.*;

class FoodOrder {
    int orderId;
    String customerName;
    double basePrice;

    FoodOrder(int orderId, String customerName, double basePrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.basePrice = basePrice;
    }

    double calculateFinalPrice() {
        return basePrice;
    }

    void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.printf("Final Price: %.2f", calculateFinalPrice());
    }
}

class DineInOrder extends FoodOrder {
    DineInOrder(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
        return basePrice + (basePrice * 0.10);
    }
}

class TakeAwayOrder extends FoodOrder {
    TakeAwayOrder(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
        return basePrice + 50;
    }
}

class DeliveryOrder extends FoodOrder {
    DeliveryOrder(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
        return basePrice + 40 + (basePrice * 0.05);
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            if (!sc.hasNextInt()) return;
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice < 1 || choice > 3) return;

            if (!sc.hasNextInt()) return;
            int orderId = sc.nextInt();
            sc.nextLine();

            if (orderId < 1 || orderId > 1_000_000) return;

            if (!sc.hasNextLine()) return;
            String customerName = sc.nextLine();

            if (!sc.hasNextDouble()) return;
            double basePrice = sc.nextDouble();

            if (basePrice < 0 || basePrice > 1_000_000) return;

            FoodOrder order = null;

            if (choice == 1) {
                order = new DineInOrder(orderId, customerName, basePrice);
            } else if (choice == 2) {
                order = new TakeAwayOrder(orderId, customerName, basePrice);
            } else if (choice == 3) {
                order = new DeliveryOrder(orderId, customerName, basePrice);
            }

            if (order != null) {
                order.displayOrderDetails();  
            }

        } catch (Exception e) {
        }
    }
}