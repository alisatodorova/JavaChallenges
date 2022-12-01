/**
Write a program that draws a picture of a house.
Implement a class House and supply a method draw(Graphics2D g2) that draws the house.

* @author Alisa Todorova
*/

import javax.swing.JFrame;

public class HouseViewer
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(300, 400); //This frame will be 300 pixels wide and 400 pixels tall.
        frame.setTitle("My House with a tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //When the user closes the frame, the program automatically exits.
        HouseComponent component = new HouseComponent();
        frame.add(component);
        frame.setVisible(true); //Makes the frame visible.
    }

}