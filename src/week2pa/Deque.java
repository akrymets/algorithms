/*
 * @author: Andrii Krymets
 * 23.09.2015
 * The class is an implementation of deque (double-ended queue) data
 * structure and methods.
 * 
 */
package week2pa;

import java.util.Iterator;

/**
 *
 * @author Andrey
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

    // Storing size of the deque
    private int dequeSize;

    // reference to the first node in the data structure
    private Node firstNode;

    // reference to the last node in the data structure
    private Node lastNode;

    /**
     * construct an empty deque
     */
    public Deque() {
        dequeSize = 0;
        firstNode = null;
        lastNode = null;
    }

    /**
     * is the deque empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return dequeSize == 0;
    }

    /**
     *
     * @return the number of items on the deque
     */
    public int size() {
        return dequeSize;
    }

    /**
     * add the item to the front
     *
     * @param item
     */
    public void addFirst(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("There is no item to add");
        }

        Node newNode = new Node(item);

        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
            newNode.nextNode = null;
            newNode.previousNode = null;
        } else {
            newNode.nextNode = firstNode;
            firstNode.previousNode = newNode;
            firstNode = newNode;
        }

        dequeSize++;
    }

    /**
     * add the item to the end
     *
     * @param item
     */
    public void addLast(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("There is no item to add");
        }

        Node newNode = new Node(item);

        if (isEmpty()) {
            lastNode = newNode;
            firstNode = newNode;
            newNode.nextNode = null;
            newNode.previousNode = null;
        } else {
            lastNode.nextNode = newNode;
            newNode.previousNode = lastNode;
            lastNode = newNode;
        }

        dequeSize++;
    }

    /**
     * remove and return the item from the front
     *
     * @return
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("The deque is empty");
        }

        Item item = firstNode.item;

        if (size() > 1) {
            Node secondNode = firstNode.nextNode;

            // avoiding loitering by deleting or changing all references to
            // the Node we're removing
            secondNode.previousNode = null;
            firstNode = secondNode;
        } else {
            firstNode = null;
            lastNode = null;
        }

        dequeSize--;

        return item;
    }

    /**
     * remove and return the item from the end
     *
     * @return
     */
    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("The deque is empty");
        }

        Item item = lastNode.item;

        if (size() > 1) {
            Node preLastNode = lastNode.previousNode;

            // avoiding loitering by deleting or changing all references to
            // the Node we're removing
            preLastNode.nextNode = null;
            lastNode = preLastNode;
        } else {
            lastNode = null;
            firstNode = null;
        }

        dequeSize--;

        return item;
    }

    /**
     * return an iterator over items in order from front to end
     *
     * @return
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * Node of linkled items list structure
     */
    private class Node {

        Node previousNode;
        Node nextNode;
        Item item;

        Node(Item item) {
            this.item = item;
        }

    }

    /**
     * Iterator class for the Deque data structure
     */
    private class ListIterator implements Iterator<Item> {

        private Node currentNode;

        public ListIterator() {
            currentNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("there are no more"
                        + " elements in the deque");
            } else {
                Item item = currentNode.item;
                currentNode = currentNode.nextNode;
                return item;
            }
        }

    }

    /**
     * unit testing
     *
     * @param args
     */
    public static void main(String[] args) {

        Deque<String> d = new Deque<>();

        d.addFirst("a");
        d.removeFirst();
        d.removeLast();

        for (String s : d) {
            System.out.print(s + " ");
        }
        System.out.println();

    }

}
