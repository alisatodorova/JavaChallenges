/**
Write a method named printGrid that accepts two integers
representing a  number  of  rows  and  columns
and  prints  a  grid  of  integers  from  1  to (rows*columns) in column-major order.
For example, the call: printGrid(4, 6);
should produce the following output:
1 5 9 13 17 21
2 6 10 14 18 22
3 7 11 15 19 23
4 8 12 16 20 24

* @author Alisa Todorova
*/
import java.util.Scanner;
public class Grid
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of columns: ");
        int columns = in.nextInt();
        System.out.print("Enter the number of rows: ");
        int rows = in.nextInt();
        in.close();
        printGrid(columns, rows);
    }

    public static void printGrid(int x, int y)
    {
        for(int i = 1; i <= x; i++)
        {
            for(int j = i; j <= x * y; j += x)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}