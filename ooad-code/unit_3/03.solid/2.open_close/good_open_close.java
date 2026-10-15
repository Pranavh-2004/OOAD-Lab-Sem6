// Good design:
// The SalaryCalculator class follows open close principle
// The program is open to extension by adding a new employee type in the future that implements the
// Employee interface
// This automatically works with the SalaryCalculator which expects a generic Employee type as arguemnt
// Hence the SalaryCalculator class is closed to modification
interface Employee {
    double getSalary();
}

class FullTimeEmployee implements Employee {
    final double salary = 2000;
    public double getSalary() { return salary; }
}

class PartTimeEmployee implements Employee {
    final double salary = 1000;
    public double getSalary() { return salary; }
}

class SalaryCalculator {
    double calcualteSalary(Employee employee) {
        return employee.getSalary();
    }
}

class GoodOpenClose {
    public static void main(String args[]) {
        SalaryCalculator calc = new SalaryCalculator();

        Employee e = new FullTimeEmployee();
        System.out.println("FullTime: " + calc.calcualteSalary(e));

        e = new PartTimeEmployee();
        System.out.println("PartTime: " + calc.calcualteSalary(e));

    }
}
