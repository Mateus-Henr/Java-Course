package tutorial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        // Editing the default "Medina" theme provided by JavaFX
        // We can edit it by using stylesheets or inline CSS in the FXML file.
        // The order of precedence is:
        // 1° - Inline CSS
        // 2° - Stylesheets
        // 3° - Application theme stylesheet
        // So by defining your own CSS you are overriding the JavaFX default CSS theme.
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
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