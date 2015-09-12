/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1pa;

/**
 *
 * @author Andrey
 */
public class PercolationStats {

    /**
     * perform T independent experiments on an N-by-N grid
     * @param N
     * @param T 
     */
    public PercolationStats(int N, int T) {
        if (T <= 0 || N <= 0) throw new java.lang.IllegalArgumentException();
        
        
        
    }

    /**
     * sample mean of percolation threshold
     * @return 
     */
    public double mean() {
        return 0;
    }
    
    /**
     * sample standard deviation of percolation threshold
     * @return 
     */
    public double stddev(){
        return 0;
    }

    /**
     * low  endpoint of 95% confidence interval
     * @return 
     */
    public double confidenceLo(){
        return 0;
    }
    
    /**
     * high endpoint of 95% confidence interval
     * @return 
     */
    public double confidenceHi(){
        return 0;
    }
    
    public static void main(String[] args) {
        
    }
    
}
