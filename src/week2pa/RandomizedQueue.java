/*
 * @author: Andrii Krymets
 * 27.09.2015
 * The class is an implementation of randomized queue data
 * structure and methods.
 * 
 */

package week2pa;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 *
 * @author Andrii Krymets
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    // number of elements in the queue
    private int n;

    // the randomized queue data structure - resizing array
    private Item[] s;

    /**
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
        n = 0;
        s = (Item[]) new Object[1];
    }

    /**
     * is the queue empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * return the number of items on the queue
     *
     * @return
     */
    public int size() {
        return n;
    }

    /**
     * resizing the array if we need to store more/much less elements
     */
    private void resize(int newCapacity) {
        Item[] copy = (Item[]) new Object[newCapacity];
        System.arraycopy(s, 0, copy, 0, n);
        s = copy;
    }

    /**
     * add the item
     *
     * @param item
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("no input item");
        }

        if (n == s.length) {
            resize(s.length * 2);
        }

        /*
         * n items have indexes from 0 to n - 1. Next enqueued item will have
         * index n in the queue.
         */
        s[n] = item;

        // increasing number of enqueued items by 1
        n++;
    }

    /**
     * remove and return a random item
     *
     * @return
     */
    public Item dequeue() {

        if (isEmpty()) {
            throw new java.util.NoSuchElementException("the queue is empty");
        }

        int i = StdRandom.uniform(0, n);

        Item item = s[i]; // selecting uniformely random item

        // moving all elements right from i to n in 1 position to the left
        // in order to get rid of null value inside the queue
        for (int j = i; j < n - 1; j++) {
            s[j] = s[j + 1];
        }

        s[n - 1] = null;

        n--; // decreasing number of elements in the queue

        // resizing the queue if needed
        if (n > 0 && n == s.length / 4) {
            resize(s.length / 2);
        }

        return item;
    }

    /**
     * return (but do not remove) a random item
     *
     * @return
     */
    public Item sample() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("the queue is empty");
        }

        // selecting uniformely random item's index
        int i = StdRandom.uniform(0, n);

        return s[i];
    }

    @Override
    /**
     * return an independent iterator over items in random order
     */
    public Iterator<Item> iterator() {
        return new QueueIterator<>();
    }

    /**
     * class of iterator for randomized queue
     *
     * @param <Item>
     */
    private class QueueIterator<Item> implements Iterator<Item> {

        private int k;

        public QueueIterator() {
            k = 0;
        }

        @Override
        public boolean hasNext() {
            return k < n;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            return (Item) s[k++];
        }
    }
}
