package challenge.first;

import java.util.ArrayList;

public class Branch
{
    private String name;
    private ArrayList<Customer> listOfCustomers;

    public Branch(String name)
    {
        this.name = name;
        this.listOfCustomers = new ArrayList<>();
    }

    public void addNewClient(String newClientName, double newClientInitialTransaction)
    {
        if (findClient(newClientName) >= 0)
        {
            System.out.println("A client with the name passed " + newClientName + " already exists.");
        } else
        {
            listOfCustomers.add(new Customer(newClientName, newClientInitialTransaction));
        }
    }

    public void addAdditionalTransaction(String clientName, double transactionValue)
    {
        int clientPosition = findClient(clientName);
        if (clientPosition >= 0)
        {
            listOfCustomers.get(clientPosition).addTransaction(transactionValue);
        } else
        {
            System.out.println("A client with the name passed " + clientName + " doesn't exist.");
        }

    }

    private int findClient(String clientName)
    {
        for (int i = 0; i < listOfCustomers.size(); i++)
        {
            if (listOfCustomers.get(i).getName().equals(clientName))
            {
                return i;
            }
        }

        return -1;
    }

    public void printCustomersAndTheirTransactions()
    {
        if (listOfCustomers.isEmpty())
        {
            System.out.println("No customers in the system.");
        } else
        {
            for (int i = 0; i < listOfCustomers.size(); i++)
            {
                System.out.println("Client - ID: " + i + " | Name: " + listOfCustomers.get(i).getName());
                listOfCustomers.get(i).printTransactions();
            }
        }
    }

    public String getName()
    {
        return name;
    }

}
