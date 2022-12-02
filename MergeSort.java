
/**
 * @author Alisa Todorova
 * @create date 2021-02-25 15:07:03
 * @modify date 2021-02-25 15:07:03
 * @desc Using the attached MergeSort.java, 
 * complete the missing merge method, so the algorithm 
 * can sort any list of integers in ascending order in O(n log n).
 */

import java.util.Arrays;

class MergeSort {

    /**
     * Merges the two sub-arrays into one array
     * 
     * @param left  the left sub-array
     * @param rigth the right sub-array
     * @return the merged array
     */
    public static int[] merge(int[] left, int[] right) {
        // Initial indexes of first and second subarrays
        int[] arr = new int[left.length + right.length];
        // Initial index of the left sub-array
        int i = 0;
        // Initial index of the right sub-array
        int j = 0;
        // Initial index of the merged array
        int k = 0;

        while (left.length > i && right.length > j) { // Element-wise comparison
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        // Copying remaining elements from the left sub-array
        while (left.length > i) {
            arr[k] = left[i];
            i++;
            k++;
        }
        // Copying remaining elements from the right sub-array
        while (right.length > j) {
            arr[k] = right[j];
            j++;
            k++;
        }
        return arr;
    }

    /**
     * Merges sorts the array
     * 
     * @param arr the array
     * @return the sorted array
     */
    public static int[] sort(int arr[]) {
        // Find the middle point
        if (arr.length > 1) {
            int m = arr.length / 2;
            int[] l1 = Arrays.copyOfRange(arr, 0, m);
            int[] l2 = Arrays.copyOfRange(arr, m, arr.length);

            l1 = sort(l1);
            l2 = sort(l2);

            return merge(l1, l2);
        } else {
            return arr;
        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 5, 1, 2, 3, 56, 6, 3, 1, 2 };
        printArray(MergeSort.sort(a));
    }
}
