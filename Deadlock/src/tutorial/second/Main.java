package tutorial.second;

public class Main
{
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args)
    {
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread
    {
        @Override
        public void run()
        {
            synchronized (lock1)
            {
                System.out.println("Thread 1: Has lock1.");
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {

                }
                System.out.println("Thread 1: Waiting for lock2.");
                synchronized (lock2)
                {
                    System.out.println("Thread 1: Has lock1 and lock2.");
                }
                System.out.println("Thread 1: Released lock2.");
            }
            System.out.println("Thread 1: Released lock1. Exiting...");
        }

    }

    private static class Thread2 extends Thread
    {
        @Override
        public void run()
        {
            // Now the locks are in both threads are in the same order, so avoiding a deadlock.
            // As one lock is inside the other, the other thread only executes when the other finishes.
            synchronized (lock1)
            {
                System.out.println("Thread 2: Has lock1.");
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {

                }
                System.out.println("Thread 2: Waiting for lock2.");
                synchronized (lock2)
                {
                    System.out.println("Thread 2: Has lock1 and lock2.");
                }
                System.out.println("Thread 2: Released lock2.");
            }
            System.out.println("Thread 2: Released lock1. Exiting...");
        }

    }

}

// Another way that deadlocks can occur:
// Let's suppose that we have two classes that contain synchronized methods, and each class calls a method
// in the other class.

// Synchronized method - When a thread is running an object's synchronized method, no other thread can run a
// synchronized method using the same object, until the first thread exits the methods that it's running.

// It might happen when you've got two classes with two synchronized methods, in which one class calls the other's
// method. Like a thread is executing a synchronized method in the display class and this synchronized method, calls
// another synchronized method, but now in the data class. However another thread is already executing another
// synchronized method inside the data class that calls another synchronized method in the display class.
// Summing up, thread2 has the lock of the data object and waiting for the display's object lock, however thread1 is
// doing the opposite, it has the lock of the display object and it's waiting for the lock of the data object.
// Both objets' locks are only released when each thread obtains the lock of the other and finishes executing the code
// that requires both locks.