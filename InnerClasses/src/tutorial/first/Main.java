package tutorial.first;

public class Main
{
    public static void main(String[] args)
    {
        GearBox mcLaren = new GearBox(6);
        GearBox.Gear first = mcLaren.new Gear(1, 12.3); // We don't want to interact directly with the Gear class, but here we are doing it.
        // GearBox.Gear second = new GearBox.Gear(2, 15.2); Error since we can instantiate an inner class without having instantiated the outer class before.
        //  GearBox.Gear third = new GearBox.Gear(3, 17.8); Error since you need to initialize the inner class as well

        System.out.println(first.driveSpeed(1000));
    }
}
