package tutorial.third;

// Every class in Java has a unique lock which is nothing but class level lock.
// If a thread wants to execute a static synchronized method, then the thread requires a class level lock.
// Class level lock prevents multiple threads to enter a synchronized block in any of
// all available instances of the class on runtime. This means if in runtime there are 10 instances of a class,
// only one thread will be able to access only one method or block of any one instance at a time.
// It is used if you want to protect static data.

// "Critical section" term - Parts of the code where just one thread at a time can execute.
// "Thread safe" term - When the developer has synchronized all the critical sections within the code.

// When synchronizing code we must synchronize code that needs to be synchronized (as minimum as possible), since
// it might affect the performance of the app.
public class Main
{
    public static void main(String[] args)
    {
        Countdown countdown = new Countdown();

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

        synchronized (this)
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
