/*
The Prototype Design Pattern is a creational design pattern used to create new objects by copying (cloning) an existing object, rather than creating them from scratch.
When to Use Prototype:
Object creation is costly or complex
You want to avoid repetitive initialization
Objects have many similar configurations
You need copies at runtime
*/
class demo
{
int x;
demo()
{
}
demo(int x)
{
this.x=x;
}
demo(demo d)
{
this.x=d.x;
}
public String toString()
{
return "x="+x;
}
}
class copydemo
{
public static void main(String args[])
{
demo d1=new demo(10);
System.out.println(d1.hashCode());
demo d2=d1;//shallow copy
//demo d2=new demo(d1);//deepcopy
System.out.println(d2.hashCode());
System.out.println(d1.x);
System.out.println(d2.x);
d2.x++;
System.out.println(d1.x);
System.out.println(d2.x);

}
}
/*
//code illustrating shallow copy 
public class Ex { 

	private int[] data; 

	// makes a shallow copy of values 
	public Ex(int[] values) { 
		data = values; 
	} 

	public void showData() { 
		System.out.println( Arrays.toString(data) ); 
	} 
} 

public class UsesEx{ 

	public static void main(String[] args) { 
		int[] vals = {3, 7, 9}; 
		Ex e = new Ex(vals); 
		e.showData(); // prints out [3, 7, 9] 
		vals[0] = 13; //third party
		e.showData(); // prints out [13, 7,9] 

		// Very confusing, because we didn't 
		// intentionally change anything about 
		// the object e refers to. 
	} 
} 
/*
*************
// Code for deep copy 

public class Ex { 
	
	private int[] data; 

	// altered to make a deep copy of values 
	public Ex(int[] values) { 
		data = new int[values.length]; 
		for (int i = 0; i < data.length; i++) { 
			data[i] = values[i]; 
		} 
	} 
	public void showData() { 
		System.out.println(Arrays.toString(data)); 
	} 
} 

public class UsesEx{ 

	public static void main(String[] args) { 
		int[] vals = {3, 7, 9}; 
		Ex e = new Ex(vals); 
		e.showData(); // prints out [3, 7, 9] 
		vals[0] = 13; 
		e.showData(); // prints out [3, 7, 9] 

	// changes in array values will not be 
	// shown in data values. 
	} 
} 

*/