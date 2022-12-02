
/**
 * @author Alisa Todorova
 * @create date 2021-02-10 17:27:59
 * @modify date 2021-02-10 17:27:59
 * @desc Implement a Binary tree using a linked representation. 
 * Implement the binary tree using the given class templates LinkedBinaryTree and LinkedBinaryTreeNode.
 */

import java.awt.geom.NoninvertibleTransformException;

public class LinkedBinaryTree<E> implements BinaryTree<E> {

    // pseudo root node that stores null
    private LinkedBinaryTreeNode<E> root = new LinkedBinaryTreeNode<>(null, null);

    /**
     * Creates a LinkedBinaryTree constructor
     */
    public LinkedBinaryTree() {
    }

    /**
     * Returns the root node of the tree
     * 
     * @return a reference to the root node
     */
    public BinaryTreeNode<E> getRoot() {
        // make sure that there's a root, or throws an error
        // assert(root.hasLeftChild() == true);
        return this.root.getLeftChild();
    }

    /**
     * Adds a root node to the tree
     * 
     * @param e The element to be stored in the root
     */
    public void addRoot(E e) {
        this.root.addLeftChild(e);
    }

    /**
     * Checks whether the tree has a root node
     * 
     * @return true if the tree already has a root node
     */
    public boolean hasRoot() {
        return this.root.hasLeftChild();
    }
}
