package tutorial;

public class Main
{
    public static void main(String[] args)
    {
        // char myChar = 'DD'; // Just allow one character
        // A char occupies 2 bytes of memory or 16 bits. The reason it's not just a single byte is that it allows you to
        // store Unicode characters.
        // Unicode allows us to represent all languages by using a combination of the two bytes that a char supports.
        char myChar = 'D';
        char myUnicode = '\u0044';
        System.out.println(myChar);
        System.out.println(myUnicode);

        char myCopyrightChar = '\u00A9';
        System.out.println(myCopyrightChar);


        boolean myTrueBooleanValue = true;
        boolean myFalseBooleanValue = false;

        boolean isCustomerOverTwentyOne = true; // Using question in a boolean
    }
}
