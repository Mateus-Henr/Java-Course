package challenge.myOwn;

public class MyTest
{
    public static boolean hasExecuted = false;

    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("While Loop");
        int count = 0;
        while (count < 10)
        {
            hasExecuted = false;
            Thread thread = new Thread(new MyThread());
            thread.start();

            if (!hasExecuted)
            {
                thread.join();
            }

            System.out.println("Counter now: " + count);
            count++;
        }

        System.out.println("For loop");
        for (count = 0; count < 10; count++)
        {
            hasExecuted = false;
            Thread thread = new Thread(new MyThread());
            thread.start();

            if (!hasExecuted)
            {
                thread.join();
            }

            System.out.println("Counter now: " + count);
        }
    }
// It may not be a good idea to use "continue" with threads because you'd need to keep a loop alive, meaning
// a possible waste of memory.
}

class MyThread extends Thread
{
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(1000);
            MyTest.hasExecuted = true;
        }
        catch (InterruptedException e)
        {
            System.out.println("InterruptedException: " + e.getMessage());
        }
    }

}
