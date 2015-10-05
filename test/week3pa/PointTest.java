/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3pa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author User
 */
public class PointTest {
    
    public PointTest() {
    }

    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        
        int[] setOfX = {1, 5, 6, 6, 6, 5, 4, 4, 5};
        int[] setOfY = {6, 6, 6, 5, 4, 4, 4, 5, 5};
        int[] expRes = {-1, -1, -1, 1, 1, 1, 1, 1, 0};
        
        for (int i = 0; i < setOfY.length; i++) {
            Point instance = new Point(5, 5);
            Point that = new Point(setOfX[i], setOfY[i]);
            int expResult = expRes[i];
            int result = instance.compareTo(that);
            assertEquals(expResult, result);
        }
        
        fail("The test case is a prototype.");
    }

    public static void main(String[] args) {
        
        PointTest pt = new PointTest();
        pt.testCompareTo();
        
    }
    
}
