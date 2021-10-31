package tutorial.third;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import tutorial.third.datamodel.ToDoData;
import tutorial.third.datamodel.ToDoItem;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

// A Context Menu is a menu pop-up, very similar to the menu that appears when we click with the right button.
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
    @FXML
    private ContextMenu listContextMenu;
    @FXML
    private ToggleButton filterToggleButton;

    // Declaring it here, because we will use it in an Event Handler.
    // THIS SOLVES A DOUBT THAT I HAD BEFORE, that is: if you want to pass something as parameter to an Event Handler
    // you have to declare a class instance instead of trying to receive the object as a parameter.
    private FilteredList<ToDoItem> filteredList;

    private Predicate<ToDoItem> wantAllItems;

    private Predicate<ToDoItem> wantTodayItems;

    // FOR EVENTS THAT WILL HAPPEN THROUGHOUT THE PROGRAM THEY WILL STAY HERE.
    // This method is called after all the "@FXML" members have been injected.
    @FXML
    public void initialize()
    {
        // Creating the Context Menu for deleting items.
        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        MenuItem updateMenuItem = new MenuItem("Edit");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                ToDoItem itemToDelete = toDoListView.getSelectionModel().getSelectedItem();
                deleteItem(itemToDelete);
            }
        });
        updateMenuItem.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                ToDoItem itemToUpdate = toDoListView.getSelectionModel().getSelectedItem();
                showUpdateItemDialog(itemToUpdate);
            }
        });
        // Adding the delete item menu to our ContextMenu.
        listContextMenu.getItems().addAll(deleteMenuItem);
        listContextMenu.getItems().addAll(updateMenuItem);

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

        wantAllItems = new Predicate<ToDoItem>()
        {
            @Override
            public boolean test(ToDoItem toDoItem)
            {
                return true;
            }
        };

        wantTodayItems = new Predicate<ToDoItem>()
        {
            // The filteredList will call this method for each item on the list, if it returns true the item will
            // be considered in the filteredList.
            @Override
            public boolean test(ToDoItem toDoItem)
            {
                return toDoItem.getDeadline().equals(LocalDate.now());
            }
        };

        // As it is in the "initialize" method, it will be the first value of the list.
        filteredList = new FilteredList<>(ToDoData.getInstance().getToDoItems(), wantAllItems);

        // A Comparator will be used, so its method "compare" will be called to compare one toDoItem with another.
        // We are doing this to organize the items by the dates that they are due to.
        // The two parameters here are: the observableArrayList with our items and the second is the Comparator.
        // Passing the filteredList as parameter for sorting the items.
        SortedList<ToDoItem> sortedList = new SortedList<>(filteredList, new Comparator<ToDoItem>()
        {
            // We pass the ToDoItems to be compared as "o1" and "o2". Knowing that we must configure it, in a
            // way that it returns a negative value if object o1 is considered to be less than object o2.
            // It must return 0 if the objects are considered to be equal.
            // If the object o1 is considered to be greater than object o2, it must return a positive value.

            // We will be comparing deadlines and the same are instances of the "LocalDate" class, so the
            // "compareTo" method from this class will be used and this method follows the same pattern as the
            // "compareTo" method from "Comparator". (0 if equal, 1 if "o1" is greater than "o2" and -1
            // otherwise).
            @Override
            public int compare(ToDoItem o1, ToDoItem o2)
            {
                return o1.getDeadline().compareTo(o2.getDeadline());
            }
        });

        // As we are still populating the ListView using the observableArrayList the next line has been commented out.
//        toDoListView.setItems(ToDoData.getInstance().getToDoItems());
        toDoListView.setItems(sortedList); // Using the SortedList now.
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        toDoListView.getSelectionModel().selectFirst();

        toDoListView.setCellFactory(new Callback<ListView<ToDoItem>, ListCell<ToDoItem>>()
        {
            @Override
            public ListCell<ToDoItem> call(ListView<ToDoItem> toDoItemListView)
            {
                ListCell<ToDoItem> cell = new ListCell<>()
                {
                    @Override
                    protected void updateItem(ToDoItem toDoItem, boolean empty)
                    {
                        super.updateItem(toDoItem, empty);

                        if (empty)
                        {
                            setText(null);
                        }
                        else
                        {
                            setText(toDoItem.getShortDescription());
                            if (toDoItem.getDeadline().isBefore(LocalDate.now().plusDays(1)))
                            {
                                setTextFill(Color.RED);
                            }
                            else if (toDoItem.getDeadline().equals(LocalDate.now().plusDays(1)))
                            {
                                setTextFill(Color.BROWN);
                            }
                        }
                    }
                };
                // It makes sense to associate the Context Menu in the Cell Factory since, it's only going to display
                /// itself when a click happens on a specific item.
                // Adding a listener for the cell's empty property. When the cell becomes non-empty, the context is
                // going to be associated to it. In other words setting the Context Menu to only cells that have data.
                cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) ->
                {
                    if (isNowEmpty)
                    {
                        cell.setContextMenu(null); // Turning it off if it's null.
                    }
                    else
                    {
                        cell.setContextMenu(listContextMenu);
                    }
                });

                return cell;
            }
        });
    }

    @FXML
    public void showNewItemDialog()
    {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("New ToDo Item");
        dialog.setHeaderText("Use this dialog to add a new item");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("toDoItemDialog.fxml"));

        try
        {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }
        catch (IOException e)
        {
            System.out.println("Couldn't load the dialog.");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            DialogController controller = fxmlLoader.getController();
            ToDoItem newItem = controller.processResult();
            toDoListView.getSelectionModel().select(newItem);

            System.out.println("OK pressed");
        }
        else
        {
            System.out.println("Cancel pressed");
        }
    }

    public void showUpdateItemDialog(ToDoItem itemToUpdate)
    {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Update ToDo Item");
        dialog.setHeaderText("Use this dialog to update an item");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("toDoItemDialog.fxml"));

        try
        {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }
        catch (IOException e)
        {
            System.out.println("Couldn't load the dialog.");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            DialogController controller = fxmlLoader.getController();
            ToDoItem updatedItem = controller.updateItem(itemToUpdate);
            toDoListView.getSelectionModel().select(updatedItem);

            System.out.println("OK pressed");
        }
        else
        {
            System.out.println("Cancel pressed");
        }
    }

    // To configure the "Del" key to be the same as clicking on the delete icon we need to listen for when the user
    // presses a key when the ListView's got focus. Typically, a Controller is given focus when the user clicks on it
    // or when the user clicks within a TextField. When the user presses a key, a key event is raised and key event
    // handlers associated with the TextField will be called (if there are other controls associate to that specific key
    // they won't be called since they don't have focus).
    @FXML
    public void handleKeyPressed(KeyEvent keyEvent)
    {
        ToDoItem selectedItem = toDoListView.getSelectionModel().getSelectedItem();

        if (selectedItem != null)
        {
            if (keyEvent.getCode().equals(KeyCode.DELETE))
            {
                deleteItem(selectedItem);
            }
        }
    }

    public void deleteItem(ToDoItem itemToDelete)
    {
        // Dialog box to confirm the item deletion.
        // We are going to be using an Alert. Its first parameter is the type of box, that might be Error,
        // Confirmation, Information, Warning and None. Each of them will have their own specific properties, however
        // "None" doesn't initialize any properties.
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete ToDo Item");
        alert.setHeaderText("Delete item: " + itemToDelete.getShortDescription());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to back out.");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK))
        {
            ToDoData.getInstance().deleteToDoItem(itemToDelete);
        }
        // As we are using a Confirmation Alert it provides the button automatically.
    }

    // Code for the "ToggleButton" filter.
    @FXML
    public void handleFilterButton()
    {
        ToDoItem selectedItem = toDoListView.getSelectionModel().getSelectedItem();
        // Just as we did with the "SortedList", for filtering items we use a "FilteredList".
        // Selecting the item that the user has selected previously if it's in the filteredList, otherwise
        // the first item will be selected.
        if (filterToggleButton.isSelected())
        {
            // When filtering we need to set a criteria.
            filteredList.setPredicate(wantTodayItems);
            if (filteredList.isEmpty())
            {
                // Cleaning the data info if there's no items.
                // It was a bug that if we changed from today's items to all items and vice and versa, a latter item
                // could still be selected.
                itemDetailsTextArea.clear();
                deadlineLabel.setText("");
            }
            else if (filteredList.contains(selectedItem))
            {
                toDoListView.getSelectionModel().select(selectedItem);
            }
            else
            {
                toDoListView.getSelectionModel().selectFirst();
            }
        }
        else
        {
            // By defining the Predicate as instances makes the code cleaner.
            filteredList.setPredicate(wantAllItems);
            toDoListView.getSelectionModel().select(selectedItem);
        }
    }

    @FXML
    public void handleExit()
    {
        Platform.exit(); // Closes the app.
    }

}
// If you want to do something new it's always a good idea to look at the FX documentation in order to not complicate
// things.