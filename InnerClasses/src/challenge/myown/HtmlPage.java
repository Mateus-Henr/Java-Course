package challenge.myown;

import java.util.Scanner;

public class  HtmlPage
{
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        // Html input element
        Input input = new Input("Username", 1, 200, 100);
        System.out.println("Type the input: ");
        String usersInput = sc.nextLine();
        input.setText(usersInput);

        // Submit input
        input.setActionCode(new InputListener()
        {
            @Override
            public void submitInput(String inputText)
            {
                System.out.println("\nYour input contains the text: " + "\"" + inputText + "\"");
            }
        });

        // Button element
        Button button = new Button("Submit Form", 1, "submit", 30, 10);
        button.setActionCode(new ButtonListener()
        {
            @Override
            public void clickButton()
            {
                if (button.getType().equals("submit"))
                {
                    input.submit();
                    System.out.println("\nThe button has been clicked. Therefore the form's been submitted.");
                } else
                    System.out.println("\nThe button has been clicked. Not submitted due to the button's type.");
            }
        });
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            System.out.println(e);
        }
        userChoice(button);
    }

    public static void userChoice(Button button) {
            System.out.println("Choose either 1 to click the button or 0 to leave");
            int choice = sc.nextInt();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    button.click();
                    break;
        }
    }

}
