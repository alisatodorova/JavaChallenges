/**
Write a program that displays the Olympic rings. Color the rings in the Olympic colors.

* @author Alisa Todorova
*/

import javax.swing.JFrame;

public class OlympicRingViewer
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(400, 400); //This frame will be 400 pixels wide and 400 pixels tall.
        frame.setTitle("The Olympic Rings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OlympicRingComponent component = new OlympicRingComponent();
        frame.add(component);
        frame.setVisible(true);
    }
}
