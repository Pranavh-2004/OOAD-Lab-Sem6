// Using the Scanner class to get user input:

import java.util.Scanner;

class UseScanner 
{
  public static void main(String[] args) 
  {
    Scanner myObj = new Scanner(System.in);  // Creating an object out of a class
    System.out.print("Enter username:");

    String userName = myObj.nextLine();
    System.out.println("Username is: " + userName);
  }
}

