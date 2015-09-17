/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1pa;

import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author Andrey
 */
public class PercolationStats {

    private double[] tresholds;
    QuickFindUF qf;
    Percolation p;
    private final int T;
    private final int N;
    private double mean;
    private double stddev;
    
    
    /**
     * perform T independent experiments on an N-by-N grid
     * @param N
     * @param T 
     */
    public PercolationStats(int N, int T) {
        if (T <= 0 || N <= 0) throw new java.lang.IllegalArgumentException();
        
        this.T = T;
        this.N = N;
        
        qf = new QuickFindUF(N);
        
        tresholds = new double[T];
        
        for (double treshold : tresholds) {
            treshold = 0.0;
        }
        
    }

    /**
     * Returns percolation treshold for a single test
     * @return 
     */
    private double treshold(){
        p = new Percolation(N);
        
        int openedSitesUntilPercolates = 0;
        while (!p.percolates()){
            openedSitesUntilPercolates++;
            p.open(StdRandom.uniform(1, N + 1), StdRandom.uniform(1, N + 1));
        }
        return 1.0 * openedSitesUntilPercolates / (N * N);
    }
    
    /**
     * run T tests and fill the tresholds[] array with tresholds for each tests
     */
    private void runTests(){
        for (int i = 0; i < T; i++) {
            tresholds[i] = treshold();
        }
    }
    
    /**
     * sample mean of percolation threshold
     * @return 
     */
    public double mean() {
        mean = StdStats.mean(tresholds);
        return mean;
    }
    
    /**
     * sample standard deviation of percolation threshold
     * @return 
     */
    public double stddev(){
        stddev = StdStats.stddev(tresholds);
        return stddev;
    }

    /**
     * low  endpoint of 95% confidence interval
     * @return 
     */
    public double confidenceLo(){
        return mean - (1.96 * stddev / (Math.sqrt(T)));
    }
    
    /**
     * high endpoint of 95% confidence interval
     * @return 
     */
    public double confidenceHi(){
        return mean + (1.96 * stddev / (Math.sqrt(T)));
    }
    
    private void showTestsResults(){
        double ciLo = confidenceLo();
        double ciHi = confidenceHi();
        double mean = mean();
        double stddev = stddev();
        
        System.out.println(mean);
        System.out.println(stddev);
        System.out.println(ciLo);
        System.out.println(ciHi);
    }
    
    public static void main(String[] args) {
        
        PercolationStats ps = new PercolationStats(100, 30);
        
        ps.showTestsResults();
    }
    
}
