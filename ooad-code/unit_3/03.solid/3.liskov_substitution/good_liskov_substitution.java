// Good design:
// The Employee types that have bonus extends the EmployeeWithBonus class while the Employee types
// that do not have bonus extends the base class Employee
// This way all classes follow the Liskov Substitution principle
abstract class Employee {
    int salary;

    double getSalary() { return salary; }
}

abstract class EmployeeWithBonus extends Employee {
    abstract double calculateBonus();
}

class FullTimeEmployee extends EmployeeWithBonus {
    FullTimeEmployee() {
        this.salary = 2000;
    }

    double calculateBonus() {
        return salary + salary * 0.02;
    }
}

class PartTimeEmployee extends EmployeeWithBonus {
    PartTimeEmployee() {
        this.salary = 1000;
    }

    double calculateBonus() {
        return salary + salary * 0.01;
    }
}

class Intern extends Employee {
    Intern() {
        this.salary = 500;
    }
}

class GoodLiskovSubstitution {
    public static void main(String args[]) {
        EmployeeWithBonus eb = new FullTimeEmployee();
        System.out.println("FullTime: " + eb.calculateBonus());

        eb = new PartTimeEmployee();
        System.out.println("PartTime: " + eb.calculateBonus());

        Employee e = new Intern();
        System.out.println("Intern: " + e.getSalary());
    }
}
