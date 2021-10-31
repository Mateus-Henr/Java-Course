package tutorial.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static tutorial.first.Main.EOF;

// The "ExecutorService" implementation manages threads for us, it optimizes the creation of threads and etc.
// Thread pools is a a managed set of threads. It can limit the number of threads that are active, etc.
// Sometimes the "ExecutorService" won't be able to perform a task straight away, because the limit has been reached.
// Meaning that will only have a certain number of threads available to process tasks at any one time.
// If there are more than the limit the other threads will wait in the queue.
public class Main
{
    public static final String EOF = "EOF";

    public static void main(String[] args)
    {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        // 2 consumers and 1 producer.
        ExecutorService executorService = Executors.newFixedThreadPool(5);


        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        // By allowing just three threads this Callable code will wait until a thread finishes its execution.
        // When we want to receive a value back from a thread we can use the "submit" method.
        Future<String> future = executorService.submit(new Callable<String>()
        {
            @Override
            public String call() throws Exception
            {
                System.out.println(ThreadColor.ANSI_WHITE + "I'm being printed from the Callable class.");
                return "This is the Callable result.";
            }
        });

        try
        {
            System.out.println(future.get()); // This call blocks until the result is available.
        } catch (ExecutionException e)
        {
            System.out.println("Something went wrong");
        } catch (InterruptedException e)
        {
            System.out.println("Thread running the task was interrupted.");
        }

        // We've got to shut down the "ExecutorService", if we don't shut it down the application doesn't terminate.
        // When shutdown is called it wait for any executing tasks to terminate, before really shutting it down.
        executorService.shutdown();
        // Can use shutdownNow() to finish immediately.
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
                bufferLock.lock();
                // By using try/catch we can use unlock just once. (if an exception happens we liberate the lock)
                // Ideal way of using locks.
                try
                {
                    buffer.add(num);
                } finally // Always execute
                {
                    bufferLock.unlock();
                }

                Thread.sleep(random.nextInt((1000)));
            } catch (InterruptedException e)
            {
                System.out.println("Producer was interrupted.");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        try
        {
            buffer.add("EOF");
        } finally
        {
            bufferLock.unlock();
        }
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

    // "getQueueLength()" method can be used to detect the number of threads waiting for a lock.
    // OBS: When we try to release a lock that we don't own we get a "IllegalMonitorState" exception.
    @Override
    public void run()
    {
        int counter = 0;
        while (true)
        {
            // When using "tryLock()" we can set a timeout period, so if a thread is still waiting for the lock when the
            // timeout expires it's interrupted. Ex: tryLock(2000, TimeUnit.MILLISECONDS)
            if (bufferLock.tryLock()) // A thread will see if the lock is available, if so it acquires the lock.
            {
                try
                {
                    if (buffer.isEmpty())
                    {
                        // bufferLock.unlock(); Throws exception, explained above.
                        continue;
                    }

                    System.out.println(color + "The counter = " + counter);
                    counter = 0;

                    if (buffer.get(0).equals(EOF))
                    {
                        System.out.println(color + "Exiting...");
                        break;
                    }
                    else
                    {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally
                {
                    bufferLock.unlock();
                }
            }
            else
            {
                counter++;
            }
        }
    }

}
