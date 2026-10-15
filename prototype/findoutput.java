public class findoutput 
{     
public static void main(String argvs[])   
{  
String obj1 = new String("Good morning.");  
String obj2 = obj1;  
obj2 = "Very Good Morning.";
  
System.out.println("The hash code is: " + obj1.hashCode());  
System.out.println("The string is: " + obj1 + "\n");  
 
System.out.println("The hash code is: " + obj2.hashCode());  
System.out.println("The string is: " + obj2);  
}  
}  

	