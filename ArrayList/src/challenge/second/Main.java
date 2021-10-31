package challenge.second;

import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args)
    {
        System.out.println("Welcome to your contact list");
        menuOfOptions();

        boolean quit = false;
        while (!quit)
        {
            System.out.println("Which option would you like? (0 to show the actions)");

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice)
            {
                case 0:
                    menuOfOptions();
                    break;
                case 1:
                    getAllContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    modifyContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    queryContact();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    private static void menuOfOptions()
    {
        System.out.println("List of contact of your smartphone" +
                "\n0 - Display menu of options" +
                "\n1 - See all contacts that you have" +
                "\n2 - Add a new contact" +
                "\n3 - Remove a contact" +
                "\n4 - Modify a contact" +
                "\n5 - Search contact" +
                "\n6 - Query contact" +
                "\n7 - Quit");
    }

    private static void getAllContacts()
    {
        System.out.println("Getting all your contacts");

        mobilePhone.getAllContacts();
    }

    private static void addContact()
    {
        System.out.println("Type the contact name: ");
        String contactNameToAdd = scanner.nextLine();

        System.out.println("Type the phone number: ");
        String contactNumberToAdd = scanner.nextLine();

        Contact contactToStore = Contact.createContact(contactNameToAdd, contactNumberToAdd);

        if (mobilePhone.store(contactToStore))
        {
            System.out.println("A contact with the name informed " + "\"" + contactToStore.getName() + "\"" + " already exists. Please type another name.");
        } else
        {
            System.out.println("The contact with name " + "\"" + contactToStore.getName() + "\"" + " and phone " + "\"" + contactToStore.getPhoneNumber() + "\"" + " has been stored successfully.");
        }
    }

    private static void removeContact()
    {
        System.out.println("Type the name of the contact you'd like to remove: ");
        String contactToRemove = scanner.nextLine();

        if (mobilePhone.remove(contactToRemove))
        {
            System.out.println("The contact " + "\"" + contactToRemove + "\"" + " has been removed successfully.");
        } else
        {
            System.out.println("The informed contact " + "\"" + contactToRemove + "\"" + " does not exist.");
        }
    }

    private static void modifyContact()
    {
        System.out.println("Type the name of the contact that you'd like to modify: ");
        String contactToModify = scanner.nextLine();

        System.out.println("Type the name of the new contact: ");
        String modifiedContactName = scanner.nextLine();

        System.out.println("Type the number of the new contact: ");
        String modifiedContactNumber = scanner.nextLine();

        Contact modifiedContact = Contact.createContact(modifiedContactName, modifiedContactNumber);

        if (mobilePhone.modify(contactToModify, modifiedContact))
        {
            System.out.println("The previous contact " + contactToModify + " has been modified for " + modifiedContact.getName() + " (" + modifiedContact.getPhoneNumber() + ")" + " successfully.");
        } else
        {
            System.out.println("The informed contact " + "\"" + contactToModify + "\"" + " does not exist.");
        }
    }

    private static void searchContact()
    {
        System.out.println("Type the name of contact that you'd like to search: ");
        String contactToSearch = scanner.nextLine();

        if (mobilePhone.findContactToTheUser(contactToSearch))
        {
            System.out.println("The informed contact " + "\"" + contactToSearch + "\"" + " has been found at the position.");
        }
    }

    private static void queryContact()
    {
        System.out.println("Type the name of the contact you'd like to see more information about: ");
        String contactToQuery = scanner.nextLine();

        mobilePhone.queryContact(contactToQuery);
    }

}
