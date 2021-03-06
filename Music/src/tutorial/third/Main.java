package tutorial.third;

import tutorial.third.model.Artist;
import tutorial.third.model.DataSource;
import tutorial.third.model.SongArtist;

import javax.swing.plaf.nimbus.State;
import java.util.List;

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

        songName = "Go Your Own Way";
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

// The way that we are currently querying the database ISN'T best practise. SQL statements have to be compiled into a
// format that the database understands, when using Statement objects to perform queries the Statements actually
// compile everytime we perform a new query and the way that we are building our query strings makes our database
// vulnerable for hacking attempts.