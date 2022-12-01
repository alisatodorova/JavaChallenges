/**
* This program is about Matrix multiplication
*
* @author Alisa Todorova
*/

import java.util.*;
public class MatrixMult
{
    public static void main(String[] args)
    {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{10, 11}, {20, 21}, {30, 31}};

        //A new matrix to store the result from the method matrixProduct
        int[][] matrix3 = matrixProduct(matrix1, matrix2);

        printProduct(matrix3);
    }

    /**
    	Implement a method that performs matrix multiplication
        and returns the product of its two parameters as a result.
    */
    public static int[][] matrixProduct(int[][] a, int[][] b)
    {
        /**
        	Make the method check whether the multiplication is legal, i.e.
        	the width of the first matrix should be equal to the height of the second,
        	and warn the user if it isn't.

        	a[0].length - returns the length of the columns (or height) in the array
        	b.length - 	returns the length of the rows (or width) in the array

        	Matrices are multipliable if the columns of the first matrix are equal to the rows of the second.
        */
        if (a[0].length != b.length)
        {
            System.out.println("Illegal multiplication!");
            return null;
        }
        else
        {
            int[][] product = new int[a.length][b[0].length];

            for(int i = 0; i < a.length; i++) //rows from matrix1
            {
                for(int j = 0; j < b[0].length; j++) //columns from matrix2
                {
                    for(int k = 0; k < a[0].length; k++) //columns from matrix1 = rows from matrix2
                    {
                        //Formula: To multiply an m×n matrix by an n×p matrix,
                        //the ns must be the same, and the result is an m×p matrix.
                        product[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            return product;
        }
    }

    //Print the product of matrix1 and matrix2, which is stored in mathrix3
    public static void printProduct(int[][] c)
    {
        if (c == null)
        {
            return; //exits the method
        }

        System.out.println("The product of matrix1 and matrix2 is ");
        for (int i = 0; i < c.length; i++)
        {
            for (int j = 0; j < c[0].length; j++)
            {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
