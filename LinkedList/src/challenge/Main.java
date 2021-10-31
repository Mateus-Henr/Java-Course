package challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main
{
    private static ArrayList<Album> albums = new ArrayList<>();
    private static LinkedList<Song> playlist = new LinkedList<>();

    public static void main(String[] args)
    {
        System.out.println("Welcome to your Playlist");

        Album album = new Album("MyAlbum");
        album.addSong("Rolling in the Deep", 3.54);
        album.addSong("Feel So Close", 4.06);
        album.addSong("Don't You Worry Child", 5.35);
        albums.add(album);

        addSong("Feel So Close", 4.06);
        addSong("Don't You Worry Child", 5.35);

        musicPlayerSystem();
    }

    private static void printMenu()
    {
        System.out.println("0 - Quit" +
                "\n1 - Next" +
                "\n2 - Previous" +
                "\n3 - Add song" +
                "\n4 - Remove song" +
                "\n5 - List all songs" +
                "\n6 - Show menu");
    }

    private static boolean findMusicInAlbum(String albumName, String musicName)
    {
        for (int i = 0; i < albums.size(); i++)
        {
            Album album = albums.get(i);
            if (album.getName().equals(albumName))
            {
                for (int j = 0; j < album.getSongs().size(); j++)
                {
                    if (album.getSongs().get(j).getTitle().equals(musicName))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static int getMusicPositionInPlaylist(String songTitle)
    {
        for (int i = 0; i < playlist.size(); i++)
        {
            if (playlist.get(i).getTitle().equals(songTitle))
                return i;
        }

        return -1;
    }

    private static void musicPlayerSystem()
    {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> songIterator = playlist.listIterator();

        boolean quit = false;
        boolean isGoingForward = true;
        printMenu();

        while (!quit)
        {
            System.out.println("Choose an option: (6 - To see the options)");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 0:
                    quit = true;
                    System.out.println("Leaving music player");
                    break;

                case 1:
                    if (!isGoingForward)
                    {
                        if (songIterator.hasNext())
                        {
                            songIterator.next();
                        }
                        isGoingForward = true;
                    }

                    if (songIterator.hasNext())
                    {
                        System.out.println("Playing " + songIterator.next().getTitle());
                    } else
                    {
                        System.out.println("You're at the end of the playlist.");
                        isGoingForward = false;
                    }
                    break;

                case 2:
                    if (isGoingForward) {
                        if (songIterator.hasPrevious()) {
                            songIterator.previous();
                        }
                        isGoingForward = false;
                    }

                    if (songIterator.hasPrevious())
                    {
                        System.out.println("Playing " + songIterator.previous().getTitle());
                    } else
                    {
                        System.out.println("You're at the start of the playlist.");
                        isGoingForward = true;
                    }
                    break;

                case 3:
                    System.out.println("Type the song name: ");
                    String songName = scanner.nextLine();
                    System.out.println("Type the song duration: ");
                    double songDuration = scanner.nextDouble();
                    if (addSong(songName, songDuration))
                    {
                        System.out.println("The song " + songName + " has been deleted successfully.");
                    } else
                    {
                        System.out.println("Error trying to add the song.");
                    }
                    break;

                case 4:
                    System.out.println("Type the song name");
                    String songNameToDelete = scanner.nextLine();
                    if (removeSongFromThePlaylist(songNameToDelete))
                    {
                        System.out.println("The song " + songNameToDelete + " has been deleted successfully.");
                    } else
                    {
                        System.out.println("Error trying to delete the song " + songNameToDelete);
                    }
                    break;

                case 5:
                    System.out.println("Listing all the songs");
                    showAllSongs();
                    break;

                case 6:
                    printMenu();
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    private static boolean addSong(String songName, double songDuration)
    {
        if (findMusicInAlbum("MyAlbum", songName))
        {
            if (getMusicPositionInPlaylist(songName) == -1)
            {
                playlist.add(new Song(songName, songDuration));
                return true;
            }
        }

        return false;
    }

    private static boolean removeSongFromThePlaylist(String songName)
    {
        int musicPositionInPlaylist = getMusicPositionInPlaylist(songName);
        if (musicPositionInPlaylist != -1)
        {
            playlist.remove(musicPositionInPlaylist);
            return true;
        } else
        {
            return false;
        }
    }

    private static void showAllSongs()
    {
        for (int i = 0; i < albums.size(); i++)
        {
            for (int j = 0; j < albums.get(i).getSongs().size(); j++)
            {
                System.out.println("> "  + albums.get(i).getSongs().get(j).getTitle());
            }
        }
    }

}
