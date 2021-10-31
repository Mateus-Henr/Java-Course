package tutorial.first;

// A deadlock occurs when two or more threads are blocked on locks and every thread that's blocked is holding
// a lock that another blocked thread wants.
// Thread1, holding lock1 and waiting to acquire lock2, but thread2 is holding lock2 and waiting to acquire lock1.
// As they are blocked they'll never release the lock, therefore they will never run.

// Solutions
// Use just one object for locking.
// Make the threads obtain the lock in the same order, so they would wait for each other, like a queue to the cashier.
public class Main
{
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args)
    {
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread
    {
        @Override
        public void run()
        {
            synchronized (lock1)
            {
                System.out.println("Thread 1: Has lock1.");
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {

                }
                System.out.println("Thread 1: Waiting for lock2.");
                synchronized (lock2)
                {
                    System.out.println("Thread 1: Has lock1 and lock2.");
                }
                System.out.println("Thread 1: Released lock2.");
            }
            System.out.println("Thread 1: Released lock1. Exiting...");
        }

    }

    private static class Thread2 extends Thread
    {
        @Override
        public void run()
        {
            synchronized (lock2)
            {
                System.out.println("Thread 2: Has lock2.");
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {

                }
                System.out.println("Thread 2: Waiting for lock1.");
                synchronized (lock1) // Can't obtain the lock because thread1 has it.
                {
                    System.out.println("Thread 2: Has lock2 and lock1.");
                }
                System.out.println("Thread 2: Released lock1.");
            }
            System.out.println("Thread 2: Released lock2. Exiting...");
        }

    }

}
