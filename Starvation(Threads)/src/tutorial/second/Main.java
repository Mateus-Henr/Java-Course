package tutorial.second;

import tutorial.ThreadColor;

import java.util.concurrent.locks.ReentrantLock;

// Fair Locks
// FIFS - First In First Served.
// Fair locks try to be fair in the FIFS.
// Not all locks do it.
// They substitute the synchronized block.
public class Main
{
    // It impacts performance to apply fairness.
    // Only fairness in acquiring the lock is guaranteed (FIFS), not fairness in thread scheduling. So it's possible that
    // the thread that gets the lock will execute a task that takes a long time, making the others wait.
    // The tryLock method doesn't have the fairness setting, so it'll not be FIFS.
    private static ReentrantLock lock = new ReentrantLock(true); // If it's true is a fair lock.

    public static void main(String[] args)
    {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static class Worker implements Runnable
    {
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor)
        {
            this.threadColor = threadColor;
        }

        @Override
        public void run()
        {
            for (int i = 0; i < 100; i++)
            {
                lock.lock();
                try
                {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                } finally
                {
                    lock.unlock();
                }
            }
        }

    }

}