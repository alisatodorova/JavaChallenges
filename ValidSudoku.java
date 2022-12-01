/**
Given a 9-by-9 array of integers between 1 and 9,
check if it is a valid solution to a Sudoku puzzle:
each row, column, and block should contain the 9integers exactly once.

* @author Alisa Todorova
*/
import java.util.*;
public class ValidSudoku
{
    public static void main(String[] args)
    {
        int[][] sudoku =
        {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        System.out.println(check(sudoku));
    }
    public static boolean check(int[][] a)
    {

        for (int i = 0; i < 9; i++) //column
        {

            int[] row = new int[9];
            int[] square = new int[9];
            //returns a reference to the new array (i.e. column) 
            //which contains (or references) the same elements as the source array (i.e. a)
            int[] column = a[i].clone();

            for (int j = 0; j < 9; j ++) //row
            {
                row[j] = a[j][i];

                //(i/3) -> column 
                //*3 -> you got the sqare you want to get in to
                //j/3 -> iterate row-wise, jump to the next column every 3 Elements
                //(i*3%9) -> jumping the squares vertically
                //%3 -> iterate 0, 1, 2
                square[j] = a[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3]; //row, then column where the element is
            }

            if (! validate(column) && validate(row) && validate(square) )
            {
                return false;
            }
        }
        return true;
    }

    //Each of the elements is given to a validate function to verify, 
    //that it contains the numbers only once.
    public static boolean validate(int[] b)
    {
        int i = 0;
        Arrays.sort(b);
        for (int number = 0; number < b.length; number++) //gives the numbers from 1 to 9
        {
            if (number != ++i){
                return false;
            }
        }
        return true;
    }
}