package tutorial.fourth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
    // Bear in mind that we never have to use lambda expressions, in the place of them we can always use anonymous
    // class.
    public static void main(String[] args)
    {
        Employee john = new Employee("John Does", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));

        // Enhanced "for" loop
        // With each iteration of the loop the variable is final.
//        for (Employee employee : employees)
//        {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
////            new Thread(() -> System.out.println(employee.getAge())).start();
//        }

        // Using a lambda as a "for" loop
        // The method "forEach" receives a lambda as parameter that executes for every single element in the list;.
        employees.forEach(employee ->
        {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        System.out.println("*****************************************************************************");
        // Usual "for" loop to show the "effectively final" variable.
        // If you move it out the for loop it can't be changed.
//        for (int i = 0; i < employees.size(); i++)
//        {
//            // A new object is defined with each iteration, meaning that it's effectively final.
//            Employee employee = employees.get(i);
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2)
    {
        return uc.upperAndConcat(s1, s2);
    }

}

class Employee
{
    private String name;
    private int age;

    public Employee(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

}

interface UpperConcat
{
    String upperAndConcat(String s1, String s2);

}
// Function Programming is a programming paradigm that focuses on computing and returning results.