package prj5;
/**
 * node class is implemented by the Doubly linked list
 * @author Chad Kelley
 *
 * @param <T>
 */
public class Node<T> {

    Node<T> next;
    Node<T> previous;
    T data;

    /**
     * Creates a new node with the given data
     *
     * @param d
     *            the data to put inside the node
     */
    public Node(T nod) {
        data = nod;
    }


    /**
     * Sets the node after this node
     *
     * @param node
     *            the node after this one
     */
    public void setNext(Node<T> node) {
        next = node;
    }


    /**
     * Sets the node before this one
     *
     * @param nxt
     *            the node before this one
     */
    public void setPrevious(Node<T> nxt) {
        previous = nxt;
    }


    /**
     * Gets next node
     *
     * @return the next node
     */
    public Node<T> next() {
        return next;
    }


    /**
     * Gets the node before this one
     *
     * @return previous node
     */
    public Node<T> previous() {
        return previous;
    }


    /**
     * Gets the data in the node
     *
     * @return the data in the node
     */
    public T getData() {
        return data;
    }

}
