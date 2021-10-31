package tutorial.challenge;

public class Room
{
    private Table table;
    private TV tv;
    private Monitor monitor;
    private Wardrobe wardrobe;
    private Bed bed;
    private Size size;

    public Room(Table table, TV tv, Monitor monitor, Wardrobe wardrobe, Bed bed, Size size)
    {
        this.table = table;
        this.tv = tv;
        this.monitor = monitor;
        this.wardrobe = wardrobe;
        this.bed = bed;
        this.size = size;
    }

    public void makeBed(){
        bed.makeTheBed();
    }

    public Table getTable()
    {
        return table;
    }

    public TV getTv()
    {
        return tv;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }

    public Wardrobe getWardrobe()
    {
        return wardrobe;
    }

    public Bed getBed()
    {
        return bed;
    }

    public Size getSize()
    {
        return size;
    }

}
