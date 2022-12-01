/**
Write a program that displays the Olympic rings. Color the rings in the Olympic colors.

* @author Alisa Todorova
*/

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class OlympicRingComponent extends JComponent
{
    /**
    * Draws a picture of the olympic rings.
    *
    * @param g the graphics context
    */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        OlympicRing ring1 = new OlympicRing(100, 100);
        OlympicRing ring2 = new OlympicRing(100, 100);
        OlympicRing ring3 = new OlympicRing(100, 100);
        OlympicRing ring4 = new OlympicRing(100, 100);
        OlympicRing ring5 = new OlympicRing(100, 100);


        ring1.draw(g2);
        ring2.draw(g2);
        ring3.draw(g2);
        ring4.draw(g2);
        ring5.draw(g2);
    }
}