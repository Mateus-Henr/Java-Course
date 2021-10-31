package tutorial.first;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        // Point to the same place in memory
        Customer customer = new Customer("Tim", 54.96); // Save a memory address
        Customer anotherCustomer = customer; // Get the same address, once we are assigning it the previous object

        // Addresses in memory
        // We could consider the address as if it were stored in the Stack Memory, so when we assign an
        // object the stored value in the stack is an address that points to a place in the Heap memory.
        // Therefore if we use (assign) the same address to another object it edits the value in the Heap.

        // Linked List ---> [value: 1 | address: 122] ---> [value: 2 | address: 132] ---> .........................
        // A node from a Liked list points to another node, so a Linked List start in a address, then from that address
        // it gets a value and in parallel with this value there's an address that points to the next value. This system
        // continues until the value from an address is null that means that there's no more nodes.

        // Linked List Example
        // If you're using a Liked List and you want to insert an element among other two the list will create a point to
        // the next value, therefore something like:
        // Start address ---> [value: "Sydney" | address: 122] ---> [value: "Melbourne" | address: 132] ---> ..........
        // yourLinkedList.add(1, "Alice Springs");
        // Start address ---> [value: "Sydney" | address: 144] ---> [value: "Alice Springs" | address: 122] ---> [value: "Melbourne" | address: 132] ---> ..........
        // So differently from ArrayList, LinkedList demands less processing from the computer since it doesn't need to
        // move anything down or up if alterations are made amid two elements.

        // Another example is when we remove an element form a Linked List
        // Start address ---> [value: "Sydney" | address: 144] ---> [value: "Alice Springs" | address: 122] ---> [value: "Melbourne" | address: 132] ---> ..........
        // yourLinkedList.remove(1);
        // Start address ---> [value: "Sydney" | address: 122] ---> [value: "Melbourne" | address: 132] ---> ..........
        // Here is a little bit different at first "Sydney" was pointing to "Alice Springs", but then we remove "Alice Springs",
        // What does that mean?
        // As soon as we remove "Alice Springs" (index 1), the point before "Alice Springs" starts pointing to "Melbourne",
        // but for until Java eliminates the element, the element keeps pointing to "Melbourne". So before Java Garbage does
        // the work there's two pointers to "Melbourne" that are "Sydney" and "Alice Springs".

        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(3);
        intList.add(4);

        System.out.println("First Time");
        for (int i = 0; i < intList.size(); i++)
        {
            System.out.println(i + ": " + intList.get(i));
        }

        intList.add(1, 2);

        System.out.println("\nSecond Time");
        for (int i = 0; i < intList.size(); i++)
        {
            System.out.println(i + ": " + intList.get(i));
        }
    }

}
