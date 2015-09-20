package week1pa;

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
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    // number of open sites fractions for each of T experiments
    private double[] fractionsOfOpenSites;

    // Percolation class implements some needed methods for performing UnionFind
    // operations
    private Percolation p;

    // number of experiments
    private final int T;

    // number of elements in the grid's dimensions
    private final int N;

    // sample mean of percolation threshold
    private double mean;

    // sample standard deviation of percolation threshold
    private double stddev;

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

        this.N = N;
        this.T = T;

        fractionsOfOpenSites = new double[T];

        runExperiments();

    }

    /**
     * Method runs T experiments and fills the fractionsOfOpenSites array
     */
    private void runExperiments() {
        for (int i = 0; i < this.T; i++) {

            /*
             * stores fraction of open sites when percolates for current
             * experiment open_sites / sqr(N)
             */
            int count = 0;

            p = new Percolation(N);

            while (!p.percolates()) {
                int row = StdRandom.uniform(1, this.N + 1);
                int column = StdRandom.uniform(1, this.N + 1);
                if (!p.isOpen(row, column)) {
                    p.open(row, column);
                    count++;
                }
            }
            // don't forget that N and count are integers! In order to get
            // correct division we must convert at least one of them into
            // double
            fractionsOfOpenSites[i] = 1.0 * count / (this.N * this.N);
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
        return mean - (1.96 * stddev / (Math.sqrt(this.T)));
    }

    /**
     * Calculates high endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceHi() {
        return mean + (1.96 * stddev / (Math.sqrt(this.T)));
    }

    /**
     * Just a test method for calculation results demonstration
     */
    private void printResult() {
        StdOut.println("mean\t\t\t\t= " + this.mean);
        StdOut.println("stddev\t\t\t\t= " + this.stddev);
        StdOut.println("95% confidence interval\t\t= " + this.confidenceLo
                + ", " + this.confidenceHi);
        StdOut.println();
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            args = new String[2];
            args[0] = "200";
            args[1] = "100";
        }

        PercolationStats ps = new PercolationStats(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]));

        ps.printResult();
    }

}
