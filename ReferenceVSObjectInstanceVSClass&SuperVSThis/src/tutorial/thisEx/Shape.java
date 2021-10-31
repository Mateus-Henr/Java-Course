package tutorial.thisEx;

// "This()" example
public class Shape
{
    private int x;
    private int y;

    public Shape(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

}

class Rectangle3 extends Shape
{
    private int width;
    private int height;

    public Rectangle3(int x, int y)
    {
        this(x, y, 0, 0); // Calls 2nd constructor
    }

    public Rectangle3(int x, int y, int width, int height)
    {
        super(x, y); // Calls constructor from patent (Shape)
        this.width = width;
        this.height = height;
    }

}