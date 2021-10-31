package challenge.second;

public class Main
{
    public static void main(String[] args)
    {
        final BankAccount bankAccount = new BankAccount("12345-678", 1000.00);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                bankAccount.deposit(300.00);
                System.out.println("Deposited 300.");
                bankAccount.withdraw(50.00);
                System.out.println("Withdrew 50.");
                System.out.println("Balance: " + bankAccount.getBalance());
            }
        }).start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                bankAccount.deposit(203.75);
                System.out.println("Deposited 203,75.");
                bankAccount.withdraw(100.00);
                System.out.println("Withdrew 100.");
                System.out.println("Balance: " + bankAccount.getBalance());
            }
        }).start();
    }

}
