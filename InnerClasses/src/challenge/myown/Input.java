package challenge.myown;

public class Input
{
    private String name;
    private int id;
    private int width;
    private int height;
    private String text;
    private InputListener actionCode;

    public Input(String name, int id, int width, int height)
    {
        this.name = name;
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public void setActionCode(InputListener actionCode)
    {
        this.actionCode = actionCode;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public void submit()
    {
        this.actionCode.submitInput(this.text);
    }

}
