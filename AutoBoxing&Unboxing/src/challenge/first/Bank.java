package challenge.first;

import java.util.ArrayList;

public class Bank
{
    private ArrayList<Branch> listOfBranches;

    public Bank()
    {
        listOfBranches = new ArrayList<>();
    }

    public void addNewBranch(String newBranchName)
    {
        if (findBranch(newBranchName) >= 0)
        {
            System.out.println("A branch with the name " + newBranchName + " already exists.");
        } else
        {
            listOfBranches.add(new Branch(newBranchName));
        }
    }

    public void addCustomerToBranch(String branchName, String customerName, double initialTransaction)
    {
        int branchPosition = findBranch(branchName);
        if (branchPosition >= 0)
        {
            listOfBranches.get(branchPosition).addNewClient(customerName, initialTransaction);
        } else
        {
            System.out.println("A branch with the name " + branchName + " does not exist.");
        }
    }

    public void addTransactionToAClient(String branchName, String clientName, double transactionValue)
    {
        int branchPosition = findBranch(branchName);
        if (branchPosition >= 0)
        {
            listOfBranches.get(branchPosition).addAdditionalTransaction(clientName, transactionValue);
        } else
        {
            System.out.println("A branch with the name " + branchName + " does not exist.");
        }
    }

    public void showAllBranches()
    {
        if (listOfBranches.isEmpty())
        {
            System.out.println("No branches in the system.");
        } else
        {
            for (int i = 0; i < listOfBranches.size(); i++)
            {
                System.out.println("\nBranch Name: " + listOfBranches.get(i).getName());
                listOfBranches.get(i).printCustomersAndTheirTransactions();
            }
        }
    }

    public int findBranch(String branchNameToFind)
    {
        for (int i = 0; i < listOfBranches.size(); i++)
        {
            if (listOfBranches.get(i).getName().equals(branchNameToFind))
            {
                return i;
            }
        }

        return -1;
    }

}
