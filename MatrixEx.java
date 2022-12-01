/**
Part 1: Print out a Matrix diagonally
Part 2: Find the shortest consecutive section of array A,
where all values between 0 and k-1 (where 1<=k<=N) appear and
more specifically the length of that shortest section.

* @author Alisa Todorova
*/

import java.util.*;
public class MatrixEx
{
    public static void main(String[] args)
    {
        int[][] myArray1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] myArray2 = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {9, 10, 11}};
        int[][] myArray3 = {{10, 11, 22, 33, 44, 55, 66, 77, 88, 99}, {111, 333, 222, 320, 456, 670, 555, 890, 900, 757}};

        //Test the method diagonalPrint with 2-3 different arrays
        diagonalPrint(myArray1);
        diagonalPrint(myArray2);
        diagonalPrint(myArray3);


        int[] A = {0, 2, 0, 2, 0, 2, 2, 1, 1, 0};
        int[] B = {0, 1, 1, 4, 0, 2, 0, 1, 0, 2};
        int[] C = {0, 0, 3, 4, 1, 2, 1, 0, 3, 4};

        //Test the method allNumsWithin with 2-3 different arrays
        System.out.println(allNumsWithin(A, 3));
        System.out.println(allNumsWithin(B, 5));
        System.out.println(allNumsWithin(C, 5));

    }

    /**
    Part 1: Print out a Matrix diagonally
    Write a method diagonalPrint that prints
    a two-dimensional integer array diagonally.
    */
    public static void diagonalPrint(int[][] M)
    {
        //k = start of each diagonal (rows 0 to M.length-1)
        for(int k = 0; k < M.length - 1; k++) //rows
        {
            int i = k; //rows
            int j = 0; //columns

            while(i >= 0 && j <= M[0].length - 1)
            {
                if(j == 0 && i == 0)
                {
                    System.out.print(M[i][j]);
                }
                else
                {
                    System.out.print(" - " + M[i][j]);
                }
                //go to the next element of the diagonal
                i--;
                j++;
            }
        }

        //k = start of each diagonal (diagonals of columns from last row)
        for(int k = 0; k <= M[0].length - 1; k++) //columns
        {
            int i = M.length - 1; //every element starts in the last row
            int j = k; //columns

            while(j <= M[0].length - 1 && i >= 0) //every diagonal ends in the last column
            {
                System.out.print(" - " + M[i][j]);
                //go to the next element of the diagonal
                i--;
                j++;

                if(j == M[0].length - 1 && i == M.length - 1)
                {
                    System.out.print(M[i][j]);

                }
            }
        }
        System.out.println();
    }

    /**
    Part 2: Find the shortest consecutive section of array A,
    where all values between 0 and k-1 (where 1<=k<=N) appear and
    more specifically the length of that shortest section.
    */

    //Check if the values are between 0 and k-1
    public static boolean checkRange(int[] A, int k, int start, int finish)
    {

        //keeps count of how many values within the range the method has found
        boolean[] found = new boolean[k];

        for(int i = start; i <= finish; i++) //check values from a specific section
        {
            found[A[i]] = true;
        }

        for(int i = 0; i <= k - 1; i++)
        {
            if(found[i] == false)
            {
                return false;
            }
        }
        return true;
    }

    public static int allNumsWithin(int[] A, int k)
    {
        int length = 0;
        int minLength = Integer.MAX_VALUE;

        for(int i = 0; i < A.length; i++) //original array
        {
            for(int j = i; j < A.length; j++) //sub-array
            {
                if(checkRange(A, k, i, j) == true)
                {
                    length = j - i + 1;
                }
            }

            if(length < minLength)
            {
                minLength = length;
            }
        }

        return minLength;
    }
}

