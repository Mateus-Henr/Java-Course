package tutorial.first;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Layout
// Layouts allow us to add controls, which are UI components, to a container without having to write code to manage
// the positioning and resizing behaviour of those controllers.
//
// Preferred size concept
// Every control computes its preferred size based on its contents (depending on the size of the content of the
// control, it will have a specific width/height).
//
// When a controller is placed into a layout it becomes a child of that layout.
// So some layouts will ensure that their children display at their preferred width or height.

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
