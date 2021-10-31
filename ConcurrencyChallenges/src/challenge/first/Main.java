package challenge.first;

public class Main
{
    public static void main(String[] args)
    {
        // Representing a joint bank account
        final BankAccount bankAccount = new BankAccount("12345-678", 1000.00);

//        // Another way of creating a thread, you could also harness it to an object
//        new Thread() {
//            @Override
//            public void run()
//            {
//                // Do Something
//                System.out.println("Hey");
//            }
//        }.start();

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
