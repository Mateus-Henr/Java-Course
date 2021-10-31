package challenge.sixth;

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
        boolean status = false; // Since this is a local variable then it's thread safe.
        // Local variables are stored on the thread stack, so each thread will have ITS OWN COPY.
        try
        {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS))
            {
                try
                {
                    balance += amount;
                    status = true;
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

        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount)
    {
        boolean status = false;

        try
        {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS))
            {
                try
                {
                    balance -= amount;
                    status = true;
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

        System.out.println("Transaction status = " + status);
    }

    public void printAccountNumber()
    {
        System.out.println("Account number = " + accountNumber);
    }

}