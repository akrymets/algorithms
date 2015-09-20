package week1pa;

// this is test comment for week1paprod branch

/*
 * @author: Andrii Krymets
 * 18.09.2015
 * The class implements a part of the programming asignment of week1 of
 * the "Algorithms" course on Coursera: variables and methods for percolation
 * simulation
 * 
 * The class doesn't have a main method. It just provides functionality for
 * other classes.
 * 
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 *
 * @author andriikrymets
 */
public class Percolation {

    // number of elements in the grid's dimensions
    private final int N; 
    
    // array for sites opened duringunion operation
    private boolean[] openedSites;
    
    // object for using UnionFind interface methods
    private WeightedQuickUnionUF qu;

    /**
     * Create N-by-N grid, with all sites blocked
     * @param N 
     */
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

    /**
     * If not already opened opens a site (row, column) coordinates
     * than checks whether this site has opened neighboars. If it does the
     * method performs union operation with such neighbor(s)
     * @param row
     * @param column 
     */
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
         * If the site is in the last row it must be also united with the
         * virtual end-site having index N*N+1
         */
        if (site1DIndex >= N * (N - 1) && site1DIndex <= N * N - 1) {
            // the virtual n-site has index N * N + 1 in the array
            qu.union(N * N + 1, site1DIndex);
        }

        int[] neighbors = getNeighbors(row, column);

        for (int k = 0; k < neighbors.length; k++) {
            if (neighbors[k] != -1) { // means this neighbor is out of grid
                int neighborRow = xyFrom1D(neighbors[k])[0];
                int neighborColumn = xyFrom1D(neighbors[k])[1];

                /*
                 * if a neighbor site is open and is not out bounds we union
                 * it with the site we have just opened
                 */
                if (isOpen(neighborRow, neighborColumn)) {
                    qu.union(neighbors[k], site1DIndex);
                }
            }
        }
    }

    /**
     * Is site (row, column) open?
     * @param row
     * @param column
     * @return 
     */
    public boolean isOpen(int row, int column) {
        checkXYValidity(row, column);
        return openedSites[xyTo1D(row, column)];
    }

    public boolean isFull(int row, int column) {
        checkXYValidity(row, column);
        // the virtual 0-site has index N * N in the array
        return qu.connected(xyTo1D(row, column), N * N);

    }

    /*
     * Percolates if virtual top and bottom sites at indexes N*N and
     * N*N+1 are connected
     */
    public boolean percolates() {
        return qu.connected(N * N, N * N + 1);
    }

    /**
     * Checks whether two elements s1 and s2 are connected with each other
     * @param s1
     * @param s2
     * @return 
     */
    private boolean connected(int s1, int s2) {
        return qu.connected(s1, s2);
    }

    /**
     * Finds all neighbors withing the grid of site (row, column)
     * @param row
     * @param column
     * @return 
     */
    private int[] getNeighbors(int row, int column) {
        checkXYValidity(row, column);

        int[] neighbors = new int[4];

        /*
         * If neighbor's coordinates are not valid - the xyTo1D function
         * returns -1
         */
        neighbors[0] = xyTo1D(row - 1, column); // Neighbor on top
        neighbors[1] = xyTo1D(row, column + 1); // Neighbor on right
        neighbors[2] = xyTo1D(row + 1, column); // Neighbor on bottom
        neighbors[3] = xyTo1D(row, column - 1); // Neighbor on left

        return neighbors;
    }

    /**
     * Maps site's coordinates in the grid into 1D array index
     *
     * @param row    row index
     * @param column column index
     * @return Returns mapped site's number in the array or -1 if the
     *         coordinates are not valid
     */
    private int xyTo1D(int row, int column) {
        if (xyAreValid(row, column)) {
            return N * (row - 1) + column - 1;
        } else {
            return -1;
        }
    }

    /**
     * Map site's index in the 1D array into its coordinates in the grid
     *
     * @param m
     * @return Array of two site's coordinates in the grid: xy[0] - x; xy[1] -
     *         y;
     */
    private int[] xyFrom1D(int m) {
        if (m < 0 || m > N * N - 1) {
            throw new IllegalArgumentException("site's id is out of bounds");
        }

        int[] xy = new int[2];
        
        if ((m + 1) % N != 0) {
            xy[0] = (m + 1) / N + 1;
            xy[1] = (m + 1) % N;
        } else {
            xy[0] = (m + 1) / N;
            xy[1] = N;
        }
        return xy;
    }

    /**
     * Checks whether site's coordinate is valid
     * @param coordinate
     * @return 
     */
    private boolean coordinateIsValid(int coordinate) {
        return coordinate > 0 && coordinate <= N;
    }

    /**
     * Checks whether both site's coordinates are valid (the site's inside
     * the grid of N * N)
     * @param row
     * @param column
     * @return 
     */
    private boolean xyAreValid(int row, int column) {
        return coordinateIsValid(row) && coordinateIsValid(column);
    }

    /**
     * Throws IndexOutOfBoundsException exception if site's out of the grid
     * @param row
     * @param column 
     */
    private void checkXYValidity(int row, int column) {
        if (!coordinateIsValid(row)) {
            throw new IndexOutOfBoundsException("row index x out of bounds");
        }
        if (!coordinateIsValid(column)) {
            throw new IndexOutOfBoundsException("column index y out of bounds");
        }
    }

}
