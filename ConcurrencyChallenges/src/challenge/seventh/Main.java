package challenge.seventh;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Example of a Livelock
// Because the two threads aren't blocked, but they can't progress. They keep on a loop of operations.

// What was happening
//  1. Thread Transfer1 calls transfer() to transfer money from account1 to account2.
//  2. Transfer1 gets account1's lock (when the transfer() method calls the withdraw() method)
//  and withdraws the money to be transferred from account 1.
//  3. Thread Transfer2 calls transfer() to transfer money from account2 to account1.
//  4. Transfer2 gets account2's lock and withdraws the money to be transferred from account2.
//  5. Transfer1 calls account2's deposit() method, but Transfer2 is holding the lock, so the transfer fails.
//  It refunds the money back into account1 (it's still holding the lock) and loops back.
//  6. Transfer2 calls account1 's deposit() method, but Transfer1 is holding the lock,
//  so the transfer fails. It refunds the money back into account2 (it's still holding the lock) and loops back.
//  7. Since Transfer1 and Transfer2 never release the locks they're holding, they'll keep looping until we
//  terminate the application.
public class Main
{
    public static void main(String[] args)
    {
        BankAccount account1 = new BankAccount("12345-678", 500.00);
        BankAccount account2 = new BankAccount("98765-432", 1000.00);

        new Thread(new Transfer(account1, account2, 10.00), "Transfer1").start();
        new Thread(new Transfer(account2, account1, 55.88), "Transfer2").start();
    }

}

class BankAccount
{
    private double balance;
    private String accountNumber;
    private Lock lock = new ReentrantLock();

    BankAccount(String accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(double amount)
    {
        if (lock.tryLock()) // The first transfer was holding the lock, so the second transfer couldn't access it.
        {
            try
            {
                try
                {
                    // Simulate database access
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                }

                balance -= amount;
                System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
                return true;
            } finally
            {
                lock.unlock();
            }
        }

        return false;
    }

    public boolean deposit(double amount)
    {
        if (lock.tryLock())
        {
            try
            {
                try
                {
                    // Simulate database access
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                }

                balance += amount;
                System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
                return true;
            } finally
            {
                lock.unlock();
            }
        }

        return false;
    }

    public boolean transfer(BankAccount destinationAccount, double amount)
    {
        if (withdraw(amount))
        {
            if (destinationAccount.deposit(amount))
            {
                return true;
            }
            else
            {
                // The deposit failed. Refund the money back into the account.
                System.out.printf("%s: Destination account busy. Refunding money\n", Thread.currentThread().getName());
                deposit(amount);
            }
        }

        return false;
    }

}

class Transfer implements Runnable
{
    private BankAccount sourceAccount, destinationAccount;
    private double amount;

    Transfer(BankAccount sourceAccount, BankAccount destinationAccount, double amount)
    {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public void run()
    {
        while (!sourceAccount.transfer(destinationAccount, amount))
            continue;
        System.out.printf("%s completed\n", Thread.currentThread().getName());
    }

}
