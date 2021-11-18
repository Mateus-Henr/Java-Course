package tutorial.second;

import tutorial.second.model.Album;
import tutorial.second.model.Artist;
import tutorial.second.model.DataSource;

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

        String artistName = "Iron Maiden";
        System.out.println("\nPrinting the albums from " + artistName);

        List<String> albums = dataSource.queryAlbumsForArtist(artistName, DataSource.ORDER_BY_ASC);

        if (albums == null)
        {
            System.out.println("No albums for the artist " + artistName);
            return;
        }

        for (String album : albums)
        {
            System.out.println("Name = " + album);
        }

        dataSource.close();
    }

}
// It's important to test SQL statements before implementing them into your program, through DB Browser is possible to
// execute SQL in the "Execute SQL" tab.