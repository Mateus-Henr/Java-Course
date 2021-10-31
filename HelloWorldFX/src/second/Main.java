package second;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        // Not using FXML anymore, we are defining the content of the FXML file through code.
        // Same code that the FXML "invokes".
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);

        Label greeting = new Label("Welcome to JavaFX!"); // Creating a label

        // Changing the color of the label's text
        greeting.setTextFill(Color.GREEN);

        // Changing the font of the label's text
        greeting.setFont(Font.font("Times New Roman", FontWeight.BOLD, 70));

        // get.Children() returns a list of children and we add our label as a children to this list.
        root.getChildren().add(greeting); // Passing the label as a children to the Panel (parent).

        primaryStage.setTitle("Hello JavaFX!");
        primaryStage.setScene(new Scene(root, 700, 275)); // Width and height
        primaryStage.show(); // Showing the "stage"

    }


    public static void main(String[] args)
    {
        launch(args);
    }

}
