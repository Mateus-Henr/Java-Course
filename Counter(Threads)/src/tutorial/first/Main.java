package tutorial.first;

public class Main
{
    public static void main(String[] args)
    {
        Countdown countdown = new Countdown(); // By using two objects there would be no interference

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }

}

class Countdown
{
    // Heap is the application memory that all threads share and each thread has its memory (accessible just for itself).
    // Local variables are stored at the thread stack, so each thread has its own copy of a local variable.
    // In contrast, the memory required to store an object instance is allocated in the heap, in other words when
    // multiple threads are working with the same object they share the same object. So if one thread modifies the value,
    // the other thread sees that value from one point forward.
    private int i;

    public void doCountdown()
    {
        String color;

        switch (Thread.currentThread().getName())
        {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        // if "i" were defined here, the countdown wouldn't have the problem of "shared access".
        for (i = 10; i > 0; i--) // In this for there are multiple points where the current thread could be suspended.
        {
            System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
        }
    }

}

class CountdownThread extends Thread
{
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown)
    {
        this.threadCountdown = countdown;
    }

    @Override
    public void run()
    {
        this.threadCountdown.doCountdown();
    }

}
