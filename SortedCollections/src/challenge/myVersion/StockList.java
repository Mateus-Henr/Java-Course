package challenge.myVersion;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList
{
    private final Map<String, StockItem> list;

    public StockList()
    {
        this.list = new LinkedHashMap<>();
    }

    public boolean addStock(StockItem item)
    {
        if (item != null)
        {
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if (inStock != item)
            {
                item.adjustQuantityStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);

            return true;
        }

        return false;
    }

    public boolean sellStock(String item, int quantity)
    {
        StockItem inStock = list.getOrDefault(item, null);

        if ((inStock != null) && (quantity <= inStock.quantityInStock()) && (quantity > 0))
        {
            inStock.adjustQuantityStock(-quantity);

            return true;
        }

        return false;
    }

    public boolean sellReservedStock(String reservedItemToSell, int reservedQuantityToSell)
    {
        StockItem inStock = list.getOrDefault(reservedItemToSell, null);

        if ((inStock != null) && (reservedQuantityToSell > 0))
        {
            return inStock.sellReservedStock(reservedQuantityToSell);
        }

        return false;
    }

    public boolean reserveStock(String itemToReserve, int quantityToReserve)
    {
        StockItem inStock = list.getOrDefault(itemToReserve, null);

        if ((inStock != null) && (quantityToReserve > 0))
        {
            return inStock.reserveStock(quantityToReserve);
        }

        return false;
    }

    public boolean unreserveStock(String itemToUnreserve, int quantityToUnreserve)
    {
        StockItem inStock = list.getOrDefault(itemToUnreserve, null);

        if ((inStock != null) && (quantityToUnreserve > 0))
        {
            return inStock.unreserveStock(quantityToUnreserve);
        }

        return false;
    }

    public StockItem get(String key)
    {
        return this.list.get(key);
    }

    public Map<String, StockItem> Items()
    {
        return Collections.unmodifiableMap(list);
    }

    public Map<String, Double> PriceList()
    {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet())
        {
            prices.put(item.getKey(), item.getValue().getPrice());
        }

        return Collections.unmodifiableMap(prices);
    }

    @Override
    public String toString()
    {
        String s = "\nStock List\n";
        double totalCost = 0.0;

        for (Map.Entry<String, StockItem> item : list.entrySet())
        {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: $";
            s = s + String.format("%.2f", itemValue) + ". Reserved = " + stockItem.getReservedQuantity() + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value $" + String.format("%.2f", totalCost);
    }

}
