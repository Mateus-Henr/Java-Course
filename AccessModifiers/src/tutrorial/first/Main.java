package tutrorial.first;

public class Main
{
    public static void main(String[] args)
    {
        Account timsAccount = new Account("Tim");
        timsAccount.deposit(1000);
        timsAccount.withdraw(500);
        timsAccount.withdraw(-200);
        timsAccount.deposit(-20);
        timsAccount.calculateBalance();

        // As the variable is saved as public in the Account class we can access/modify it outside of the class.
        // In the bank context is a fraud, to check it a bank would look at the history transaction.
        // But as the transactions are also receiving a public modifier it can be tampered with as well.
        timsAccount.balance = 5000;

        System.out.println("Balance on account is " + timsAccount.getBalance());

        // Tampering the account's transactions.
        timsAccount.transactions.add(4500);
        timsAccount.calculateBalance();
    }

}
