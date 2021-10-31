package challenge;

import java.util.ArrayList;

public class Album
{
    private String name;
    private ArrayList<Song> songs;

    public Album(String name)
    {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String songName, double songDuration)
    {
        Song newSong = new Song(songName, songDuration);

        if (!songExists(newSong.getTitle()))
        {
            this.songs.add(newSong);
            return true;
        }

        return false;
    }

    private boolean songExists(String songName)
    {
        for (int i = 0; i < songs.size(); i++)
        {
            if (songs.get(i).getTitle().equals(songName))
            {
                return true;
            }
        }

        return false;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Song> getSongs()
    {
        return songs;
    }

}
