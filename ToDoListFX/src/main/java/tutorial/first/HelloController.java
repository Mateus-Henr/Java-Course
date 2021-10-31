package tutorial.first;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import tutorial.first.datamodel.ToDoItem;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// The Controller handles the interaction between the user interface and the data model.
public class HelloController
{
    private List<ToDoItem> toDoItems;

    @FXML
    private ListView<ToDoItem> toDoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;

    // Initializing our app with some sample data.
    public void initialize()
    {
        ToDoItem item1 = new ToDoItem("Mail birthday card",
                "Buy a 30th birthday card for John",
                LocalDate.of(2016, Month.APRIL, 25));
        ToDoItem item2 = new ToDoItem("Doctor's Appointment",
                "See Dr. Smith at 123 Main Street. Bring paperwork",
                LocalDate.of(2016, Month.MAY, 25));
        ToDoItem item3 = new ToDoItem("Finish design proposal for client",
                "I promised Mike I'd email website mockups by Friday 22nd April",
                LocalDate.of(2016, Month.APRIL, 22));
        ToDoItem item4 = new ToDoItem("Pickup Doug at the train station",
                "Doug's arriving on March 23 on the 5:00 train",
                LocalDate.of(2016, Month.MARCH, 25));
        ToDoItem item5 = new ToDoItem("Pick up dry cleaning",
                "The clothes should be ready by Wednesday",
                LocalDate.of(2016, Month.APRIL, 25));

        toDoItems = new ArrayList<>();
        toDoItems.add(item1);
        toDoItems.add(item2);
        toDoItems.add(item3);
        toDoItems.add(item4);
        toDoItems.add(item5);

        // As we don't select the first item by clicking on it (we are currently selecting it when the event handler is
        // performed), we need to set it up.
        // Instead of assigning an event handler to the onMouseClicked property, we will run our event handler
        // whenever the selected item property of the selection model changes.
        toDoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoItem>()
        {
            // Listening to list changes to always select the last item entered by the user.
            // Event handlers are also known as event listeners, because an app will listen for an event and when the
            // event is raised the associated event listener will run.
            // When making code to set up event listeners is very common to use lambda expressions, as shown here.
            @Override
            public void changed(ObservableValue<? extends ToDoItem> observableValue, ToDoItem oldValue, ToDoItem newValue)
            {
                if (newValue != null)
                {
                    ToDoItem item = toDoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());

                    // Formatting the date (receives a LocalDate object for most of its methods)
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                    // More information on the following link:
                    // https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
                }
            }
        });

        toDoListView.getItems().setAll(toDoItems);
        // The ListView could be multiple selected, meaning that the user would be able to select more than one item
        // at a time. So if you want it to be single selected you have to set it up.
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        toDoListView.getSelectionModel().selectFirst(); // Selecting the first item.
        // Bear in mind that by default the ListView will display the items using their "toString()" method, in other
        // words it will display the object reference.
    }

//    // We aren't using this event handler anymore, we wouldn't be able to manage list updates and TextArea initial
//    // value through here, therefore we started using a more generic event handler that listens for changes on the list.
//    @FXML
//    public void handleClickListView()
//    {
//        // The SelectModel class tracks which item is selected on the control. (We used it below when setting the
//        // list up for selecting just one item).
//        // If we had multiple items selected we could use "getSelectionModel().getSelectedItems()" to get all of them.
//        // If we don't declare a type when declaring the "ListView" we need to do some casting here, since it's going
//        // to return an "Object" type.
//        ToDoItem item = toDoListView.getSelectionModel().getSelectedItem();
//        itemDetailsTextArea.setText(item.getDetails());
//        deadlineLabel.setText(item.getDeadline().toString());
//        System.out.println("The selected item is " + item);
//
//        // Changing the handler that instead of writing to the console we are going to display the details on the
//        // TextArea.
//        // Not using StringBuilder, because we define specific slots for the items.
////        StringBuilder sb = new StringBuilder(item.getDetails()); // Initializing with some values.
////        sb.append("\n\n\n");
////        sb.append("Due: ");
////        sb.append(item.getDeadline().toString());
////        itemDetailsTextArea.setText(sb.toString());
//    }

}