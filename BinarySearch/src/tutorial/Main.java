package tutorial;

public class Main
{
    public static void main(String[] args)
    {
        Theater theater = new Theater("Theater", 100, 100);
        System.out.println("Theater Name: " + theater.getTheaterName());
        System.out.println("Seats: ");
        theater.getSeats();

        if (theater.reserveSeat("F06"))
        {
            System.out.println("Please pay");
        }
        else
        {
            System.out.println("Sorry, seat is taken");
        }
    }

}

// Structure
//                                     Collection
// Set ---------------------- List ---------------------- Queue ---------------------- Deque
// Sorted Set
// When we implement seat using collection we can implement a List or a Set or a Queue or a Deque.

// When implementing TreeSet we need to make the class Comparable