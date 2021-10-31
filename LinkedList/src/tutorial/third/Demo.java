package tutorial.third;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo
{
    public static void main(String[] args)
    {
        LinkedList<String> placesToVisit = new LinkedList<>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);

        // Testing invalid inputs
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Alice Springs"); // Not valid
        printList(placesToVisit);

        visit(placesToVisit);
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
                // Adds to the end
            }
        }
        // Add in the end of the list
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities)
    {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty())
        {
            System.out.println("No cities in the itenerary");
        } else
        {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit)
        {
            int action = scanner.nextInt();
            scanner.nextLine();
            boolean goingForward = true;

            switch (action)
            {
                case 0:
                    System.out.println("Holiday's over!");
                    quit = true;
                    break;

                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext())
                    {
                        System.out.println("Now visiting " + listIterator.next());
                    } else
                    {
                        System.out.println("Reached the end of the list.");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious())
                    {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else
                    {
                        System.out.println("We are at the start of the list.");
                        goingForward = true;
                    }
                    break;

                case 3:
                    printMenu();
                    break;
            }
        }

    }

    private static void printMenu()
    {
        System.out.println("Available actions> \nPress ");
        System.out.println("0 - to quit\n" +
                "1 - Go to next city\n" +
                "2 - Go to previous city\n" +
                "3 - Print menu of options");
    }

}
