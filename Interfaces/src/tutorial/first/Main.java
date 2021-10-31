package tutorial.first;

public class Main
{
    // Interfaces are abstract, they don't carry code implementation.
    // Interfaces is used to implement a common behaviour to classes that implement that specific interface.
    // Interfaces is a sort of commitment that makes some methods unchangeable. The code needs to stick to what's
    // provided in the interface.
    public static void main(String[] args)
    {
        ITelephone timsPhone; // We instantiate the interface since like this we can instantiate other classes
        // that implement the same interface.
        timsPhone = new DeskPhone(123456);
        timsPhone.powerOn();
        timsPhone.callPhone(123456);
        timsPhone.answer();

        // You can't instantiate since the interface doesn't have the proper ways to do something, do you remember when
        // we were having a look at classes? We considered classes as some sort of blueprint, with a blueprint we can
        // build an object, just with a contract (interface in this case) we can't.
        // If you instantiate an interface I'll create a class we you try to instantiate it. Example:
        ITelephone myPhone = new ITelephone()
        {
            @Override
            public void powerOn()
            {

            }

            @Override
            public void dial(int phoneNumber)
            {

            }

            @Override
            public void answer()
            {

            }

            @Override
            public boolean callPhone(int phoneNumber)
            {
                return false;
            }

            @Override
            public boolean isRinging()
            {
                return false;
            }
        };

        myPhone.powerOn();
    }

}
