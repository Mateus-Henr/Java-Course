package challenge.tutorial.second;

public class Main
{
    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";

    public static void main(String[] args)
    {
        int seconds = 6000;
        System.out.println("The conversion of " + seconds + "s to hours/minutes/seconds is " + getDurationString(seconds));

        int minutes = 10000;
        seconds = 50;
        System.out.println("The conversion of " + minutes + "m " + seconds + "s to hours/minutes/seconds is " + getDurationString(minutes, seconds));

        System.out.println(getDurationString(-1));
    }

    private static String getDurationString(int minutes, int seconds)
    {
        if (minutes < 0 || (seconds < 0 || seconds > 59))
        {
            return INVALID_VALUE_MESSAGE;
        }

        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;

        String hoursString = hours + "h";
        if (hours < 10)
        {
            hoursString = "0" + hoursString;
        }

        String minutesString = minutes + "m";
        if (minutes < 10)
        {
            minutesString = "0" + minutesString;
        }

        String secondsString = seconds + "s";
        if (seconds < 10)
        {
            secondsString = "0" + secondsString;
        }

        return hoursString + "h " + minutesString + "m " + secondsString + "s";
    }

    private static String getDurationString(int seconds)
    {
        if (seconds < 0)
        {
            return INVALID_VALUE_MESSAGE;
        }

        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;

        return getDurationString(minutes, remainingSeconds);
    }

}
