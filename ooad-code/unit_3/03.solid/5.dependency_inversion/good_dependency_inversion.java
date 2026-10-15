// Good design:
// Both high level classes and low level classes depend on the EmployeeRepository abstraction
// Changes made in the high level class or low level class do not propagate to the other class
interface EmployeeRepository {
    void saveEmployee(String name);
}

// Low level class
class MySQLDatabase implements EmployeeRepository {
    public void saveEmployee(String name) {
        System.out.println("Saving employee to MySQL: " + name);
    }
}

class MongodbDatabase implements EmployeeRepository {
    public void saveEmployee(String name) {
        System.out.println("Saving employee to Mongodb: " + name);
    }
}

// High level class
class EmployeeService {
    EmployeeRepository repo;

    EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    void registerEmployee(String name) {
        repo.saveEmployee(name);
    }
}

class GoodDependencyInversion {
    public static void main(String args[]) {
        EmployeeService service = new EmployeeService(new MySQLDatabase());
        service.registerEmployee("E1");

        service = new EmployeeService(new MongodbDatabase());
        service.registerEmployee("E2");
    }
}
