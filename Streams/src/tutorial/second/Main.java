package tutorial.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        Employee john = new Employee("John Doe ", 30);
        Employee jane = new Employee("Jane Deer ", 25);
        Employee jack = new Employee("Jack Hill ", 40);
        Employee snow = new Employee("Snow White ", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        // The flatMap method
        // It's used to map a single object to many (flattens nested lists). In other words, it's used
        // It requires a function that returns a stream.
        // Here, each department becomes the argument to the function, then we are getting a stream
        // of employees from each department, and they are added to the stream that is going to return from the flapMap.

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        // The collect method (terminal operation)
        // It collects the elements of a stream into a different type of result (transforming from a stream to a Set
        // for example).
        System.out.println("\nShowing the collect operation");
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "071");

//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        // More specific collect
        // Parameters
        // 1° - Supplier that creates objects, in the example below it's creating an ArrayList.
        // 2° - Accumulator that adds items. Used when the runtime needs to add a single item into the list.
        // 3° - Combiner is up to the Java Runtime, since it's used for improvement.
        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for (String s : sortedGNumbers)
        {
            System.out.println(s);
        }

        // Example of creating a Map of Lists based on age
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        // The reduce method
        // In the example below we are using the version of "reduce" that accepts a BiFunction.
        // It's a terminal operation.
        System.out.println("\nYoungest employee (using reduce method)");
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                // "ifPresent" is not a part of the stream operation chain, since reduce is an optional operation,
                .ifPresent(System.out::println);

        // Notes
        // We can't reuse a stream, once we call a terminal operation on a stream, it will receive an
        // "IllegalStateException" if we try to operate on that again.
        // Operations in streams are lazily evaluated, so intermediate operations are not performed until there's a
        // terminal operation.
        // It also has the more specific versions (Int, etc.)
        // There are also parallel streams that are used for increasing performance by executing streams in parallel.

        System.out.println("\nLaziness example");
        // Just by executing the code below nothing will happen since there must have a terminal operation to be run.
        // By the logic, if we don't have a terminal operation, there's nothing coming at the bottom of the pipe, it's
        // as if it gets stuck in the middle of the pipe until there's a terminal operation that grabs the result. And
        // would be a waste of time to execute intermediate operation.
        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s ->
                {
                    System.out.println(s);
                    return s.length() == 3;
                });
//                .count() // By putting it here it would work.
    }

    // Best practises on lambda expressions
    // Short expressions (no parenthesis, no return, no type) are usually readable, but sometimes when striving for
    // conciseness, we would lose a lot of information making it hard to decipher.
    // A lot of tutorials on the internet fall on the side of conciseness.
    // According to Tim, when it comes to practise that are syntactic and don't make a difference to the code that's
    // generated, the key thing is to be consistent, avoiding different styles in the same file (even more when working
    // in an existing file). If you're writing code from scratch you can choose what's clearer and easiest for you.
    // And always thing that someone is going to read your code in the future.
    // Also, it's preferred to have a verbose lambda than a concise with a comment, since comments aren't really
    // updated.
}
