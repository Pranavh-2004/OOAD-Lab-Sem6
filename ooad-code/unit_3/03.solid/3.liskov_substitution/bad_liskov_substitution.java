abstract class Employee {
    double salary;

    double getSalary() { return salary; }
    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee() {
        this.salary = 2000;
    }

    @Override
    double calculateBonus() { return salary + salary * 0.02; }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee() {
        this.salary = 1000;
    }

    @Override
    double calculateBonus() { return salary + salary * 0.01; }
}

// Bad design:
// The child class Intern modifies the behaviour of the function calculateBonus in the parent class
// This violates the Liskov Substitution principle as all variables makred with PartTimeEmployee type
// can not be changed to Employee type without breaking the program
class Intern extends Employee {
    Intern() {
        this.salary = 500;
    }

    @Override
    double calculateBonus() {
        throw new UnsupportedOperationException("Inters do not get bonus");
    }
}

class BadLiskovSubstitution {
    public static void main(String args[]) {
        Employee e = new FullTimeEmployee();
        System.out.println("FullTime: " + e.calculateBonus());

        e =  new PartTimeEmployee();
        System.out.println("PartTime: " + e.calculateBonus());

        e = new Intern();
        System.out.println("Intern: " + e.calculateBonus());
    }
}
