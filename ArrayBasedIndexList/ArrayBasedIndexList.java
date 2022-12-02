/**
 * @author Alisa Todorova
 * @create date 2021-02-06 11:49:01
 * @modify date 2021-02-06 11:49:01
 * @desc Implement an IndexList specified by the Interface using an Array.
 *       Implement your ArrayBasedIndexList in the proposed template.
 */

public class ArrayBasedIndexList<E> implements IndexList<E> {

    // Array of type E
    private E array[];
    // Size of array
    private int size;

    // int firstFree = 0;

    // Constructor to initialize the ArrayBasedIndexList
    public ArrayBasedIndexList() {
        array = (E[]) (new Object[size]);
    }

    // Inserts the specified element e at the specified position
    public void insert(int index, E e) {
        // assert(index < firstFree+1); //check if you can really insert there
        if (e == null) {
            throw new NullPointerException("The input is empty!");
        }

        // A new array, which is bigger than the original array
        E[] biggerArray = (E[]) (new Object[array.length + 1]); // array.length * 2 is better

        // Copy the elements from the old array into the new array
        // before the specified index
        for (int i = 0; i < index; i++) {
            biggerArray[i] = array[i];
        }

        // Insert the new element here
        biggerArray[index] = e;

        // Copy the elements from the old array into the new array
        // after the specified index
        for (int j = index + 1; j <= array.length; j++) {
            biggerArray[j] = array[j - 1];
        }
        array = biggerArray;
        // firstFree++; //to know how many elements are there
    }

    // Removes the element with the specified index
    public void remove(int index) {
        if (array == null) {
            throw new NullPointerException("The array is empty!");
        }

        // A new array, which is smaller than the original array
        E[] smallerArray = (E[]) (new Object[array.length - 1]);

        for (int i = 0; i < smallerArray.length; i++) {
            // Skip the element with the specified index
            if (i >= index) {
                smallerArray[i] = array[i + 1];
            }
            // Copy the elements from the old array into the new array
            else {
                smallerArray[i] = array[i];
            }
        }
        array = smallerArray;
    }

    /*
     * alternative to remove method:
     * 
     * for(int i = index, i<firstFree; i++){
     * 
     * array[i]= array[i+1]; }
     * 
     * firstFree--;
     **/

    // Returns the element with the specified index
    public E get(int index) {
        if (array == null) {
            throw new NullPointerException("The array is empty!");
        }

        return array[index];
    }

    // Returns the size of the IndexList
    public int getSize() {
        return size;
    }

}
