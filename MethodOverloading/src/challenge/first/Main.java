package challenge.first;

public class Main
{
    public static void main(String[] args)
    {
        double feet = 6;
        double inches = 0;

        System.out.println(inches + " inches is equal to " + calcFeetAndInchesToCentimeters(inches) + " centimeter(s).");
        System.out.println(feet + " feet and " + inches + " inches is equal to " + calcFeetAndInchesToCentimeters(feet, inches) + " centimeter(s).");
    }

    private static double calcFeetAndInchesToCentimeters(double feet, double inches)
    {
        if (feet >= 0 && (inches >= 0 && inches <= 12))
        {
            double totalInches = inches + (feet * 12);

            return totalInches * 2.54;
        }

        System.out.println("Invalid values");
        return -1;
    }

    private static double calcFeetAndInchesToCentimeters(double inches)
    {
        if (inches >= 0)
        {
            double feet = (int) inches / 12;
            double remainingInches = (int) inches % 12;

            return calcFeetAndInchesToCentimeters(feet, remainingInches);
        }

        System.out.println("Invalid feet or inches parameters.");
        return -1;
    }

    // 1 inch == 2.54 cm
    // 1 foot == 12 inches
}
