package challenge.fourth;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount
{
    private double balance;
    private String accountNumber;
    private Lock lock; // We can use the interface "Lock"

    public BankAccount(String accountNumber, double initialBalance)
    {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock(); // We don't actually need to pass the lock through parameters.
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
        lock.lock();
        try // Always use "try/finally" block.
        {
            balance += amount;
        } finally
        {
            lock.unlock();
        }
    }

    public void withdraw(double amount)
    {
        lock.lock();
        try
        {
            balance -= amount;
        } finally
        {
            lock.unlock();
        }
    }

    public void printAccountNumber()
    {
        System.out.println("Account number = " + accountNumber);
    }

}
//  Points to consider when using locks
//  1 - Both threads need to compete for the same lock,So we create only one lock
//  object that we use in all the methods that have critical sections of code.
//
//  2 - We put the critical section of code within a try/finally block,to ensure that the
//  lock will be released.
//
//  Don't forget to create the lock instance in the BankAccount constructor.