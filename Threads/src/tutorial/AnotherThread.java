package tutorial;

import static tutorial.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread
{
    @Override
    public void run()
    {
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());

        try
        {
            Thread.sleep(3000); // It's never guaranteed that the thread will sleep.
        } catch (InterruptedException e) // It occurs if the thread is interrupted.
        // We can only interrupt a thread through its instance.
        {
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            return;
        }

        System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake.");
    }

}
