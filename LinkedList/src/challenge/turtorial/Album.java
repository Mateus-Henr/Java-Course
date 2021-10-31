package challenge.turtorial;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album
{
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist)
    {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String newSongTitle, double newSongDuration)
    {
        if (findSong(newSongTitle) == null)
        {
            this.songs.add(new Song(newSongTitle, newSongDuration));
            return true;
        }

        return false;
    }

    private Song findSong(String songTitleToSearch)
    {
        for (Song checkedSong : this.songs)
        {
            if (checkedSong.getTitle().equals(songTitleToSearch))
            {
                return checkedSong;
            }
        }

        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList)
    {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.size()))
        {
            playList.add(this.songs.get(index));
            return true;
        }

        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playList)
    {
        Song checkedSong = findSong(songTitle);
        if (checkedSong != null)
        {
            playList.add(checkedSong);
            return true;
        }

        System.out.println("The song " + songTitle + " is not in this album.");
        return false;
    }

}
