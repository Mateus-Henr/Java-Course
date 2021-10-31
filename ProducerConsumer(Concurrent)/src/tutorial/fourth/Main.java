package tutorial.fourth;

import java.util.Random;
import java.util.concurrent.*;

import static tutorial.first.Main.EOF;

// An ArrayBlockingQueue is a BlockingQueue backed by an array.
// What happens is that if the queue is full then any thread trying to
// queue in a new task is "blocked" until some other thread dequeues an element from the array.
public class Main
{
    public static final String EOF = "EOF";

    public static void main(String[] args)
    {
        // This array manages a queue FIFO (First In, First Out).
        // Does the work of the lock. Needs to have a capacity.
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(5);


        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

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
            System.out.println(future.get());
        } catch (ExecutionException e)
        {
            System.out.println("Something went wrong");
        } catch (InterruptedException e)
        {
            System.out.println("Thread running the task was interrupted.");
        }

        executorService.shutdown();
    }

}

class MyProducer implements Runnable
{
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color)
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
                buffer.put(num);

                Thread.sleep(random.nextInt((1000)));
            } catch (InterruptedException e)
            {
                System.out.println("Producer was interrupted.");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        try
        {
            // We are using "put" because if we were using "add" and the task might not be performed immediately, so
            // it'd throw an exception (Because another thread got the queue locked). The "put" and "take" will block
            // when the queue is locked.
            buffer.put("EOF"); // Thread safe method
        } catch (InterruptedException e)
        {
        }
    }

}

class MyConsumer implements Runnable
{
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color)
    {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run()
    {
        while (true)
        {
            synchronized (buffer)
            {
                try
                {
                    if (buffer.isEmpty())
                    {
                        continue;
                    }

                    // The two consumers see the element, but they "crash" with each other.
                    // Peek returns the next element on the queue, but can be executed by the two threads.
                    // Consequently, synchronized is necessary.
                    if (buffer.peek().equals(EOF)) //
                    {
                        System.out.println(color + "Exiting...");
                        break;
                    }
                    else
                    {
                        System.out.println(color + "Removed " + buffer.take()); // FIFO
                    }
                } catch (InterruptedException e)
                {

                }
            }
        }

    }

}
