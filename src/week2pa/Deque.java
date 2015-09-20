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
 */
public class Deque<Item> implements Iterable<Item> {

    /**
     * construct an empty deque
     */
    public Deque() {
    }

    /**
     * is the deque empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     *
     * @return the number of items on the deque
     */
    public int size() {
        return 0;
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
        
        
        
        return null;
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
        
        
        
        return null;
    }

    /**
     * return an iterator over items in order from front to end
     *
     * @return
     */
    public Iterator<Item> iterator() {
        return null;
    }

   
    
    /**
     * unit testing
     *
     * @param args
     */
    public static void main(String[] args) {

    }

}
