package tutorial.second;

public class Dog
{
    private final String name;

    public Dog(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public final boolean equals(Object obj) // By using final in this method it guarantees that the method cannot be overwritten
    {                                       // Once the method is not overwritten it avoids confusion with subclasses trying to
        if (this == obj)                    // to detect whether the class is or not an instance of "Dog".
        {                                   // Considering the "Labrador" class, when it used the "equals" method, it tried
            return true;                    // to see if the object delivered to it was an instance of "Labrador",
        }                                   // but in reality it should be trying to detect if it was an instance of "Dog"
                                            // and if the parameters compared were equal.
        if (obj instanceof Dog)
        {
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        }

        return false;
    }

}
