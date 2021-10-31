package tutorial.first;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

// Bearing in mind the MVC design, we have the Controller that handles the user's input. So for this reason it's here
// where we will place our event handlers.

// Another way of saying that an application is interested in handling an event is saying that the app is listening for
// that event. So event handlers can be referred to as event listeners (user in mobile apps).

public class HelloController
{
    // As mentioned in the FXML code, we need to define a variable with the same name as the fx:id to interact with
    // the control.
    // When we run our app we need to tell the JavaFX Runtime that it creates the instance of the controller class, it
    // needs to assign the TextField that it created from the FXML to the "nameField" instance variable. And to do that
    // we annotate the instance variable declaration with "@FXML". Otherwise, you'll have to change the access modifier
    // of the field to be able to use the control (BUT THIS IS NOT RECOMMENDED AT ALL).
    // So when the JavaFX Runtime instantiates the Controller, what it did was assign or another term is injected the
    // reference to the TextFiled into the nameField variable. So it matches FXML definitions to variables by looking
    // for the exact name matches between the fx:id and the variable names.
    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;

    // This method is called automatically by the JavaFX runtime when the UI is being initialized.
    @FXML
    public void initialize()
    {
        // Disable both buttons in order to rely on the event handler below.
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    // After creating the event handler (method) we have to associate it to the desired control.
    // In this case when the button is clicked the UI Thread notices and dispatches the event to the event handler,
    // executing this method.
    // It's also a good practise to annotate event handlers (methods) to facilitate readability.


    // It's good to pass a parameter to an event handler because we might want to use the same event handler for more
    // than one control. So by having this parameter and calling the "getSource" method, we can identify which control
    // the user's interacted with.
    // Depending on the event handler code to avoid duplication it's best to just one event handler. Depends on the case.
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

        // When displaying "getSource" it will appear a value such as: "Button@31a2b4cb[styleClass=button]'Say Hello'"
        // The characters after the "@" show a memory location of the button.
//        System.out.println("The following button was pressed: " + e.getSource());
    }

    // To detect if an TextField is empty you could use a condition in the event handler, or we could display a ERROR
    // message for example. It's important to give a feedback to the user. But here the best approach would be having
    // the buttons disabled while there's no input the TextField in it.
    // Even though it might see inefficient we have to check every time that the user enters something in the field.
    // We could also enter a key parameter to identify which key was pressed.
    @FXML
    public void handleKeyRelease()
    {
        String text = nameField.getText();
        // The first "isEmpty" might not be necessary.
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty(); // "trim()" is used to ignore spaces.
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

}