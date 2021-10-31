package myImplementation;

public class Main
{
    public static void main(String[] args)
    {
        myArrayList<String> listOfIntegers = new myArrayList<>();

        listOfIntegers.add("Hey");
        listOfIntegers.add("Hey2");
        listOfIntegers.add("Hey2");
        listOfIntegers.add("Hey3");
        listOfIntegers.add("Hey2");
        listOfIntegers.add("Hey2");

        listOfIntegers.remove("Hey2");

        listOfIntegers.getAll();
    }

}


class myArrayList<E>
{

    private Object[] array;
    private int lastPosition = 0;
    private int currentLength = 1;

    public myArrayList()
    {
        array = new Object[currentLength];
    }

    public void getAll()
    {
        for (int i = 0; i < currentLength; i++)
        {
            System.out.println("Element " + i + ": " + array[i]);
        }
    }

    public Object get(int i)
    {
        return array[i];
    }

    public void add(Object value)
    {
        if (array[0] == null)
        {
            array[0] = value;
        } else
        {
            currentLength++;
            int maxIndex = currentLength - 1;
            Object[] newArray = new Object[currentLength]; // 2

            for (int i = 0; i < maxIndex; i++)
            {
                newArray[i] = array[i];
            }

            newArray[maxIndex] = value;
            array = newArray.clone();
        }
    }

    public void remove(Object value)
    {
        for (int i = 0; i < currentLength; i++)
        {
            if (array[i] instanceof Object)
            {
                if (array[i].equals(value))
                {
                    array[i] = null;
                    break;
                }
            }
        }

        int control = 0;
        Object[] newArray = new Object[currentLength - 1];
        for (int i = 0; i < currentLength; i++)
        {
            if (array[i] != null)
            {
                newArray[control] = array[i];
                control++;
            }
        }
        array = null;
        array = newArray.clone();
        currentLength--;
    }

}
