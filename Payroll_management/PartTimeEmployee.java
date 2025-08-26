package Payroll_management;

public class PartTimeEmployee extends Employee implements Payable {
    private int hours;
    private double hr_wages; 
    public PartTimeEmployee(String name, int age, String designation, int hours, double hr_wages) {
        super(name, age, designation);
        this.hours = hours;
        this.hr_wages = hr_wages;
    }

    public void calculate() {
        salary = hours * hr_wages;
        System.out.println("Part Time Employee Salary(" + name + "): " + salary);
    }
}
