package Payroll_management;

public abstract class Employee{
    public String name, designation;
    public int age;
    public double salary;

    public Employee(String name, int age, String designation) {
        this.name = name;
        this.age = age;
        this.designation = designation;
    }

    public abstract void calculate();
}