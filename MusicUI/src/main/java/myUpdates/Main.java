package myUpdates;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import myUpdates.model.DataSource;

import java.io.IOException;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
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

    @Override
    public void init() throws Exception
    {
        super.init();
        if (!DataSource.getInstance().open())
        {
            System.out.println("FATAL ERROR: Couldn't connect to database");
            Platform.exit();
        }
    }

    @Override
    public void stop() throws Exception
    {
        super.stop();
        DataSource.getInstance().close();
    }

}


