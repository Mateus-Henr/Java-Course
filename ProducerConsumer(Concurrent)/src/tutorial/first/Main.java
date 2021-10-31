package tutorial.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static tutorial.first.Main.EOF;

public class Main
{
    public static final String EOF = "EOF";

    public static void main(String[] args)
    {
        List<String> buffer = new ArrayList<>();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        (new Thread(producer)).start();
        (new Thread(consumer1)).start();
        (new Thread(consumer2)).start();
    }

}

// The producer sleeps after adding the string to give the consumer the change of removing the string.
// Even though is synchronized you can't manage which consumer is going to access the class.
// So 1 consumer can run twice, before the other consumer runs, for example.

// Problems: (Can be solved by using the "ReentrantLock" class)
// 1 - Once a thread is blocked in the "synchronized" you cannot delete it.
// 2 - The "synchronized block" must be in the same method, we can't start the "synchronized" block in one method and
// end it in other.
// 3 - We cannot find out if an object intrinsic lock is available or any other information about that lock.
// 4 - If the lock isn't available, we cannot timeout after waiting for that lock for a while.
// 5 - If multiple threads are waiting for a lock you cannot control the order of which thread is going to execute
// the lock first.
class MyProducer implements Runnable
{
    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color)
    {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run()
    {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums)
        {
            try
            {
                System.out.println(color + "Adding...." + num);
                synchronized (buffer)
                {
                    buffer.add(num);
                }

                Thread.sleep(random.nextInt((1000)));
            } catch (InterruptedException e)
            {
                System.out.println("Producer was interrupted.");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        synchronized (buffer)
        {
            buffer.add("EOF");
        }
    }

}

class MyConsumer implements Runnable
{
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color)
    {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run()
    {
        while (true)
        {
            // Because of the "continue" when it loops back the code releases the lock, since
            // it leaves the "synchronized" block
            synchronized (buffer)
            {
                if (buffer.isEmpty()) // With two consumers we can run into problems here.
                {
                    continue;
                    // consumer1 can be empty and consumer2 not, then they can mix up the operations.
                    // Like if consumer1 is not empty and consumer2 calls the get method.
                    // Another problem is if both consumers try to remove the same string (ArrayList is not Concurrent)
                }

                if (buffer.get(0).equals(EOF))
                {
                    System.out.println(color + "Exiting...");
                    break;
                }
                else
                {
                    // This code throws an "IndexOutOfBounds" exception if running in Java 8 and without "synchronized".
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            }
        }
    }

}
