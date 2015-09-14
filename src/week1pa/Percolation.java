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

        qu = new WeightedQuickUnionUF(N * N + 2);

    }

    public void open(int row, int column) {
        checkXYValidity(row, column);

        // Finishes if already open
        if (isOpen(row, column)) {
            return;
        }

        int site1DIndex = xyTo1D(row, column);

        // Mark this site as open
        openedSites[site1DIndex] = true;
     
        /*
         * If the site is in the first row it must be also united with the
         * virtual 0-site having index N * N
         */
        if (site1DIndex <= N - 1) {
            qu.union(N * N, site1DIndex);
        }
        
        /*
         * If the site is in the last row it must be also united with
         * the virtual end-site having index N*N+1
         */
        if (site1DIndex >= N * (N - 1) && site1DIndex <= N * N - 1) {
            qu.union(N * N + 1, site1DIndex); // the virtual n-site has index N * N + 1 in the array
        }

        int[] neighbors = getNeighbors(row, column);

        for (int k = 0; k < neighbors.length; k++) {
            if (neighbors[k] != -1) { // means this neighbor is out of grid
                int neighborRow = xyFrom1D(neighbors[k])[0];
                int neighborColumn = xyFrom1D(neighbors[k])[1];

            // if a neighbor site is open and is not out bounds we union it with the site we have just opened
                if (isOpen(neighborRow, neighborColumn)) {
                    qu.union(neighbors[k], site1DIndex);
                }
            }
        }
    }

    public boolean isOpen(int row, int column) {
        checkXYValidity(row, column);
        return openedSites[xyTo1D(row, column)];
    }

    public boolean isFull(int row, int column) {
        checkXYValidity(row, column);
        return qu.connected(xyTo1D(row, column), N * N); // the virtual 0-site has index N * N in the array

    }

    public boolean percolates() {
        return false;
    }

    private boolean connected(int s1, int s2) {
        return qu.connected(s1, s2);
    }

    private int[] getNeighbors(int row, int column) {
        checkXYValidity(row, column);

        int[] neighbors = new int[4];

        // If neighbor's coordinates are not valid - the xyTo1D function returns -1
        neighbors[0] = xyTo1D(row - 1, column); // Neighbor on top
        neighbors[1] = xyTo1D(row, column + 1); // Neighbor on right
        neighbors[2] = xyTo1D(row + 1, column); // Neighbor on bottom
        neighbors[3] = xyTo1D(row, column - 1); // Neighbor on left

        return neighbors;
    }

    /**
     * Map site's coordinates in the grid into the its array index.
     * @param row row index
     * @param column column index
     * @return Returns mapped site's number in the array or -1 if the coordinates are not valid
     */
    private int xyTo1D(int row, int column) {
        return xyAreValid(row, column) ? N * (row - 1) + column - 1 : -1;
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
        xy[0] = (m + 1) % N != 0 ? (m + 1) / N + 1 : (m + 1) / N;
        xy[1] = (m + 1) % N != 0 ? (m + 1) % N : N;
        return xy;
    }

    private boolean coordinateIsValid(int axis) {
        return axis > 0 && axis <= N;
    }

    private boolean xyAreValid(int row, int column) {
        return coordinateIsValid(row) && coordinateIsValid(column);
    }

    private void checkXYValidity(int row, int column) {
        if (!coordinateIsValid(row)) {
            throw new IndexOutOfBoundsException("row index x out of bounds");
        }
        if (!coordinateIsValid(column)) {
            throw new IndexOutOfBoundsException("column index y out of bounds");
        }
    }

    /*
     * For testing of implemented methods
     */
    public static void main(String[] args) {

        Percolation p = new Percolation(20);

        p.open(7, 11);
        p.open(18, 11);
        p.open(12, 5);
        p.open(9, 5);
        p.open(5, 9);
        p.open(1, 1);
        p.open(12, 1);
        p.open(5, 4);
        p.open(16, 19);
        
        
        
    }

}
