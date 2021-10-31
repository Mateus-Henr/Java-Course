package challenge.mine.first;

public class Main
{
    public static void main(String[] args)
    {
        Saveable registration = new Registration("Mateus", "Figueiredo", 11, 11, 2002);
        Saveable registration2 = new Registration("Another", "Guy", 11, 11, 2002);

        registration.save(registration);
        registration.save(registration2);

        for (Saveable registrationElement : registration.read())
        {
            Registration theRegistration = (Registration) registrationElement;
            System.out.println(theRegistration.toString());
        }

    }

}
