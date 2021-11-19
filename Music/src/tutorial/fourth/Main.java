package tutorial.fourth;

import tutorial.fourth.model.Artist;
import tutorial.fourth.model.DataSource;
import tutorial.fourth.model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        DataSource dataSource = new DataSource();

        if (!dataSource.open())
        {
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = dataSource.queryArtists(DataSource.ORDER_BY_ASC);

        if (artists == null)
        {
            System.out.println("No artists.");
            return;
        }

        for (Artist artist : artists)
        {
            System.out.println("ID = " + artist.getID() + ", Name = " + artist.getName());
        }

        String artistName = "Pink Floyd";
        System.out.println("\nPrinting the albums from " + artistName);

        List<String> albums = dataSource.queryAlbumsForArtist(artistName, DataSource.ORDER_BY_DESC);

        if (albums == null)
        {
            System.out.println("No albums for the artist " + artistName);
            return;
        }

        for (String album : albums)
        {
            System.out.println("Name = " + album);
        }

        String songName = "She's On Fire";
        System.out.println("\nPrinting artists for song " + songName);
        List<SongArtist> songArtists = dataSource.queryArtistsForSong(songName,
                                                                      DataSource.ORDER_BY_ASC);

        if (songArtists == null)
        {
            System.out.println("Couldn't find the artist for the song " + songName);
            return;
        }

        for (SongArtist songArtist : songArtists)
        {
            System.out.println("Artist = " + songArtist.getArtistName() +
                                       ", Album name = " + songArtist.getAlbumName() +
                                       ", Track = " + songArtist.getTrack());
        }

        System.out.println("\nPrinting table of song's metadata");
        dataSource.querySongsMetadata();

        int count = dataSource.getCount(DataSource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

        dataSource.createViewForSongArtists();


        // The way that we are currently querying the database ISN'T best practise. SQL statements have to be compiled
        // into a format that the database understands, when using Statement objects to perform queries the Statements
        // actually compile everytime we perform a new query and the way that we are building our query strings makes
        // our database vulnerable for hacking attempts.

        // Showing way our database is vulnerable for hacking attempts
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: ");

        // If the user enters (Go Your Own Way" or 1=1 or "), for example, it'll return all the songs in the database.
        // This is called a "Single Injection Attack", since "1=1" will be true for every record this will get all of
        // them. It's called like this because the user has injected SQL into a statement we didn't intend to run.
        // For that reason concatenating Strings to produce our statement becomes a problem.

        // A hacker could even DROP tables, however when using SQLite driver it's not possible since the "executeQuery"
        // method can only execute one SQL statement.
        // That's why we MUST use the "PreparedStatement" class, it can protect against Single Injection Attacks because
        // when we use it we don't concatenate use input into the SQL statement that we'll ultimately be running.
        songName = scanner.nextLine();
        System.out.println("\nPrinting artists for song " + songName + " (VIEW version)");
        songArtists = dataSource.querySongInfoView(songName);

        if (songArtists == null || songArtists.isEmpty())
        {
            System.out.println("Couldn't find the artist for the song " + songName);
            return;
        }

        for (SongArtist songArtist : songArtists)
        {
            System.out.println("Artist = " + songArtist.getArtistName() +
                                       ", Album name = " + songArtist.getAlbumName() +
                                       ", Track = " + songArtist.getTrack());
        }

        dataSource.close();
    }

    // How does PreparedStatement protect us against Single Injection Attacks?
    // The values that are being substituted are treated as literal values, nothing there is treated as SQL. That's why
    // it's different from using String concatenation, since when using it the whatever value inputted by the user
    // would be treated as SQL, once we had no protection against it.
    // Therefore, with the following command in mind:
    // SELECT name, album, track FROM artist_list WHERE title = "GO Your Own Way" or 1=1 or""
    // As you can see because of the double quites the SQL was being modified.
    // Using PreparedStatement we would have:
    // SELECT name, album, track FROM artist_list WHERE title = "GO Your Own Way or 1=1 or" (the quotes would still be
    // there, but they would be interpreted as part of the SQL statement)

    // OR in PreparedStatements
    // SELECT name, album, track FROM artist_list WHERE title = ? OR artist = ?
    // For each value we need a placeholder, we can't substitute more than one value for one placeholder, and we can't
    // inject SQL, and we can ONLY substitute values we can't use placeholders for tables and column names, this happens
    // because the statement needs to be precompiled to then pass the literal values. So the only info that we can
    // postpone when performing queries are the values themselves.
}