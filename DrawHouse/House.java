/**
Write a program that draws a picture of a house.
Implement a class House and supply a method draw(Graphics2D g2) that draws the house.

* @author Alisa Todorova
*/

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class House
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
    public House(double x, double y)
    {
        xLeft = x;
        yTop = y;
    }

    /**
     * Draws the house.
     *
     * @param g2 the graphics context
     */
    public void draw(Graphics2D g2)
    {
        //(double x, double y, double width, double height)
        Rectangle2D.Double body = new Rectangle2D.Double(xLeft + 20, yTop + 20, 60, 50); //The body of the house.
        //Points of the roof
        Point2D.Double r1 = new Point2D.Double(xLeft + 20, yTop + 20);
        Point2D.Double r2 = new Point2D.Double(xLeft + 50, yTop - 10);
        Point2D.Double r3 = new Point2D.Double(xLeft + 80, yTop + 20);
        //Lines of the roof
        Line2D.Double roofSide1 = new Line2D.Double(r1, r2);
        Line2D.Double roofSide2 = new Line2D.Double(r2, r3);
        //The door and its knob
        Rectangle2D.Double door = new Rectangle2D.Double(xLeft + 40, yTop + 55, 20, 15);
        Point2D.Double r4 = new Point2D.Double(xLeft + 40, yTop + 63);
        Point2D.Double r5 = new Point2D.Double(xLeft + 50, yTop + 63);
        Line2D.Double doorKnob = new Line2D.Double(r4, r5);
        //Windows
        Rectangle2D.Double window1 = new Rectangle2D.Double(xLeft + 30, yTop + 30, 15, 15);
        Rectangle2D.Double window2 = new Rectangle2D.Double(xLeft + 55, yTop + 30, 15, 15);
        //Chimney
        Point2D.Double r6 = new Point2D.Double(xLeft + 30, yTop + 10);
        Point2D.Double r7 = new Point2D.Double(xLeft + 30, yTop - 10);
        Point2D.Double r8 = new Point2D.Double(xLeft + 40, yTop - 10);
        Point2D.Double r9 = new Point2D.Double(xLeft + 40, yTop);
        Line2D.Double chimneyLine1 = new Line2D.Double(r6, r7);
        Line2D.Double chimneyLine2 = new Line2D.Double(r7, r8);
        Line2D.Double chimneyLine3 = new Line2D.Double(r8, r9);
        //The tree next to the house
        Rectangle2D.Double treeStem = new Rectangle2D.Double(xLeft + 120, yTop + 20, 10, 50);
        Ellipse2D.Double treeCrown1 = new Ellipse2D.Double(xLeft + 100, yTop - 5, 30, 30);
        Ellipse2D.Double treeCrown2 = new Ellipse2D.Double(xLeft + 110, yTop - 15, 30, 30);
        Ellipse2D.Double treeCrown3 = new Ellipse2D.Double(xLeft + 120, yTop - 5, 30, 30);


        g2.draw(body);
        g2.draw(roofSide1);
        g2.draw(roofSide2);
        g2.draw(door);
        g2.draw(doorKnob);
        g2.draw(window1);
        g2.draw(window2);
        g2.draw(chimneyLine1);
        g2.draw(chimneyLine2);
        g2.draw(chimneyLine3);
        g2.draw(treeStem);
        g2.draw(treeCrown1);
        g2.draw(treeCrown2);
        g2.draw(treeCrown3);

    }
}