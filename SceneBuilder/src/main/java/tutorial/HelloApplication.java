package tutorial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Scene Builder
// It's a GUI builder (Graphical User Interface Builder), which is system to build UIs by using dragging and dropping
// interactions, so instead of writing FXML ourselves it writes it for us.
// It's important to learn how to write code rather than just using tools that generate code automatically, since
// these "tools" might get discontinuous, etc.
//
// Installing Screen Builder on Windows (https://gluonhq.com/products/scene-builder/)
// Go to the site and install the version for your PC, and install it. Also while installing pay attention to the
// folder where it's going to download it in.
// The Screen Builder has its own UI, but we can use Intellij to display it.
// To do that click on "Configure > Settings > Languages & Frameworks > JavaFX", then you need to select the where the
// "ScreenBuilder.exe" file that's inside the folder where Screen Builder installed itself (it's usually in the
// "AppData" folder).
// We can see a tab on the bottom of the page when using ScreenBuilder on a project.

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

}

// Using Screen Builder standalone version
// To start just search for the app and open it.
// You can use both at the same time (Screen Builder and Intellij), also any modifications that you make on some file
// (i.e. CSS file) will be updated on the Screen Builder app.
// You can also search things on the standalone version. It also gives you the possibility of defining a Controller.
// In overall, it's better to work with Screen Builder outside Intellij, since any changes make in Intellij will be
// automatically reflected on Screen Builder. So the project is in Intellij and the FXML is in Screen Builder.
