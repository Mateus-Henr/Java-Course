package challenge.second;

public class Main
{
    public static void main(String[] args)
    {
        VipCustomer tim = new VipCustomer("Tim", "tim@email.com");
        System.out.println("Name: " + tim.getName() + " | Credit Limit: $" + tim.getCreditLimit() + " | Email Account: " + tim.getEmailAddress());

        VipCustomer mateus = new VipCustomer("Mateus", 1200.00, "mateus@email.com");
        System.out.println("\nName: " + mateus.getName() + " | Credit Limit: $" + mateus.getCreditLimit() + " | Email Account: " + mateus.getEmailAddress());

        VipCustomer unknown = new VipCustomer();
        System.out.println("\nName: " + unknown.getName() + " | Credit Limit: $" + unknown.getCreditLimit() + " | Email Account: " + unknown.getEmailAddress());

    }

}
