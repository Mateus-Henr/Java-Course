package tutorial;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tutorial.model.DataSource;

import java.io.IOException;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        // Loading the artists here because we want to make sure that the UI has been built (since this method only
        // runs after the "init()" method)
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.listArtists();
        Scene scene = new Scene(root, 800, 600);
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


