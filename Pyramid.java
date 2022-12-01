/**
* Write a Java program that prints a pyramid like this:
	[]
  [][][]
[][][][][]
Let your program ask the user for the height of the pyramid.  
*
* @author Alisa Todorova
*
*/
import java.util.Scanner;
public class Pyramid
{
    public static void main(String[] args)
    {
    	System.out.println("Enter height of the pyramid: ");
    	Scanner in = new Scanner(System.in);
    	int rows = in.nextInt();
    	
    	int k = 0;

        for(int i = 1; i <= rows; ++i, k = 0) {
            for(int space = 1; space <= rows - i; ++space) {
                System.out.print("  ");
            }

            while(k != 2 * i - 1) {
                System.out.print("[]");
                ++k;
            }

            System.out.println();
    	}
    }
}