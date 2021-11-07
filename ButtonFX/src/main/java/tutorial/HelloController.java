package tutorial;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController
{
    @FXML
    private Button clickMeButton;

    public void initialize()
    {
        // Setting up an event handler for our button though the Controller class.
        // Version without using lambda expression.
//        clickMeButton.setOnAction(new EventHandler<ActionEvent>()
//        {
//            // In UI programming is very common to use an anonymous class for the event handler.
//            @Override
//            public void handle(ActionEvent actionEvent)
//            {
//                System.out.println("You clicked me!");
//            }
//        });

        // Version using a lambda
        // With just one parameter we don't need parenthesis.
        clickMeButton.setOnAction(event -> System.out.println("You clicked me!"));

        // Whenever we see an anonymous class definition that only overrides one method we can consider using a lambda.
    }

}