package challenge.first;

import java.util.ArrayList;

public class Customer
{
    private String name;
    private ArrayList<Double> listOfTransactions;

    public Customer(String name, double initialAmount)
    {
        this.name = name;
        this.listOfTransactions = new ArrayList<>();
        addTransaction(Double.valueOf(initialAmount));
    }

    public String getName()
    {
        return this.name;
    }

    public void addTransaction(double transactionValue)
    {
        listOfTransactions.add(transactionValue);
    }

    public void printTransactions()
    {
        if (listOfTransactions.isEmpty())
        {
            System.out.println("No transactions in the system.");
        } else
        {
            for (int i = 0; i < listOfTransactions.size(); i++)
            {
                System.out.println("Transaction - n°" + i + " value: " + listOfTransactions.get(i));
            }
        }
    }

}
