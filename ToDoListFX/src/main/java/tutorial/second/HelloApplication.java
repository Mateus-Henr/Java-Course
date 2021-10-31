package tutorial.second;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tutorial.second.datamodel.ToDoData;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setTitle("ToDo List");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

    // The method runs when the user exits the application. It's going to be used to store our items.
    @Override
    public void stop() throws Exception
    {
        try
        {
            ToDoData.getInstance().storeToDoItems(); // Getting the instance and calling the static method.
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() throws Exception
    {
        try
        {
            ToDoData.getInstance().loadToDoItems(); // Loads the data into the instance of the Singleton class.
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}