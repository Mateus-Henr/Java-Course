package challenge;

import java.util.Scanner;

public class Main
{
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {

        System.out.println("Welcome to Bill's Burgers");
        System.out.println("What type of burger would you like to savor today? \n1 - Hamburger \n2 - DeluxeBurger \n3 - HealthyBurger");
        int choice = 0;
        try
        {
            choice = sc.nextInt();
        } catch (Exception e)
        {
            System.out.println("Invalid Input.");
        }

        if (choice != 0)
        {
            Hamburger chosenHamburger = burgerChoice(choice);
            if (chosenHamburger == null)
            {
                System.out.println("Invalid type of burger.");
                return;
            }
            if (!(chosenHamburger instanceof DeluxeBurger))
            {
                additionMethod(chosenHamburger);
            }

            double totalPrice = chosenHamburger.getTotalPrice();

            System.out.println("The total price is $" + totalPrice);

        } else
        {
            System.out.println("Invalid type of burger.");
        }


    }

    private static Hamburger burgerChoice(int userChoice)
    {
        switch (userChoice)
        {
            case 1:
                return new Hamburger("Normal", "Chicken");
            case 2:
                return new DeluxeBurger("Normal", "Chicken");
            case 3:
                return new HealthyBurger("Normal", "Chicken");
            default:
                return null;

        }
    }

    private static Item additionChoice(int userChoice, int itemQuantity)
    {
        switch (userChoice)
        {
            case 1:
                return new Tomato(itemQuantity);
            case 2:
                return new Lettuce(itemQuantity);
            case 3:
                return new Bacon(itemQuantity);
            case 4:
                return new Carrot(itemQuantity);
            case 5:
                return new Drink(itemQuantity);
            case 6:
                return new Chips(itemQuantity);
            default:
                return null;
        }
    }

    private static void additionMethod(Hamburger chosenHamburger)
    {
        int totalItemQuantity = 0;
        while (true)
        {
            int chosenItem = 0;
            int itemQuantity = 0;
            try
            {
                System.out.println("Choose an Item to add: Up to " + chosenHamburger.MAX_NUMBER_OF_ADDITIONS + " items.");
                System.out.println("0 - Stop \n1 - Tomato \n2 - Lettuce \n3 - Bacon \n4 - Carrot");
                chosenItem = sc.nextInt();

                if (chosenItem == 0)
                    return;

                System.out.println("How many " + additionChoice(chosenItem, 0).getName() + " would you like to add? ");
                itemQuantity = sc.nextInt();
                totalItemQuantity += itemQuantity;

                if (totalItemQuantity == 4)
                    return;


            } catch (Exception e)
            {
                System.out.println("Invalid Input.");
            }

            Item additionalItem = additionChoice(chosenItem, itemQuantity);

            chosenHamburger.addItem(additionalItem);
        }
    }

}
