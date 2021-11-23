package tutorial;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import tutorial.model.Album;
import tutorial.model.Artist;
import tutorial.model.DataSource;

// Performing queries and binding results.

// Remember that we ALWAYS want to perform long tasks in a background thread, not in the main JavaFX app thread.
// The steps will be:
// 1 - Create a task to perform the database action.
// 2 - Initialize the task with the necessary values to perform an action (if necessary).
// 3 - Implement the "Task.call()" method to perform the action.
// 4 - Bind the results from the previous method to the TableView's items property.
// 5 - Invoke the task.

// When we want to update something on the User Interface we have to do so on the JavaFX Application UI Thread.
// And when using data binding the UI code will run on the UI Thread automatically. If not we would run on the
// "Platform.runLater()" or on the "Task.setOnSucceeded()".

public class Controller
{
    // NOT RECOMMENDED
    @FXML
    private TableView artistTable;
    // This progress bar will only be used to show that the app is working. As we load data in one go, there wouldn't be
    // much usage for it trying to display the progress of this task, for that reason we added some code to delay this
    // process in the DataSource class.
    // This will be an undetermined progress bar, it won't show any progress it'll just move from left to right and the
    // other way around.
    @FXML
    private ProgressBar progressBar;

    // Using it as an event as well.
    @FXML
    public void listArtists()
    {
        Task<ObservableList<Artist>> task = new GetAllArtistsTask(); // Creating the object.
        // Binding the results of the task to the TableView's items property.
        artistTable.itemsProperty().bind(task.valueProperty());

        // Any code that modifies a UI control has to run inside the UI thread.
        progressBar.progressProperty().bind(task.progressProperty());
        progressBar.setVisible(true);

        task.setOnSucceeded(e -> progressBar.setVisible(false));
        task.setOnFailed(e -> progressBar.setVisible(false));

        // Invoking the task (Challenge)
        new Thread(task).start();
    }

    @FXML
    public void listAlbumsForArtist()
    {
        final Artist selectedArtist = (Artist) artistTable.getSelectionModel().getSelectedItem();

        if (selectedArtist == null)
        {
            System.out.println("NO ARTIST SELECTED");
            return;
        }

        // Using an anonymous class since we don't have to use it multiple times.
        Task<ObservableList<Album>> task = new Task<>()
        {
            @Override
            public ObservableList<Album> call() throws Exception
            {
                return FXCollections.observableArrayList(DataSource.getInstance().queryAlbumForArtistID(selectedArtist.getID()));
            }
        };

        artistTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

    // Ways to keep the database in sync with the UI when doing operations
    // 1° - Requery the database after the operation, being okay for small data sets.
    // 2° - With data binding we can find a specific record in the list an update the field.
    // We don't want to update the User Interface first because if the database operation fails the UI will be out of
    // sync with the database. The other way around isn't as bad since the user won't see the change, but it would be
    // in the database.
    // Translating it into code, we can do the database operation, and then we run the UI update using
    // "Task.setOnSucceeded()". After that we just use the "refresh()" method.
    // This method will be simulating the update to avoid having to create a dialog that receives the new name.
    @FXML
    public void updateArtist()
    {
        // Specific Item
        final Artist artist = (Artist) artistTable.getItems().get(2);

        Task<Boolean> task = new Task<Boolean>()
        {
            @Override
            protected Boolean call() throws Exception
            {
                // Updating the record in the database.
                return DataSource.getInstance().updateArtistName(artist.getID(), "AC/DC");
            }
        };

        task.setOnSucceeded(e ->
                            {
                                if (task.valueProperty().get())
                                {
                                    artist.setName("AC/DC"); // Altering the name of the object in the UI.
                                    // It forces the TableView to redraw its visible area, it won't redraw areas
                                    // that are off the screen. But these areas will redraw when the user scrolls
                                    // towards them.
                                    artistTable.refresh(); // Forcing the refresh of the UI.
                                }
                            });

        new Thread(task).start();
    }

}

// We are creating a separate class because we may need to use this class in two places, first when starting the app,
// and second when the user asks for it.
class GetAllArtistsTask extends Task
{
    // If we want to use data binding to populate the table this method has to return an "ObservableList" of artists.
    @Override
    public ObservableList<Artist> call() throws Exception
    {
        // We don't want the method in "DataSource" to return an "ObservableList", since it would violate the
        // separation between the model and UI code.
        return FXCollections.observableArrayList(DataSource.getInstance().queryArtists(DataSource.ORDER_BY_ASC));
    }

}