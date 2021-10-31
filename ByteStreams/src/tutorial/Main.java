package tutorial;

// Let's suppose that we have a class called "Foo" and we have a "Bar" object as field. If we serialize "Foo" objects
// that point to the same bar, will we get a file that contains two bar objects or just one?
// We will get just one, as the two "Foo" instances refer to the same "Bar" instance only one instance is serialized.
// To sum up, a serialized file will only contain one copy of the same instance. They are unique within a file.
public class Main
{
    public static void main(String[] args)
    {
        Bar bar = new Bar("MyBar");
        Foo f1 = new Foo(bar);
        Foo f2 = new Foo(bar);
        // Bearing in mind the comment above, just one "Bar" object is going to be serialized.
    }

}

class Foo
{
    private Bar bar;

    public Foo(Bar bar)
    {
        this.bar = bar;
    }

}

class Bar
{
    private String name;

    public Bar(String name)
    {
        this.name = name;
    }

}
