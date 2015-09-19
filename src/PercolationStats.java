/*
 * @author: Andrii Krymets
 * 18.09.2015
 * The class implements a part of the programming asignment of week1 of
 * the "Algorithms" course on Coursera: getting statistics of percolation
 * simulations for different input parameters
 * 
 * To run the program you have to input the following parameters:
 * N - number of elements in the grid's dimensions
 * T - number of tests
 * 
 * Example:
 * java -cp /build/classes;lib/algs4.jar week1pa.PercolationStats 100 200
 */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    // number of open sites fractions for each of T experiments
    private double[] fractionsOfOpenSites;

    /*
     * Percolation class implements some needed methods for performing UnionFind
     * operations
     */
    private Percolation p;

    // number of experiments
    private int t;

    // number of elements in the grid's dimensions
    private int n;

    // sample mean of percolation threshold
    private double mean = 0.0;

    // sample standard deviation of percolation threshold
    private double stddev = 0.0;

    // low  endpoint of 95% confidence interval
    private double confidenceLo;

    // high endpoint of 95% confidence interval
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

        this.n = N;
        this.t = T;

        fractionsOfOpenSites = new double[T];

        runExperiments();

    }

    /**
     * Method runs T experiments and fills the fractionsOfOpenSites array
     */
    private void runExperiments() {
        for (int i = 0; i < this.t; i++) {

            /*
             * stores fraction of open sites when percolates for current
             * experiment open_sites / sqr(N)
             */
            int count = 0;

            p = new Percolation(n);

            while (!p.percolates()) {
                int row = StdRandom.uniform(1, this.n + 1);
                int column = StdRandom.uniform(1, this.n + 1);
                if (!p.isOpen(row, column)) {
                    p.open(row, column);
                    count++;
                }
            }
            fractionsOfOpenSites[i] = count / (this.n * this.n);
        }

        this.mean = mean();
        this.stddev = stddev();
        this.confidenceLo = confidenceLo();
        this.confidenceHi = confidenceHi();
    }

    /**
     * Calculates sample mean of percolation threshold
     *
     * @return
     */
    public double mean() {
        return StdStats.mean(fractionsOfOpenSites);
    }

    /**
     * Calculates sample standard deviation of percolation threshold
     *
     * @return
     */
    public double stddev() {
        return StdStats.stddev(fractionsOfOpenSites);
    }

    /**
     * Calculates low endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceLo() {
        return mean - (1.96 * stddev / (Math.sqrt(this.t)));
    }

    /**
     * Calculates high endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceHi() {
        return mean + (1.96 * stddev / (Math.sqrt(this.t)));
    }

    /**
     * Just a test method for calculation results demonstration
     */
    private void printResult() {
        System.out.println("mean\t\t\t\t= " + this.mean);
        System.out.println("stddev\t\t\t\t= " + this.stddev);
        System.out.println("95% confidence interval\t\t= " + this.confidenceLo
                + ", " + this.confidenceHi);
        System.out.println();
    }

    public static void main(String[] args) {

        PercolationStats ps = new PercolationStats(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]));

        ps.printResult();

    }

}
