package challenge.mine.first;

import java.time.YearMonth;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Registration implements Saveable
{
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private List<Saveable> listOfRegistrations;

    public Registration(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        listOfRegistrations = new ArrayList<>();

        boolean isYearValid = validYearOfBirth(yearOfBirth);
        boolean isMonthValid = validMonthOfBirth(monthOfBirth);
        boolean isDayValid = validDayOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);

        if (isYearValid && isMonthValid)
        {
            if (isDayValid)
            {
                this.yearOfBirth = yearOfBirth;
                this.monthOfBirth = monthOfBirth;
                this.dayOfBirth = dayOfBirth;
                return;
            }
        }

        this.yearOfBirth = -1;
        this.monthOfBirth = -1;
        this.dayOfBirth = -1;
    }

    private boolean validYearOfBirth(int yearOfBirth)
    {
        if (yearOfBirth < 1900 && dayOfBirth > LocalDateTime.now().getYear())
        {
            return false;
        }

        return true;
    }

    private boolean validMonthOfBirth(int monthOfBirth)
    {
        if (monthOfBirth > 0 && monthOfBirth <= 12)
        {
            return true;
        }

        return false;
    }

    private boolean validDayOfBirth(int dayOfBirth, int monthOfBirth, int yearOfBirth)
    {
        YearMonth yearMonthObject = YearMonth.of(yearOfBirth, monthOfBirth);
        if (dayOfBirth > 0 && dayOfBirth <= yearMonthObject.lengthOfMonth())
        {
            return true;
        }

        return false;
    }

    @Override
    public void save(Saveable storageMedium)
    {
        this.listOfRegistrations.add(storageMedium);
    }

    @Override
    public List<Saveable> read()
    {
        return this.listOfRegistrations;
    }

    @Override
    public String toString()
    {
        return "Registration: " + this.firstName + " " + this.lastName;
    }

}
