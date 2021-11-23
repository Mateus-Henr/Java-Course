package tutorial.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// We want the Controller to be able to use this class (in a real world app we would have more than one controller, and
// they all would need access).
// To keep things synchronize when using data source it's quite common to use a Singleton pattern.

public class DataSource
{
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:F:\\JavaCourse\\MusicUI\\" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 2;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME +
                    " FROM " + TABLE_ALBUMS +
                    " INNER JOIN " + TABLE_ARTISTS +
                    " ON " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ARTIST +
                    " = " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_ID +
                    " WHERE " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME + " = \"";

    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            " ORDER BY " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME +
                    " COLLATE NOCASE ";

    public static final String QUERY_ARTISTS_SORT =
            " ORDER BY " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME +
                    " COLLATE NOCASE ";

    public static final String QUERY_ARTIST_FOR_SONG_START =
            "SELECT " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + '.' +
                    COLUMN_ALBUM_NAME + ", " + TABLE_SONGS + '.' + COLUMN_SONG_TRACK +
                    " FROM " + TABLE_SONGS +
                    " INNER JOIN " + TABLE_ALBUMS +
                    " ON " + TABLE_SONGS + '.' + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ID +
                    " INNER JOIN " + TABLE_ARTISTS +
                    " ON " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_ID +
                    " WHERE " + TABLE_SONGS + '.' + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_ARTIST_FOR_SONG_SORT =
            " ORDER BY " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME +
                    " COLLATE NOCASE ";

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";

    public static final String CREATE_ARTIST_FOR_SONG_VIEW =
            "CREATE VIEW IF NOT EXISTS " + TABLE_ARTIST_SONG_VIEW +
                    " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS +
                    "." + COLUMN_ALBUM_NAME +
                    " AS " + COLUMN_SONG_ALBUM + ", " + TABLE_SONGS + "." + COLUMN_SONG_TRACK +
                    ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE +
                    " FROM " + TABLE_SONGS +
                    " INNER JOIN " + TABLE_ALBUMS +
                    " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
                    " INNER JOIN " + TABLE_ARTISTS +
                    " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " ORDER BY " +
                    TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
                    TABLE_SONGS + "." + COLUMN_SONG_TRACK;

    public static final String QUERY_VIEW_SONG_INFO =
            "SELECT " + COLUMN_ARTIST_NAME + ", " + COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK +
                    " FROM " + TABLE_ARTIST_SONG_VIEW +
                    " WHERE " + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_VIEW_SONG_INFO_PREP =
            "SELECT " + COLUMN_ARTIST_NAME + ", " + COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK +
                    " FROM " + TABLE_ARTIST_SONG_VIEW +
                    " WHERE " + COLUMN_SONG_TITLE + " = ?";

    public static final String INSERT_ARTIST =
            "INSERT INTO " + TABLE_ARTISTS +
                    '(' + COLUMN_ARTIST_NAME + ") VALUES(?)";

    public static final String INSERT_ALBUMS = "INSERT INTO " + TABLE_ALBUMS +
            '(' + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";

    public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS +
            '(' + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM + ") VALUES(?, ?, ?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID +
            " FROM " + TABLE_ARTISTS +
            " WHERE " + COLUMN_ARTIST_NAME + " = ?";

    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID +
            " FROM " + TABLE_ALBUMS +
            " WHERE " + COLUMN_ALBUM_NAME + " = ?";

    public static final String QUERY_ALBUMS_BY_ARTIST_ID =
            "SELECT * FROM " + TABLE_ALBUMS +
                    " WHERE " + COLUMN_ALBUM_ARTIST +
                    " = ? ORDER BY " + COLUMN_ALBUM_NAME +
                    " COLLATE NOCASE";

    public static final String UPDATE_ARTIST_NAME =
            "UPDATE " + TABLE_ARTISTS +
                    " SET " + COLUMN_ARTIST_NAME +
                    " = ? WHERE " + COLUMN_ARTIST_ID +
                    " = ?";

    private PreparedStatement querySongInfoView;
    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;
    private PreparedStatement queryAlbumsByArtistID;

    private PreparedStatement updateArtistName;

    private Connection conn;

    // This is also a lazy instantiation, because the instance won't be created until the first time the class is
    // loaded, in other words when a class calls the "getInstance()" method. The advantage of defining it here it's
    // because it's thread safe.
    private static DataSource instance = new DataSource();

    // Applying the Singleton pattern. When declaring a constructor private, only the class will be able to create
    // instances of itself.
    private DataSource()
    {

    }

    // This is called a lazy instantiation because the instance isn't created until the first time it's needed.
    // However, this is not thread safe meaning that we could have more than one instance at some point if a thread
    // returns where it shouldn't.
    public static DataSource getInstance()
    {
//        if (instance == null)
//        {
//            instance = new DataSource();
//        }
        // For accessing methods in this class
        // DataSource.getInstance().methodName();

        return instance;
    }

    // For the "open()" and "close()" methods in the context of a GUI app, we would want to show data when we open the
    // application, so the "open()" method should be called when the app executes and regarding the "close()" method
    // we would want to execute it when the user shuts down the app since we want to display data throughout the entire
    // process. Knowing that, we can use JavaFX methods (init and stop) to correlate with our database methods.

    public boolean open()
    {
        try
        {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = conn.prepareStatement(INSERT_SONGS);
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);
            queryAlbumsByArtistID = conn.prepareStatement(QUERY_ALBUMS_BY_ARTIST_ID);
            updateArtistName = conn.prepareStatement(UPDATE_ARTIST_NAME);

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
            if (querySongInfoView != null)
            {
                querySongInfoView.close();
            }

            if (insertIntoArtists != null)
            {
                insertIntoArtists.close();
            }

            if (insertIntoAlbums != null)
            {
                insertIntoAlbums.close();
            }

            if (insertIntoSongs != null)
            {
                insertIntoSongs.close();
            }

            if (queryArtist != null)
            {
                queryArtist.close();
            }

            if (queryAlbum != null)
            {
                queryAlbum.close();
            }

            if (queryAlbumsByArtistID != null)
            {
                queryAlbumsByArtistID.close();
            }

            if (updateArtistName != null)
            {
                updateArtistName.close();
            }

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

    public List<Artist> queryArtists(int sortOrder)
    {
        // Managing the ordering of the data
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (sortOrder != ORDER_BY_NONE)
        {
            sb.append(QUERY_ARTISTS_SORT);

            if (sortOrder == ORDER_BY_DESC)
            {
                sb.append("DESC");
            }
            else
            {
                sb.append("ASC");
            }
        }

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString()))
        {
            List<Artist> artists = new ArrayList<>();
            while (results.next())
            {
                // This "delay" has been added just to demonstrate the progress bar.
                try
                {
                    Thread.sleep(20);
                }
                catch (InterruptedException e)
                {
                    System.out.println("Interrupted: " + e.getMessage());
                }
                Artist artist = new Artist();
                artist.setID(results.getInt(INDEX_ARTIST_ID));
                artist.setName(results.getString(INDEX_ARTIST_NAME));
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

    // Getting the albums with the artist ID. We are querying it based on the ID because we don't need to do the extra
    // step to look for the artist name in the artists table.
    public List<Album> queryAlbumForArtistID(int ID)
    {
        try
        {
            queryAlbumsByArtistID.setInt(1, ID);
            ResultSet results = queryAlbumsByArtistID.executeQuery();

            List<Album> albums = new ArrayList<>();

            while (results.next())
            {
                Album album = new Album();
                album.setID(results.getInt(1));
                album.setName(results.getString(2));
                album.setArtistID(3);
                albums.add(album);
            }

            return albums;
        }
        catch (SQLException e)
        {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<String> queryAlbumsForArtist(String artistName, int sortOrder)
    {
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append(artistName);
        sb.append("\"");
        if (sortOrder != ORDER_BY_NONE)
        {
            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);

            if (sortOrder == ORDER_BY_DESC)
            {
                sb.append("DESC");
            }
            else
            {
                sb.append("ASC");
            }
        }

        System.out.println("SQL statement = " + sb.toString());

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString()))
        {
            List<String> albums = new ArrayList<>();

            while (results.next())
            {
                albums.add(results.getString(1));
            }

            return albums;
        }
        catch (SQLException e)
        {
            System.out.println("Error closing ResultSet: " + e.getMessage());
            return null;
        }
    }

    public void querySongsMetadata()
    {
        String sql = "SELECT * FROM " + TABLE_SONGS;

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql))
        {
            ResultSetMetaData meta = results.getMetaData();
            int numColumns = meta.getColumnCount();

            for (int i = 1; i <= numColumns; i++)
            {
                System.out.printf("Column %d in the songs table is names %s\n", i, meta.getColumnName(i));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Query failed: " + e.getMessage());
        }
    }

    public int getCount(String table)
    {
        String sql = "SELECT COUNT(*) AS count, MIN(_id) AS min_id FROM " + table;

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql))
        {
            int count = results.getInt("count");
            int min = results.getInt("min_id");

            System.out.printf("\nCount = %d, Min = %d\n", count, min);

            return count;
        }
        catch (SQLException e)
        {
            System.out.println("Query failed: " + e.getMessage());
            return -1;
        }
    }

    public boolean createViewForSongArtists()
    {
        try (Statement statement = conn.createStatement())
        {
            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println("Create view failed: " + e.getMessage());
            return false;
        }
    }

    private int insertArtist(String name) throws SQLException
    {
        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();

        if (results.next())
        {
            return results.getInt(1);
        }
        else
        {
            insertIntoArtists.setString(1, name);
            int affectedRows = insertIntoArtists.executeUpdate();

            if (affectedRows != 1)
            {
                throw new SQLException("Couldn't insert artist!");
            }

            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();

            if (generatedKeys.next())
            {
                return generatedKeys.getInt(1);
            }
            else
            {
                throw new SQLException("Couldn't get _id for artist");
            }
        }
    }

    private int insertAlbum(String name, int artistID) throws SQLException
    {
        queryAlbum.setString(1, name);
        ResultSet results = queryAlbum.executeQuery();

        if (results.next())
        {
            return results.getInt(1);
        }
        else
        {
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistID);
            int affectedRows = insertIntoAlbums.executeUpdate();

            // Still just updating one record
            if (affectedRows != 1)
            {
                throw new SQLException("Couldn't insert album!");
            }

            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();

            if (generatedKeys.next())
            {
                return generatedKeys.getInt(1);
            }
            else
            {
                throw new SQLException("Couldn't get _id for album");
            }
        }
    }

    public boolean updateArtistName(int ID, String newName)
    {
        try
        {
            updateArtistName.setString(1, newName);
            updateArtistName.setInt(2, ID);

            int affectedRecords = updateArtistName.executeUpdate();

            return affectedRecords == 1; // Return true if we updated one record
        }
        catch (SQLException e)
        {
            System.out.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    public void insertSong(String title, String artist, String album, int track)
    {
        try
        {
            conn.setAutoCommit(false);

            int artistID = insertArtist(artist);
            int albumID = insertAlbum(album, artistID);

            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumID);

            int affectedRows = insertIntoSongs.executeUpdate();

            if (affectedRows == 1)
            {
                conn.commit();
            }
            else
            {
                throw new SQLException("The song insert failed");
            }

        }
        catch (Exception e)
        {
            System.out.println("Insert song exception: " + e.getMessage());
            try
            {
                System.out.println("Performing rollback");
                conn.rollback();
            }
            catch (SQLException e2)
            {
                System.out.println("Oh boy! Things are really bad! " + e2.getMessage());
            }
        }
        finally
        {
            try
            {
                System.out.println("Resetting default commit behaviour");
                conn.setAutoCommit(true);
            }
            catch (SQLException e)
            {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }
        }
    }

}