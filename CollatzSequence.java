/**
Collatz Sequence:
If you take any natural number n (i.e.  1, 3, 27 etc.), apply the following rules:
1.  if n is even:  divide n by 2
2.  if n is odd:  multiply by 3 and add 1
and continue to do this with the new number you obtain, you will at some point always reach the number 1.
Implement Collatz Sequence as a Java Program.
Your program should print out all the numbers that make up the sequence together
with, at the end, the number of steps it took to reach the value 1.
*
*
* @author Alisa Todorova
*
*/
import java.util.Scanner;
public class CollatzSequence
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = in.nextInt();
        in.close();

        int count = 0;

        // We simply follow steps
        // while we do not reach 1
        while (n != 1)
        {
            count++;
            System.out.print(n + " ");

            // If n is odd
            if ((n & 1) == 1)
                n = (3 * n) + 1;

            // If even
            else
                n = n / 2;
        }

        // Print 1 at the end
        System.out.println(n);
        System.out.println("The number of steps it took to reach the value 1 is " + count);
    }
}