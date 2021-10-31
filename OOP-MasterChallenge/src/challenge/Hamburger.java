package challenge;

import java.util.ArrayList;
import java.util.List;

public class Hamburger
{
    private String name;
    private String breadRollType;
    private String meat;
    private double price;
    private List<Item> items;
    protected final int MAX_NUMBER_OF_ADDITIONS = 4;

    public Hamburger(String breadRollType, String meat)
    {
        this.name = getClass().getSimpleName();
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.price = 10.00;
        this.items = new ArrayList<>();
    }

    public void addItem(Item itemToAdd)
    {
        int currentAdditionQuantity = itemToAdd.getQuantity();
        for (Item item : this.items)
        {
            currentAdditionQuantity += item.getQuantity();
        }
        if (currentAdditionQuantity > MAX_NUMBER_OF_ADDITIONS)
        {
            System.out.println("The limit of additional items for the " + name + " has been reached. Being it up to " + MAX_NUMBER_OF_ADDITIONS + " items.");
        } else
        {
            this.items.add(itemToAdd);
            System.out.println("Added " + itemToAdd.getQuantity() + " " + itemToAdd.getName() + " with an extra value of $" + itemToAdd.getQuantity() * itemToAdd.getPrice());
        }
    }

    public double getItemsTotalPrice()
    {
        double totalPrice = 0;

        if (items.isEmpty())
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

    public double getTotalPrice()
    {
        return this.price + getItemsTotalPrice();
    }

    public String getName()
    {
        return this.name;
    }

}
