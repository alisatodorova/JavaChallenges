/**
 * @author Alisa Todorova
 * @create date 2021-02-10 17:28:30
 * @modify date 2021-02-10 17:28:30
 * @desc Implement a Binary tree using a linked representation. Implement the
 *       binary tree using the given class templates LinkedBinaryTree and
 *       LinkedBinaryTreeNode.
 */

public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E> {

    private E element;
    private LinkedBinaryTreeNode<E> parent;
    private LinkedBinaryTreeNode<E> leftChild;
    private LinkedBinaryTreeNode<E> rightChild;

    /**
     * Creates a LinkedBinaryTreeNode constructor
     * 
     * @param e the element to be stored in the node
     * @param p the parent node of the created node
     */
    public LinkedBinaryTreeNode(E e, LinkedBinaryTreeNode<E> p) {
        element = e;
        parent = p;
        leftChild = null;
        rightChild = null;
    }

    /**
     * Returns the element contained in the node
     * 
     * @return a reference to the element contained in the node
     */
    public E getElement() {
        return element;
    }

    /**
     * Sets an element in the node
     * 
     * @param e The element to be stored in the node
     */
    public void setElement(E e) {
        element = e;
    }

    /**
     * Returns the parent of the node
     * 
     * @return a reference to the parent node
     */
    public BinaryTreeNode<E> getParent() {
        return parent;
    }

    /**
     * Returns the left child of the node
     * 
     * @return a reference to the left child of the node
     */
    public BinaryTreeNode<E> getLeftChild() {
        return leftChild;
    }

    /**
     * Returns the right child of the node
     * 
     * @return a reference to the right child of the node
     */
    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }

    /**
     * Adds a left child to the node
     * 
     * @param element The element to be stored in the left node
     */
    public void addLeftChild(E element) {
        if (hasLeftChild()) {
            throw new IllegalArgumentException("The node already has a left child!");
        }
        leftChild = new LinkedBinaryTreeNode<>(element, this); // this = node itself (calls the constructor and creates
                                                               // an object, i.e. a node)
    }

    /**
     * Adds a right child to the node
     * 
     * @param element The element to be stored in the right node
     */
    public void addRightChild(E element) {
        if (hasRightChild()) {
            throw new IllegalArgumentException("The node already has a right child!");
        }
        rightChild = new LinkedBinaryTreeNode<>(element, this);
    }

    /**
     * Cheks whether the node has a left child
     * 
     * @return true if there is already a left child
     */
    public boolean hasLeftChild() {
        return (leftChild != null);
    }

    /**
     * Cheks whether the node has a right child
     * 
     * @return true if there is already a right child
     */
    public boolean hasRightChild() {
        return (rightChild != null);
    }

    /**
     * Deletes the nodes
     */
    public void delete() {
        // An internal node with 2 children cannot be deleted
        assert (rightChild == null || leftChild == null);

        if (rightChild == null) {
            // this (aka ourself) is the left child of the parent
            if (this.parent.leftChild == this) {
                // put the left child up and
                // replace ourself with the left child
                this.parent.leftChild = leftChild;
                if (leftChild != null) {
                    // the parent of our left child is our previous parent
                    leftChild.parent = this.parent;
                }
            } else { // this (aka ourself) is the right child of the parent
                this.parent.rightChild = leftChild;
                if (leftChild != null) {
                    leftChild.parent = this.parent;
                }
            }
        } else { // the left child is null
            if (this.parent.leftChild == this) {
                this.parent.leftChild = rightChild;
                if (rightChild != null) {
                    rightChild.parent = this.parent;
                }
            } else {
                this.parent.rightChild = rightChild;
                if (rightChild != null) {
                    rightChild.parent = this.parent;
                }
            }
        }
        parent = null;
        leftChild = null;
        rightChild = null;

        // // Remove leafs
        // if (this.leftChild == null && this.rightChild == null) {
        // this.parent = null;
        // this.leftChild = null;
        // this.rightChild = null;
        // } else if (this.leftChild == null) {
        // if (this.parent.leftChild == this) {
        // this.parent.leftChild = this.rightChild;
        // } else {
        // this.parent.rightChild = this.rightChild;
        // }
        // } else if (this.rightChild == null) {
        // if (this.parent.leftChild == this) {
        // this.parent.leftChild = this.leftChild;
        // } else {
        // this.parent.leftChild = this.leftChild;
        // }
        // } else {
        // throw new IllegalArgumentException("You can't delete a node with 2
        // children!");
        // }
    }
}
