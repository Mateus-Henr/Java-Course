package challenge.myVersion;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket
{
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name)
    {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public boolean addToBasket(StockItem itemToAdd, int quantityToAdd)
    {
        if ((itemToAdd != null) && (quantityToAdd > 0))
        {
            int inBasket = list.getOrDefault(itemToAdd, 0);
            list.put(itemToAdd, (inBasket + quantityToAdd));

            return true;
        }

        return false;
    }

    public boolean removeFromBasket(StockItem itemToRemove, int quantityToRemove)
    {
        if ((itemToRemove != null) && (quantityToRemove > 0))
        {
            int inBasket = list.getOrDefault(itemToRemove, 0);

            if (quantityToRemove <= inBasket)
            {
                if (quantityToRemove < inBasket)
                {
                    list.put(itemToRemove, (inBasket - quantityToRemove));
                }
                else
                {
                    list.remove(itemToRemove);
                }

                return true;
            }
        }

        return false;
    }

    public void cleanBasket()
    {
        this.list.clear();
    }

    public Map<StockItem, Integer> Items()
    {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString()
    {
        String s = "\nShopping basket '" + name + "' contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet())
        {
            s = s + item.getKey() + " - " + item.getValue() + " in the basket.\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }

        return s + "Total cost $" + String.format("%.2f", totalCost);
    }

}
