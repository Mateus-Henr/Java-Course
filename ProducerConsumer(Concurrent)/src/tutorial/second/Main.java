package tutorial.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static tutorial.first.Main.EOF;

public class Main
{
    public static final String EOF = "EOF";

    public static void main(String[] args)
    {
        List<String> buffer = new ArrayList<>();
        // If a thread is already holding a reentrant lock when it reaches the code that requires the lock
        // it executes the code (it doesn't need to obtain it again)
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        (new Thread(producer)).start();
        (new Thread(consumer1)).start();
        (new Thread(consumer2)).start();
    }

}

class MyProducer implements Runnable
{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock)
    {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
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
                bufferLock.lock(); // Just one thread can have the lock, the others will be suspended.
                buffer.add(num);
                bufferLock.unlock();

                Thread.sleep(random.nextInt((1000)));
            } catch (InterruptedException e)
            {
                System.out.println("Producer was interrupted.");
            }
        }

        // When using "synchronized" block, the lock is released when the thread holding the lock exits the block.
        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock(); // Used to avoid thread interference, similar to the "synchronized" block.
        buffer.add("EOF");
        bufferLock.unlock(); // As you can see we're responsible for releasing the lock.
    }

}

class MyConsumer implements Runnable
{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock)
    {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run()
    {
        while (true)
        {
            // We never release the lock once the code loops back to the beginning.
            // So it throws an exception saying that it reached the maximum count of locks that a thread can have.
            // As it loops back here because of the "continue", the thread acquires the lock several times and even
            // if we liberate one of them wouldn't be enough.
            bufferLock.lock();
            if (buffer.isEmpty())
            {
                bufferLock.unlock(); // If this code weren't here the errors above would happen.
                continue;
            }

            if (buffer.get(0).equals(EOF))
            {
                System.out.println(color + "Exiting...");
                bufferLock.unlock(); // If this code weren't here the app wouldn't stop because the lock wasn't released.
                break;
            }
            else
            {
                System.out.println(color + "Removed " + buffer.remove(0));
            }
            bufferLock.unlock();
        }
    }

}

//    A thread can acquire the same lock multiple times. However when a thread acquires the same lock multiple times
//    you've got to liberate the lock the same amount of times.

//    ReentrantLock lock1;
//
//    public void MethodA()
//    {
//        lock1.lock();
//        methodB();
//        [more code]
//        lock1.unlock();
//    }
//
//    public void MethodB()
//    {
//        [more code]
//        lock1.lock();
//        [more code]
//        lock1.unlock();
//        [more code]
//    }
