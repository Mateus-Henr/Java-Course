package challenge.tutorial;

import java.util.ArrayList;

public class Bank
{
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name)
    {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName)
    {
        if (findBranch(branchName) == null)
        {
            this.branches.add(new Branch(branchName));
            return true;
        }

        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction)
    {
        Branch branch = findBranch(branchName);

        if (branch != null)
        {
            return branch.newCustomer(customerName, initialTransaction);
        }

        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transactionToAdd)
    {
        Branch branch = findBranch(branchName);

        if (branch != null)
        {
            return branch.addTransaction(customerName, transactionToAdd);
        }

        return false;
    }

    private Branch findBranch(String branchName)
    {
        for (int i = 0; i < branches.size(); i++)
        {
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getName().equals(branchName))
            {
                return checkedBranch;
            }
        }

        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions)
    {
        Branch branch = findBranch(branchName);

        if (branch != null)
        {
            System.out.println("Customers details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++)
            {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");

                if (showTransactions)
                {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();

                    for (int j = 0; j < transactions.size(); j++)
                    {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }

            return true;
        } else
        {
            return false;
        }
    }

}
