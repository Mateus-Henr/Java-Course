package tutorial.first;

public class BankAccount
{
    private int accountNumber;
    private double balance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    public BankAccount() // Constructors are just called once when you create an object.
    {
        this(5678, 2.50, "Default Name", "Default Address", "Default Phone"); // Default values for the constructor
        // "this" like this must be on the first line.
        System.out.println("Empty constructor called.");
    }

    public BankAccount(int accountNumber, double balance, String customerName, String customerEmail, String customerPhone)
    {
        System.out.println("BankAccount constructor with parameters called.");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public void deposit(double amountToDeposit)
    {
        if (amountToDeposit <= 0)
        {
            System.out.println("Amount invalid.");
            return;
        }

        this.balance += amountToDeposit;
        System.out.println("Deposit of $" + amountToDeposit + " was a success! Current balance: $" + this.balance);
    }

    public void withdrawal(double amountToWithdraw)
    {
        if (amountToWithdraw > this.balance)
        {
            System.out.println("Insufficient funds. Only $" + this.balance + " available.");
            return;
        }

        this.balance -= amountToWithdraw;
        System.out.println("Withdrawal of $" + amountToWithdraw + " was a success! Remaining balance: $" + this.balance);
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerEmail()
    {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail)
    {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone()
    {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone)
    {
        this.customerPhone = customerPhone;
    }

}
