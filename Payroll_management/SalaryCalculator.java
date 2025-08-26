package Payroll_management;
public class SalaryCalculator {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new FullTimeEmployee("Alice", 30, "Software Engineer", 50000, 0.2,0.1);
        employees[1] = new PartTimeEmployee("Kapil", 30, "Tester", 3, 4000);
        employees[2] = new Intern("Kishore", 19, "Web Intern", 40000);
        for (Employee e : employees) {
            e.calculate();
        }
    }
}

