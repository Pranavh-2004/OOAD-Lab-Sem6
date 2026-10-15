// Program to show the use of ArrayList

import java.util.ArrayList;

class MIntList 
{
  public static void main(String[] args) 
  {
    ArrayList<Integer> languages = new ArrayList<>();

    // add elements in the array list
    languages.add(1);
    languages.add(2);
    languages.add(3);
    System.out.println("ArrayList: " + languages);

    // get the element from the arraylist
    int str = languages.get(1);

    System.out.println("Element at index 1: " + str);

    // change the element of the array list
    languages.set(2, 5);
    System.out.println("Modified ArrayList: " + languages);

    // remove element from index 2
    str = languages.remove(2);

    System.out.println("Updated ArrayList: " + languages);
    System.out.println("Removed Element: " + str);
  }
}