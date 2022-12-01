/**
Write a program that displays the Olympic rings. Color the rings in the Olympic colors.

* @author Alisa Todorova
*/

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.BasicStroke;
import java.awt.Color;

public class OlympicRing
{

    //The left corner coordinate
    private double xLeft;
    //The top corner coordinate
    private double yTop;

    /**
     * Constructor to initiate the corners coordinates.
     *
     * @param x the left corner coordinate
     * @param y the top corner coordinate
     */
    public OlympicRing(double x, double y)
    {
        xLeft = x;
        yTop = y;
    }

    /**
     * Draws the olympic rings.
     *
     * @param g2 the graphics context
     */
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double ring1 = new Ellipse2D.Double(xLeft, yTop, 60, 60);
        Ellipse2D.Double ring2 = new Ellipse2D.Double(xLeft + 63, yTop, 60, 60);
        Ellipse2D.Double ring3 = new Ellipse2D.Double(xLeft + 126, yTop, 60, 60);
        Ellipse2D.Double ring4 = new Ellipse2D.Double(xLeft + 33, yTop + 33, 60, 60);
        Ellipse2D.Double ring5 = new Ellipse2D.Double(xLeft + 96, yTop + 33, 60, 60);

        g2.setStroke(new BasicStroke(3));

        g2.setColor(Color.BLUE);
        g2.draw(ring1);

        g2.setColor(Color.BLACK);
        g2.draw(ring2);

        g2.setColor(Color.RED);
        g2.draw(ring3);

        g2.setColor(Color.YELLOW);
        g2.draw(ring4);

        g2.setColor(Color.GREEN);
        g2.draw(ring5);

    }
}