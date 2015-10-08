/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3pa;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrey
 */
public class PointTest {

    public PointTest() {
    }

    /**
     * Test of slopeTo method, of class Point.
     */
    @Test
    public void testSlopeTo() {

        System.out.println("Testing slopeTo");

        // positive slope 45 degrees
        Point instance = new Point(1000, 1000);
        Point that = new Point(2000, 2000);
        double result = instance.slopeTo(that);
        assertEquals(1.0, result, 0.0);

        // negative slope 45 degrees
        instance = new Point(1000, 1000);
        that = new Point(0, 2000);
        result = instance.slopeTo(that);
        assertEquals(-1.0, result, 0.0);

        // if the line is vertical
        instance = new Point(1000, 1000);
        that = new Point(1000, 2000);
        result = instance.slopeTo(that);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0);

        // if the line is horizontal
        instance = new Point(1000, 3000);
        that = new Point(2000, 3000);
        result = instance.slopeTo(that);
        assertEquals(0.0, result, 0.0);

        // if the line is degraded
        instance = new Point(1200, 3100);
        that = new Point(1200, 3100);
        result = instance.slopeTo(that);
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.0);

    }

    @Test
    public void testCompareTo() {
        
        System.out.println("Testing compareTo");
        
        // two points are equal
        Point instance = new Point(1235, 3112);
        Point that = new Point(1235, 3112);
        int result = instance.compareTo(that);
        assertEquals(0, result);

        // first point is less
        instance = new Point(1000, 3000);
        that = new Point(2000, 3000);
        result = instance.compareTo(that);
        assertEquals(-1, result);

        // first point is less
        instance = new Point(1000, 2000);
        that = new Point(2000, 3000);
        result = instance.compareTo(that);
        assertEquals(-1, result);
        
        // first point is bigger
        instance = new Point(5000, 3000);
        that = new Point(2000, 3000);
        result = instance.compareTo(that);
        assertEquals(1, result);
    }

}
