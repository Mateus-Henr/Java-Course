package challenge.second;

public class VipCustomer
{
    private String name;
    private double creditLimit;
    private String emailAddress;

    public VipCustomer()
    {
        this("Default name", 100.00, "default@email.com");
    }

    public VipCustomer(String name, String emailAddress)
    {
        this(name, 1000.00, emailAddress);
    }

    public VipCustomer(String name, double creditLimit, String emailAddress)
    {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public String getName()
    {
        return name;
    }

    public double getCreditLimit()
    {
        return creditLimit;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

}
