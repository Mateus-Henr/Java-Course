package challenge;

public abstract class Item
{
    public abstract double getPrice();

    public abstract int getQuantity();

    public abstract String getName();

}

class Lettuce extends Item
{
    private String name;
    private int quantity;
    private double price;

    public Lettuce(int quantity)
    {
        this.name = getClass().getSimpleName();
        this.quantity = quantity;
        this.price = 2.00;
    }

    public double getPrice()
    {
        return this.price;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public String getName()
    {
        return this.name;
    }

}

class Tomato extends Item
{
    private String name;
    private int quantity;
    private double price;

    public Tomato(int quantity)
    {
        this.name = getClass().getSimpleName();
        this.quantity = quantity;
        this.price = 2.00;
    }

    public double getPrice()
    {
        return this.price;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public String getName()
    {
        return this.name;
    }

}

class Carrot extends Item
{
    private String name;
    private int quantity;
    private double price;

    public Carrot(int quantity)
    {
        this.name = getClass().getSimpleName();
        this.quantity = quantity;
        this.price = 3.00;
    }

    public double getPrice()
    {
        return this.price;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public String getName()
    {
        return this.name;
    }

}

class Bacon extends Item
{
    private String name;
    private int quantity;
    private double price;

    public Bacon(int quantity)
    {
        this.name = getClass().getSimpleName();
        this.quantity = quantity;
        this.price = 4.00;
    }

    public double getPrice()
    {
        return this.price;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public String getName()
    {
        return this.name;
    }

}

class Chips extends Item
{
    private String name;
    private int quantity;
    private double price;

    public Chips(int quantity)
    {
        this.name = getClass().getSimpleName();
        this.quantity = quantity;
        this.price = 4.00;
    }

    public double getPrice()
    {
        return this.price;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public String getName()
    {
        return this.name;
    }

}

class Drink extends Item
{
    private String name;
    private int quantity;
    private double price;

    public Drink(int quantity)
    {
        this.name = getClass().getSimpleName();
        this.quantity = quantity;
        this.price = 4.00;
    }

    public double getPrice()
    {
        return this.price;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public String getName()
    {
        return this.name;
    }

}






