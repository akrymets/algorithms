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
        
        if (args.length == 0) {
            //throw new IllegalArgumentException("waiting for k");
            k = 3;
        } else {    
            k = Integer.parseInt(args[0]);
        }
        
        RandomizedQueue<String> rq = new RandomizedQueue<>();
            
        String str = StdIn.readString();
        
        while (!"end".equals(str)) {
            rq.enqueue(StdIn.readString());
            str = StdIn.readString();
        }
        
        for (int i = 0; i < k; i++) {
            StdOut.println(rq.dequeue());
        }
        
        
        
    }
}
