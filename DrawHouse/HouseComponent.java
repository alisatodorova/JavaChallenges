/**
Write a program that draws a picture of a house.
Implement a class House and supply a method draw(Graphics2D g2) that draws the house.

* @author Alisa Todorova
*/

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HouseComponent extends JComponent
{
    /**
    * Draws a picture of a house, using the House class.
    *
    * @param g the graphics context
    */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        House house = new House(100, 100);
        house.draw(g2);
    }
}