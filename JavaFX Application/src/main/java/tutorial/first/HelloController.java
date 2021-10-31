package tutorial.first;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class HelloController
{
    @FXML
    private Label label;
    @FXML
    private Button button4;
    @FXML
    private GridPane gridPane;

    public void initialize()
    {
        button4.setEffect(new DropShadow()); // The drop shadow itself can be customized as well.
    }

    @FXML
    public void handlerMouseEnter()
    {
        // "setScale" methods are used to zoom in or out in controls.
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handlerMouseExit()
    {
        // Setting them to the original size.
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    public void handleClick()
    {
        // Calling the "shownOpenDialog" method that shows the FileChooser in open mode.
        // However, it's needed to pass in a parent window to this method.
//        FileChooser chooser = new FileChooser();
        // If we don't pass in a parent window the FileChooser does open, but as it has no connection with the main
        // window it can be opened multiple times, in other words the main window it's still accessible. Beyond that
        // because of the no connection we can even close the program and the FileChooser will stay opened.
//        chooser.showOpenDialog(gridPane.getScene().getWindow());
        // To make the FileChooser open in a specific directory whe can use the "setInitialDirectory" method.


        // If we want the user to select a directory we use the "DirectoryChooser" class.
        DirectoryChooser chooser = new DirectoryChooser();
        // Using "File" here to save the selected directory.
        File file = chooser.showDialog(gridPane.getScene().getWindow());
        if (file != null)
        {
            System.out.println(file.getPath());
        }
        else
        {
            System.out.println("Chooser was canceled.");
        }
    }

}