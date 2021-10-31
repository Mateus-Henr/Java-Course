package tutorial.second;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import tutorial.second.datamodel.ToDoData;
import tutorial.second.datamodel.ToDoItem;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class HelloController
{
    private List<ToDoItem> toDoItems;

    @FXML
    private ListView<ToDoItem> toDoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;
    @FXML
    private BorderPane mainBorderPane;

    public void initialize()
    {
        // The hard code that initialized the items has been removed from here (can still be found in the "first" package
        // if needed. Before removing we had put the data into the Singleton class to save our data).

        toDoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoItem>()
        {
            @Override
            public void changed(ObservableValue<? extends ToDoItem> observableValue, ToDoItem oldValue, ToDoItem newValue)
            {
                if (newValue != null)
                {
                    ToDoItem item = toDoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());

                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

//        toDoListView.getItems().setAll(ToDoData.getInstance().getToDoItems()); // Using the Singleton
        toDoListView.setItems(ToDoData.getInstance().getToDoItems());
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        toDoListView.getSelectionModel().selectFirst();

        // For a highlighting items that have already "expired" we will be using a "Cell Factory". Each item in the
        // ListView is being displayed in a cell, so we can customize how it looks by assigning a Custom Cell Factory
        // to the ListView. When using it we need to declare a callback method that will be called when the ListView
        // wants to customize the cell.
        toDoListView.setCellFactory(new Callback<ListView<ToDoItem>, ListCell<ToDoItem>>()
        { // The first parameter is the type of data that we are going to receive and teh second is the returned one.
            @Override
            public ListCell<ToDoItem> call(ListView<ToDoItem> toDoItemListView)
            { // This method will run whenever the ListView wants to paint a single cell.
                ListCell<ToDoItem> cell = new ListCell<>()
                {
                    @Override
                    protected void updateItem(ToDoItem toDoItem, boolean empty)
                    {
                        // As we want to keep most of the appearance provided by the Label class this has been kept.
                        super.updateItem(toDoItem, empty);

                        if (empty)
                        {
                            setText(null);
                        }
                        else
                        {
                            // As we are defining the item's text here, we don't need to set it anymore in the
                            // ToDoItem class.
                            setText(toDoItem.getShortDescription());
                            // Checking for today and before today.
                            if (toDoItem.getDeadline().isBefore(LocalDate.now().plusDays(1)))
                            {
                                setTextFill(Color.RED);
                            }
                            // Checking for tomorrow
                            else if (toDoItem.getDeadline().equals(LocalDate.now().plusDays(1)))
                            {
                                setTextFill(Color.BROWN);
                            }
                        }
                    }
                };

                return cell;
            }
        });
    }

    public void showNewItemDialog()
    {
        // As we want the dialog to pop up when the user clicks on File -> New, we are using it here.
        // A Modal Dialog is a dialog that while it's opened (visible) it doesn't allow the user to interact with the
        // other parts of the application. By default, it's modal.
        Dialog<ButtonType> dialog = new Dialog<>();
        // It's good practise to set the dialog's owner or parent that is the window that the dialog was opened from.
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New ToDo Item"); // Just a title for the dialog.
        dialog.setHeaderText("Use this dialog to create a new item");
        // The dialog header text is different from the dialog pane text. The dialog pane text will appear at the border
        // of the window, however dialog header text will appear as some sort of title on the "content".

        // Initializing our FXML file.
        // Initializing this in this way to make possible for us to get the Controller from the FXMLLoader.
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("toDoItemDialog.fxml"));

        try
        {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }
        catch (IOException e)
        {
            System.out.println("couldn't load the dialog.");
            e.printStackTrace();
            return;
        }

        // Adding buttons through code since by the time that the video was made FX didn't support buttons on the FXML.
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            // Calling the Controller through the instance mentioned above.
            DialogController controller = fxmlLoader.getController();
            ToDoItem newItem = controller.processResult(); // The Event Listener when the "OK" is pressed.

            // Our ListView doesn't automatically update, so for now we are replacing the ListView for a new one.
            // It's not a good idea to always repopulate the list as we are doing here because in other parts
            // of the app could have problems with data synchronization.
            // So to avoid having to "setAll" the items everytime that there's a change on the ListView we are going to
            // use data binding. When we bing a control to data, the control is going to notice when the data changes
            // automatically. It works very similarly as an event handler works. When the controller is populated with
            // what's called an observable collection, it's going to react to events raised by that collection by
            // running a handler (so when there's any modification on the items the controller will change what it's
            // displaying).
//            toDoListView.getItems().setAll(ToDoData.getInstance().getToDoItems());
            toDoListView.getSelectionModel().select(newItem); // Selecting the recently created item.

            System.out.println("OK pressed"); // "Enter" is also interpreted as "OK".
        }
        else
        {
            System.out.println("Cancel pressed");
        }
    }

    // There are two methods for showing the Dialog, being them:
    // show() - Brings up a non-blocking Dialog (Returns immediately after showing the dialog).
    // showAndWait() - Brings up a blocking Dialog (waits for the user to press a button). (Generally used)
}

// Control descendants from the Label class can display text and graphics.
// Using data binding we don't explicitly have to update the UI.
// Usually the other "View" controllers have the same resources as the "ListView".