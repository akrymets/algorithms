/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1pa;

import edu.princeton.cs.algs4.*;

/**
 *
 * @author andriikrymets
 */
public class Percolation {

    boolean[][] grid = null;

    public Percolation(int N) {
        grid = new boolean[N][N];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = false;
            }
        }
    }

    public void open(int i, int j) {
        if (!isOpen(i, j)) {
            grid[i][j] = true;
        }
    }

    public boolean isOpen(int i, int j) {
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length) ? grid[i][j] : false;
    }

    public boolean isFull(int i, int j) {
        boolean topIsOpen = (i - 1 >= 0 && j >= 0 && j < grid[i].length) ? grid[i - 1][j] : false;
        boolean rightIsOpen = (i >= 0 && i < grid.length && j - 1 >= 0) ? grid[i][j - 1] : false;
        boolean bottomIsOpen = (i + 1 < grid.length && j >= 0 && j < grid[i].length) ? grid[i + 1][j] : false;
        boolean leftIsOpen = (i >= 0 && i < grid.length && j + 1 < grid[i].length) ? grid[i][j + 1] : false;
        return topIsOpen && rightIsOpen && bottomIsOpen && leftIsOpen;
    }

    public boolean percolates() {
        return false;
    }

    public static void main(String[] args) {

        Percolation perc = new Percolation(10);

        perc.open(0, 5);
        perc.open(1, 5);
        perc.open(0, 4);
        perc.open(0, 6);

        System.out.println(perc.isFull(0, 5));

    }

}
