package challenge.first;

import java.util.HashMap;
import java.util.Map;

public class ImprovedOne
{
    public static void main(String[] args)
    {
        Map<Integer, Map<String, Integer>> players = new HashMap<>()
        {{
            put(0, new HashMap<>()
            {{
                put("Mateus", 1500);
            }});
            put(1, new HashMap<>()
            {{
                put("Leo", 900);
            }});
            put(2, new HashMap<>()
            {{
                put("Tim", 400);
            }});
            put(3, new HashMap<>()
            {{
                put("Lucas", 50);
            }});
            put(4, new HashMap<>()
            {{
                put("Carol", 1000);
            }});
        }};

        Map<Integer, Integer> highScorePositions = calculateHighScorePosition(players);

        displayHighScorePosition(players, highScorePositions);
    }

    private static void displayHighScorePosition(Map<Integer, Map<String, Integer>> players, Map<Integer, Integer> highScorePositions)
    {
        for (int i = 0; i < players.size(); i++)
        {
            System.out.println("The player named as " + players.get(i).keySet().toArray()[0] + " managed to get into position " + highScorePositions.get(i) + " on the high score table.");
        }
    }

    private static Map<Integer, Integer> calculateHighScorePosition(Map<Integer, Map<String, Integer>> players)
    {
        Map<Integer, Integer> highScorePositions = new HashMap<>();

        for (int i = 0; i < players.size(); i++)
        {
            int playerScore = (int) players.get(i).values().toArray()[0];

            if (playerScore >= 1000)
            {
                highScorePositions.put(i, 1);
            }
            else if (playerScore >= 500) // if-elseif-else statements stop doing comparisons as soon as it finds one that's true.
            {
                highScorePositions.put(i, 2);
            }
            else if (playerScore >= 100)
            {
                highScorePositions.put(i, 3);
            }
            else
            {
                highScorePositions.put(i, 4);
            }
        }

        return highScorePositions;
    }

}
