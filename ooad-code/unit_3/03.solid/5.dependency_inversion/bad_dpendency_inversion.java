// Bad desing:
// The low level class and high level class directly interact with each other
// If we make changes to the low level class or the high level class, the other class must also be
// modified

// Low level class
class MySQLDatabase {
    void saveEmployee(String name) {
        System.out.println("Saving employee to MySQL: " + name);
    }
}

// High level class
class EmployeeService {
    MySQLDatabase db = new MySQLDatabase();

    void registerEmployee(String name) {
        db.saveEmployee(name);
    }
}

class BadDependencyInversion {
    public static void main(String args[]) {
        EmployeeService service = new EmployeeService();
        service.registerEmployee("E1");
    }
}
