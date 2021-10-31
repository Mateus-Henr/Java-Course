package tutorial.fourth;

import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args)
    {
        btnPrint.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(String title)
            {
                System.out.println(title + " was clicked.");
            }
        });
        listen();
    }

    private static void listen()
    {
        boolean quit = false;
        while (!quit)
        {
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 0:
                    quit = true;
                    break;

                case 1:
                    btnPrint.OnClick();
            }
        }
    }

}
