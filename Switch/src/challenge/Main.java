package challenge;

public class Main
{
    public static void main(String[] args)
    {
        char switchChar = 'A';

        switch (switchChar)
        {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
                System.out.println("The char '" + switchChar + "' has been found.");
                break;
            default:
                System.out.println("The char 'A', 'B', 'C', 'D' or 'E' was not found.");
                break;
        }

        String month = "november";

        switch (month.toLowerCase()) // Remember that lowercase is different of capital letter.
        {
            case "january":
                System.out.println("Jan");
                break;
            case "june":
                System.out.println("Jun");
                break;
            case "february":
            case "march":
            case "april":
            case "may":
            case "december":
            case "november":
            case "july":
            case "september":
            case "august":
            case "october":
                System.out.println(month.substring(0, 1).toUpperCase() + month.substring(1, 3));
                break;
            default:
                System.out.println("Not sure.");
                break;

        }
    }

}
