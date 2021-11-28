package tutorial.first;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

// We will be simulating getting data from a database through a background thread.
// Remember to edit UI control the JavaFX Application Thread must be used.
public class HelloController
{
    @FXML
    private ListView<String> listView; // We don't have to initialize FXML controls

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    public Task<ObservableList<String>> task;

    // This method is run whenever the Controller instance is created
    public void initialize()
    {
        // Simulating a list of employee names.
        task = new Task<ObservableList<String>>()
        {
            @Override
            protected ObservableList<String> call() throws Exception // We are not handling the exception.
            {
//                Thread.sleep(1000);

                String[] names = {
                        "Tim Buchalka",
                        "Bill Rogers",
                        "Jack Jill",
                        "Joan Andrews",
                        "Mary Johnson",
                        "Bob McDonald"};

                ObservableList<String> employees = FXCollections.observableArrayList();

                // Creating a loop to add the names and simulate the delay for the progress bar
                for (int i = 0; i < 6; i++)
                {
                    employees.add(names[i]);
                    updateMessage("Added " + names[i] + " to the list");
                    // This method takes two parameters the current progress and the maximum progress.
                    // Adding 1 because we are counting from 0.
                    updateProgress(i + 1, 6);
                    Thread.sleep(200);
                }

                // This method accepts a Runnable and runs in the UI thread.
                // It's not a good practise to tie a task to a UI in this way. If we change the UI we will also have to
                // change the task.
                // We are using data binding now.
//                Platform.runLater(() -> listView.setItems(employees));

                // We are return it to use data biding.
                return employees;
            }
        };

        // Gluing one list to the other
        // Doing it this way the task doesn't know anything about the UI.
        // It's not tied to the UI.
        listView.itemsProperty().bind(task.valueProperty());
        // More about Task at https://docs.oracle.com/javase/8/javafx/api/javafx/concurrent/Task.html

        // Adding code for the ProgressBar
        // In a real word we would display the progress bar just when we start a background task.
        // As default, it's defined as an undetermined progress bar, it means that nothing is reporting progress to it.
        // Binding the progress bar to the task that "fetches" data.
        progressBar.progressProperty().bind(task.progressProperty());

        // Binding the label text to the task message property that's updating whenever a name is added.
        progressLabel.textProperty().bind(task.messageProperty());

        // JAVAFX IS DESIGNED TO USE PROPERTIES BY BINDING THEM.
    }

    @FXML
    public void buttonPressed()
    {
        new Thread(task).start();
    }

}