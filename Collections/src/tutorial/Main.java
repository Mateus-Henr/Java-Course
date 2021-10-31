package tutorial;

public class Main
{
    public static void main(String[] args)
    {
        Theater theater = new Theater("Theater", 10, 10);
        System.out.println("Theater Name: " + theater.getTheaterName());
        System.out.println("Seats: ");
        theater.getSeats();

        if (theater.reserveSeat("F05"))
        {
            System.out.println("Please pay");
        }
        else
        {
            System.out.println("Sorry, seat is taken");
        }

        if (theater.reserveSeat("F05"))
        {
            System.out.println("Please pay");
        }
        else
        {
            System.out.println("Sorry, seat is taken");
        }
    }
}
