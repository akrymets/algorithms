package week3pa;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class BruteCollinearPoints {

    private LineSegment[] lines;
    private int numberOfSegments;

    /**
     * finds all line segments containing 4 points
     *
     * @param points
     */
    public BruteCollinearPoints(Point[] points) {
        
        numberOfSegments = 0;
        lines = new LineSegment[points.length];
        double s2, s3, s4;
        Point p = null; // a line's first endpoint
        Point q = null; // the line's second endpoint
        
        
        for (int i = 0; i < points.length; i++) {
            p = points[i];
            q = points[i];
            for (int j = i; j < points.length; j++) {
                s2 = points[j].slopeTo(points[i]);
                p = lessPoint(p, points[j]);
                q = higherPoint(q, points[j]);
                for (int k = j; k < points.length; k++) {
                    s3 = points[k].slopeTo(points[i]);
                    p = lessPoint(p, points[k]);
                    q = higherPoint(q, points[k]);
                    if (Double.compare(s2, s3) != 0) {
                        break;
                    } else {
                        for (int l = k; l < points.length; l++) {
                            s4 = points[l].slopeTo(points[i]);
                            if (Double.compare(s4, s2) != 0) {
                                break;
                            } else {
                                p = lessPoint(p, points[l]);
                                q = higherPoint(q, points[l]);
                                lines[numberOfSegments++] = new LineSegment(p, q);
                            }
                        }
                    }
                }
            }
        }
    }

    private Point lessPoint(Point p1, Point p2) {
        return p1.compareTo(p2) < 0 ? p1 : p2;
    }

    private Point higherPoint(Point p1, Point p2) {
        return p1.compareTo(p2) > 0 ? p1 : p2;
    }

    /**
     * the number of line segments
     *
     * @return
     */
    public int numberOfSegments() {
        return numberOfSegments;
    }

    /**
     * the line segments
     *
     * @return
     */
    public LineSegment[] segments() {
        return lines;
    }

}
