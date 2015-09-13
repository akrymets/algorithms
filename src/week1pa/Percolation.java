/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1pa;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 *
 * @author andriikrymets
 */
public class Percolation {

    private final int N;
    private int[] connectedSites;
    private boolean[] openedSites;
    private WeightedQuickUnionUF qu;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }

        this.N = N;

        openedSites = new boolean[N * N + 1];

        
        for (int i = 1; i <= N * N; i++) {
            openedSites[i] = false;
        }

        qu = new WeightedQuickUnionUF(N * N);

    }

    public void open(int i, int j) {
        checkXYValidity(i, j);

        // Finishes if already open
        if (isOpen(i, j)) {
            return;
        }

        int site1DIndex = xyTo1D(i, j);

        // Mark this site as open
        openedSites[site1DIndex] = true;

        // If the site is in the first row it must be also union with the virtual 0-site;
        if (site1DIndex <= N - 1) {
            qu.union(N, site1DIndex); // the virtual 0-site has index N in the array
        }

        int[] neighbors = getNeighbors(i, j);

        for (int k = 0; k < neighbors.length; k++) {
            if (neighbors[k] != -1) { // means this neighbor is out of grid
                int x = xyFrom1D(neighbors[k])[0];
                int y = xyFrom1D(neighbors[k])[1];

            // if a neighbor site is open and is not out bounds we union it with the site we have just opened
                if (isOpen(x, y)) {
                    qu.union(neighbors[k], site1DIndex);
                }
            }
        }
    }

    public boolean isOpen(int i, int j) {
        checkXYValidity(i, j);
        return openedSites[xyTo1D(i, j)];
    }

    public boolean isFull(int i, int j) {
        checkXYValidity(i, j);
        return qu.connected(xyTo1D(i, j), N); // the virtual 0-site has index N in the array

    }

    public boolean percolates() {
        return false;
    }

    private boolean connected(int s1, int s2) {
        return qu.connected(s1, s2);
    }

    private int[] getNeighbors(int x, int y) {
        checkXYValidity(x, y);

        int[] neighbors = new int[4];

        // If neighbor's coordinates are not valid - the xyTo1D function returns -1
        neighbors[0] = xyTo1D(x, y - 1); // Neighbor on top
        neighbors[1] = xyTo1D(x + 1, y); // Neighbor on right
        neighbors[2] = xyTo1D(x, y + 1); // Neighbor on bottom
        neighbors[3] = xyTo1D(x - 1, y); // Neighbor on left

        return neighbors;
    }

    /**
     * Map site's coordinates in the grid into the its array index.
     * @param x
     * @param y
     * @return Returns mapped site's number in the array or -1 if the coordinates are not valid
     */
    private int xyTo1D(int x, int y) {
        return xyAreValid(x, y) ? N * (y - 1) + x - 1 : -1;
    }

    /**
     * Map site's index in the array into its coordinates in the grid
     * @param m
     * @return Array of two site's coordinates in the grid: xy[0] - x; xy[1] - y;
     */
    private int[] xyFrom1D(int m) {
        if (m < 0 || m > N * N - 1) {
            throw new IllegalArgumentException("site's id is out of bonds of array");
        }
        
        int[] xy = new int[2];
        xy[0] = (m + 1) % N != 0 ? (m + 1) % N : N;
        xy[1] = (m + 1) % N != 0 ? (m + 1) / N + 1 : (m + 1) / N;
        return xy;
    }

    private boolean coordinateIsValid(int x) {
        return x > 0 && x <= N;
    }

    private boolean xyAreValid(int x, int y) {
        return coordinateIsValid(x) && coordinateIsValid(y);
    }

    private void checkXYValidity(int x, int y) {
        if (!coordinateIsValid(x)) {
            throw new IndexOutOfBoundsException("row index x out of bounds");
        }
        if (!coordinateIsValid(y)) {
            throw new IndexOutOfBoundsException("column index y out of bounds");
        }
    }

    /*
     * For testing of implemented methods
     */
    public static void main(String[] args) {

        Percolation p = new Percolation(5);

        p.open(3, 1);
        System.out.println("isFull: " + p.isFull(2, 1)); // false
        System.out.println("isFull: " + p.isFull(3, 1)); // true
        System.out.println("------------------");
        
        p.open(3, 2);
        System.out.println(p.connected(p.xyTo1D(3, 2), p.xyTo1D(3, 1))); // true
        System.out.println("isFull: " + p.isFull(3, 2)); // true
        System.out.println(p.connected(p.xyTo1D(3, 2), p.xyTo1D(2, 2))); // false
        System.out.println(p.connected(p.xyTo1D(4, 2), p.xyTo1D(3, 1))); // false
        System.out.println("isFull: " + p.isFull(4, 2)); // false
        System.out.println("isFull: " + p.isFull(3, 3)); // false
        System.out.println("isFull: " + p.isFull(5, 5)); // false
        System.out.println("------------------");
        
        p.open(4, 2);
        System.out.println(p.connected(p.xyTo1D(4, 2), p.xyTo1D(3, 1))); // true
        System.out.println("isFull: " + p.isFull(4, 2)); // true
        System.out.println("isFull: " + p.isFull(4, 4)); // false
        System.out.println("isFull: " + p.isFull(1, 5)); // false
        System.out.println("isFull: " + p.isFull(1, 1)); // false
        
//        int[] test = p.xyFrom1D(5);
//        System.out.println("x: " + test[0] + ", y: " + test[1]);
        
        
    }

}
