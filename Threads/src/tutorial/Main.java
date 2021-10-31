package tutorial;

import static tutorial.ThreadColor.ANSI_GREEN;
import static tutorial.ThreadColor.ANSI_RED;

//  A process is a unit of execution that has its own memory space.
//  Each instance of a Java Virtual Machine (JVM) runas a process.
//  When we run a Java console app we're kicking off a process.
//
//  When we run an app it has its own memory space that's called the "heap".
//  Each one has its own "heap" and cannot be accessed by other apps.
//
//  Thread is a unit of execution within a process. In Java, every process (or app) has at least one thread.
//  Within these process there are multiple threads, but we don't deal with them.
//  Each thread has what's called a thread stack, which is the memory that only that thread can access.
//  They're used to break a program into multiple codes that can execute at the same time
//  (Concurrency - "An app doing more than one thing at a time").
//  Concurrency means that one task doesn't have to complete before another can start.
//  So, every Java application runs a single process, and each process can have multiple threads.
//  Every process has a heap, and every thread has a thread stack.

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread.");

        // ------------------------------------------- Using a class ---------------------------------------------------
        AnotherThread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();
//        If we use the "run()" method it'll be executed by the current thread, in this case the main Thread.
//        anotherThread.run();
//        anotherThread.start(); Throws an exception.

        // ----------------------------------------- Using an anonymous class ------------------------------------------
        new Thread()
        {
            @Override
            public void run()
            {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread.");
            }
        }.start();

        // ------------------------------------ Using the Runnable class -----------------------------------------------
//        Thread myRunnableThread = new Thread(new MyRunnable());
//        myRunnableThread.start();

        // ------------------------------------ Using a anonymous runnable ---------------------------------------------
        Thread myRunnableThread = new Thread(new MyRunnable()
        {
            @Override
            public void run() // A Thread will terminate after executing its "run" method.
            {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
                try
                {
                    // When we join a thread to another thread what happens is the first
                    // thread will wait for the second thread to terminate and then it'll continue to execute.
                    // We can pass a timeout value to the join method, but the timeout will only count if the
                    // thread takes more than the timeout time.
                    // anotherThread.join(2000); // Here it'll timeout if the anotherThread takes more than 2s.
                    anotherThread.join();
                    System.out.println(ANSI_RED + "AnotherThread terminated, or timed out, so I'm running again");
                } catch (InterruptedException e)
                {
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted.");
                }
            }
        });

        myRunnableThread.start();


        // anotherThread.interrupt();

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread.");
    }

}
// There's no guarantee that threads are going to run the way that you want even if you have given them a higher priority.
// If you want to run the same code multiple times you need to create multiple instances of the class.
