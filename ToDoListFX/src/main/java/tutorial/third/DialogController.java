package tutorial.third;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import tutorial.third.datamodel.ToDoData;
import tutorial.third.datamodel.ToDoItem;

import java.time.LocalDate;

public class DialogController
{
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    public ToDoItem processResult()
    {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        ToDoItem newItem = new ToDoItem(shortDescription, details, deadlineValue);
        ToDoData.getInstance().addToDoItem(newItem);

        return newItem;
    }

    public ToDoItem updateItem(ToDoItem oldItem)
    {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        ToDoItem updatedItem = new ToDoItem(shortDescription, details, deadlineValue);
        ToDoData.getInstance().updateItem(oldItem, updatedItem);

        return updatedItem;
    }

}