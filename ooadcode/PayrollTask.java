public class PayrollTask implements Runnable 
{
    private String employeeName;
    private double baseSalary;

    PayrollTask(String employeeName, double baseSalary) 
    {
        this.employeeName = employeeName;
        this.baseSalary = baseSalary;
    }

    @Override
    public void run() 
    {
        double hra = baseSalary * 0.20;
        double da = baseSalary * 0.10;
        double gross = baseSalary + hra + da;
        System.out.println("Processed salary for " + employeeName + ": " + gross);
    }

    public static void main(String[] args) 
    {
        Thread t1 = new Thread(new PayrollTask("Alice", 50000));
        Thread t2 = new Thread(new PayrollTask("Bob", 60000));
        Thread t3 = new Thread(new PayrollTask("Charlie", 55000));

        t1.start();
        t2.start();
        t3.start();
    }
}