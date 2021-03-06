package tutorial.model;

// As both classes, Album and Artist, are using "name" as the property field we can take advantage of it to use the data
// binding. Since in our FXML we are defining a "PropertyValueFactory" that is valid, it doesn't really care about the
// type of the class that stores the field. A developer might use it while prototyping.
// But we WOULD NOT do that in a real world application, we would get around that by having multiple tables each on a
// tab or having multiple tables and setting only one visible at a time.

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

// This class also had to be altered to be able to use data binding.
public class Album
{
    private SimpleIntegerProperty ID;
    private SimpleStringProperty name;
    private SimpleIntegerProperty artistID;

    public Album()
    {
        ID = new SimpleIntegerProperty();
        name = new SimpleStringProperty();
        artistID = new SimpleIntegerProperty();
    }

    public int getID()
    {
        return ID.get();
    }

    public void setID(int ID)
    {
        this.ID.set(ID);
    }

    public String getName()
    {
        return name.get();
    }

    public void setName(String name)
    {
        this.name.set(name);
    }

    public int getArtistID()
    {
        return artistID.get();
    }

    public void setArtistID(int artistID)
    {
        this.artistID.set(artistID);
    }

}
