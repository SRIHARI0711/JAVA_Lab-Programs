package Payroll_management;

public class Intern extends Employee implements Payable {
    private double stipend;
    public Intern(String name, int age, String designation, double stipend) {
        super(name, age, designation);
        this.stipend = stipend;
    }
    public void calculate() {
        salary = stipend;
        System.out.println("Intern Salary(" + name + "): " + salary);
    }
}
