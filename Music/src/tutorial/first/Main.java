package tutorial.first;

import tutorial.first.model.Artist;
import tutorial.first.model.DataSource;

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

        // This method doesn't need to make any assumptions from where the data is coming from.
        List<Artist> artists = dataSource.queryArtists();

        if (artists == null)
        {
            System.out.println("No artists.");
            return;
        }

        for (Artist artist : artists)
        {
            System.out.println("ID = " + artist.getID() + ", Name = " + artist.getName());
        }

        dataSource.close();
    }

}
