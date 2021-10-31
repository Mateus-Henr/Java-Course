package tutorial;

//        Reference vs Object vs Instance vs Class
//
//        A class is a blueprint of a house for example, we can build as many houses as we like using that class.
//
//        Each house you build (in other words instantiate using the new operator) is an object also known as an instance.
//
//        Each house you build has an address in other words a reference.
//
//        You can copy that reference as many times as you like but there's still just one house. In other words we are
//        copying the paper that has address on it not the house itself.
//
//        We can pass references as parameters to constructors and methods.

// Here we have a class House with an instance variable (field) colour.
public class House
{
    private String color;

    public House(String color)
    {
        // "this" keyword is required, same parameter name as field
        this.color = color;
    }

    public String getColor()
    {
        // "this" is optional
        return color; // same as return this.color;
    }

    public void setColor(String color)
    {
        // "this" keyword is required, same parameter name as field
        this.color = color;
    }

}

// "super" is used to access or call parent class members (variables and methods)
// "this" is used to access the current class members (variables and methods)
// We can not use "super" or "this" with static areas. (throws an error)
// "super"