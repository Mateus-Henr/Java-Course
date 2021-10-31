package tutorial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Lambdas are used to facilitate the usage of interfaces.
public class Main
{
    public static void main(String[] args)
    {
//        new Thread(new CodeToRun()).start();

//        new Thread(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                System.out.println("Printing from the Runnable.");
//            }
//        }).start();

        // Lambda (with empty argument list)
        // We pass what we want to the thread constructor.
        // Matches the expression with the run method in the Runnable interface, because there's no parameters.
        // The compiler always needs to match the lambda expression to a method, so lambda expressions can only
        // be used with interfaces that contain only one method.
        // The interfaces mentioned above are also known as functional interfaces.
//        new Thread(() ->
//        {
//            System.out.println("Printing from the Runnable.");
//            System.out.println("Line 2");
//            System.out.format("This is line %d\n", 3);
//        }).start();


        Employee john = new Employee("John Does", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

//        Collections.sort(employees, new Comparator<Employee>()
//        {
//            @Override
//            public int compare(Employee employee1, Employee employee2)
//            {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));

        for (Employee employee : employees)
        {
            System.out.println(employee.getName());
        }
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

class CodeToRun implements Runnable
{

    @Override
    public void run()
    {
        System.out.println("Printing from the Runnable.");
    }

}

// Every Lambda expression have three parts, which are:
// 1 - The arguments list
// 2 - The arrow token
// 3 - The body