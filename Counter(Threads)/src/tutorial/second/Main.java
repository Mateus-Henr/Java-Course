package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        // Synchronization is to control the threads access to the heap.
        // When a method is synchronized only one thread can execute that at a time.
        // Other threads are suspended until the first thread finishes the method execution.
        // When working with threads it's important to synchronize all the areas that an interference might happen.
        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }

}

// Other way to prevent this "race condition" is to synchronize block of statements rather than the entire method.
// Every Java object has its "intrinsic lock" and we can use this lock to allow just one thread to execute the object.
// Primitive types don't have intrinsic locks.
// When using a local object variable the object's reference is stored in the thread stack, but the object values
// are store on the heap.
// Since the threads will each create their own copy of the object so the object references will then be different
// they will be no interference even though the object values are on the heap.

class Countdown
{
    private int i;

    // We can't synchronize constructors. Only one thread can construct an instance and
    // until the constructor has finished executing the instance won't be available for other threads to use.
    public void doCountdown() // By using synchronized here, we don't have thread interference.
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

        synchronized (this)
        // Local variable will be stored in the thread stack, each thread will have its own
        // version of it and its copy is an object that has its own lock.
        // We need to use objects that both threads can share, so it CAN NEVER be a local variable.
        {
            for (i = 10; i > 0; i--)
            {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
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
