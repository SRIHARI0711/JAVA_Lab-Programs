package MissedCallLog;

public class Contact 
{
    String name;
    long number;

    public Contact(String name, long number) 
    {
        this.name = name;
        this.number = number;
    }

    public String toString() 
    {
        return "Name: " + name + ", Number: " + number;
    }
}
