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

    private boolean[][] grid = null;
    private final int N;
    int[] opened = null;
    int[] connected = null;
    

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }

        this.N = N;

        grid = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                grid[i][j] = false;
            }
        }

    }

    public void open(int i, int j) {
        if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
        if (j <= 0 || j > N) throw new IndexOutOfBoundsException("row index j out of bounds");

        if (!isOpen(i, j)) {
            grid[i][j] = true;
        }
    }

    public boolean isOpen(int i, int j) {
        if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
        if (j <= 0 || j > N) throw new IndexOutOfBoundsException("row index j out of bounds");
        
        return grid[i][j];
    }

    public boolean isFull(int i, int j) {
        if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
        if (j <= 0 || j > N) throw new IndexOutOfBoundsException("row index j out of bounds");

        return false;

    }

    public boolean percolates() {
        return false;
    }

    private int xyTo1D(int x, int y){
        return N * (y - 1) + x; 
    }
    
    private int[] xyFrom1D(int m){
        int[] coordinates = new int[2];
        coordinates[0] = m % N;
        coordinates[1] = m / N + 1;
        return coordinates;
    }
    
    public static void main(String[] args) {

        Percolation percolation = new Percolation(7);

        int[] test = percolation.xyFrom1D(25);
        System.out.println(test[0] + ", " + test[1]);
        
        System.out.println(percolation.xyTo1D(test[0], test[1]));
        

    }

}
