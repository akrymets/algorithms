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

        // Return if already open
        if (isOpen(i, j)) {
            return;
        }

        int site = xyTo1D(i, j);

        // Mark this site as open
        openedSites[site] = true;

        // If the site is in the first row it must be also union with the virtual 0-site;
        if (site <= N) {
            qu.union(0, site);
        }

        // If the site is in the last row it must be also union with the virtual N * N + 1 -site;
        if (site <= N * N && site > N * (N - 1) + 1) {
            qu.union(N * N, site);
        }

        int[] neighbors = getNeighbors(i, j);

        for (int k = 0; k < neighbors.length; k++) {
            if (neighbors[k] != -1) {
                int x = xyFrom1D(neighbors[k])[0];
                int y = xyFrom1D(neighbors[k])[1];

            // if a neighbor site is open and is not out bounds we union it with the site
                if (isOpen(x, y)) {
                    qu.union(neighbors[k], site);
                }
            }
        }
    }

    public boolean isOpen(int i, int j) {
        checkXYValidity(i, j);

        return openedSites[xyTo1D(j, j)];
    }

    public boolean isFull(int i, int j) {
        checkXYValidity(i, j);

        return false;

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

        neighbors[0] = xyTo1D(x, y - 1);
        neighbors[1] = xyTo1D(x + 1, y);
        neighbors[2] = xyTo1D(x, y + 1);
        neighbors[3] = xyTo1D(x - 1, y);

        return neighbors;
    }

    private int xyTo1D(int x, int y) {
        return xyAreValid(x, y) ? N * (y - 1) + x : -1;
    }

    private int[] xyFrom1D(int m) {
        int[] xy = new int[2];
        xy[0] = m % N;
        xy[1] = m / N + 1;
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

        Percolation perc = new Percolation(10);

        perc.open(3, 1);
        perc.open(4, 4);
        perc.open(2, 3);
        perc.open(3, 2);
        
        System.out.println(perc.connected(perc.xyTo1D(3, 1), perc.xyTo1D(3, 2)));
        
        perc.open(2, 2);
        
        System.out.println(perc.connected(perc.xyTo1D(2, 3), perc.xyTo1D(2, 2)));
        
        
    }

}
