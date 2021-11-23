package myUpdates;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import myUpdates.model.Album;
import myUpdates.model.Artist;
import myUpdates.model.DataSource;

public class Controller
{
    @FXML
    private TableView<Artist> artistTable;
    @FXML
    private TableView<Album> albumTable;
    @FXML
    private ProgressBar progressBar;

    @FXML
    public void listArtists()
    {
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());

        progressBar.progressProperty().bind(task.progressProperty());
        progressBar.setVisible(true);

        task.setOnSucceeded(e -> progressBar.setVisible(false));
        task.setOnFailed(e -> progressBar.setVisible(false));

        new Thread(task).start();
    }

    @FXML
    public void listAlbumsForArtist()
    {
        final Artist selectedArtist = artistTable.getSelectionModel().getSelectedItem();

        if (selectedArtist == null)
        {
            System.out.println("NO ARTIST SELECTED");
            return;
        }

        albumTable.setManaged(true);
        albumTable.setVisible(true);

        Task<ObservableList<Album>> task = new Task<>()
        {
            @Override
            public ObservableList<Album> call() throws Exception
            {
                return FXCollections.observableArrayList(DataSource.getInstance().queryAlbumForArtistID(selectedArtist.getID()));
            }
        };

        albumTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }

    @FXML
    public void updateArtist()
    {
        final Artist artist = (Artist) artistTable.getItems().get(2);

        Task<Boolean> task = new Task<Boolean>()
        {
            @Override
            protected Boolean call() throws Exception
            {
                return DataSource.getInstance().updateArtistName(artist.getID(), "AC/DC");
            }
        };

        task.setOnSucceeded(e ->
                            {
                                if (task.valueProperty().get())
                                {
                                    artist.setName("AC/DC");
                                    artistTable.refresh();
                                }
                            });

        new Thread(task).start();
    }

}

class GetAllArtistsTask extends Task
{
    @Override
    public ObservableList<Artist> call() throws Exception
    {
        return FXCollections.observableArrayList(DataSource.getInstance().queryArtists(DataSource.ORDER_BY_ASC));
    }

}