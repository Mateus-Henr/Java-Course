package tutorial;

public class Main
{
    // Method Overloading
    // Method overloading means providing two oor more separate methods in class with the same name but different parameters.
    // Method return type doesn't need to be the same.
    // It's used to avoid duplicated code and useless additional method names.
    // The compiler decide which methods is going to be called based on method name, return type and argument list.
    // We can overload static and instance methods.
    // We can have a mix of method overloading and inheritance, in other words, we can overload a method from the base class
    // in the subclass.
    // They're considered overloading when they have the same name but different parameters (number or type).
    // Optional - Return type, access modifier and "throws".

    // Method Overriding
    // Method Overriding means defining a method in a child class that already exists in the parent class with same signature.
    // By extending the parent class the child class gets all the methods defined in the parent class (those methods are
    // also known as derived methods).
    // The method that's going to be called is decided at run time by the JVM.
    // Don't forget the "@Override"
    // We can't override static methods.
    // They're considered overriding when they have the same name and arguments,
    // Return type can be a subclass of the return type in the parent class.
    // It can't have a lower access modifier. For example if the parent class is protected then using private in the child is not
    // allowed but using public in the child would be allowed.
    // Important points
    // Only inherited methods can be overridden
    // Constructors and private methods cannot be overridden
    // Methods that are final cannot be overridden.
    // A subclass can use "super" to get the methods from the parent class.
    // Can't use additional "throws"
}
