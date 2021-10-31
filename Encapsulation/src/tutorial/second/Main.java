package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        EnhancedPlayer player = new EnhancedPlayer("Tim", 50, "Sword");
        System.out.println("Initial health is " + player.getHealth());
    }
}
