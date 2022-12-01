/**
Write a method that inserts a new value into a sorted array.
(Keep in mind that this will increase the size of the array).
Test your method by sorting a number of numeric values read from the prompt using the Scanner class
and printing out the sorted list.

* @author Alisa Todorova
*/
import java.util.*;
public class Insert
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int length = in.nextInt();
        int[] array = new int[length];

        System.out.print("Enter the elements of the array: ");
        for(int i = 0; i < array.length; i++)
        {
            array[i] = in.nextInt();
        }

        System.out.print("Enter a new value to be inserted into the array: ");
        int newValue = in.nextInt();

        in.close();

        Arrays.sort(array);
        System.out.println("The old array is ");
        System.out.println(Arrays.toString(array));

        System.out.println("The new array with the inserted value " + newValue + " is ");
        insert(array, newValue);
    }

    public static void insert(int[] a, int b)
    {
        Arrays.sort(a);

        int[] newArray = new int[a.length + 1];

        for(int i = 0; i < a.length; i++)
        {
            if(b < a[i]) //sorts the new element
            {
                newArray[i] = b;

                //if the "if" is true, the next element of array a is moved one index
                //ex: 0 1 4; new element = 3
                //newArray[3] = a[2];
                for(int j = i + 1; j < newArray.length; j++) 
                {
                    newArray[j] = a[i];
                    i++;
                }
            }
            else
            {
                newArray[i] = a[i];
            }
        }
        System.out.println(Arrays.toString(newArray));

    }
}