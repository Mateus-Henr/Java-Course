package tutorial;

import java.util.*;

public class Theater
{
    private final String theaterName;
    private List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER;

    static
    {
        PRICE_ORDER = new Comparator<Seat>() // Anonymous inner class implementing a Comparator
        {                                                                  // Creating the concrete implementation for the interface.
            @Override
            public int compare(Seat seat1, Seat seat2)
            {
                if (seat1.getPrice() < seat2.getPrice())
                {
                    return -1;
                }
                else if (seat1.getPrice() > seat2.getPrice())
                {
                    return 1;
                }

                return 0;
            }
        };
    }

    public Theater(String theaterName, int numRows, int seatsPerRow)
    {
        this.theaterName = theaterName;
        int lastRow = 'A' + (numRows - 1);

        int startMiddle = (seatsPerRow / 2) - (seatsPerRow / 4);
        int endMiddle = (seatsPerRow / 2) + (seatsPerRow / 4);
        int startBack = (numRows / 2) - (numRows / 4) + 'A';
        int endBack = numRows;

        System.out.println(lastRow);

        for (char row = 'A'; row <= lastRow; row++)
        {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++)
            {
                double price = 12.00;

                if ((seatNum > startMiddle) && (seatNum < endMiddle))
                {
                    price = 14.00;
                }
                if ((row > startBack) && (row < endBack))
                {
                    price = 5.00;
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheaterName()
    {
        return theaterName;
    }

    public boolean reserveSeat(String seatNumber)
    {
        Seat requestSeat = null;
        for (Seat seat : seats)
        {
            if (seat.getSeatNumber().equals(seatNumber))
            {
                requestSeat = seat;
                break;
            }
        }

        if (requestSeat == null)
        {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        return requestSeat.reserve();
    }

    public Collection<Seat> getSeats()
    {
        return seats;
    }

    public class Seat implements Comparable<Seat>
    {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price)
        {
            this.seatNumber = seatNumber;
            this.price = price;
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

        public double getPrice()
        {
            return price;
        }

        @Override
        public int compareTo(Seat seat)
        {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

    }

    // Using comparator you can create an object to compare objects, so you can have more than one way to compare objects
    // which is different from compareTo, since it just allows one method.

    // CompareTo
    // I've got a pretty good idea on how to implement my on compareTo for Strings.
    // I use chart.At() on the entire string and save them into an integer that sums all the chars, getting a final
    // value in the end and comparing to the other string.

}
