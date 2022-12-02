
/**
 * @author Alisa Todorova
 * @create date 2021-02-25 16:44:11
 * @modify date 2021-02-25 16:44:11
 * @desc Implement the missing upHeap and downHeap methods.
 * Make sure that after deletion and insertion the heap order property is maintained.
 * [It's a MaxHeap]
 */

import java.util.*;

class Heap {
    private static final int d = 2;
    private int[] heap;
    private int heapSize;

    public Heap(int capacity) {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    private int parent(int i) {
        return (i - 1) / d;
    }

    private int kthChild(int i, int k) {
        return d * i + k;
    }

    public void insert(int x) {
        if (isFull())
            throw new NoSuchElementException("Heap is full");
        heap[heapSize++] = x;
        upHeap(heapSize - 1);
    }

    public int delete(int x) {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty");
        int key = heap[x];
        heap[x] = heap[heapSize - 1];
        heapSize--;
        downHeap(x);

        return key;
    }

    public int getHeapSize() {
        return heapSize;
    }

    // maintain heap property during insertion
    private void upHeap(int i) {
        int temp = heap[i]; // where we start
        // After insertion:
        // Are we not at the root && do we need to swap?
        while (i > 0 && temp > heap[parent(i)]) {
            heap[i] = heap[parent(i)]; // Swap
            i = parent(i); // Switch node to parent (i.e. reset the parent to position i)
        }
        heap[i] = temp;
    }

    // maintain heap property during deletion
    private void downHeap(int i) {
        int child;
        int temp = heap[i];
        // Check if we have not reached the last node
        while (kthChild(i, 1) < heapSize) {
            // Get either left or right child to swap
            child = maxChild(i);
            // Do we still have to swap?
            if (temp < heap[child]) {
                heap[i] = heap[child]; // Swap
            } else {
                break;
            }
            i = child; // Switch
        }
        heap[i] = temp;
    }

    private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

    public void printHeap() {
        System.out.println("nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    // return max from the heap
    public int findMax() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty.");
        return heap[0];
    }

    public int[] getHeap() {
        // This method is used for autotesting
        return heap;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);

        heap.delete(3);
        heap.printHeap();

    }
}