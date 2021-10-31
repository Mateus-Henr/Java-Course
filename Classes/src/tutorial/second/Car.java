package tutorial.second;

// "public" is an access modifier used to determine the visibility of a class/field.
// "protected" allows classes in the same package to have access.
public class Car
{
    // State
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    public void setModel(String model)
    {
        String validModel = model.toLowerCase();
        if (validModel.equals("carrera") || validModel.equals("commodore"))
        {
            this.model = model; // "this" is used for field of a class.
        }
        else
        {
            this.model = "Unknown";
        }
    }

    public String getModel()
    {
        return this.model;
    }

}
