package challenge.first;

public class Main
{
    public static void main(String[] args)
    {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(12345);
        bankAccount.setBalance(0.00);
        bankAccount.setCustomerName("Bob Brown");
        bankAccount.setCustomerEmail("myemail@bob.com");
        bankAccount.setCustomerPhone("(087) 123-456");

        bankAccount.deposit(12.23);
        bankAccount.withdrawal(1.23);
        System.out.println("Final balance: " + bankAccount.getBalance());

        System.out.println("\n");
        bankAccount.withdrawal(432.00);
    }

}
