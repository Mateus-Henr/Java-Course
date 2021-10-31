package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        BankAccount bankAccount = new BankAccount(12345, 0.00, "Bob Brown", "myemail@bob.com", "(087) 123-456");

        System.out.println("Account number: " + bankAccount.getAccountNumber());
        System.out.println("Account balance: $" + bankAccount.getBalance());

        bankAccount.deposit(12.23);
        bankAccount.withdrawal(1.23);
        System.out.println("Final balance: " + bankAccount.getBalance());

        System.out.println("\n");
        bankAccount.withdrawal(432.00);

        BankAccount mateusAccount = new BankAccount("Mateus", "mateus@email.com", "1234");
        System.out.println(mateusAccount.getAccountNumber() + " name " + mateusAccount.getCustomerName());
    }

}
