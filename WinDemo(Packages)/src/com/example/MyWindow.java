package com.example;

// Fully qualified class name == last name in the package.
// Basically everything to build a window is here, so we just use these classes to create our own window.
// The "*" means to import classes, interfaces and static objects from a certain package.
// But you could have problems if you've got two packages with the same fully qualified class name.
import java.awt.*;

// We need these two separated imports because "java.awt" is separated from "java.awt.event", "event.*" would work.
// Even though one is inside the other, "event" is a subpackage, so it needs to be specified.
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindow extends Frame
{
    public MyWindow(String title)
    {
        super(title);
        setSize(500, 140);
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Font sansSerifLarge = new Font("SansSerif", Font.BOLD, 18);
        Font sansSerifSmall = new Font("SansSerif", Font.BOLD, 12);
        g.setFont(sansSerifLarge);
        g.drawString("The Complete Java Developer Course", 60, 60);
        g.setFont(sansSerifSmall);
        g.drawString("The Complete Java Developer Course", 60, 100);
    }

}
// In "External Libraries" you can see the packages that you can use.