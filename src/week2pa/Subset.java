/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        
        int k;
        int n;
        
        if (args.length > 0) {
            k = Integer.parseInt(args[0]);
            n = Integer.parseInt(args[1]);
            
            if (k > n) {
                throw new IllegalArgumentException("k should be less than n");
            }
            
        } else {
            k = 3;
            n = 8;
        }
        
        RandomizedQueue<String> rq = new RandomizedQueue<>();
                
        for (int i = 0; i < n; i++) {
            rq.enqueue(StdIn.readString());
        }
        
        StdOut.print("% echo ");
        
        for (String s : rq) {
            StdOut.print(s + " ");
        }
        
        StdOut.println("| java Subset " + k);
        
        for (int i = 0; i < k; i++) {
            StdOut.println(rq.dequeue());
        }
        
        
        
    }
}
