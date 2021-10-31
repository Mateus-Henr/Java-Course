package tutorial.second;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;

// When writing a user interface you have to write a lot of code in order to prevent unexpected scenarios,
// due to relationship among some controls this the lack of this code could lead to bugs in the code.

// NEVER ASSUME THAT A USER WILL INTERACT WITH THE UI IN A CERTAIN WAY OR SPECIFIC ORDER.

// UI Thread and Event Handling
// An event handler runs on the UI Thread, so while an event handler is running the UI Thread is occupied with that
// event, so it's no longing paying attention to the user input. Meaning that the user won't be able to interact
// with the UI while that event is occurring (it freezes).

public class HelloController
{
    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;

    @FXML
    public void initialize()
    {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e)
    {
        if (e.getSource().equals(helloButton))
        {
            System.out.println("Hello, " + nameField.getText());
        }
        else if (e.getSource().equals(byeButton))
        {
            System.out.println("Bye, " + nameField.getText());
        }

        // Putting the UI Thread to sleep to represent that if the UI thread takes too much time in a process it'll
        // "lock up" the program and ignore user inputs, as explained above.
        try
        {
            Thread.sleep(10000);
        }
        catch (InterruptedException event)
        {
            // Not used
        }

        if (ourCheckBox.isSelected()) // Cleaning the TextField if the CheckBox is selected after pressing the button.
        {
            nameField.clear();
            // We need to alter the state of the button after clearing the nameField once they aren't updated again.
            // Remember we are initializing the buttons as disabled and only enabling them if there's a character
            // on the TextField.
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }

    }

    @FXML
    public void handleKeyRelease()
    {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    @FXML
    public void handleChange()
    {
        System.out.println("The checkbox is " + (ourCheckBox.isSelected() ? "checked" : "not checked"));
    }

}