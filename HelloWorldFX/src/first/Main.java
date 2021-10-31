package first;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Java FX
// Java FX is a set of APIs that we use to build user interfaces in Java.
// For JDK greater than 8 we need to import the FX jar files into the "Project Structure" of the IDE,
// also you need to add these files into the global libraries of the your FX project and add a "module-info.java"
// (there's a model in the "bin" folder).
//
// JavaDx was designed with the MVC, or Model-View-Controller, pattern in mind.
// In a nutshell, this pattern keeps the code that handles an application's data separate from the UI code.
// Therefore when using this pattern, we need to keep the UI code separated to the code that manipulates the app.
// The controller is sort of the middleman between the UI and the data (handles events).
//
// When working with JavaFX, the model corresponds to the application's data model,
// the view is the FXML and the controller is the code that determines what happens when a user interacts with the UI.
// It's a good practise to use this MVC pattern when using JavaFX.

// Application comes from javafx.application and it's used as the app entry's point.
// The Application class manages the life cycle of a javafx application, when we run it the "application.launch" method
// will be called from the main method (it doesn't return until the app has exited).
// When a JavaFX Application is launched the "init" method runs first, but tif we don't override it and add something
// to it it won't do anything since it doesn't have any implementation.
// After the "init" method the "start" method runs, as you can see below this method because it's abstract.
// When the Application finishes the "stop" method runs, that's also empty (needs implementation by the user).
public class Main extends Application
{

    // "Stage" is a top-level JavaFX container that extends the "Window" class, in other words, a main window.
    // The JavaFX runtime constructs the initial stage and passes it into the start method.
    // Dialogues are presented within the stage, we don't create the stage, we use the dialogue class which wraps
    // the dialogue into a stage for us.
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Here it loads the UI from the FXML file.
        // When the FXML file is loaded it also constructs all the UI objects defined within it.
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        // Since the "Window" class is the parent of the stage class (and the stage is the top-level container),
        // this will set the title of the window.
        primaryStage.setTitle("Hello World");

        // The JavaFX is based on a theatre metaphor.
        // Each stage requires a scene and backing each scene is a scene graph, a tree in which each node corresponds
        // to a UI control or an area of the scene.
        // Using this metaphor we can have different scenes in one stage.
        // In practise we would load a different FXML file into a new scene and call "stage.setScene".
        // Example using the same stage (window) to make a "next" and "previous" button, changing the scene when any of
        // the is clicked (so we don't need to make components invisible, etc).
        // Essentially, these scenes make it easy to reuse a container.

        // When we load the FXML we assign to a variable of type "Parent" with the name root.
        // The parent class descends directly from the node class which is the base class for scene graph nodes.
        // Nodes that descend from "Parent" can have children in the same scene graph.
        // Here the top-level and only node is "GridPane", so it'll be the root of the scene graph (which is also what
        // is returned from the "FXMLLoader.load" call)
        primaryStage.setScene(new Scene(root, 300, 275)); // Width and height
        primaryStage.show(); // Showing the "stage"

        // The "Stage" class provides all the window's declarations, such as close, resize and minimize button when
        // the project is being run.
    }


    public static void main(String[] args)
    {
        launch(args);
    }

}
