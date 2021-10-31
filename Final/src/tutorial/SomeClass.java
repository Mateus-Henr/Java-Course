package tutorial;

public class SomeClass
{
    // By using the "classCounter" we can track the amount of classes created and set a final value to each class
    // like some sort of database key.
    private static int classCounter = 0;
    public final int instanceNumber;
    private final String name;

    public SomeClass(String name)
    {
        // Usually you'd declare a final variable in the constructor when the value to be assigned to it depends on
        // code on another class for example.
        this.name = name;
        classCounter++;
        this.instanceNumber = classCounter;
        System.out.println(name + " created, instance is " + instanceNumber);
    }

    public int getInstanceNumber()
    {
        return instanceNumber;
    }

}
