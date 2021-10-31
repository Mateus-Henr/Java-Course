package tutorial;

public class Main
{
    public static void main(String[] args)
    {
        final PolitePerson jane = new PolitePerson("Jane");
        final PolitePerson john = new PolitePerson("John");

        // By using two threads it deadlocks, they can't say "Hello back".
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                jane.sayHello(john);
            }
        }).start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                john.sayHello(jane);
            }
        }).start();

        // What happens for the deadlock to happen
        // 1. Thread1 acquires the lock on the jane object and enters the sayHello() method.
        // It prints to the console, then suspends.
        //
        // 2. Thread2 acquires the lock on the john object and enters the sayHello() method.
        // It prints to the console, then suspends.
        //
        // 3. Thread1 runs again and wants to say hello back to the john object.
        // It tries to call the sayHelloBack() method using the john object that was passed into the sayHello() method,
        // but Thread2 is holding the john lock, so Thread1 suspends.
        //
        // 4. Thread2 runs again and wants to say hello back to the jane object.
        // It tries to call the sayHelloBack() method using the jane object that was passed into the sayHello() method,
        // but Thread1 is holding the jane lock, so Thread2 suspends.


//        As the code is executing in the same thread (main), there's no deadlock.
//        jane.sayHello(john);
//        john.sayHello(jane);
    }

    static class PolitePerson
    {
        private final String name;

        public PolitePerson(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return name;
        }

        // We want to maintain a conversation order.
        public synchronized void sayHello(PolitePerson person) // It's not FIFO
        {
            // By using this there's a higher probability of a deadlock.
            System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName()); // Similar to Python
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person)
        {
            System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
        }

    }

}
