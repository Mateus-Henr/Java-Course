package tutorial.second;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Demo
{
    public static void main(String[] args)
    {
        LinkedList<String> placesToVisit = new LinkedList<>();
        placesToVisit.add("Sydney");
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Canberra");
        placesToVisit.add("Adelaide");
        placesToVisit.add("Darwin");

        printList(placesToVisit);

        placesToVisit.add(1, "Alice Springs");
        printList(placesToVisit);

        placesToVisit.remove(4);
        printList(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList)
    {
        Iterator<String> i = linkedList.iterator();

        System.out.println("==================================");

        while (i.hasNext())
        {
            System.out.println("Now visiting " + i.next());
        }

        System.out.println("==================================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity)
    {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext())
        {
            int comparison = stringListIterator.next().compareTo(newCity);

            if (comparison == 0)
            {
                // Equal, do not add
                System.out.println(newCity + " is already included as a destination.");
                return false;
            } else if (comparison > 0)
            {
                // new City should appear before this one
                // Brisbane -> Adelaide
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0)
            {
                // Move on the next city
            }

            stringListIterator.add(newCity);
            return true;
        }

        return true;
    }

}
