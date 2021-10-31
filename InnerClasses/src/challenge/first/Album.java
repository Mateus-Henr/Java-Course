package challenge.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album
{
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist)
    {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration)
    {
        return songs.addSong(title, duration);
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList)
    {
        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong != null)
        {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList)
    {
        Song checkedSong = this.songs.findSong(title);
        if (checkedSong != null)
        {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    class SongList
    {
        private List<Song> songs;

        private SongList()
        {
            this.songs = new ArrayList<>();
        }

        private boolean addSong(String title, double duration)
        {
            if (findSong(title) == null)
            {
                this.songs.add(new Song(title, duration));
                return true;
            }
            return false;
        }

        private Song findSong(String title)
        {
            for (Song checkedSong : this.songs)
            {
                if (checkedSong.getTitle().equals(title))
                {
                    return checkedSong;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber)
        {
            int index = trackNumber - 1;

            if ((index < this.songs.size()) && (trackNumber >= 0))
            {
                return this.songs.get(index);
            }

            return null;
        }

    }


}
