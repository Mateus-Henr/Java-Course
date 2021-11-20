package tutorial;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tutorial.model.DataSource;

import java.io.IOException;

// Remember that we ALWAYS want to perform long tasks in a background thread, not in the main JavaFX app thread.
// The steps will be:
// 1 - Create a task to perform the database action.
// 2 - Initialize the task with the necessary values to perform an action (if necessary).
// 3 - Implement the "Task.call()" method to perform the action.
// 4 - Bind the results from the previous method to the TableView's items property.
// 5 - Invoke the task.

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Music Database");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

    // Runs before the "start()" method that creates the user interface.
    @Override
    public void init() throws Exception
    {
        // These "super()" methods that appear by default in these methods don't really do anything
        super.init();
        // If any errors appear during the initialization process of the database we don't want the UI to appear.
        // So we are quitting the UI in case of that happening.
        if (!DataSource.getInstance().open())
        {
            System.out.println("FATAL ERROR: Couldn't connect to database");
            Platform.exit();
        }
    }

    // Runs when the app is shutting down.
    @Override
    public void stop() throws Exception
    {
        super.stop();
        DataSource.getInstance().close();
    }

}