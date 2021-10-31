package tutorial.first;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        // ArrayList items = new ArrayList(); // It's useful when you want to dissect an object into different types.
        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add(3);
        // items.add("tim"); // Error just appears at runtime if no parameterized type is defined.
        items.add(4);
        items.add(5);

        printDoubled(items);
    }

    private static void printDoubled(ArrayList<Integer> n)
    {
//        for (Object i : n)
//        {
//            if (i instanceof Integer) // My implementation
//            {
//                System.out.println((Integer) i * 2); // Casting since we're using "Object"
//            }
//        }

        for (int i : n)
        {
            System.out.println(i * 2);
        }
    }

    // Parameterized type - When you use the <> (diamond) and inside it the Object type willed.
}
