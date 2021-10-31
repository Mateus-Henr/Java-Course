package tutorial.second.datamodel;

import java.time.LocalDate;

// This will be the model of the items.
public class ToDoItem
{
    private String shortDescription;
    private String details;
    private LocalDate deadline;

    public ToDoItem(String shortDescription, String details, LocalDate deadline)
    {
        this.shortDescription = shortDescription;
        this.details = details;
        this.deadline = deadline;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription)
    {
        this.shortDescription = shortDescription;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public LocalDate getDeadline()
    {
        return deadline;
    }

    public void setDeadline(LocalDate deadline)
    {
        this.deadline = deadline;
    }

    // Overriding this method for displaying the desired value on the ListView, in this case the shorDescription.
    // Not needed anymore since we are setting the item's text with the callback function that is performed on each
    // cell.
//    @Override
//    public String toString()
//    {
//        return shortDescription;
//    }

}
