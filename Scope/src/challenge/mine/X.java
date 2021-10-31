package challenge.mine;

public class X
{
    private int x;

    public X()
    {
        this.x = 1;
    }

    public void x(int x)
    {
        while (this.x != 12)
        {
            System.out.println(x + " * " + this.x + " = " + (x * this.x));
            this.x++;
        }
    }

}
