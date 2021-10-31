package tutorial;

import java.util.*;

public class Theater
{
    private final String theaterName;
    private List<Seat> seats = new ArrayList<>();

    public Theater(String theaterName, int numRows, int seatsPerRow)
    {
        this.theaterName = theaterName;
        int lastRow = 'A' + (numRows - 1); // A9
        System.out.println(lastRow);
        for (char row = 'A'; row <= lastRow; row++) // Loops through the letters of the alphabet
        {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) // Loops through the seats
            {
                Seat seat = new Seat(row + String.format("%02d", seatNum)); // Formats for the sake of the 0
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

    // For testing purposes
    public void getSeats()
    {
        for (Seat seat : seats)
        {
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat
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

    }

}
