package challenge.eighth;

public class Main
{
// There are many interfaces in the Java SDK, and sometimes we can use a lambda expression instead of creating an
// instance that implements the interface we want to use.
//
// Given a specific interface, how can we tell whether we can map a lambda
// expression to it? What's the criteria that has to be met?
// We can tell if we can map a lambda expression to it if the interface only has one method that has to be implemented,
// then Java Runtime can infer what method has to be used. In other words, the interface has to be a functional
// interface (it can only have a single method that must be implemented).
// A functional interface can contain more than one method, but all the methods but one must have default
// implementation.
// Through the interface's documentation you'll know if it's a functional interface.

// With that in mind, can we use a lambda expression to represent an instance of the java.util.Callable interface?
// Yes, we can. By looking at the interfaces source code we can see that's a functional interface because of the
// "@FunctionalInterface" annotation and because it has one method that must be implemented.


// Is the java.util.Comparator interface a functional interface?
// By looking at its source code we can say that it is. Even though this interface has more than one method, there's
// just one method that has to be implemented, the rest are default method, beyond that it also has the
// "@FunctionalInterface" annotation.
}
// Java SDK = Java Software Development Kit