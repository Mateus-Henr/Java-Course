package myUpdates.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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
