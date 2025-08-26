package Student_info_app;

public class Student {
    public String name,usn;
    public int age;
    public String address;
    public float sgpa1,sgpa2,sgpa3,sgpa4;
    public float cgpa;
    public String category;
    
    public Student(String name, String usn, int age, String address, float sgpa1, float sgpa2, float sgpa3, float sgpa4, String category) {
        this.name = name;
        this.usn = usn;
        this.age = age;
        this.address = address;
        this.sgpa1 = sgpa1;
        this.sgpa2 = sgpa2;
        this.sgpa3 = sgpa3;
        this.sgpa4 = sgpa4;
        this.cgpa = (sgpa1 + sgpa2 + sgpa3 + sgpa4) / 4;
        this.category = category;
    }
    public String toString() {
        return "Name: " + name + "\nUSN: " + usn + "\nAge: " + age + "\nAddress: " + address + 
               "\nSGPA1: " + sgpa1 + "\nSGPA2: " + sgpa2 + "\nSGPA3: " + sgpa3 + "\nSGPA4: " + sgpa4 + 
               "\nCGPA: " + String.format("%.2f", cgpa) + "\nCategory: " + category;
    }
}
