package tutorial.fifth;

import tutorial.fifth.model.Artist;
import tutorial.fifth.model.DataSource;
import tutorial.fifth.model.SongArtist;

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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: ");

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

}

// Transactions
// They are a sequence of SQL statements that are treated as single logical unit. If any of the statements fail, the
// results of any previous statements in the transaction can be rolled back, or just not saved. It's as if they never
// happened, so when working with relations between two databases or tables we can keep the integrity of the data.
// Sometimes it's necessary to disable the auto "commit" that JDBC does, because things need to be checked, etc.
// An example is transferring money between to accounts, because we need to update the value in both accounts. However,
// if whichever update fails, money would go missing, it could be solved after executing the statement but several
// problems could come from it, for example not being able to reach the money.
// So a possible solution is try to run all the statements as a single unit, either all of them get completed or none
// of them are executed.

// Database transactions must be ACID-compliant, being them:
// 1 - Atomicity: If a series of SQL statements change the database, then either all the changes are committed, or none
//                of them are.
// 2 - Consistency: Before a transaction begins, the database is in a valid state. When it completes, the database is
//                  still in a valid state.
// 3 - Isolation: Until the changes committed by a transaction are completed, they won't be visible to other
//                connections. Transactions can't depend on each other.
// 4 - Durability: Once the changes performed by a transaction are committed to the database, they're permanent. If an
//                 application then crashes or the database server goes down, the changes made by the transaction are
//                 still there when the app runs again.

// We only need to use Transactions when changing data in a database (for querying data we don't use them).
// SQLite uses transactions, and auto-commits by default. In fact, no changes can be made to the database outside a
// transaction, so when using CRUD operations, SQLite is creating a transaction, running the statement, and then
// committing the changes.

// Even if we turn off the auto-commit in JDBC, the changes will still make part of a transaction.

// Commands
// BEGIN TRANSACTION - To manually start a transaction.
// END TRANSACTION - To end a transaction. Committing changes automatically ends a transaction. Also, ending a
//                   transaction also commits any changes. So, "END TRANSACTION" and "COMMIT" serve the same purpose.
// COMMIT - To commit the changes made by a transaction.
// ROLLBACK - To roll back any uncommitted changes and ends the transaction. It can only roll back changes that have
//            occurred since the last COMMIT or ROLLBACK.

// If we close a connection before we commit any outstanding changes, the changes are rolled back.

// Using a transaction
// 1. Turn off the default auto-commit behaviour by calling Connection.setAutoCommit(false)
// 2. Perform the SQL operations that form the transaction
// 3. If there are no errors, call Connection.commit() to commit the changes. If there are errors, call
// Connnection.rollback() to roll back any changes made since the transaction began.
// 4. Turn the default auto-commit behaviour back on by calling setAutoCommit(true).

// Making a transaction to add a song to the database
// To add a song, the user has to provide us with the song title, the album it's on, the artist, and the track number
// for the song. So, we'll perform the following steps:
// 1. Get the title, album, track number, and artist (we'll just have the main() method pass them as parameters,
// rather than prompting for them)
// 2. Check to see the there's a record for the artist in the artists table. If yes, go to step 4. If no, do step 3.
// 3. Add the artist to the artist's table.
// 4. Check to see if the album is in the albums table. If yes, go to step 6. Otherwise, do to step 5.
// 5. Add the album to the albums table.
// 6. Add the song to the songs table.

// And we want to treat all the above steps as one single transaction. And we are going to assume that the song doesn't
// exist to avoid too much complication. Also, we won't be updating our view.