import java.util.Scanner;

// Step 1 - create an interface InternetAccess to provide internet access to the employees
interface InternetAccess {
    public void grantInternetAccessToEmployees();
}

// Step 2 - To grant the authorization to the particular employee, create an
// EmployeeInternetAccess class that implements the InternetAccess interface.

class EmployeeInternetAccess implements InternetAccess {
    private String employeeName;

    @Override
    public void grantInternetAccessToEmployees() {
        System.out.println("Internet Access granted for employee: " + employeeName);
    }

    public EmployeeInternetAccess(String empName) {
        this.employeeName = empName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}

// Step 3 - To provide the object of the EmployeeInternetAccess class,
// create a ProxyInternetAccess class that implements the InternetAccess
// interface.
class ProxyEmployeeInternetAccess implements InternetAccess {
    private String employeeName;
    private EmployeeInternetAccess employeeInternetAccess;

    public ProxyEmployeeInternetAccess(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public void grantInternetAccessToEmployees() {
        if (getRole(employeeName) > 4) {
            employeeInternetAccess = new EmployeeInternetAccess(employeeName);
            employeeInternetAccess.grantInternetAccessToEmployees();
        } else {
            System.out.println("No Internet access granted. Your job level is below 5");
        }
    }

    public int getRole(String empName) {
        int roleNum;
        // The following lines help you simulate different levels
        Scanner scan = new Scanner(System.in);
        System.out.print("Key in a level number:");
        roleNum = scan.nextInt();
        scan.close();
        // make a DB call to get the employee role and return it.
        return roleNum;
    }
}

// Step 4 - Create a class called ProxyPatternClient that can provide
// employees the access to the internet.
public class ProxyPatternClient {

    public static final String EMPLOYEE_NAME = "Anand Subbarao";

    public static void main(String[] args) {
        InternetAccess internetAccess = new ProxyEmployeeInternetAccess(EMPLOYEE_NAME);
        internetAccess.grantInternetAccessToEmployees();
    }
}