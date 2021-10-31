package challenge;

import java.util.ArrayList;
import java.util.List;

public class HealthyBurger extends Hamburger
{
    private String name;
    private double price;
    private List<Item> items;
    protected final int MAX_NUMBER_OF_ADDITIONS = 4;

    public HealthyBurger(String breadRollType, String meat)
    {
        super(breadRollType, meat);
        this.name = getClass().getSimpleName();
        this.price = 12.00;
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(Item itemToAdd)
    {
        int currentAdditionQuantity = itemToAdd.getQuantity();
        for (Item item : this.items)
        {
            currentAdditionQuantity += item.getQuantity();
        }
        if (currentAdditionQuantity > this.MAX_NUMBER_OF_ADDITIONS)
        {
            System.out.println("The limit of additional items for the " + this.name + " has been reached. Being it up to " + this.MAX_NUMBER_OF_ADDITIONS + " items.");
            System.out.println("No items have been ended.");
        } else
        {
            this.items.add(itemToAdd);
            System.out.println("Added " + itemToAdd.getQuantity() + " " + itemToAdd.getName() + " with an extra value of $" + itemToAdd.getQuantity() * itemToAdd.getPrice());
        }
    }

    @Override
    public double getItemsTotalPrice()
    {
        double totalPrice = 0;

        if (this.items.isEmpty())
        {
            System.out.println("No items found.");
            return 0.0;
        }
        for (Item item : this.items)
        {
            totalPrice = item.getPrice() * item.getQuantity();
        }

        return totalPrice;
    }

    @Override
    public double getTotalPrice()
    {
        return this.price + getItemsTotalPrice();
    }

    @Override
    public String getName()
    {
        return this.name;
    }

}
