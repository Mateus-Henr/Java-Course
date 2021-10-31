package tutorial;

public class Main
{
    // Static Methods
    // Static methods are declared using a static modifier.
    // Static methods can't access instance methods and instance variable directly. (They need to be static as well).
    // They are usually used for operations that don't require any data from an instance of the class (from "this").
    // In static methods we can't use this keyword.
    // When methods doesn't use instance variables that method should be used as static.

    // Instance Methods
    // Instance Methods belong to an instance of a class.
    // To use an instance methods we have to instantiate the class first usually by using the new keyword.
    // Instance methods can access instance methods and instance variables directly as well as static methods and variables.

    // Choosing which you should choose.
    // 1° Question - Should a method be static?
    // 2° Question - Does it use any fields (instance variables) or instance methods?
    // If Yes, you should use an instance method, otherwise you should use a static method.
}
