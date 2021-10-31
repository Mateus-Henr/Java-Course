package tutorial;

// Method Overriding
public class Dog
{
    public void bark()
    {
        System.out.println("Woof");
    }

}

class GermanShepherd extends Dog
{
    @Override
    public void bark()
    {
        System.out.println("Woof Woof Woof");
    }

}

// Method Overloading
class Dog2
{
    public void bark()
    {
        System.out.println("Woof");
    }

    public void bark(int number)
    {
        for (int i = 0; i < number; i++)
        {
            System.out.println("Woof Woof Woof");
        }
    }

}