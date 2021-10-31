package tutorial.superEx;

public class SuperClass // Parent class (Super class)
{
    public void printMethod()
    {
        System.out.println("Printed in Superclass.");
    }
}

class SubClass extends SuperClass
{
    @Override // Overrides method from parent
    public void printMethod()
    {
        super.printMethod(); // Calls method in SuperClass (parent) Without the "super" the method would call itself forever
        System.out.println("Printed in Subclass");
    }
}

class MainClass
{
    public static void main(String[] args)
    {
        SubClass s = new SubClass();
        s.printMethod();
    }
}

// Use "this()" to call a constructor from another overloaded constructor in the same class.
// Can just be used in a constructor and needs to be the first line. It's used with constructor chaining, in other
// words, one constructor calls another constructor, and helps to reduce duplicated code.

// Use "super()" to call the parent constructor.
// If you don't add a super will be inserted by the compiler (without arguments)
// Needs to be the first statement in each constructor

// Even abstract class have constructors, but it's not possible to instantiate an abstract class directly.
// An abstract class is still a super class, so its constructors run when someone makes an instance of a concrete class.