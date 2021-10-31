package tutorial.first;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// JavaFX allows us to transform nodes in the scene graph, meaning that we can zoom in on them, rotate them, animate
// them, apply other effects, etc.
public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        // We can edit it by using stylesheets or inline CSS in the FXML file.
        // The order of precedence is:
        // 1° - Inline CSS
        // 2° - Stylesheets
        // 3° - Application theme stylesheet
        // So by defining your own CSS you are overriding the JavaFX default CSS theme.
//        setUserAgentStylesheet(STYLESHEET_CASPIAN); // Editing the default "Medina" theme provided by JavaFX
        Scene scene = new Scene(fxmlLoader.load(), 600, 275);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

}

// File Chooser Class
// It's a very rare Client Application that offers some type of open and save functionality.
// As it doesn't descend from the Node class it can't be added to the Scene graph (can't be added to the layout).