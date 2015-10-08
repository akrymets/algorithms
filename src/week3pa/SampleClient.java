/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3pa;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author User
 */
public class SampleClient {

    public static void main(String[] args) {

        String var;
        
        if (args.length == 0) {
            var = "data/week3data/input3.txt";
        } else {
            var = args[0];
        }
        
        // read the N points from a file
        In in = new In(var);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.show(0);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
    }
}
