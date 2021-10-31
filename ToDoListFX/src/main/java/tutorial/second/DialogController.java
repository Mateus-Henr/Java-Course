package tutorial.second;

// The DialoguePane is a layout manager used for dialogues that allows us to set 4 properties, namely the header, the
// graphic, content and buttons. Each property expects a control.
// Since we normally want to display text on the header it also offers us two properties, which are "header text" and
// "content text". (By using this we don't have to create a Label for the text).
// OBS: If we set the header property to a control and the header's property the header's property will be ignored.

// We show the Dialogue when the user presses file on the main window menu, therefore we have to handle this event in
// the main window's controller.

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import tutorial.second.datamodel.ToDoData;
import tutorial.second.datamodel.ToDoItem;

import java.time.LocalDate;

public class DialogController
{
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    // Method performed after clicking the "OK" button
    public ToDoItem processResult()
    {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        ToDoItem newItem = new ToDoItem(shortDescription, details, deadlineValue);
        ToDoData.getInstance().addToDoItem(newItem);

        return newItem;
    }

}
// To select an item when it's added we need to select it in the main controller.
// It's safer to get the item created by the "processResult()" method rather than trying to get the last item in the
// list.