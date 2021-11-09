package tutorial.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
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
        System.out.println("\nTesting Type Predicates");
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
        System.out.println("\nDemonstrating Supplier Interface");
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++)
        {
            System.out.println(randomSupplier.get());
        }


        System.out.println("\nGetting the Last Name of the Employees");
        employees.forEach(employee ->
        {
            // Getting the first space in the name and assigning to the variable everything that comes after it.
            String lastname = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println("Last Name is:" + lastname);
        });

        // An interface represents a function when it takes parameter(s) and returns a value.
        // When using the Function class we use Generics as well, the first type is the argument type and the second
        // type is the return type.
        // If the lambda has more than one line you're obliged to use curly braces and the "return" statement.
        Function<Employee, String> getLastName = (Employee employee) ->
        {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        // To get the last name of an employee we have to call the apply method and pass it to the employee object.
        System.out.println("\nGetting the last name of an employee");
        String lastName = getLastName.apply(employees.get(2));
        System.out.println(lastName);

        // Using functions we can pass code that accepts and return a value in the form of a lambda expression
        // without having to create an interface and a class that implements the interface.
        // As seen previously we can change what a method does based on the function that we pass in.
        Function<Employee, String> getFirstName = (Employee employee) ->
        {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        System.out.println("\nPrinting first name or last name randomly using function as parameter.");
        Random random1 = new Random();
        for (Employee employee : employees)
        {
            if (random1.nextBoolean())
            {
                System.out.println(getAName(getFirstName, employee));
            }
            else
            {
                System.out.println(getAName(getLastName, employee));
            }
        }

        // Functions are used when we want to run similar code in different ways. Making the code more concise.
    }

    // Passing in a function as an argument.
    private static String getAName(Function<Employee, String> getName, Employee employee)
    {
        // When using "Function" if you want to pass in arguments to the function you have to use the "apply" method.
        return getName.apply(employee);
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

// Code example
// Another situation that functions are used is when we want to use callbacks (when a non-UI event occurs, threading is
// an example).
// In the code example below we are fetching data from a background thread and then resizing the received image.
// Therefore, one thread receives the image from the other.
//public interface ResizeImage
//{
//    public Image resizeImage(Image image);
//
//}
//
//public List<Image> runWhenDone() // Method that's executed when the background thread has images.
//{
//    // Pretend that we have access to an ImageResizer instance (probably provided when a Runnable object was
//    // constructed), and to a list called images that has all the images fetched from the Internet.
//
//    for (Image image : images)
//    {
//        resizedImages.add(resizer.resizeImage(image));
//    }
//}

// Code using functions (avoiding the usage of interface)
// As said before, when using functions + lambda we can avoid the usage of interfaces and classes than implement that.
// Function<Image, Image> resizer1 = (Image image) -> { resize using algorithm 1}
// Function<Image, Image> resizer2 = (Image image) -> { resize using algorithm 2}
//
//public List<Image> runWhenDone()
//{
//    for (Image image : images)
//    {
//        resizedImages.add(resizer.apply(image));
//    }
//}
// SUMMING UP: When you want to modify an object in some way and there are several different ways for modifying that
// object (depending on as specific thing of the object), so functions can be used to keep the code neater.
// All we would need to do is to write a method that can manipulate the object based on the function that it has
// received as parameter.