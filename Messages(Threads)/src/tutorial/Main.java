package tutorial;

import java.util.Random;

// ArrayList is not thread safe.
// A critical section is a part of the code that accesses the same data through different threads.
// We use the synchronized keyword to mark critical sections.
// We can use it to mark methods (also called synchronized methods)
// or even smaller portions of code (synchronized statements).

// A monitor is something a thread can grab and hold, preventing all other threads from grabbing that same
// monitor and forcing them to wait until the monitor is released. This is what a synchronized block does.

// A monitor is a synchronization mechanism that allows threads to have:
// Mutual exclusion – only one thread can execute the method at a certain point in time, using locks
// Cooperation – the ability to make threads wait for certain conditions to be met, using wait-set
public class Main
{
    public static void main(String[] args)
    {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
        // Each thread waits and releases its lock on the Message object.
    }

}

class Message
{
    private String message;
    private boolean empty = true;

    // Using synchronized to allow just one access.
    // We'll get the "IllegalMonitorStateException" exception if we call one of the wait(), notify(), or notifyAll()
    // methods of the Object class outside of a synchronized block.
    public synchronized String read() // Used by the consumer to read the message.
    {
        while (empty)
        {
            try
            {
                wait();
            } catch (InterruptedException e)
            {

            }

        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) // Used by the produce to write the message.
    {
        // Generally we call wait within a loop.
        // Never assumes that a thread has been woken up because it's condition has changed.
        // (Reason why not to use conditions)
        while (!empty)
        {
            try
            {
                wait();
            } catch (InterruptedException e)
            {

            }

        }
        empty = false;
        this.message = message;
        notifyAll(); // We can't notify a specific thread, so we notify all of them.
    }

}

class Writer implements Runnable
{
    private Message message;

    public Writer(Message message)
    {
        this.message = message;
    }

    @Override
    public void run()
    {
        String[] messages = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again."
        };

        Random random = new Random();

        for (int i = 0; i < messages.length; i++)
        {
            message.write(messages[i]);
            try
            {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e)
            {

            }
        }
        message.write("Finished");
    }

}

class Reader implements Runnable
{
    private Message message;

    public Reader(Message message)
    {
        this.message = message;
    }

    @Override
    public void run()
    {
        Random random = new Random();
        for (String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read())
        {
            System.out.println(latestMessage);
            try
            {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e)
            {

            }
        }
    }

}