package challenge.mine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeagueTable<T extends Team>
{
    private List<T> listOfTeams = new ArrayList<>();

    public boolean addTeam(T teamToAdd)
    {
        if (listOfTeams.contains(teamToAdd))
        {
            System.out.println("Team already on the list.");
            return false;
        }

        this.listOfTeams.add(teamToAdd);
        System.out.println("The team with name " + teamToAdd.getName() + " has been added successfully!");
        return true;
    }

    public void printTeams()
    {
        List<T> orderedList = new ArrayList<>(listOfTeams);
        orderedList.sort(Comparator.comparingInt(Team::getScore));

        System.out.println("Printing the Results");
        for (int i = orderedList.size() - 1; i >= 0; i--)
        {
            System.out.println(orderedList.get(i).getName() + ": " + orderedList.get(i).getScore());
        }
    }

}
