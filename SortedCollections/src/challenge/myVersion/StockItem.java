package challenge.myVersion;

public class StockItem implements Comparable<StockItem>
{
    private final String name;
    private double price;
    private int reservedQuantity;
    private int quantityStock;

    public StockItem(String name, double price)
    {
        this.name = name;
        this.price = price;
        this.reservedQuantity = 0;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock)
    {
        this.name = name;
        this.price = price;
        this.reservedQuantity = 0;
        this.quantityStock = quantityStock;
    }

    public String getName()
    {
        return this.name;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(double price)
    {
        if (price > 0.0)
        {
            this.price = price;
        }
    }

    public int getReservedQuantity()
    {
        return this.reservedQuantity;
    }

    public int quantityInStock()
    {
        return this.quantityStock - this.reservedQuantity;
    }

    public void adjustQuantityStock(int quantityStock)
    {
        int newQuantity = this.quantityStock + quantityStock;

        if (newQuantity >= 0)
        {
            this.quantityStock = newQuantity;
        }
    }

    public boolean sellReservedStock(int quantityToSell)
    {
        if (quantityToSell <= this.reservedQuantity)
        {
            this.reservedQuantity -= quantityToSell;
            this.quantityStock -= quantityToSell;

            return true;
        }

        return false;
    }

    public boolean reserveStock(int quantityToReserve)
    {
        if (quantityToReserve <= this.quantityInStock())
        {
            this.reservedQuantity += quantityToReserve;

            return true;
        }

        return false;
    }

    public boolean unreserveStock(int quantityToUnreserve)
    {
        if (quantityToUnreserve <= this.reservedQuantity)
        {
            this.reservedQuantity -= quantityToUnreserve;

            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }

        if ((obj == null) || (obj.getClass() != this.getClass()))
        {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o)
    {
        if (this == o)
        {
            return 0;
        }

        if (o != null)
        {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString()
    {
        return this.name + ": $" + String.format("%.2f", this.price);
    }

}
