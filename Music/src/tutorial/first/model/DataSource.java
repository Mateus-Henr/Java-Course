package tutorial.first.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource
{
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:F:\\JavaCourse\\Music\\" + DB_NAME;

    // Using column indexes instead of column names is faster, however when using column names we don't have to do
    // any modifications to the position of the columns, in other words we don't have to change any code. However, we
    // were using column indexes if we change the positioning of a column we would have to modify the code.
    // When working with ResultSets the index that we pass to the ResultSet getter methods is the index of a column in
    // the ResultSet, not in the table. In the end, if retrieving all the columns the indexes in the ResultSet will be
    // the same as the indexes in the table, however when getting just a specific number of tables these indexes change.
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";

    private Connection conn;

    public boolean open()
    {
        try
        {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;

        }
        catch (SQLException e)
        {
            System.out.println("Couldn't connect to database " + e.getMessage());
            return false;
        }
    }

    public void close()
    {
        try
        {
            if (conn != null)
            {
                conn.close();
            }
        }
        catch (SQLException e)
        {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    // In larger apps we would create a model for each table and the Connections might be coming from a connection pool.
    // Our method shouldn't return a ResultSet, since we don't want classes that use methods in the model package to
    // have to understand the implementation details of the model. So if we change DB later or for something that isn't
    // a DB we only have to change the code in the model package. So instead of returning a ResultSet we will return
    // a list with the data.

    public List<Artist> queryArtists()
    {
//        Statement statement = null;
//        ResultSet results = null;
//
//        try
//        {
//            statement = conn.createStatement();
//            results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS);
//
//            List<Artist> artists = new ArrayList<>();
//            while (results.next())
//            {
//                Artist artist = new Artist();
//                artist.setID(results.getInt(COLUMN_ARTIST_ID));
//                artist.setName(results.getString(COLUMN_ARTIST_NAME));
//                artists.add(artist);
//            }
//
//            return artists;
//        }
//        catch (SQLException e)
//        {
//            System.out.println("Query failed: " + e.getMessage());
//            return null;
//        }
//        finally
//        {
//            // We have to close them independently, so we can have more specific messages about the error and for one
//            // not to stop the execution of the other in case of an exception.
//            try
//            {
//                if (results != null) // Closing the results first.
//                {
//                    results.close();
//                }
//            }
//            catch (SQLException e)
//            {
//                System.out.println("Error closing ResultSet: " + e.getMessage());
//            }
//            try
//            {
//
//                if (statement != null)
//                {
//                    statement.close();
//                }
//            }
//            catch (SQLException e)
//            {
//                System.out.println("Error closing Statement: " + e.getMessage());
//            }
//        }

        // Using "try-with-resources" and not having to worry about closing resources.
        // LOOK AT THIS BEAUTY
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS))
        {
            List<Artist> artists = new ArrayList<>();
            while (results.next())
            {
                Artist artist = new Artist();
                artist.setID(results.getInt(COLUMN_ARTIST_ID));
                artist.setName(results.getString(COLUMN_ARTIST_NAME));
                artists.add(artist);
            }

            return artists;
        }
        catch (SQLException e)
        {
            System.out.println("Error closing ResultSet: " + e.getMessage());
            return null;
        }
    }

}
