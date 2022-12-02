/**
 * @author Alisa Todorova
 * @create date 2021-02-06 10:38:05
 * @modify date 2021-02-06 10:38:05
 * @desc Write a program that implements a Queue data structure using two
 *       stacks. Meaning: do not store the Queue elements in an array or linked
 *       list, but use two stacks to store the elements. All the Queue's
 *       operations should then be executed on the underlying stacks.
 */

// Class for queue
public class Queue<E> implements IQueue<E> {
    private Stack<E> stackQu; // stack for queueing elements
    private Stack<E> stackDe; // stack for dequeueing element
    private int capacity; // maximum capacity of the stack
    private int count; // current size of the stack

    // Constructor to initialize queue/stack
    public Queue(int size) {
        stackQu = new Stack<>(size);
        stackDe = new Stack<>(size);
        capacity = size;
        count = 0;
    }

    // Removes and returns element at front of stack
    public E dequeue() {
        if (isEmpty())
            throw new RuntimeException("Queue empty exception");

        // "Flip" one stack over into the other
        while (!stackQu.isEmpty()) {
            stackDe.push(stackQu.pop());
        }

        count--;
        return stackDe.pop();
    }

    // Inserts item at end of stack
    public void enqueue(E item) {
        if (isFull())
            throw new RuntimeException("Queue is full exception");

        stackQu.push(item);
        count++;
    }

    public E peek() {
        if (isEmpty())
            throw new RuntimeException("Queue empty exception");

        return stackQu.peek();
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public boolean isFull() {
        return (size() == capacity);
    }
}
