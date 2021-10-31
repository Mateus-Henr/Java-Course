package challenge.first;

public class Main
{
    public static void main(String[] args)
    {
        Bank bank = new Bank();

        bank.addNewBranch("Branch1");
        bank.addCustomerToBranch("Branch1", "Mateus", 10.10);
        bank.addTransactionToAClient("Branch1", "Mateus", 10.10);
        bank.addTransactionToAClient("Branch1", "Mateus", 10.10);


        bank.addNewBranch("Branch2");
        bank.addCustomerToBranch("Branch2", "John", 12.11);
        bank.addTransactionToAClient("Branch2", "John", 1032.48);

        bank.showAllBranches();
    }

}
