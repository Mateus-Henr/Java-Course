package challenge.turtorial;

import java.util.*;

public class Main
{
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args)
    {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double healer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks.", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night og the long knives", 5.12);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList); // Does not exist
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList); // Does not exist

        play(playList);
    }

    private static void play(LinkedList<Song> playList)
    {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.isEmpty())
        {
            System.out.println("No songs in playList.");
            return;
        } else
        {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit)
        {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action)
            {
                case 0:
                    System.out.println("PlayList complete.");
                    quit = true;
                    break;

                case 1:
                    if (!forward)
                    {
                        if (listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext())
                    {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else
                    {
                        System.out.println("We have reached the end of the playList.");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward)
                    {
                        if (listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious())
                    {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else
                    {
                        System.out.println("We have reached the start of the playList.");
                        forward = true;
                    }
                    break;

                case 3:
                    if (forward)
                    {
                        if (listIterator.hasPrevious())
                        {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else
                        {
                            System.out.println("We are at the start of the playList.");
                        }
                    } else
                    {
                        if (listIterator.hasNext())
                        {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else
                        {
                            System.out.println("We have reached the end of the playList.");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playList.size() > 0)
                    {
                        listIterator.remove();
                        if (listIterator.hasNext())
                        {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious())
                        {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    } else
                    {
                        System.out.println("The playList is empty.");
                    }
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    private static void printMenu()
    {
        System.out.println("Available actions: \nPress");
        System.out.println("0 - To quit\n" +
                "1 - To play next song\n" +
                "2 - To play previous song\n" +
                "3 - To replay the current song\n" +
                "4 - List songs in the playList\n" +
                "5 - Print available actions\n" +
                "6 - To remove the current song");
    }

    private static void printList(LinkedList<Song> playList)
    {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===============================");
        while (iterator.hasNext())
        {
            System.out.println(iterator.next().toString());
        }
        System.out.println("===============================");
    }

}
