package tutorial.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Artist
{
    // To take advantage of data biding we need to user "SimpleStringProperty" to store our fields.
    // As "SimpleStringProperty" is not a specific UI class, this wouldn't violate the separation between model and UI
    // code.
    private SimpleIntegerProperty ID;
    private SimpleStringProperty name;

    public SimpleIntegerProperty getID()
    {
        return ID;
    }

    public void setID(SimpleIntegerProperty ID)
    {
        this.ID = ID;
    }

    public SimpleStringProperty getName()
    {
        return name;
    }

    public void setName(SimpleStringProperty name)
    {
        this.name = name;
    }

}

// Ways of setting the Artists without data binding
// Calling the method "Platform.runLater()" when the queryArtists return its results, and we would set it inside a
// Runnable.
// We can call the "Task.setOnSucceeded" method that's going to happen after the "call()" method returns its results,
// and we pass a lambda calling the method to set the items.
// Either way if data binding is an option just use it.