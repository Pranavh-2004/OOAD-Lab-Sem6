// Bad design:
// The SalaryCalculator does not follow open close principle,
// If a new employeeType is added in the future, the calcualteSalary function must be updated, hence
// it is not closed for modification
class SalaryCalculator {
    double calcualteSalary(String employeeType) {
        if (employeeType.equals("FullTime")) {
            return 2000;
        }
        else if (employeeType.equals("PartTime")) {
            return 1000;
        }

        return 0;
    }
}

class BadOpenClose {
    public static void main(String args[]) {
        SalaryCalculator calc = new SalaryCalculator();
        System.out.println("FullTime: " + calc.calcualteSalary("FullTime"));
        System.out.println("PartTime: " + calc.calcualteSalary("PartTime"));
    }
}
