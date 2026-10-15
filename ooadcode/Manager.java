// Superclass
class Employee 
{
    protected String name;
    protected double baseSalary;

    // Parent Constructor
    public Employee(String name, double baseSalary) 
    {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public void displayInfo() 
    {
        System.out.println("Employee: " + name + " | Base Salary: $" + baseSalary);
    }

    public final void Cannot_override ()
    {
    }

}

// Subclass inheriting from Employee
public class Manager extends Employee 
{
    private double bonus;

    // Constructor chaining using 'super'
    public Manager(String name, double baseSalary, double bonus) 
    {
        super(name, baseSalary); // Calls Employee constructor
        this.bonus = bonus;
    }

    // Method Overriding
    @Override
    public void displayInfo() 
    {
        // Calls the original method from Employee and adds specific data
        super.displayInfo();
        System.out.println("Role: Manager | Bonus: $" + bonus);
        System.out.println("Total Compensation: $" + (baseSalary + bonus));
    }

    // Trying to override a method declared as final
    @Override
    public void Cannot_override() 
    {
    }


    public static void main(String[] args) 
    {
	// Check for the right number of arguments
	if (args.length == 3)
	{
		String mangr = args[0];
		double baseS = Double.parseDouble (args[1]);
		double bonus = Double.parseDouble (args[2]);
        	Manager mgr = new Manager(mangr, baseS, bonus);
		// Demonstrates runtime polymorphism
        	mgr.displayInfo();
        }
	else
		System.out.println ("Please pass 3 arguments");
    }
}

