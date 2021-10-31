package tutorial;

public class Worker
{
    private String name;
    private boolean active;

    public Worker(String name, boolean active)
    {
        this.name = name;
        this.active = active;
    }

    public String getName()
    {
        return name;
    }

    public boolean isActive()
    {
        return active;
    }

    public synchronized void work(SharedResource sharedResource, Worker otherWorker)
    {
        while (active)
        {
            if (sharedResource.getOwner() != this) // Sees if it owns the sharedResource.
            {
                try
                {
                    wait(10);
                } catch (InterruptedException e)
                {

                }
                continue;
            }
            // This thread will only complete the iteration is when it owns the shared resource and the other
            // thread isn't active.
            if (otherWorker.isActive())
            {
                System.out.println(getName() + " : Give the resource to the worker " + otherWorker.getName());
                sharedResource.setOwner(otherWorker);
                continue;
            }

            // Never arrives here.
            System.out.println(getName() + ": Working on the common resource");
            active = false;
            sharedResource.setOwner(otherWorker);
        }
    }

}
