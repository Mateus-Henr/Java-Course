package challenge.mine.second;

import java.util.ArrayList;
import java.util.List;

public class HardDisk implements Saveable
{
    private List<Saveable> internalStorage;

    public HardDisk()
    {
        this.internalStorage = new ArrayList<>();
    }

    @Override
    public void save(Saveable objectToSave)
    {
        if (objectToSave != null)
        {
            this.internalStorage.add(objectToSave);
        }
    }

    @Override
    public Saveable load(String objectName)
    {
        Saveable objectToLoad = findObject(objectName);

        return objectToLoad;
    }

    private Saveable findObject(String objectName)
    {
        for (int i = 0; i < this.internalStorage.size(); i++)
        {
            Saveable objectToCheck = this.internalStorage.get(i);
            if (objectToCheck.getName().equalsIgnoreCase(objectName))
            {
                return objectToCheck;
            }
        }

        return null;
    }

    @Override
    public String getName()
    {
        // Do nothing
        return null;
    }

    public void getAllInternalStorage()
    {
        for (int i = 0; i < this.internalStorage.size(); i++)
        {
            System.out.println((i + 1) + " ° position: " + this.internalStorage.get(i));
        }
    }


}
