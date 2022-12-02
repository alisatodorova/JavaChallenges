
/**
 * @author Alisa Todorova
 * @create date 2021-02-05 19:42:33
 * @modify date 2021-02-05 19:42:33
 * @desc Using the attached Stack class implement a method 
 *       that reverses a list of integers using a stack.
 */

import java.util.Arrays;

public class Reverse {

    public static int[] reverse(int[] list) {

        Stack<Integer> stack = new Stack<>(list.length);

        // Push each integer one by one
        for (int i = 0; i < list.length; i++) {
            stack.push(list[i]);
        }

        // Pop all integers and then put into the list
        for (int j = 0; j < list.length; j++) {
            list[j] = stack.pop();
        }

        // Return the reversed list
        return list;
    }

    public static void main(String[] args) {
        // Every value in the argument array is a single element in the list
        int[] arr = new int[args.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        int[] result = reverse(arr);
        System.out.println(Arrays.toString(result));
    }
}
