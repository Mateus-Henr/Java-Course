package tutorial.second;

import java.util.ArrayList;
import java.util.List;

// Comparing Team of the same type
public class Team<T extends Player> implements Comparable<Team<T>>// Using this <T> makes the class accepts just one type of parameter for the parameterized type.
{ // By using "extends" we are telling Java to accept types that extends from player or a subclass of player.
    // For multiple bounds would be something like <T extends Player & Coach & Manager>
    private String name;
    private int played = 0;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;

    private List<T> members = new ArrayList<>();

    public Team(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public boolean addPlayer(T player)
    {
        if (members.contains(player))
        {
            System.out.println(player.getName() + " is already on this team."); // As class extends from player the cast is no longer necessary
            return false;
        }

        members.add(player);
        System.out.println(player.getName() + " picked for team " + this.name);
        return true;
    }

    public int numPlayers()
    {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore)
    {
        String message;
        if (ourScore > theirScore)
        {
            won++;
            message = " beat ";
        }
        else if (ourScore == theirScore)
        {
            tied++;
            message = " drew with ";
        }
        else
        {
            lost++;
            message = " lost to ";
        }

        if (opponent != null)
        {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore); // Used to add the opponent results.
        }
    }

    public int ranking()
    {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team)
    {
        if (this.ranking() > team.ranking())
        {
            return -1;
        }
        else if (this.ranking() < team.ranking())
        {
            return 1;
        }

        return 0;
    }

}
