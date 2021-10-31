package challenge.myown;

public class Button
{
    private String name;
    private int id;
    private String type;
    private int width;
    private int height;
    private ButtonListener actionCode;

    public Button(String name, int id, String type, int width, int height)
    {
        this.name = name;
        this.id = id;
        this.type = type;
        this.width = width;
        this.height = height;
    }

    public void setActionCode(ButtonListener actionCode)
    {
        this.actionCode = actionCode;
    }

    public String getType()
    {
        return type;
    }

    public void click()
    {
        this.actionCode.clickButton();
    }

}
