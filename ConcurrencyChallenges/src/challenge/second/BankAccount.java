package challenge.second;

public class BankAccount
{
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance)
    {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public double getBalance()
    {
        return balance;
    }

//    public synchronized void deposit(double amount) // Synchronizing just a part of the method.
//    {
//        synchronized (this) // This would be a better solution if there were more than critical section code.
//        {
//            balance += amount;
//        }
//    }

    public synchronized void deposit(double amount) // Synchronizing methods that are updating fields.
    {
        balance += amount;
    }

    public synchronized void withdraw(double amount)
    {
        balance -= amount;
    }

}
