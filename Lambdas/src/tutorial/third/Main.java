package tutorial.third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.graalvm.compiler.loop.InductionVariable.Direction.Up;

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

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
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

class AnotherClass
{
    public String doSomething()
    {
        // Version without using lambda
//        System.out.println("The Another class's name is: " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat()
//        {
//            @Override
//            public String upperAndConcat(String s1, String s2)
//            {
//                // Anonymous class doesn't have a name.
//                System.out.println("The anonymous class's is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");

        // Version using lambda
//        UpperConcat uc = (s1, s2) ->
//        {
//            // A lambda is not treated as an anonymous class, it's treated as a nested block of code and the cope
//            // is a nested block.
//            System.out.println("The lambda expression's class is: " + getClass().getSimpleName());
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            // As we have more than one statement we need the "return" keyword.
//            return result;
//        };

        // NESTED BLOCK
        // By putting the code inside a nested block all me mean is that we've enclosed it with another set of curly
        // braces. Code within a nested block can reference variables defined within the enclosing block.
        {
            UpperConcat uc = new UpperConcat()
            {
                @Override
                public String upperAndConcat(String s1, String s2)
                {
                    return s1.toUpperCase() + s2.toUpperCase();
                }
            };
            System.out.println("The Another class's name is: " + getClass().getSimpleName());
            return Main.doStringStuff(uc, "String1", "String2");
        }
    }

}