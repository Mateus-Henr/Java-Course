package tutorial;

import java.util.ArrayList;

class IntClass
{
    private int myValue;

    public IntClass(int myValue)
    {
        this.myValue = myValue;
    }

    public int getMyValue()
    {
        return myValue;
    }

    public void setMyValue(int myValue)
    {
        this.myValue = myValue;
    }

}

public class Main
{
    @Deprecated
    public static void main(String[] args)
    {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<>();
        strArrayList.add("Tim");

        // ArrayList<int> intArrayList = new ArrayList<int>();
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));
        Integer integer = new Integer(54);
        Double doubleValue = new Double(12.25);

        ArrayList<Integer> intArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            intArrayList.add(Integer.valueOf(i)); // Autoboxing -> Converting from a primitive class to a class.
        }

        for (int i = 0; i < 10; i++)
        {
            System.out.println(i + " --> " + intArrayList.get(i).intValue()); // Unboxing -> Converting from a class to a primitive type.
        }

        Integer myIntValue = 56; // Under the hood the code executed is Integer.valueOf(56);
        int myInt = myIntValue; // Under the hood the code executed is myInt.intValue();


        ArrayList<Double> myDoubleValues = new ArrayList<>();

        // Autoboxing
        System.out.println("\nAutoboxing");
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
            myDoubleValues.add(Double.valueOf(dbl));
        }

        // Unboxing
        System.out.println("\nUnboxing");
        for (int i = 0; i < myDoubleValues.size(); i++) {
            double value = myDoubleValues.get(i).doubleValue(); // OR myDoubleValues.get(i)
            System.out.println(i + " --> " + value);
        }
    }

}

