package tutorial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Theater theater = new Theater("Theater", 10, 10);

        if (theater.reserveSeat("D01"))
        {
            System.out.println("Please pay for D01");
        }
        else
        {
            System.out.println("Seat already reserved");
        }

        if (theater.reserveSeat("B01"))
        {
            System.out.println("Please pay for B01");
        }
        else
        {
            System.out.println("Seat already reserved");
        }


        List<Theater.Seat> reverseSeats = new ArrayList<>(theater.getSeats());
        Collections.reverse(reverseSeats);
        // printList(reverseSeats);

        List<Theater.Seat> priceSeats = new ArrayList<>(theater.getSeats());
        priceSeats.add(theater.new Seat("B00", 13.00));
        priceSeats.add(theater.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theater.PRICE_ORDER);
        printList(priceSeats);
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

            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }

        System.out.println();
        System.out.println("==========================================================================================");

    }

}