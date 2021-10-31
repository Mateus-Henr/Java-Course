package challengeVersionTwo;

public class DeluxeBurger extends Hamburger
{
    private String name;
    private double price;

    public DeluxeBurger() {
        super("Basic",19.10,"Sausage","White");
        this.name = "Me";
        this.price = 19.10;
    }

    @Override
    public boolean addItem(String itemToAdd, double itemToAddPrice)
    {
        System.out.println("No additional items allowed for the Deluxe Burger");
        return false;
    }

    @Override
    public String getFinalInformation()
    {
        return "\nTotal price: $" + this.price;
    }

}
