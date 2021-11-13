package challenge.first;

public class Main
{
    public static void main(String[] args)
    {
        // Non-lambda version
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part : parts)
                {
                    System.out.println(part);
                }
            }
        };

        // Lambda version
        // It doesn't map to any functions in the Function package, since it doesn't take any arguments and doesn't
        // return a value (otherwise it would map).
        Runnable runnable1 = () ->
        {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts)
            {
                System.out.println(part);
            }
        };

        new Thread(runnable).start();
        new Thread(runnable1).start();
    }

}
