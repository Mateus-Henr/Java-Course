package challenge.mine;

public class Ferrari extends Car
{
    private String model;
    private int year;
    private int speed;

    public Ferrari(String model, int year)
    {
        super(true);
        this.model = model;
        this.year = year;
        this.speed = 0;
    }

    @Override
    public void move(int speed)
    {
        super.move(speed);
        System.out.println("Your Ferrari " + model + " is moving at " + speed);
        this.speed = speed;
    }

    public String getModel()
    {
        return model;
    }

    public int getYear()
    {
        return year;
    }
}
