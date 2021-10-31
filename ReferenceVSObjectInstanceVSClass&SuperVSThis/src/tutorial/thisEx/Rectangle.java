package tutorial.thisEx;

// Bad Example
public class Rectangle
{
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle()
    {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(int width, int height)
    {
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}

// Good Example
class Rectangle2
{
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle2()
    {
        this(0, 0, 0, 0);
    }

    public Rectangle2(int width, int height)
    {
        this(0, 0, width, height);
    }

    // This constructor is the only one that's allowed to initialize the variables
    public Rectangle2(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}