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
    
    public void open(int i, int j){
        grid[i][j] = true;
    }
    
    public boolean isOpen(int i, int j){
        return grid[i][j] && i >=0 && i < grid.length && j >=0 && j < grid.length;
    }
    
    public boolean isFull(int i, int j){
        boolean onTop = ;
        boolean onRight;
        boolean onBottom;
        boolean onLeft;
    }
    

}
