package challenge.mine.second;

public class MyString extends HardDisk
{
    private String name;
    private String string;

    public MyString(String string)
    {
        this.name = "" + Math.random();
        this.string = string;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public String getString()
    {
        return string;
    }

    public void setString(String string)
    {
        this.string = string;
    }

    @Override
    public String toString()
    {
        return "MyString{" +
                "name='" + name + '\'' +
                ", string='" + string + '\'' +
                '}';
    }

}
