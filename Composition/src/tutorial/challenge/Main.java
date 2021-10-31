package tutorial.challenge;

public class Main
{
    public static void main(String[] args)
    {
        Room room = new Room(new Table(165, 80, 80, 2, "White", "Wood"),
                    new TV(new Resolution(1360, 768), "LG"),
                    new Monitor("LG", 100, new Resolution(2560, 1080)),
                    new Wardrobe("Wood", 6, 4,
                    new Size(2000, 2000)),
                    new Bed("Wood", "Bunk bed"),
                    new Size(3000, 3000));

        House house = new House(room);

        //Two ways of accessing objects
        room.makeBed();
        house.getRoom().makeBed();
    }

}
