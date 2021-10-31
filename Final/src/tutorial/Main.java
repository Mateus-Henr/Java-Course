package tutorial;

// Final fields aren't constants because the can be modified, but only once and any modification must be performed
// before the class constructor finishes.
// Therefore, we can just assign a value to a final field when declaring it or in the constructor.
public class Main
{
    public static void main(String[] args)
    {
        SomeClass one = new SomeClass("One");
        SomeClass two = new SomeClass("Two");
        SomeClass three = new SomeClass("Three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

        // Not allowed since the variable is final.
//        one.instanceNumber = 4;

        System.out.println(Math.PI);

//        Math m = new Math();

        int pw = 54546;
        Password password = new ExtendedPassword(pw);
        // If someone overrides the "storePassword" method, the person could "hack" the password system.
        // The person could extend the class and change the method by overriding it.
        // By defining it as final it doesn't allow sub-classing.
        password.storePassword();

        password.letMeIn(1);
        password.letMeIn(4343534);
        password.letMeIn(7687);
        password.letMeIn(0);
        password.letMeIn(-1);
        password.letMeIn(54546);

        System.out.println("Main method called.");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);
    }

}

// Constants values are defined as "static final", because by doing it, it allows their usage without the need of
// instantiating a class just ot ise a constant.

// "final" in a class is used to prevent the class from being subclassed.
// "final" in a method prevents the method from being overwritten.