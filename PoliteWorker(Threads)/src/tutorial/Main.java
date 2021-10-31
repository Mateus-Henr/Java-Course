package tutorial;

// Live Lock
// When the threads are active and waiting for the other threads to complete their tasks.
// As they've been waiting for others to complete they can't progress.
public class Main
{
    public static void main(String[] args)
    {
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);

        final SharedResource sharedResource = new SharedResource(worker1);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                worker1.work(sharedResource, worker2);
            }
        }).start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                worker2.work(sharedResource, worker1);
            }
        }).start();

    }

}

// Slipped condition (specific type of race condition)
// It can occur when a thread can be suspended between reading a condition and acting on it.
// Let's say that we have two threads reading from a buffer. Each thread does the following:
// 1 - Check the status.
// 2 - If it's OK, reads data from the buffer.
// 3 - If the data is EOF, it sets the status to EOF and terminates. If the data isn't EOF, it sets the status to OK.

// If it's not synchronized properly the following can happen:
// 1 - Thread1 checks the status and gets OK. It suspends.
// 2 - Thread2 checks the status and gets OK. It reads EOF from the buffer and sets the status to EOF, then terminates.
// 3 - Thread1 runs again, it tries to read data from the buffer, but there's no data. It throws an exception
// (NullPointer) or crashes.

// Because the threads can interfere with each other when checking and setting the condition, Thread1 tried to do
// something based on obsolete information (when it checked the status, it was OK)
// But by the time it acted upon the condition it checked, the status had been updated by Thread2. As Thread1 doesn't
// see the updated information, it does something erroneous.

// To solve it you can use synchronized blocks or locks to synchronize the critical section of the code.

// When using multiple locks, the order in which the locks can be acquired can also result in a slipped condition.