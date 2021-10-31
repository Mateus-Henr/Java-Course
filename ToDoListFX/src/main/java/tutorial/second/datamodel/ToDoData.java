package tutorial.second.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

// This is a Singleton class that only the Main and the Controller class can access.
// A Singleton is used when we want just one instance of a class to run in our entire app.
public class ToDoData
{
    private static ToDoData instance = new ToDoData();
    private static String fileName = "ToDoItems.txt";

    private ObservableList<ToDoItem> toDoItems; // Changing to an observable list to facilitate the data binding.
    private DateTimeFormatter formatter;

    // Used to return the only instance of this class.
    // When whatever part of our app wants to access the data, it needs to call this instance (since our constructor
    // is private).
    public static ToDoData getInstance()
    {
        return instance;
    }

    // To ensure that we can't create any other instances of this class
    private ToDoData()
    {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public ObservableList<ToDoItem> getToDoItems()
    {
        return toDoItems;
    }

    public void addToDoItem(ToDoItem item)
    {
        toDoItems.add(item);
    }

    // This method has been removed since once we have the file we don't need to set any list anymore.
//    public void setToDoItems(List<ToDoItem> toDoItems)
//    {
//        this.toDoItems = toDoItems;
//    }

    // This method is going to be used to load our toDoItems from the file.
    public void loadToDoItems() throws IOException
    {
        // We are using an "observableArrayList" for performance reasons. Observable lists will raise events and methods
        // in the list classes may call each other when the list is changed, it's then possible to more than one event
        // to be raised for a single change.
        // UI calls are expensive so running a ListView handler each time an item is modified is not a good idea.
        // So when working with JavaFX is always better to use the FXCollections versions.
        toDoItems = FXCollections.observableArrayList();
        Path path = Paths.get(fileName);
        // Here we are creating a buffered reader for this particular file.
        BufferedReader br = Files.newBufferedReader(path); // Buffers are containers for data.

        String input;

        try
        {
            while ((input = br.readLine()) != null)
            {
                String[] itemPieces = input.split("\t");

                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];

                LocalDate date = LocalDate.parse(dateString, formatter);
                ToDoItem toDoItem = new ToDoItem(shortDescription, details, date);
                toDoItems.add(toDoItem);
            }
        }
        finally
        {
            if (br != null)
            {
                br.close();
            }
        }
    }

    // Method to save the data (We wouldn't use this form of saving data in a real world app)
    public void storeToDoItems() throws IOException
    {
        Path path = Paths.get(fileName);
        BufferedWriter bw = Files.newBufferedWriter(path);

        try
        {
            // Iterating through the list and save one by one
            // The code below just builds up an iterator that we can cycle through record by record from our list and
            // retrieve one at a time.
            Iterator<ToDoItem> iter = toDoItems.iterator();
            while (iter.hasNext())
            {
                ToDoItem item = iter.next();
                // Interestingly by using an uppercase letter in one of these formats would make the String that is
                // going to be formatted string here in uppercase.
                bw.write(String.format("%s\t%s\t%s", // Formatting data
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline().format(formatter)));
                bw.newLine();
            }
        }
        finally
        {
            if (bw != null)
            {
                bw.close();
            }
        }
    }

}
