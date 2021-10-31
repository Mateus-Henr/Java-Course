package tutorial.third;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// The UI Thread isn't the best solution for events that take some time to complete.
// So if the event handler takes more time to complete a particular tasks, it's recommendable starting a new thread
// (avoiding pauses on the user experience).
//We refer to the thread that's going to perform the work as the background thread. When the background thread
// finishes the work it notifies the user interface, for example the retrieval of data from a database.
// The UI Thread kicks off the background thread, then the background thread gets the data, and it informs the UI
// and then the data can be loaded into the UI.

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
    private Label ourLabel;

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

        // Running code on the background thread
        // If we try to run as shown below we will get an exception, because the scene graph isn't thread safe
        // so the code assumes that nodes in the screen graph will only ever be updated by the same thread (UI Thread)
        // also known as the JavaFX Application Thread.
        // If more than one thread could update a node it would be possible for the internal integrity of the node to
        // be compromised. For example if thread A runs and starts to change the state of a node, and then it's
        // suspended so that thread B can run nothing in the JavaFX prevents thread B from also updating the same node.
        // Two processes that conflict with each other.
        // Because of what has been described above we must alter control states on the JavaFX Application Thread, if
        // we don't we will get an exception (in this case, an "IllegalStateException").
        // JavaFX throws an exception which is different from its older version "Swing" that didn't.

        // Runnable is an interface that's used to perform code in another thread.
        Runnable task = new Runnable()
        {
            @Override
            public void run()
            {
                // Here we would put the code that we would like to be executed.
                try
                {
                    // The "Platform.isFxApplicationThread()" is used to identify if the code is running on the UI
                    // Thread or not (used for debugging).
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("I'm going to sleep on the: " + s);
                    Thread.sleep(10000);

                    // The following method receives a "Runnable" as a parameter and forces it to run on the UI Thread.
                    // This way avoiding the exception as described above.
                    Platform.runLater(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println("I'm updating the label on the: " + s);
                            // Now the label is going to be updated on the UI Thread.
                            ourLabel.setText("We did something!");
                        }
                    });
                }
                catch (InterruptedException event)

                {
                    // Not used
                }
            }
        };

        // Above we are sort of declaring the variable, so we need to start it.
        new Thread(task).start();

        if (ourCheckBox.isSelected())
        {
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }

        // JavaFX provides a set of APIs that help us to run background threads and communicate with the UI and these
        // APIs can be found in the "java.fx.concurrent" package.
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