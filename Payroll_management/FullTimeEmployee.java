package Payroll_management;

public class FullTimeEmployee extends Employee implements Payable {
    private double hra,da,basic;

    public FullTimeEmployee(String name, int age, String designation, double basic,double hra, double da) {
        super(name, age, designation);
        this.basic = basic;
        this.hra = hra;
        this.da = da;
    }
    public void calculate() {
        salary = basic + (hra * basic) + (da * basic);
        System.out.println("Full Time Employee Salary(" + name + "): " + salary);
    }
}
