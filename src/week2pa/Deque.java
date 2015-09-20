/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
            throw new java.lang.NullPointerException();
        }

        Node newNode = new Node(item);

        if (isEmpty()) {
            newNode.nextNode = null;
            newNode.previousNode = null;
            firstNode = newNode;
        } else {
            newNode.nextNode = firstNode;
            firstNode.previousNode = newNode;
            firstNode = newNode;
        }

        // if it's the first node in the data structure then it's
        // also the last node
        if (isEmpty()) {
            lastNode = newNode;
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
            throw new java.lang.NullPointerException();
        }

        Node newNode = new Node(item);

        lastNode.nextNode = newNode;
        newNode.previousNode = lastNode;
        lastNode = newNode;

        dequeSize++;
    }

    /**
     * remove and return the item from the front
     *
     * @return
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        Node secondNode = firstNode.nextNode;
        firstNode.nextNode = null; // avoiding loitering
        firstNode = secondNode;

        dequeSize--;

        return firstNode.item;
    }

    /**
     * remove and return the item from the end
     *
     * @return
     */
    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        Node preLastNode = lastNode.previousNode;
        lastNode.previousNode = null;
        lastNode = preLastNode;

        dequeSize--;

        return lastNode.item;
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

        private Node currentNode = firstNode;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                Item item = currentNode.item;
                currentNode = currentNode.nextNode;
                return item;
            } else {
                return null;
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

        d.addFirst("b");
        d.addLast("c");
        d.addFirst("e");
        d.removeLast();

        for (String s : d) {
            System.out.println(s);
        }

    }

}
