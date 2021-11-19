package tutorial.fifth.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource
{
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:F:\\JavaCourse\\Music\\" + DB_NAME;

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

    // Using these constants to check if the artist/album exists.
    // If it doesn't exist we are going to return the new ID after the "INSERT".
    // Therefore, by doing this we cover ourselves for the two possibilities of item existence.
    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID +
            " FROM " + TABLE_ARTISTS +
            " WHERE " + COLUMN_ARTIST_NAME + " = ?";

    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID +
            " FROM " + TABLE_ALBUMS +
            " WHERE " + COLUMN_ALBUM_NAME + " = ?";

    private PreparedStatement querySongInfoView;
    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;

    private Connection conn;

    public boolean open()
    {
        try
        {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            // Using the second argument to be able to get the key from the statement.
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
            // As we don't have to pass the song key to anything else, we don't have to return a key.
            insertIntoSongs = conn.prepareStatement(INSERT_SONGS);
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);

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

    public List<SongArtist> queryArtistsForSong(String songName, int sortOrder)
    {
        StringBuilder sb = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
        sb.append(songName);
        sb.append("\"");

        if (sortOrder != ORDER_BY_NONE)
        {
            sb.append(QUERY_ARTIST_FOR_SONG_SORT);

            if (sortOrder == ORDER_BY_DESC)
            {
                sb.append("DESC");
            }
            else
            {
                sb.append("ASC");
            }
        }

        System.out.println("SQL Statement: " + sb.toString());

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString()))
        {
            List<SongArtist> songArtists = new ArrayList<>();

            while (results.next())
            {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));

                songArtists.add(songArtist);
            }

            return songArtists;
        }
        catch (SQLException e)
        {
            System.out.println("Query failed: " + e.getMessage());
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

    public List<SongArtist> querySongInfoView(String title)
    {
        try
        {
            querySongInfoView.setString(1, title);
            ResultSet results = querySongInfoView.executeQuery();

            List<SongArtist> songArtists = new ArrayList<>();

            while (results.next())
            {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));
                songArtists.add(songArtist);
            }

            return songArtists;
        }
        catch (SQLException e)
        {
            System.out.println("Query view failed: " + e.getMessage());
            return null;
        }
    }

    private int insertArtist(String name) throws SQLException
    {
        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();

        // If there's any results from the query that we have executed it means that we have successfully found an ID
        // for the artist meaning that the artist exists.
        if (results.next())
        {
            // This code will be executed if the artist already exists.
            return results.getInt(1);
        }
        else
        {
            // Artist not in the database, so we are inserting it here
            insertIntoArtists.setString(1, name);
            // By using this method it saves the record and tells us how many rows have been updated. And as we are
            // just inserting an artist it will return 1 if everything goes smoothly.
            int affectedRows = insertIntoArtists.executeUpdate();

            if (affectedRows != 1)
            {
                throw new SQLException("Couldn't insert artist!");
            }

            // Retrieving the IDs after having inserted the new artist
            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();

            if (generatedKeys.next())
            {
                // Returning the new artist's ID
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

    // The explication behind the implementation of this method can be found at the "Main" class.
    public void insertSong(String title, String artist, String album, int track)
    {
        try
        {
            // We are going to perform our own transaction, so we are starting it off here.
            // After turning auto-commit off we can start our own transaction.
            conn.setAutoCommit(false);

            // These will return the artistID/AlbumID if it already exists, otherwise the method will create a new
            // record and set an ID to it/them.
            // These methods are throwing exceptions to be "caught" here (in this method).
            int artistID = insertArtist(artist);
            int albumID = insertAlbum(album, artistID);

            // We don't use the artistID again, it was just to help us to look for the album. And from here on we are
            // using the albumID, because the songs table ONLY relations with the albums table.
            // Here we are setting the values to insert the song.
            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumID);
            // During the video Tim inserted a column that doesn't exist, therefore it threw an "IndexOutOfBounds"
            // exception, however even with this exception being thrown th artist and the album still got created.
            // That's because for the transaction rollback to happen we are waiting for an SQL exception and as it
            // the exception thrown wasn't this one, the transaction completed.
            // And by setting auto-commit to true we ended up auto-committing the changes that we were making in this
            // method.
            // That's why that instead of using just SQL exception to stop the transaction we've started using
            // the Exception class to catch all the exceptions that might be thrown.

            int affectedRows = insertIntoSongs.executeUpdate();

            // Only one row will be updated being it the row that we've added the song.
            if (affectedRows == 1)
            {
                // Everything works, so we are telling that the transaction worked, and we are committing the changes to
                // the database and consequently ending the transaction as has been explained before.
                conn.commit();
            }
            else
            {
                throw new SQLException("The song insert failed");
            }

        }
        catch (Exception e) // Catching all possible exceptions
        {
            System.out.println("Insert song exception: " + e.getMessage());
            try
            {
                // If something goes wrong this method will back out every change we've made since starting the
                // transaction, and it'll also end the transaction.
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
                // Because using transactions involves getting database locks it's best practise to only turn off
                // auto-commit for the duration of a transaction and to turn it on back again immediately afterwards.
                conn.setAutoCommit(true);
            }
            catch (SQLException e)
            {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }
        }
    }

}

// It's also possible to roll back a transaction to a specific point and to do this we call the
// "Connection.setSavepoint()" method which returns a Savepoint object and if we want to roll back any changes since we
// created this savepoint we pass the Savepoint to the "Connection.rollback()" method.