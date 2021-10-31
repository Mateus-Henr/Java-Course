package challenge.tutorial;

import java.util.ArrayList;

public class Branch
{
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name)
    {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean newCustomer(String customerName, double initialAmount)
    {
        if (findCustomer(customerName) == null)
        {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }

        return false;
    }

    public boolean addTransaction(String customerName, double transactionTodd)
    {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null)
        {
            existingCustomer.addTransaction(transactionTodd);
            return true;
        }

        return false;
    }

    private Customer findCustomer(String customerName)
    {
        for (int i = 0; i < customers.size(); i++)
        {
            Customer checkedCustomer = this.customers.get(i);
            if (checkedCustomer.getName().equals(customerName))
            {
                return checkedCustomer;
            }
        }

        return null;
    }

    public String getName()
    {
        return this.name;
    }

    public ArrayList<Customer> getCustomers()
    {
        return this.customers;
    }

}
