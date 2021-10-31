package challenge.tutorial.first;

public class Main
{
    public static void main(String[] args)
    {
        double feet = 1000;
        double inches = -10;

        calcFeetAndInchesToCentimeters(inches);
    }

    private static double calcFeetAndInchesToCentimeters(double feet, double inches)
    {
        if (feet >= 0 && (inches >= 0 && inches <= 12))
        {
            double totalInches = inches + (feet * 12);
            double centimeters = totalInches * 2.54;

            System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " cm.");
            return centimeters;
        }

        System.out.println("Invalid feet or inches parameters.");
        return -1;
    }

    private static double calcFeetAndInchesToCentimeters(double inches)
    {
        if (inches >= 0)
        {
            double feet = (int) inches / 12;
            double remainingInches = (int) inches % 12;

            System.out.println(inches + " inches is equal to " + feet + " feet and " + remainingInches + " inches.");
            return calcFeetAndInchesToCentimeters(feet, remainingInches);
        }

        System.out.println("Invalid feet or inches parameters.");
        return -1;
    }

    // 1 inch == 2.54 cm
    // 1 foot == 12 inches
}
