package tutorial;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import tutorial.model.Artist;
import tutorial.model.DataSource;

public class Controller
{
    @FXML
    private TableView<Artist> artistTable;

    public void listArtists()
    {
        Task<ObservableList<Artist>> task = new GetAllArtistsTask(); // Creating the object.

        // Binding the results of the task to the TableView's items property.
        artistTable.itemsProperty().bind(task.valueProperty());
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