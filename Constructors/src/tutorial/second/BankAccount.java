package tutorial.second;

public class BankAccount
{
    private int accountNumber;
    private double balance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    public BankAccount()
    {
        this(5678, 2.50, "Default Name", "Default Address", "Default Phone");
        System.out.println("Empty constructor called.");
    }

    public BankAccount(int accountNumber, double balance, String customerName, String customerEmail, String customerPhone)
    {
        System.out.println("BankAccount constructor with parameters called.");
        setAccountNumber(accountNumber); // If we had some validation in set number we could check it by using this format. But It can have problems because it can be executed before the set method.
        this.balance = balance; // We do NOT call methods in constructors. Because in constructors that we initialize an object and could be problems calling methods in constructors.
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public BankAccount(String customerName, String customerEmail, String customerPhone)
    {
        this(99999, 100.55, customerName, customerEmail, customerPhone); // "this" here call the major constructor.
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
