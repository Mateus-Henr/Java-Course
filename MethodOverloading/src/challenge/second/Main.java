package challenge.second;

public class Main
{
    public static void main(String[] args)
    {
        int seconds = 6000;
        System.out.println("The conversion of " + seconds + "s to hours/minutes/seconds is " + getDurationString(seconds));

        int minutes = 10000;
        seconds = 50;
        System.out.println("The conversion of " + minutes + "m " + seconds + "s to hours/minutes/seconds is " + getDurationString(minutes, seconds));
    }

    private static String getDurationString(int minutes, int seconds)
    {
        if (minutes < 0 || (seconds < 0 || seconds > 59))
        {
            return "Invalid Value";
        }

        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;

        return String.format("%02d", hours) + "h " + String.format("%02d", remainingMinutes) + "m " + String.format("%02d", seconds) + "s";
    }

    private static String getDurationString(int seconds)
    {
        if (seconds < 0)
        {
            return "Invalid Value";
        }

        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;

        return getDurationString(minutes, remainingSeconds);
    }

}
