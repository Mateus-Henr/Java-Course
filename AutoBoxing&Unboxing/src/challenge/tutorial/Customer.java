package challenge.tutorial;

import java.util.ArrayList;

public class Customer
{
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount)
    {
        this.name = name;
        this.transactions = new ArrayList<>();
        addTransaction(initialAmount);
    }

    public void addTransaction(double amount)
    {
        this.transactions.add(amount);
    }

    public String getName()
    {
        return this.name;
    }

    public ArrayList<Double> getTransactions()
    {
        return this.transactions;
    }

}
