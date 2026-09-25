public class Employee {
    private String empId;
    private double salary;

    // Resolving parameter and field naming clash using 'this'
    public Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    // Resolving parameter and field naming clash using 'this'
    public void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public void printSalary() {
        System.out.println(this.empId + " - Final Salary: Rs " + this.salary);
    }

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("E101", 40000),
            new Employee("E-102", 55000),
            new Employee("E-103", 62000),
            new Employee("E104", 48000)
        };

        double bonus = 5000;

        // Batch processing in a single pass
        for (Employee emp : employees) {
            emp.raiseSalary(bonus);
            emp.printSalary();
        }
    }
}