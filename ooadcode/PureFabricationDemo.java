// Domain class representing a Customer
class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { 
        return id; 
    }

    public String getName() { 
        return name; 
    }

    @Override
    public String toString() {
        return "Customer[ID=" + id + ", Name=" + name + "]";
    }
}

// Pure Fabrication class for persistence
class DataPersistence {
    // This class is fabricated to handle persistence responsibilities.
    // It is not part of the domain model.
    
    public void saveCustomer(Customer customer) {
        // In a real system, this might involve database operations.
        System.out.println("Saving customer: " + customer);
    }

    public void deleteCustomer(Customer customer) {
        System.out.println("Deleting customer: " + customer.getId());
    }

    public void updateCustomer(Customer customer) {
        System.out.println("Updating customer: " + customer);
    }
}

// Client code demonstrating Pure Fabrication
public class PureFabricationDemo {
    public static void main(String[] args) {
        // Create a domain object
        Customer customer = new Customer("C101", "Anand");

        // Use fabricated persistence class
        DataPersistence persistence = new DataPersistence();
        
        persistence.saveCustomer(customer);
        persistence.updateCustomer(customer);
        persistence.deleteCustomer(customer);
    }
}