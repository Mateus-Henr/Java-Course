package challenge.myVersion;

import java.util.Map;

public class Main
{
    private static final StockList stockList = new StockList();

    public static void main(String[] args)
    {
        // ---------------------------Adding Items To the Stock List-----------------------------------
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
        // --------------------------------------------------------------------------------------------

        System.out.println("\n---------------------------Basket with All the Items------------------------------------");
        System.out.println(stockList);

        // --------------------------------Adding Items to a Basket------------------------------------
        Basket mateusBasket = new Basket("Mateus");
        reserveItem(mateusBasket, "Car", 1);
        reserveItem(mateusBasket, "Car", 4);
        reserveItem(mateusBasket, "Juice", 4);
        reserveItem(mateusBasket, "Cup", 56);
        reserveItem(mateusBasket, "Bread", 1);
        // --------------------------------------------------------------------------------------------

        // --------------------------------Adding Items to a Basket------------------------------------
        Basket customerBasket = new Basket("Customer");
        reserveItem(customerBasket, "Car", 1);
        reserveItem(customerBasket, "Car", 4);
        reserveItem(customerBasket, "Juice", 4);
        reserveItem(customerBasket, "Cup", 100);
        reserveItem(customerBasket, "Bread", 1);
        // --------------------------------------------------------------------------------------------

        System.out.println("\n--------------------------Basket with the Reserved Items--------------------------------");
        System.out.println(mateusBasket);
        System.out.println("\n--------------------------Basket with the Reserved Items--------------------------------");
        System.out.println(customerBasket);
        System.out.println("\n-------------------------Stock List with Reserved Items---------------------------------");
        System.out.println(stockList);

        System.out.println("\n-----------------------------Basket while Checking Out----------------------------------");
        System.out.println("Unreserving 5 cups.");
        unreserveItem(mateusBasket, "Car", 10);
        unreserveItem(mateusBasket, "Cup", 5);
        checkOut(mateusBasket);
        System.out.println(mateusBasket);

        System.out.println("\n--------------------------Stock List After Checking Out---------------------------------");
        System.out.println(stockList);
    }

    private static boolean reserveItem(Basket basket, String itemToReserve, int quantityToReserve)
    {
        StockItem stockItem = stockList.get(itemToReserve);

        if (stockItem == null)
        {
            System.out.println("We don't sell " + itemToReserve);
            return false;
        }

        if (stockList.reserveStock(itemToReserve, quantityToReserve))
        {
            return basket.addToBasket(stockItem, quantityToReserve);
        }

        return false;
    }

    private static boolean unreserveItem(Basket basket, String itemToUnreserve, int quantityToUnreserve)
    {
        StockItem stockItem = stockList.get(itemToUnreserve);

        if (stockItem == null)
        {
            System.out.println("In your basket there is no " + itemToUnreserve);
            return false;
        }

        if (stockList.unreserveStock(itemToUnreserve, quantityToUnreserve))
        {
            basket.removeFromBasket(stockItem, quantityToUnreserve);

            return true;
        }

        return false;
    }

    private static void checkOut(Basket basket)
    {
        if (!basket.Items().isEmpty())
        {
            for (Map.Entry<StockItem, Integer> itemToSell : basket.Items().entrySet()) // VERY IMPORTANT - We cannot access the objects themselves,
                                                                                        // once the same object is used for two baskets for example.
            {
                System.out.println(itemToSell.getKey().getName() + " of the " + itemToSell.getValue() + " have been sold.");
                stockList.sellReservedStock(itemToSell.getKey().getName(), itemToSell.getValue());
            }

            basket.cleanBasket();
        }
    }

}
