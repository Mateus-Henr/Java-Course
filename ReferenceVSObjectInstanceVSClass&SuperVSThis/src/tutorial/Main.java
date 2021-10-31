package tutorial;

public class Main
{
    public static void main(String[] args)
    {
        House blueHouse = new House("blue"); // Creating an instance of the house class. "blueHouse" is a variable, in other words a reference to the object in memory.
        House anotherHouse = blueHouse; // Points the new object to the old one, therefore they found their data at the same place in memory. Two references pointing to the same object in memory
        // We have two houses, but two references to that same object (two pieces of paper with the same address)
        // So an variable is stored in the heap memory then point to the object in the stack memory.
        System.out.println(blueHouse.getColor()); // blue
        System.out.println(anotherHouse.getColor()); // blue

        anotherHouse.setColor("red"); // As both objects point to the same point in memory, when you change one both are going to be affected.
        System.out.println(blueHouse.getColor()); // red
        System.out.println(anotherHouse.getColor()); // red

        House greenHouse = new House("green");
        anotherHouse = greenHouse; // Here we are changing were an object points and pointing to another object.

        System.out.println(blueHouse.getColor()); // red
        System.out.println(greenHouse.getColor()); // green
        System.out.println(anotherHouse.getColor()); // green

//        Object = Instance of a Class. (The content in memory)
//        Instance = Object (the creation of an object)
//        Reference = A variable that holds bit pattern which points to the Object in the Memory (The variable)
    }
}
