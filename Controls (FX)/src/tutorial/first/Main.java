package tutorial.first;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1500, 500));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }

}

// We are adding the "jlfgr" (Java Look and Feel Graphics Repository) jar to the modules of this project,
// it can be found in the folder of this project. Select "Classes" when setting it up.