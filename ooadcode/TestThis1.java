// Without using "this" keyword
// Observe parameters (formal arguments) and instance variables are same
// The output would be:
// 0 null 0.0
// 0 null 0.0

class Student
{  
	int rollno;  
	String name;  
	float fee;  
	Student(int rollno,String name,float fee)
	{  
		rollno=rollno;  
		name=name;  
		fee=fee;  
	}  

	void display()
	{
    		System.out.println(rollno+" "+name+" "+fee);
	}  
}  

public class TestThis1
{  
	public static void main(String args[])
	{  
		Student s1=new Student(111,"bharat",5000f);  
		Student s2=new Student(112,"Sharath",6000f);  
		s1.display();  
		s2.display();  
	}
}  