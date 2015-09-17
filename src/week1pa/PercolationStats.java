/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1pa;

import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 *
 * @author Andrey
 */
public class PercolationStats {

    private double[] fractionsOfOpenSites;
    QuickFindUF qf;
    Percolation p;
    private static int T;
    private static int N;
    private double mean = 0.0;
    private double stddev = 0.0;
    private double confidenceLo;
    private double confidenceHi;

    /**
     * perform T independent experiments on an N-by-N grid
     *
     * @param N
     * @param T
     */
    public PercolationStats(int N, int T) {
        if (T <= 0 || N <= 0) {
            throw new java.lang.IllegalArgumentException();
        }

        PercolationStats.N = N;
        PercolationStats.T = T;

        fractionsOfOpenSites = new double[T];

        for (double fraction : fractionsOfOpenSites) {
            fraction = 0.0;
        }

        /*
         * !!! Run T experiments !!!
         */
        runExperiments();

        this.mean = mean();
        this.stddev = stddev();
        this.confidenceLo = confidenceLo();
        this.confidenceHi = confidenceHi();

    }

    private void runExperiments() {
        for (int i = 0; i < PercolationStats.T; i++) {

            int count = 0; // stores fraction of open sites when percolates for current experiment

            p = new Percolation(N);

            while (!p.percolates()) {
                int row = StdRandom.uniform(1, PercolationStats.N + 1);
                int column = StdRandom.uniform(1, PercolationStats.N + 1);
                if (!p.isOpen(row, column)) {
                    p.open(row, column);
                    count++;
                }
            }
            fractionsOfOpenSites[i] = count / Math.pow(PercolationStats.N, 2);
        }
    }

    /**
     * sample mean of percolation threshold
     *
     * @return
     */
    public double mean() {
        return StdStats.mean(fractionsOfOpenSites);
    }

    /**
     * sample standard deviation of percolation threshold
     *
     * @return
     */
    public double stddev() {
        return StdStats.stddev(fractionsOfOpenSites);
    }

    /**
     * low endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceLo() {
        return this.mean - (1.96 * this.stddev / (Math.sqrt(PercolationStats.T)));
    }

    /**
     * high endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceHi() {
        return mean + (1.96 * stddev / (Math.sqrt(PercolationStats.T)));
    }

    private void printResult() {
        System.out.println("mean\t\t\t\t= " + this.mean);
        System.out.println("stddev\t\t\t\t= " + this.stddev);
        System.out.println("95% confidence interval\t\t= " + this.confidenceLo + ", " + this.confidenceHi);
        System.out.println();
    }

    public static void main(String[] args) {

        PercolationStats ps = new PercolationStats(200, 100);
        ps.printResult();
        
        ps = new PercolationStats(2, 10000);
        ps.printResult();
        
        ps = new PercolationStats(2, 100000);
        ps.printResult();
        

    }

}
