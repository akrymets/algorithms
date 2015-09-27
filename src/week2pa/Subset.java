/*
 * @author: Andrii Krymets
 * 27.09.2015
 * The class tests methods from RandomizedQueue class.
 * 
 */

package week2pa;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author Andrey
 */
public class Subset {
    public static void main(String[] args) {

        RandomizedQueue<String> rq = new RandomizedQueue<>();
        
        int k;
        
        if (args.length == 0) {
            //throw new IllegalArgumentException("waiting for k");
            k = 3;
        } else {    
            k = Integer.parseInt(args[0]);
        }

        String[] strings = StdIn.readAllStrings();

        for (String string : strings) {
            rq.enqueue(string);
        }
        
        for (int i = 0; i < k; i++) {
            StdOut.println(rq.dequeue());
        }
        
    }
}
