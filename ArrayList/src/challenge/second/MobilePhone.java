package challenge.second;

import java.util.ArrayList;

public class MobilePhone
{
    private ArrayList<Contact> listOfContacts;

    public MobilePhone()
    {
        this.listOfContacts = new ArrayList<>();
    }

    public boolean store(Contact contactToStore)
    {
        if (!contactExists(contactToStore.getName()))
        {
            this.listOfContacts.add(contactToStore);
            return true;
        }

        return false;
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

    public boolean modify(String contactToModify, Contact modifiedContact)
    {
        if (contactExists(contactToModify))
        {
            int contactPosition = findContact(contactToModify);
            this.listOfContacts.set(contactPosition, modifiedContact);
            return true;
        }

        return false;
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

    public boolean findContactToTheUser(String contactToFind)
    {
        if (contactExists(contactToFind))
            return true;

        return false;
    }

    public boolean remove(String contactToRemove)
    {
        if (contactExists(contactToRemove))
        {
            int contactIndex = findContact(contactToRemove);
            this.listOfContacts.remove(contactIndex);
            return true;
        }

        return false;
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
