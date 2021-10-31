package challenge.first;

import java.util.ArrayList;

public class MobilePhone
{
    private ArrayList<Contact> listOfContacts;

    public MobilePhone()
    {
        this.listOfContacts = new ArrayList<>();
    }

    public void store(String contactToStoreName, String contactToStoreNumber)
    {
        if (contactExists(contactToStoreName))
        {
            System.out.println("A contact with the name informed " + "\"" + contactToStoreName + "\"" + " already exists. Please type another name.");
        } else
        {
            this.listOfContacts.add(Contact.createContact(contactToStoreName, contactToStoreNumber));
            System.out.println("The contact with name " + "\"" + contactToStoreName + "\"" + " and phone " + "\"" + contactToStoreNumber + "\"" + " has been stored successfully.");
        }
    }

    private boolean contactExists(String contactToSearchFor)
    {
        for (Contact element : this.listOfContacts)
        {
            if (element.getName().equals(contactToSearchFor))
            {
                return true;
            }
        }

        return false;
    }

    public void modify(String contactToModify, String modifiedContactName, String modifiedContactPhone)
    {
        if (contactExists(contactToModify))
        {
            int contactPosition = findContact(contactToModify);

            Contact modifiedContact = new Contact(modifiedContactName, modifiedContactPhone);

            if (contactExists(modifiedContact.getName())) {
                System.out.println("The contact you're trying to update to " + "\"" + modifiedContactName + " (" + modifiedContactPhone + ")" + "\"" + " already exists.");
            } else
            {
                this.listOfContacts.set(contactPosition, Contact.createContact(modifiedContactName, modifiedContactPhone));
                System.out.println("The previous contact " + contactToModify + " has been modified for " + modifiedContactName + " (" + modifiedContactPhone + ")" + " successfully.");
            }
        } else
        {
            System.out.println("The informed contact " + "\"" + contactToModify + "\"" + " does not exist.");
        }
    }

    private int findContact(String contactToFind)
    {
        for (Contact element : this.listOfContacts)
        {
            if (element.getName().equals(contactToFind))
            {
                return this.listOfContacts.indexOf(element);
            }
        }

        return -1;
    }

    public void findContactToTheUser(String contactToFind)
    {
        if (contactExists(contactToFind))
        {
            int contactPosition = findContact(contactToFind);

            System.out.println("The informed contact " + "\"" + contactToFind + "\"" + " has been found at the position " + (contactPosition + 1) + ".");

        } else
        {
            System.out.println("The informed contact " + "\"" + contactToFind + "\"" + " does not exist.");
        }
    }

    public void remove(String contactToRemove)
    {
        if (contactExists(contactToRemove))
        {
            int contactIndex = findContact(contactToRemove);
            this.listOfContacts.remove(contactIndex);
            System.out.println("The contact " + "\"" + contactToRemove + "\"" + " has been removed successfully.");
        } else
        {
            System.out.println("The informed contact " + "\"" + contactToRemove + "\"" + " does not exist.");
        }
    }

    public void getAllContacts()
    {
        if (this.listOfContacts.isEmpty())
        {
            System.out.println("No contacts found.");
        } else
        {
            for (int i = 0; i < this.listOfContacts.size(); i++)
            {
                System.out.println((i + 1) + ". " + this.listOfContacts.get(i).getName() + " (" + this.listOfContacts.get(i).getPhoneNumber() + ") ");
            }
        }
    }

    public void queryContact(String contactName)
    {
        if (contactExists(contactName))
        {
            int contactIndex = findContact(contactName);
            System.out.println("The contact information: " + "Name: " + listOfContacts.get(contactIndex).getName() + " | Phone number: " + listOfContacts.get(contactIndex).getPhoneNumber());
        } else
        {
            System.out.println("The informed contact " + "\"" + contactName + "\"" + " does not exist.");
        }
    }

}
