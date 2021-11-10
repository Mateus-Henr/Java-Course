package tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Streams
// They here will be referred as a sequence of computations (a set of computation steps that chain together)
public class Main
{
    public static void main(String[] args)
    {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "071");

        List<String> gNumbers = new ArrayList<>();

        // Code without the usage of Streams
//        // Separating numbers that start with "G", using forEach (and Consumer).
//        someBingoNumbers.forEach(n ->
//        {
//            if (n.toUpperCase().startsWith("G"))
//            {
//                // Because of scope, normally inside a lambda expression we would have to declare variable as final or
//                // effectively final. When dealing with objects, their references are effectively final, therefore we
//                // can alter them inside the lambda.
//                gNumbers.add(n);
//            }
//        });
//
//        // Sorting the Strings
//        gNumbers.sort((s1, s2) -> s1.compareTo(s2));
//
//        gNumbers.forEach(s -> System.out.println(s));

        // Code with the usage of Streams
        someBingoNumbers
                .stream() // Always the first choice
                // The "::" notation is called a method reference and all the lambda does is to call an existing method.
                // The "map" method expects a function (expects an argument and returns a value), in this case we are
                // mapping the "String.toUpperCase()" method to Function, so the method itself doesn't accept a
                // parameter, but there's a source String (and it's the String object that we use to invoke the method).
                // So the return from the Function will be a String in uppercase.
                .map(String::toUpperCase) // .map(s-> s.toUpperCase)
                // So to use a method reference for a method that takes parameters the compiler has to be able to infer
                // what the arguments are, such when using ".map". However, using below we couldn't do it, since the
                // compiler cannot infer that the argument should be "G".
                // More about it at https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);
        // A Stream is a sequence of elements supporting sequential and parallel aggregate operations, in other words,
        // it executes each command on each object of the Collection, however the source Collection does not change.
        // For them to work they need to be non-interfering (they don't change the stream source) and the must be
        // stateless, so the result of an operation can't depend on any state outside the operation (it can't depend
        // on variable values in a previous step).
    }

}
