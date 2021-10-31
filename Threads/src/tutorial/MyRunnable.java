package tutorial;

import static tutorial.ThreadColor.ANSI_RED;

// Runnable is more flexible.
public class MyRunnable implements Runnable
{
    @Override
    public void run()
    {
        System.out.println(ANSI_RED + "Hello from MyRunnable's implementation of run()");
    }

}
