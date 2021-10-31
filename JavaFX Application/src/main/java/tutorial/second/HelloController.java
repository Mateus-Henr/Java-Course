package tutorial.second;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class HelloController
{
    @FXML
    private Label label;
    @FXML
    private Button button4;
    @FXML
    private GridPane gridPane;
    @FXML
    private WebView webView;

    public void initialize()
    {
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handlerMouseEnter()
    {
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handlerMouseExit()
    {
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    public void handleClick()
    {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Application File");
        // To allow default types of files to be saved we can set the File chooser Extension Filters.
        // When creating an instance of "ExtensionFilter" we pass in a description of the file extension as the first
        // parameter and the file extension as the second parameter.
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"),
                // "Catch all" filter
                new FileChooser.ExtensionFilter("AllFiles", "*.*"));
        // This method is used when the user wants to save a file, and it'll return the path from where the user's
        // saved it at, but the returned path will be limited to what was selected, if "PDF" was selected even if the
        // user tries to modify the extension for something like: "myFile.mine", it'll be saved as "myFile.mine.pdf".
//        File file = chooser.showSaveDialog(gridPane.getScene().getWindow());

        // In a "openShowDialog" the "ExtensionFilter" is convenient because we can limit the number of files that the
        // user sees, just by allowing him to see one specific file extension.
        // In other words, when filters are set the FileChooser will only display files that match that filter.
        // When the user wants to open a file that doesn't match those filters, we can't really prohibit it.
//        File file = chooser.showOpenDialog(gridPane.getScene().getWindow());

//        if (file != null)
//        {
//            System.out.println(file.getPath());
//        }
//        else
//        {
//            System.out.println("Chooser was canceled.");
//        }

        // To give the user the ability of opening more than one file we can use the following method:
        List<File> files = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());

        if (files != null)
        {
            for (int i = 0; i < files.size(); i++)
            {
                System.out.println(files.get(i));
            }
        }
        else
        {
            System.out.println("Chooser was canceled.");
        }
    }

    // Seeing web pages through JavaFX applications
    // The "help" item is one common example of it.
    // There are two ways of doing it, we can open the system's default browser or add a WebView controller to our UI
    // and display the contents of the web page within the WebView.
    @FXML
    public void handleLinkClick()
    {
        System.out.println("The link was clicked!");

        // Opening the link on the user's browser.
//        try
//        {
//            Desktop.getDesktop().browse(new URI("http://www.javafx.com")); // Getting default browser
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        catch (URISyntaxException e)
//        {
//            e.printStackTrace();
//        }

        // Showing the WebView UI in our UI.
        WebEngine engine = webView.getEngine();
        engine.load("http://www.javafx.com");
        // More info on: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/web/WebEngine.html
    }

}