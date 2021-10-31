package challenge;

public class Main
{
    public static void main(String[] args)
    {
        Printer printer = new Printer(10, true);
        System.out.println("Initial page count = " + printer.getPagesPrinted());
        printer.printPages(17);
        System.out.println("Middle page count = " + printer.getPagesPrinted());
        printer.printPages(16456);
        System.out.println("Final page count = " + printer.getPagesPrinted());
    }
}
