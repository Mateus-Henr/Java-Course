package challenge.first;

public class BankAccount
{
    private int accountNumber;
    private double balance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

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
