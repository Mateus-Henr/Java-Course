package challenge.tutorial;

public class Vehicle
{
    private String name;
    private String size;

    private int currentVelocity;
    private int currentDirection;

    public Vehicle(String name, String size)
    {
        this.name = name;
        this.size = size;

        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void steer(int direction)
    {
        this.currentVelocity += direction;
        System.out.println("Vehicle.steer(): Steering at " + currentDirection + " degrees.");
    }

    public void move(int velocity, int direction)
    {
        this.currentVelocity = velocity;
        this.currentDirection = direction;
        System.out.println("Vehicle.move(): Moving at " + currentVelocity + " in direction " + currentDirection);
    }

    public void stop()
    {
        this.currentDirection = 0;
    }

    public int getCurrentVelocity()
    {
        return currentVelocity;
    }

    public int getCurrentDirection()
    {
        return currentDirection;
    }

}
