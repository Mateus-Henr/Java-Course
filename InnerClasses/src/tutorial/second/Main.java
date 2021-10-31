package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        GearBox mcLaren = new GearBox(6);
        mcLaren.operatingClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operatingClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operatingClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operatingClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));
    }
}
