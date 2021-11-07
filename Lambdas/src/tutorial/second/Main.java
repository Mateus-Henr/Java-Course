package tutorial.second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
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

        for (Employee employee : employees)
        {
            System.out.println(employee.getName());
        }

        // Code using anonymous class
//        String sillyString = doStringStuff(new UpperConcat() // First parameter
//                                           {
//                                               @Override
//                                               public String upperAndConcat(String s1, String s2)
//                                               {
//                                                   return s1.toUpperCase() + s2.toUpperCase();
//                                               }
//                                           },
//                employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        // Code using lambda (with types)
        // If we try to add a "return" key word here we get a compiler error. Since the "body" of the lambda evaluates
        // to a value (that's the type of the evaluated value), the "return" keyword is sort of "built-in".
//        UpperConcat uc = (String s1, String s2) -> s1.toUpperCase() + s2.toUpperCase();

        // Code using lambda (without types)
        // We can assign lambdas to variables to use them later (example below).
        // If the lambda contains more than one statement we need to use the "return" keyword.
//        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);


        // Example using the "return" keyword.
        UpperConcat uc = (s1, s2) ->
        {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);
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