package challenge.fifth;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount
{
    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance)
    {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

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
        try
        {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS))
            {
                try
                {
                    balance += amount;
                } finally
                { // Using this way is more advantageous once we are unlocking it only if it's managed to get the lock.
                    lock.unlock();
                }
            }
            else
            {
                System.out.println("Could not get the lock.");
            }
        } catch (InterruptedException e)
        {
            // Happens if the method throws an exception.
        }
    }

    public void withdraw(double amount)
    {
        try
        {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS))
            {
                try
                {
                    balance -= amount;
                } finally
                {
                    lock.unlock();
                }
            }
            else
            {
                System.out.println("Could not get the lock.");
            }
        } catch (InterruptedException e)
        {
            // Happens if the method throws an exception.
        }
    }

    public void printAccountNumber()
    {
        System.out.println("Account number = " + accountNumber);
    }

}