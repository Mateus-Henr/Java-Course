package tutorial.first;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// AnchorPane
// It's a top level layout that allows us to anchor children to its edges, which can influence what happens when
// the pane is resized.
// For example anchoring a title to the top of the pane, so when the window is resized a bunch of space isn't added
// between the title and the window's total bar.
//
// FlowPane
// It differs from previous layouts when it comes to wrapping its children, with HBox, children are laid out
// horizontally as a single row and if there isn't enough room when resizing the window, the children will be
// cut off (and the same thing occurs to VBox).
// With FlowPane the children won't be cut off unless the user resizes the window, they will be sent to the next row
// or column (depending on the setting).
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
