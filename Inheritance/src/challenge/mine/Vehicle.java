package challenge.mine;

public class Vehicle
{
    private String type;
    private int speed;

    public Vehicle(String type)
    {
        this.type = type;
        this.speed = 0;
    }

    public void move(int speed)
    {
        if (speed < 0)
        {
            System.out.println("Invalid speed has been provided for the vehicle.");
        }
        else if (speed == 0)
        {
            System.out.println("Speed cannot be 0.");
        }
        else
        {
            this.speed = speed;
            System.out.println("Vehicle is moving at " + speed);
        }
    }

    public String getType()
    {
        return type;
    }

    public int getSpeed()
    {
        return speed;
    }

}
