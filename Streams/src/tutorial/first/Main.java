package tutorial.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
                .stream() // Must be the first
                // The "::" notation is called a method reference and all the lambda does is to call an existing method.
                // The "map" method expects a function (expects an argument and returns a value), in this case we are
                // mapping the "String.toUpperCase()" method to Function, so the method itself doesn't accept a
                // parameter, but there's a source String (and it's the String object that we use to invoke the method).
                // So the return from the Function will be a String in uppercase.
                .map(String::toUpperCase) // Same thing as .map(s-> s.toUpperCase)
                // So to use a method reference for a method that takes parameters the compiler has to be able to infer
                // what the arguments are, such when using ".map". However, in the usage of the "filter" method below,
                // we couldn't do it, since the compiler cannot infer that the argument should be "G".
                // Also, we couldn't use a method that takes two arguments, because that method would be mapped to a
                // Function, not a BiFunction.
                // More about it at https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println); // Since this method doesn't return a value, the stream ends here.
        // A Stream is a sequence of elements supporting sequential and parallel aggregate operations, in other words,
        // it executes each command on each object of the Collection, however the source Collection does not change.
        // For them to work they need to be non-interfering (they don't change the stream source) and the must be
        // stateless, so the result of an operation can't depend on any state outside the operation (it can't depend
        // on variable values in a previous step).
        // In the stream above, each method is performed on the previous result from the methods. And all the methods
        // are from the "Stream" class (since they all return a stream to go the next step).

        // More about the "map" method
        // This method maps each element from the source String to a Function, then the Function is performed on each
        // element, and it returns a result stream.

        // Terminal operation
        // It returns a void or a non stream result, so it ends the steps of stream ("forEach" for example).

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "071");
        // We can't create a Stream of mixed types.
        Stream<String> inNumbersStream = Stream.of("N40", "N36", "I26", "I17", "I29", "071");

        // Concatenating Streams together
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumbersStream);
        // As the "concat" method is static it cannot be used in a chain, but it can be used as the source for a chain.
//        System.out.println("\nNumber of elements inside the Stream");
//        System.out.println(concatStream.count());

        // This method uses the "equals()" method to determine which strings are duplicate.
//        System.out.println("\nNumber of Unique Elements");
//        System.out.println(concatStream.distinct().count());

        // We can use the "peak()" method to observer the action without ending the operation, knowing that it makes
        // the peak method a non-termination method and therefore can be used in a chain without ending a sequence of
        // operations that are being performed on a Stream.
        // This method evaluates the Consumer for each item in the source stream and then add the item to a new String
        // which then returns.
        // Getting each item from the Stream and then counting them all.
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());
    }

}
