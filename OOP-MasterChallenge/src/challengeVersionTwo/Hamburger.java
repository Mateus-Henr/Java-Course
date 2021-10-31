package challengeVersionTwo;

import java.util.ArrayList;
import java.util.List;

public class Hamburger
{
    private String name;
    private String breadRollType;
    private String meat;
    private double price;
    private List<String> items;
    private List<Double> itemsPrice;
    protected final int MAX_NUMBER_OF_ADDITIONS = 4;

    public Hamburger(String name, double price, String breadRollType, String meat)
    {
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.price = price;
        this.items = new ArrayList<>();
        this.itemsPrice = new ArrayList<>();
        this.name = name;
    }

    public boolean addItem(String itemToAdd, double itemToAddPrice)
    {
        if (this.items.size() < MAX_NUMBER_OF_ADDITIONS)
        {
            this.items.add(itemToAdd);
            this.itemsPrice.add(itemToAddPrice);
            System.out.println("Added " + itemToAdd + " with a value of " + itemToAddPrice);
            return true;
        } else
        {
            System.out.println("The limit of additions has been reached.");
            return false;
        }
    }

    public String getFinalInformation() {
        String message = null;
        double totalPrice = 0;

        message = "SELECTED: A " + this.name + " on a " + this.breadRollType + "bread with " + this.meat + " with the price of " + this.price;

        for (int itemIndex = 0; itemIndex < this.items.size(); itemIndex++) {
            message += "\nADDED: " + this.items.get(itemIndex) + " with the price of " + this.itemsPrice.get(itemIndex);
            totalPrice += this.itemsPrice.get(itemIndex);
        }

        totalPrice += this.price;

        message += "\nTotal price: $" + totalPrice;

        return message;
    }

}
