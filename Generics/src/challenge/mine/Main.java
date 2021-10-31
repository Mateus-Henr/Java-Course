package challenge.mine;

public class Main
{
    public static void main(String[] args)
    {
        LeagueTable<FootballTeam> firstLeagueTable = new LeagueTable<>();

        FootballTeam barcelona = new FootballTeam("Barcelona", 10);
        FootballTeam realMadrid = new FootballTeam("Real Madrid", 12);
        FootballTeam juventus = new FootballTeam("Juventus", 14);
        FootballTeam manchesterTheCity = new FootballTeam("Manchester The City", 5);

        BaseballTeam iDK = new BaseballTeam("I don't know", 1);
//        firstLeagueTable.addTeam(iDK);

        firstLeagueTable.addTeam(barcelona);
        firstLeagueTable.addTeam(realMadrid);
        firstLeagueTable.addTeam(juventus);
        firstLeagueTable.addTeam(manchesterTheCity);

        firstLeagueTable.printTeams();
    }

}
