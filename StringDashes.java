/**
Write a method named printLetters that takes a String as its parameter
and that prints the letters of the String, separated by dashes.
For example, the call of printLetters("Rabbit") should print: R-a-b-b-i-t

* @author Alisa Todorova
*/

import java.util.Scanner;
public class StringDashes
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = in.next();
        in.close();

        printLetters(word);
    }

    public static void printLetters(String x)
    {
        if(x.length() > 0)
        {
            for(int i = 0; i < x.length(); i++)
            {
            	if((i==0) || (i==x.length())){
            	System.out.print(x.charAt(i));
            	}
            else{
                System.out.print("-" + x.charAt(i));
            }
            }
             System.out.println();
        }
    }
}