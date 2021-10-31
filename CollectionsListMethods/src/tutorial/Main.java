package tutorial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Theater theater = new Theater("Theater", 10, 10);
        List<Theater.Seat> seatCopy = new ArrayList<>(theater.seats); // Swallow copy - The two references point to the same object
        System.out.println("Printing the original list");
        printList(seatCopy);

        // Proving that's the same object
        seatCopy.get(1).reserve();
        if (theater.reserveSeat("A02"))
        {
            System.out.println("Please pay for A02");
        }
        else
        {
            System.out.println("Seat already reserved by the first reference");
        }

        Collections.reverse(seatCopy);
        System.out.println("Printing reversed list");
        printList(seatCopy);

//        System.out.println("Printing the original list");
//        printList(seatCopy); Doesn't work since the list has been modified

        Collections.shuffle(seatCopy); // Randomize the elements in the object
//        System.out.println("Printing shuffled list");
//        printList(seatCopy);

        // Min and Max
        Theater.Seat minSeat = Collections.min(seatCopy);
        Theater.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min = " + minSeat.getSeatNumber() + " Max = " + maxSeat.getSeatNumber());

        System.out.println("Printing sorted list (using homemade method)");
        sortList(seatCopy);
        printList(seatCopy);

//        // Throws an error, it initializes an ArrayList with the initial amount of elements, but as there's no
//        // elements inside the list, it can't just copy one into the other
//        List<Theater.Seat> newList = new ArrayList<>(theater.seats.size());
//        Collections.copy(newList, theater.seats);
    }

    private static void printList(List<Theater.Seat> listOfSeats)
    {
        int currentSeat = listOfSeats.get(0).getSeatNumber().charAt(0);
        int maxSeat = Collections.max(listOfSeats).getSeatNumber().charAt(0);
        boolean isReversed = (maxSeat == currentSeat);
        System.out.println("CurrentSeat = " + currentSeat + " maxSeat = " + maxSeat + " isReversed = " + isReversed);

        System.out.println("==========================================================================================");
        for (Theater.Seat seat : listOfSeats)
        {
            if (seat.getSeatNumber().indexOf(currentSeat) < 0)
            {
                System.out.println();

                if (isReversed)
                {
                    currentSeat--;
                }
                else
                {
                    currentSeat++;
                }
            }

            System.out.print(" " + seat.getSeatNumber());
        }

        System.out.println();
        System.out.println("==========================================================================================");

    }

    // Sorting List (Quite rare used since the Collections framework provides the necessary methods)
    public static void sortList(List<? extends Theater.Seat> list)
    {
        for (int i = 0; i < list.size() - 1; i++)
        {
            for (int j = i + 1; j < list.size(); j++)
            {
                if (list.get(i).compareTo(list.get(j)) > 0)
                {
                    Collections.swap(list, i, j);
                }
            }
        }
    }

}