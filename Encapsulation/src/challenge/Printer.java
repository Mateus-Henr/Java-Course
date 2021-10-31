package challenge;

public class Printer
{
    private int tonerLevel = 50;
    private int pagesPrinted = 0;
    private boolean isDuplex;

    public Printer(int tonerLevel, boolean isDuplex)
    {
        if (tonerLevel < 100)
            this.tonerLevel = tonerLevel;
        else
            this.tonerLevel = -1;

        this.isDuplex = isDuplex;
    }

    public int setTonerLevel(int tonerLevel)
    {
        if (tonerLevel > 0 && tonerLevel <= 100) {
            if (tonerLevel + this.tonerLevel > 100) {
                return -1;
            }

            return this.tonerLevel + tonerLevel;
        }

        return -1;
    }

    public void printPage() {
        String checkIsDuplex = (isDuplex) ? " is " : " isn't ";
        System.out.println("Printing page number " + pagesPrinted + " and the printer" + checkIsDuplex + " a duplex printer.");
        pagesPrinted++;
    }

    public int printPages(int amountOfCopies) {
        int printTimes = amountOfCopies;

        if(isDuplex)
        {
            if (printTimes % 2 == 0)
            {
                printTimes = amountOfCopies / 2;
            } else
            {
                printTimes = amountOfCopies / 2 + (amountOfCopies % 2);
            }
        }

        for (int i = 0; i < printTimes; i++) {
            printPage();
        }

        printTimes += pagesPrinted;

        return printTimes;
    }

    public int getPagesPrinted() {
        return this.pagesPrinted;
    }

}
