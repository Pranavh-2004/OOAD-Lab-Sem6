// Program to show the use of ArrayList

import java.util.ArrayList;

class MArrayList 
{
  public static void main(String[] args) 
  {
    ArrayList<String> languages = new ArrayList<>();

    // add elements in the array list
    languages.add("Java");
    languages.add("Pascal");
    languages.add("C++");
    System.out.println("ArrayList: " + languages);

    // get the element from the arraylist
    String str = languages.get(1);

    System.out.println("Element at index 1: " + str);

    // change the element of the array list
    languages.set(2, "JavaScript");
    System.out.println("Modified ArrayList: " + languages);

    // remove element from index 2
    str = languages.remove(2);

    System.out.println("Updated ArrayList: " + languages);
    System.out.println("Removed Element: " + str);
  }
}