package challengeVersionTwo;

public class Main
{
    public static void main(String[] args)
    {
        Hamburger hamburger = new Hamburger("Hamburger", 10.00, "Normal", "Chicken");
        hamburger.addItem("Tomato", 2.00);
        hamburger.addItem("Bacon", 3.00);
        hamburger.addItem("Cheese", 1.12);
        System.out.println("\n");
        System.out.println(hamburger.getFinalInformation());

        System.out.println("\n\n");

        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.addItem("Tomato", 2.00);
        System.out.println("\n");
        System.out.println(deluxeBurger.getFinalInformation());

        System.out.println("\n\n");

        HealthyBurger healthyBurger = new HealthyBurger("Chicken", 10.00);
        healthyBurger.addItem("Tomato", 2.00);
        healthyBurger.addItem("Bacon", 3.00);
        System.out.println("\n");
        System.out.println(healthyBurger.getFinalInformation());

    }
}
