package challenge.third;

public class BankAccount
{
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance)
    {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // When reading values thread interference isn't an issue.
    // Would be bad synchronizing these methods that get a value once it prejudices performance.
    public double getBalance()
    {
        return balance;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void deposit(double amount)
    {
        synchronized (this)
        {
            balance += amount;
        }
    }

    public void withdraw(double amount)
    {
        synchronized (this)
        {
            balance -= amount;
        }
    }

    public void printAccountNumber()
    {
        System.out.println("Account number = " + accountNumber);
    }

}
