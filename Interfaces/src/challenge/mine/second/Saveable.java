package challenge.mine.second;

public interface Saveable
{
    void save(Saveable objectToSave);

    Saveable load(String objectName);

    String getName();
}
