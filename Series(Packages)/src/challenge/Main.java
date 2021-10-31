package challenge;

// This is the continuation of the series challenge, the first part is in the "Packages" project.
// The "jar" file being imported here is the result of the artifact of the "Packages" project.
// The artifact needs to be build in the "Packages" project.
// To select the "jar" file is just go to "Project Structure", then you add a new Library.
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("The sum from 0 to 9 is " + Series.nSum(9));
        System.out.println("The factorial of 6 is " + Series.factorial(6));
        System.out.println("The 10° element of the Fibonacci sequence is " + Series.fibonacci(10));
    }

}
