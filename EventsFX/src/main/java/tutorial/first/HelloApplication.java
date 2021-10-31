package tutorial.first;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// When dealing with the user interface you need to make the program aware of possible state changes that happen with
// controls.

// How does the IDEA know when we press a button?
// When the user interacts with a control it runs a method that is commonly called an event handler.
// It considered a code that makes our application pay attention to the user's action.

// Procedure Driven Program
// Console application and other that don't have a user interface. They run from the entry point of the application
// to the last line of code. Therefore, with this kind of application we know at which order the code is going to be
// executed.

// UI Application
// These types of applications are event driven, in other words, the user dictates what code is going to be run
// and when, by interacting with the app. (IntelIJ is an example of it).
// The line of executing of UI apps are very similar in overall, firstly it runs the initialization code then it'll
// build the main user interface and wait for the user input. And when the user interacts with something the app
// will run a particular code related to what the user has interacted to.
// When the user wants to close the up any cleanup code will run and the app will exit.

// In JavaFX the JavaFX Application Thread, also known as the UI Thread waits for the user input.
// When the user does whatever interaction with a control an event is raised on the UI Thread. The UI Thread notices
// that the user's done something then it checks to see if any part of the application has expressed interesting in
// handling that particular event.

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

}