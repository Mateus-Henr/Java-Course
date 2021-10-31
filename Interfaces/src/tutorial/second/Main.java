package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        // Interface vs Inheritance
        // You need to consider the final object.
        // In our mobile phone / desk phone was better to use an interface since phone is just a part of them.
        // Mobile phone is not just a phone it has more characteristics.
        // A mobile phone is a computer tha HAS a phone interface. Both CAN telephone which means that both need to
        // to implement an interface, rather than extending a class.
        // Just one inheritance is allowed.
        // Considering the Animal base class used before, we cannot say that all Animals can walk. So we could define a walk
        // interface to mention this action. For Birds we can extends Animal and implements Walk and Fly.

        ITelephone timsPhone;
        timsPhone = new DeskPhone(123456);
        timsPhone.powerOn();
        timsPhone.callPhone(123456);
        timsPhone.answer();

        System.out.println("\n");
        timsPhone = new MobilePhone(24565); // Using the interface instance
        timsPhone.powerOn();
        timsPhone.callPhone(24565);
        timsPhone.answer();
    }

}
