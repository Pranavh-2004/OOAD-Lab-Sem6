import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Employee {
    double calculateBonus(double salary) { // with only salary as parameter
        return salary * 0.10; // 10% bonus
    }

    double calculateBonus(double salary, double performanceRating) { // with salary and performance rating as parameters
            return salary * (0.05 + performanceRating * 0.02); // base 5% bonus + additional based on performance rating
    }

    double calculateBonus(double salary, int yearsOfService) { // with salary, performance rating, and years of service as parameters
        return salary * (0.08 + yearsOfService * 0.01); // base 8% bonus + additional based on years of service
    }
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Employee emp = new Employee();

        double salary = sc.nextDouble();
        int choice = sc.nextInt();
        double bonus = 0;
        
        if (choice == 1) {
            bonus = emp.calculateBonus(salary);
        } else if (choice == 2) {
            double performanceRating = sc.nextDouble();
            bonus = emp.calculateBonus(salary, performanceRating);
        } else if (choice == 3) {
            int yearsOfService = sc.nextInt();
            bonus = emp.calculateBonus(salary, yearsOfService);
        } else {
            System.out.println("Invalid choice");
        }


        System.out.printf("%.2f%n", bonus);
        sc.close();
    }
}