package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// HBox Layout lays out its children horizontally in a single row and sizes its children to their preferred widths.
// If there's any horizontal spaces left over, it's going to stretch itself to fill the excess rather than stretching
// its children.
// The height is very similar to the width in the matter of stretching itself.
// It's often used to lay out a set of buttons in a dialogue (used as a child of another layout).
// The VBox layout is very similar to the HBox layout, being the difference that it just lays out things vertically.

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
