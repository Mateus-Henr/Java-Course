package tutorial.fourth.model;

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

    // SELECT name, album, track FROM artist_list WHERE title = ?
    // Using a question mark for the song title, that's actually a placeholder character that we use in
    // PreparedStatements.
    // When replacing a placeholder in a PreparedStatement the database understands that a String is one value
    // (i.e. "Going Your Own Way"). So we only substitute one value for one placeholder.
    // And it only needs to be precompiled once, so we need to create an instance only once. If trying to create a new
    // instance everytime when performing a query we would lose performance.
    public static final String QUERY_VIEW_SONG_INFO_PREP =
            "SELECT " + COLUMN_ARTIST_NAME + ", " + COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK +
                    " FROM " + TABLE_ARTIST_SONG_VIEW +
                    " WHERE " + COLUMN_SONG_TITLE + " = ?";

    private PreparedStatement querySongInfoView;

    private Connection conn;

    public boolean open()
    {
        try
        {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            // Initializing our PreparedStatement instance.
            querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
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
            // If we use a Statement ot do more than one query, which is common when using PreparedStatement,
            // each time we need to do a new query the existing ResultSet is closed and a new one is created.
            // So we don't have to worry about closing the ResultSet when using PreparedStatement, when we close
            // the PreparedStatement whichever ResultSet is active would also be closed.
            // And as it's an instance, we are going to close it in here. And the order is important.
            if (querySongInfoView != null)
            {
                querySongInfoView.close();
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
        // Using PreparedStatement (it's worthy mentioning that this class is a subclass of Statement, that's why
        // we can use all the methods that the Statement class provides.)
        try
        {
            // Using the "setString" method to specify the position of the placeholder to set the user string.
            // For JDBC position is 1 based.
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

}
// Summing up how to use PreparedStatements
// 1 - Declare a constant for the SQL statement that contains the placeholders.
// 2 - Create a PreparedStatement instance using Connection.prepareStatement(sqlStmtString).
// 3 - When we're ready to perform the query (or the insert, update, delete), we call the appropriate setter methods to
// set the placeholders to the values we want to use in the statement.
// 4 - We run the statement using PreparedStatement.execute() or PreparedStatement.executeQuery().
// 5 - We process the results the same way we do when using a regular old