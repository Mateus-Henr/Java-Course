package tutorial.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

// Just as we could with Predicates we can also chain Functions together, to do that we use ".andThen" method.
// Just as Consumer and Predicate, Function also has type functions.
// The Function interface basically represents structures for lambda expressions.
// When we want a lambda to test something we use Predicate, since it returns true or false.
// When we want a lambda that accepts an argument or returns a value we use Function (up to two arguments).
public class Main
{
    public static void main(String[] args)
    {
        Employee john = new Employee("John Doe", 30);
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

        // Gets the entire employee name and converts it to uppercase.
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        // Gets the first name of the employee.
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        // Chaining both of them.
        // To join functions together you have to create a composed function, as below. The function that calls the
        // ".andThen()" method will run first, then the function passed in will be called, operating on the result of
        // the first function. It also has the ".compose()" method that runs in the opposite order of the ".andThen()"
        // method.
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(0)));


        // As the BiFunction needs two arguments it can't be the second function in a chain, but if it was the first
        // we could use the BiFunction and the "andThen" method (the BiFunction interface doesn't have a "compose"
        // method).
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) ->
        {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        // This is a more specific type of function that accepts an argument and returns a value of the same type as
        // the argument. "UnaryOperator" extends the Function interface, therefore they can be chained together.
        System.out.println("\nUsing IntUnaryOperator");
        IntUnaryOperator incBy4 =i -> i + 5;
        System.out.println(incBy4.applyAsInt(10));


        System.out.println("\nChaining Consumers");
        // Consumers can also be chained, but for that to work we need to use the "accept()" method instead of working
        // on the result from the previous consumer, so each Consumer in the chain runs using the argument passed in
        // this method.
        // In the case below, there's no advantage since Consumers don't return anything.
        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello, World");
    }

}

// Interface       |      Functional Method     |       Num of Args     |      Returns a value       |    Can be Chained
// Consumer                   accept()                   1 or 2 (Bi)                 No                       Yes
// Supplier                    get()                         0                      Yes                        No
// Predicate                  test()                     1 or 2 (Bi)           Yes - boolean                  Yes
// Function                   apply()                    1 or 2 (Bi)                Yes                       Yes
// UnaryOperator          depends on type                    1             Yes - same type as arg             Yes