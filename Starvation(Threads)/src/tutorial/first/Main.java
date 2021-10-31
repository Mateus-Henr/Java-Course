package tutorial.first;

import tutorial.ThreadColor;

// Thread Starvation
// FIFS - First In First Served.
// Often occurs due to threads priority.
// It's when a thread doesn't have a chance to progress.
// In other words they can't execute in circles in a way that they don't "waste" time.
// Generally because synchronized blocks aren't FIFS it can result in starvation.
// When it threads get to run when a lock gets available that's important here.
public class Main
{
    // The lock object is static so there's only one instance of this object.
    // All the threads will be competing for this instance's lock.
    // The lock will be frequently released once we are not synchronizing the entire loop.
    private static Object lock = new Object();

    public static void main(String[] args)
    {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        t1.setPriority(10); // Just a suggestion, we can't force the OS to run threads in a specific order.
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        // The result might depend on timing and the order that you're executing the threads.
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
                synchronized (lock)
                {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // Execute critical section of code
                }
            }
        }

    }

}
