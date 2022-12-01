/**
	The Towers of Hanoi
	Write a recursive method that writes out all the
	steps necessary to solve the Towers of Hanoi problem.

	@author Alisa Todorova
*/
import java.util.*;
public class HanoiTowers
{
    private static int count = 0; //for counting the total moves

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Give the tower height: ");
        int height = in.nextInt();
        in.close();

        //The Towers of Hanoi have 3 rods or stacks
        String leftStack = "first";
        String middleStack = "second";
        String rightStack = "third";

        moveDiscs(height, leftStack, middleStack, rightStack);
        System.out.println("Congrats! You are done!");
        System.out.println("Total moves: " + count);
    }

    /**
    	The Towers of Hanoi
    	Write a recursive method that writes out all the
    	steps necessary to solve the Towers of Hanoi problem.

     	@param n Number of discs
     	@param initialStack All the discs are stacked on this rod (or stack) initially
     	@param supportStack This is the middle rod (or stack) which helps us move the discs in the correct order
     	@param targetStack All the discs must be moved on this rod (or stack) in the end

    */
    public static void moveDiscs(int n, String initialStack, String supportStack, String targetStack)
    {
        //base case: when there's only 1 disc left
        if(n == 1)
        {
            count++; //base case is also counted in the total moves
            System.out.println("Move the top disc from the " + initialStack + " stack to the " + targetStack + " stack.");
            return; //ends the whole method
        }

        count++; //counts how many moves it took to move all discs from initialStack to targetStack
        moveDiscs(n - 1, initialStack, targetStack, supportStack); //from 1st rod to 2nd using the 3rd as help
        System.out.println("Move the top disc from the " + initialStack + " stack to the " + targetStack + " stack.");
        moveDiscs(n - 1, supportStack, initialStack, targetStack); //from 2nd rod to 3rd using 1st as help

    }
}