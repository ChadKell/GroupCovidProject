package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// Mingji Xi

/**
 * Linked List will store and sort the data contained within this project using
 * linked chains.
 * 
 * @author Mingji Xi
 * @version 11/21/2020
 *
 */

public class LinkedList<T> implements DLLInterface<T>, Iterable<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedList() {
        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     * Adds a new entry to the end of this list. Entries currently in the list
     * are unaffected. The list's size is increased by 1.
     * 
     * @param newEntry
     *            The object to be added as a new entry.
     */
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
        }
        else {
            Node lastNode = getNodeAt(numberOfEntries - 1);
            lastNode.setNext(newNode);
        }

        numberOfEntries++;

    }


    /**
     * Adds a new entry at a specified position within this list. Entries
     * originally at and above the specified position are at the next higher
     * position within the list. The list's size is increased by 1.
     * 
     * @param newPosition
     *            An integer that specifies the desired position of the new
     *            entry.
     * @param newEntry
     *            The object to be added as a new entry.
     * @throws IndexOutOfBoundsException
     *             if either newPosition less than 0 or newPosition greater than
     *             getLength().
     */
    public void add(int position, T newEntry) {
        if ((position >= 0) && (position <= numberOfEntries)) {
            Node newNode = new Node(newEntry);

            if (position == 0) {
                newNode.setNext(firstNode);
                firstNode = newNode;
            }
            else {
                Node nodeBefore = this.getNodeAt(position - 1);
                Node nodeAfter = nodeBefore.getNext();
                newNode.setNext(nodeAfter);
                nodeBefore.setNext(newNode);
            }

            numberOfEntries++;
        }
        else {
            throw new IndexOutOfBoundsException("Illegal Position given.");
        }

    }


    /**
     * Removes the entry at a given position from this list. Entries originally
     * at positions higher than the given position are at the next lower
     * position within the list, and the list's size is decreased by 1.
     * 
     * @param givenPosition
     *            An integer that indicates the position of the entry to be
     *            removed.
     * @return A reference to the removed entry.
     * @throws IndexOutOfBoundsException
     *             if either givenPosition less than 0 or givenPosition greater
     *             than or equal to getLength().
     */
    public T remove(int position) {
        T result = null;

        if ((position >= 0) && (position < numberOfEntries)) {

            if (position == 0) {
                result = firstNode.getData();
                firstNode = firstNode.getNext();
            }
            else {
                Node nodeBefore = this.getNodeAt(position - 1);
                Node nodeToRemove = nodeBefore.getNext();
                result = nodeToRemove.getData();
                Node nodeAfter = nodeToRemove.getNext();
                nodeBefore.setNext(nodeAfter);
            }

            numberOfEntries--;
            return result;

        }
        else {
            throw new IndexOutOfBoundsException(
                "Illegal Position given to remove");
        }

    }


    /** Removes all entries from this list. */
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;

    }


    /**
     * Replaces the entry at a given position in this list.
     * 
     * @param givenPosition
     *            An integer that indicates the position of the entry to be
     *            replaced.
     * @param newEntry
     *            The object that will replace the entry at the position
     *            givenPosition.
     * @return The original entry that was replaced.
     * @throws IndexOutOfBoundsException
     *             if either givenPosition less than 0 or givenPosition greater
     *             than or equal to getLength().
     */
    public T replace(int position, T newEntry) {
        if ((position >= 0) && (position < numberOfEntries)) {
            Node desiredNode = this.getNodeAt(position);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        }
        else {
            throw new IndexOutOfBoundsException(
                "Illegal Position given to replace");
        }

    }


    /**
     * Retrieves the entry at a given position in this list.
     * 
     * @param givenPosition
     *            An integer that indicates the position of the desired entry.
     * @return A reference to the indicated entry.
     * @throws IndexOutOfBoundsException
     *             if either givenPosition less than 0 or givenPosition greater
     *             than getLength().
     */
    public T getEntry(int position) {
        if ((position >= 0) && (position < numberOfEntries)) {
            return getNodeAt(position).getData();
        }
        else {
            throw new IndexOutOfBoundsException(
                "Illegal Position given to getEntry.");
        }

    }


    /**
     * Retrieves all entries that are in this list in the order in which they
     * occur in the list.
     * 
     * @return A newly allocated array of all the entries in the list. If the
     *         list is empty, the returned array is empty.
     */
    public T[] toArray() {

        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNext();
            index++;
        }

        return result;
    }


    /**
     * Sees whether this list contains a given entry.
     * 
     * @param anEntry
     *            The object that is the desired entry.
     * @return True if the list contains anEntry, or false if not.
     */
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            }
            else {
                currentNode = currentNode.getNext();
            }
        }

        return found;
    }


    /**
     * Gets the length of this list.
     * 
     * @return The integer number of entries currently in the list.
     */
    public int getLength() {
        return numberOfEntries;

    }


    /**
     * Sees whether this list is empty.
     * 
     * @return True if the list is empty, or false if not.
     */
    public boolean isEmpty() {
        return (numberOfEntries == 0);

    }


    /**
     * Helper method which obtains the node at the specified index.
     * 
     * @param givenPosition
     *            The position where the node is located.
     * @return
     *         The node at the specified position.
     */
    private Node getNodeAt(int position) {
        Node currentNode = firstNode;
        for (int counter = 0; counter < position; counter++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;

    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}"
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        String result = "{";

        Node current = firstNode;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Insertion sort method for sorting the data
     */

    public void insertionSort(Comparator<T> comparator) {
        if (numberOfEntries > 1) {
            Node unsorted = firstNode.getNext();
            Node sorted = firstNode;
            sorted.setNext(null);

            while (unsorted != null) {
                Node nodeInsert = unsorted;
                unsorted = unsorted.getNext();
                this.insertInOrder(nodeInsert, comparator); 
            }
        }
    }


    /**
     * Helper method for insertionSort method
     * 
     * @param nodeInsert
     *            the insert node
     */
    @SuppressWarnings("unchecked")
    private void insertInOrder(Node nodeInsert, Comparator<T> comparator) { 
        T item = nodeInsert.getData();
        Node current = firstNode;
        Node previous = null;

        while ((current != null) && (comparator.compare(item, current
            .getData()) > 0)) { 
            previous = current;
            current = current.getNext();
        }

        if (previous != null) {
            previous.setNext(nodeInsert);
            nodeInsert.setNext(current);
        }
        else {
            nodeInsert.setNext(firstNode);
            firstNode = nodeInsert;
        }
    }

    /**
     * Node class will contain the data and next field of the LinkedList
     * object.
     * 
     * @author Mingji Xi
     * @version 11/14/2020
     *
     */
    private class Node {
        private T data;
        private Node next;

        /**
         * Creates a new Node object.
         * 
         * @param dataPortion
         *            The data that the node object will hold.
         */
        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        }


        /**
         * Creates a new Node object.
         * 
         * @param dataPortion
         *            The data that the node object will hold.
         * @param nextNode
         *            The variable that will reference the next node object.
         */
        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }


        /**
         * Obtains the data of the node.
         * 
         * @return the data that the node is holding.
         */
        private T getData() {
            return data;
        }


        /**
         * Sets the data for the node.
         * 
         * @param newData
         *            The data that the node will be set to.
         */
        private void setData(T newData) {
            data = newData;
        }


        /**
         * Obtains the next field of the node.
         * 
         * @return the next field of the node.
         */
        private Node getNext() {
            return next;
        }


        /**
         * Sets the next field of the node.
         * 
         * @param nextNode
         *            The next field of the node will be set to this node.
         */
        private void setNext(Node nextNode) {
            next = nextNode;
        }

    }

    /**
     * Iterator method creates Iterator object.
     *
     * @return new Iterator object
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Iterator class
     * 
     * @author Mingji Xi
     * @version 11/14/2020
     *
     */
    private class LinkedListIterator implements Iterator<T> {
        Node current = null;

        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        public boolean hasNext() {
            if (current == null && firstNode != null) {
                return true;
            }
            else if (current != null) {
                return current.getNext() != null;
            }
            return false;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        public T next() {
            if (current == null && firstNode != null) {
                current = firstNode;
                return firstNode.getData();

            }
            else if (current != null) {

                current = current.getNext();
                return current.getData();
            }
            throw new NoSuchElementException();
        }

    }

    @Override
    /**
     * returns size
     */
    public int size() {
        
        return numberOfEntries;
    }


    @Override
    /**
     * kind of caught in a loop
     */
    public T get(String object) {       
        return null;
    }

}
