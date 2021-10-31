package challenge;

import java.util.ArrayList;
import java.util.List;

public class DeluxeBurger extends Hamburger
{
    private String name;
    private double price;
    private List<Item> items;
    protected final int MAX_NUMBER_OF_ADDITIONS = 0;

    public DeluxeBurger(String breadRollType, String meat)
    {
        super(breadRollType, meat);
        this.name = getClass().getSimpleName();
        this.price = 20.00;
        this.items = new ArrayList<>();
        initializeAdditions();
    }

    private void initializeAdditions()
    {
        this.items.add(new Chips(1));
        this.items.add(new Drink(1));
    }

    @Override
    public void addItem(Item itemToAdd)
    {
        System.out.println("No items are allowed for " + this.name);
    }

    @Override
    public double getItemsTotalPrice()
    {
        System.out.println("No items are allowed for " + this.name);
        return 0.0;
    }

    @Override
    public double getTotalPrice()
    {
        return this.price;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

}
