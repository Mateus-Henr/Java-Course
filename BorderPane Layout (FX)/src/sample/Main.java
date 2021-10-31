package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// It's one of the most famous layouts for top level windows.
// When using this layout you can place controls into one of five positions: top, bottom, left, right and center.
// The structure of "Eclipse" is very similar to how this layout is positioned.
// Children in the top and bottom positions will have their preferred height and extend the width of the BorderPane.
// In the other hand, children in the sides will have an extended height and a preferred width.
// When a position is empty no space is given to it and another extend in it (we don't have to have all the positions).

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }

}
