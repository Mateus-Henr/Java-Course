package myUpdates.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Artist
{
    private SimpleIntegerProperty ID;
    private SimpleStringProperty name;

    public Artist()
    {
        this.ID = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
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

}