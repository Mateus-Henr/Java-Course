package tutorial;

import java.util.Map;

// The linked versions of map and set maintain an order.
public class Main
{
    private static StockList stockList = new StockList();

    public static void main(String[] args)
    {
        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("Car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("Chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("Cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("Cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("Door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("Juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("Phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("Towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("Vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s : stockList.Items().keySet()) // It has the same order of the original map. Ex: if it's a hashmap it's not alphabetical.
        {
            System.out.println(s);
        }

        Basket mateusBasket = new Basket("Mateus");
        sellItem(mateusBasket, "Car", 1);
        System.out.println(mateusBasket);

        sellItem(mateusBasket, "Car", 1);
        System.out.println(mateusBasket);

        if (sellItem(mateusBasket, "Car", 1) != 1)
        {
            System.out.println("There are no more cars in stock.");
        }
        System.out.println(mateusBasket);

        sellItem(mateusBasket, "Spanner", 1);
        System.out.println(mateusBasket);

        sellItem(mateusBasket, "Juice", 4);
        sellItem(mateusBasket, "Cup", 12);
        sellItem(mateusBasket, "Bread", 1);
        System.out.println(mateusBasket);

        System.out.println(stockList);

        // temp = new StockItem("Pen" , 1.12);
        // stockList.Items().put(temp.getName(), temp); Throws an exception, once the map used is a unmodifiedMap.

        stockList.Items().get("Car").adjustQuantityStock(2000);     // This works, even though the map is unmodifiable,
        stockList.get("Car").adjustQuantityStock(-1000);            // we still ca modify a single object.
        System.out.println(stockList);  // The collection that's unmodifiable the objects are not.

        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet())
        {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity)
    {
        // Retrieve item from stock list
        StockItem stockItem = stockList.get(item);

        if (stockItem == null)
        {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if (stockList.sellStock(item, quantity) != 0)
        {
            basket.addToBasket(stockItem, quantity);

            return quantity;
        }

        return 0;
    }

}
