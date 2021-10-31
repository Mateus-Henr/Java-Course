package tutorial;

import java.util.*;

public class Theater
{
    private final String theaterName; // Belas Artes
    private List<Seat> seats = new ArrayList<>();

    public Theater(String theaterName, int numRows, int seatsPerRow)
    {
        this.theaterName = theaterName;
        int lastRow = 'A' + (numRows - 1);
        System.out.println(lastRow);
        for (char row = 'A'; row <= lastRow; row++)
        {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++)
            {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheaterName()
    {
        return theaterName;
    }

    // binarySearch starts in the middle of the list then it starts comparing based on the value compared to the searched
    // value
//    public boolean reserveSeat(String seatNumber)
//    {
//        Seat requestSeat = new Seat(seatNumber);
//        int foundSeat = Collections.binarySearch(seats, requestSeat, null);
//        if (foundSeat >= 0)
//        {
//            return seats.get(foundSeat).reserve();
//        }
//
//        System.out.println("There is no seat " + seatNumber);
//        return false;
//    }

    // Binary search code
    // Binary search works by locating the position of an object in a sorted list.
    //
    // Works like this:
    // Let's suppose that you have a list with 100 elements.
    // 1° - The compareTo method which direction to go to by dividing the list in the middle
    // So, now you're on element 5000 and depending on the compareTo return value you'll decide which direction you're
    // going to (left or right).
    // After deciding the direction, it'll divide the new number in half (2500) and determine the direction again.
    // This loop will happen until it find or not the informed value.
    public boolean reserveSeat(String seatNumber)
    {
        int low = 0;
        int high = seats.size() - 1;

        while (low <= high)
        {
            System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0)
            {
                low = mid + 1;
            }
            else if (cmp > 0)
            {
                high = mid - 1;
            }
            else
            {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
    }

    // For testing purposes
    public void getSeats()
    {
        for (Seat seat : seats)
        {
            System.out.println(seat.getSeatNumber());
        }
    }

    // Comparable is used here since we want to find a Seat faster. Looping through every seat to find a specific one
    // is bad. So we use comparable on Seat to compare them. This way avoid having to cast Object.
    private class Seat implements Comparable<Seat>
    {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber)
        {
            this.seatNumber = seatNumber;
        }

        public boolean reserve()
        {
            if (!this.reserved)
            {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }
            else
            {
                return false;
            }
        }

        public boolean cancel()
        {
            if (this.reserved)
            {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            }
            else
            {
                return false;
            }
        }

        public String getSeatNumber()
        {
            return seatNumber;
        }

        @Override
        public int compareTo(Seat seat)
        {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

    }

}
