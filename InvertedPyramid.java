/**
Output an inverted pyramid:
*******
*****
***
*

* @author Alisa Todorova
*/

public class InvertedPyramid
{
    public static void main(String[] args)
    {
        for(int i = 1; i <= 7; i+=2)
        {
            for (int j=7-i; j >= 0; j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}