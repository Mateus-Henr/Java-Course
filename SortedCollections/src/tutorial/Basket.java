package tutorial;

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
        this.list = new TreeMap<>(); // TreeMap does more work than using a HashMap.
        // When using it everytime you enter a new item the compareTo() method
        //  will be called to decide where the item should go in the map.
    }

    public int addToBasket(StockItem item, int quantity)
    {
        if ((item != null) && (quantity > 0))
        {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);

            return inBasket;
        }

        return 0;
    }

    public void removeItem(StockList stockList, StockItem itemToAdd)
    {
        stockList.addStock(itemToAdd);
    }

    public Map<StockItem, Integer> Items()
    {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString()
    {
        String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet())
        {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }

        return s + "Total cost " + totalCost;
    }

}
