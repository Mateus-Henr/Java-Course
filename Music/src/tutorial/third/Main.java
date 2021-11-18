package tutorial.third;

import tutorial.third.model.Artist;
import tutorial.third.model.DataSource;
import tutorial.third.model.SongArtist;

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

        dataSource.close();
    }

}