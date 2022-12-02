/**
 * @author Alisa Todorova
 * @create date 2021-03-05 08:55:24
 * @modify date 2021-03-05 08:55:24
 * @desc Write a RECURSIVE method that calculates the number of occurrences of a
 *       character c in a string S starting at a given position i to the end of
 *       the string (so including i, where the numbering of the string starts at
 *       0). So if the position i is specified as 0, it should just return the
 *       number of occurrences of this character c in the whole string.
 * 
 *       Example: count("abcdee",e,0)=2
 * 
 *       Implement therefore the method count in the class StringCount. Since it
 *       is recursive, the method count needs to call itself!
 */

public class StringCount {

    public StringCount() {
    }

    public int count(String s, char c, int i) {

        // Base case: we've reach the end of the string
        if (s.length() == i) {
            return 0;
        }
        // c is at the current position
        else if (s.charAt(i) == c) {
            return 1 + count(s, c, i + 1); // return this position and start from the next position
        } else {
            return count(s, c, i + 1); // start from the next position, i.e. i+1
        }
    }

    public static void main(String[] args) {
        StringCount s = new StringCount();
        System.out.println(s.count("abcdee", 'b', 1));
    }
}