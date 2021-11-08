package tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

// Java.util.function package
// This package contains functional interfaces that are meant to be used with lambda expressions.
public class Main
{
    public static void main(String[] args)
    {
        Employee john = new Employee("John Does", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        // Using forEach
//        // When using forEach we pass a lambda expression that meets the requirements of the Consumer interface.
//        // It's called a consumer because it doesn't return anything, so for printing stuff can be handy.
//        // Here after printing the employee, it's consumed, and it goes to the next employee.
//        employees.forEach(employee ->
//        {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        });

        System.out.println("Employees over 30.");
        System.out.println("==================");

        // Enhanced for loop
        for (Employee employee : employees)
        {
            if (employee.getAge() > 30)
            {
                System.out.println(employee.getName());
            }
        }

        // Lambda version
        employees.forEach(employee ->
        {
            if (employee.getAge() > 30)
            {
                System.out.println(employee.getName());
            }
        });

        System.out.println("\nEmployees 30 and younger");
        System.out.println("==========================");
        employees.forEach(employee ->
        {
            if (employee.getAge() <= 30)
            {
                System.out.println(employee.getName());
            }
        });

        // Avoiding duplicated code by using the "Predicate" interface for filtering things.
        // The argument is just a lambda expression that matches the predicate interface, they accept one parameter
        // and return a boolean value.
        printEmployeesByAge(employees, "\nEmployees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "\nEmployees 30 and under", employee -> employee.getAge() <= 30);

        // Using an anonymous class as the Predicate argument.
        printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>()
        {
            @Override
            public boolean test(Employee employee)
            {
                return employee.getAge() < 25;
            }
        });

        // The "Predicate" and "Consumer" are more general interfaces, there are the most specific ones such as
        // "IntPredicate" and "LongConsumer", for example. By using these "specific" ones it helps readability.
        System.out.println("\nTesting type predicates");
        IntPredicate greaterThan15 = i -> i > 15;
        System.out.println(greaterThan15.test(10));
        int a = 20;
        System.out.println(greaterThan15.test(a + 5));

        // Chaining Predicates together (we use ".and" or ".or" to do this).
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(15));

        // Example of the "greaterThan15" lambda
//        {
//            int i;
//
//            return i < 15;
//        }
        // The Predicate interface also contains ".negate" and ".equals" methods, but for more specific Predicates,
        // they don't contain ".equals" method.


        // Supplier interface
        // This interface doesn't accept any parameters, it just supplies something with something else.
        // We could use it for testing, for example the supplier could instantiate objects and populate them
        // with random values.
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++)
        {
            System.out.println(randomSupplier);
        }

    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition)
    {
        System.out.println(ageText);
        System.out.println("==========================");
        for (Employee employee : employees)
        {
            // Passing every employee to the Predicate.test method.
            if (ageCondition.test(employee))
            {
                System.out.println(employee.getName());
            }
        }
    }

}
