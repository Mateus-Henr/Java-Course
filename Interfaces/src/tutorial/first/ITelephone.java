package tutorial.first;

public interface ITelephone
{ // Coming back to old classes we mentioned the method's signatures that's basically using the name plus the parameters +
    // its data types. In an interface we define the method signature to be used in a class, a common behaviour.

    void powerOn();

    void dial(int phoneNumber);

    void answer();

    boolean callPhone(int phoneNumber);

    boolean isRinging();

}
// We don't need data modifier "public", since the interface is gonna be used in a class.
// If you commit with a contract you need to follow all of it rules, therefore with interfaces is quite similar,
// in order to use an interface you need to follow its contact and one of them is to implement all of its methods with
// the proper signature.
