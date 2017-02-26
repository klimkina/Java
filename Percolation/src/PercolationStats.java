/******************************************************************************
 *  Compilation:  javac PercolationStats.java
 *  Execution:    java PercolationStats N T (grid size and number of trials)
 *  Dependencies: Percolation.java 
 *
 *  Liudmila Klimkina 11/6/2016
 *
 ******************************************************************************/
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    private int trials;
    private double[] x;
    private double mean;
    private double stddev;
    
    public PercolationStats(int n, int t)    // perform trials independent experiments on an n-by-n grid
    {
        if (t <= 0 || n <= 0)
            throw new java.lang.IllegalArgumentException();
        trials = t;
        x = new double[trials];
        
        for (int i = 0; i < trials; i++)
        {
            Percolation perc = new Percolation(n);
            int opened = 0;
            while (!perc.percolates())
            {
                int p = StdRandom.uniform(n) + 1;
                int q = StdRandom.uniform(n) + 1;
                if (!perc.isOpen(p, q)) {
                    perc.open(p, q);
                    opened++;
                }                
            }  
            x[i] = (double) opened/(n * n);
        }         
        calcMean();        
        calcStddev();       
    }
    
    private void calcMean()
    {
        mean = 0;
        for (int i = 0; i < trials; i++)
            mean += x[i];
        mean = mean/trials;
    }
    
    private void calcStddev()
    {
        stddev = 0;
        for (int i = 0; i < trials; i++)
            stddev += (x[i] - mean) * (x[i] - mean);
        if (trials > 1) 
            stddev = Math.sqrt(stddev/(trials-1));
    }
    
    public double mean()                          // sample mean of percolation threshold
    {
       return mean;
    }
       
    public double stddev()                        // sample standard deviation of percolation threshold
    {       
       return stddev;
    }
       
    public double confidenceLo()                  // low  endpoint of 95% confidence interval
    {
       return mean - (1.96 * stddev / Math.sqrt(trials));
    }
       
    public double confidenceHi()   
    {
       return mean + (1.96 * stddev / Math.sqrt(trials));
    }
       
    public static void main(String[] args) {
            // TODO Auto-generated method stub
            System.out.println("Enter grid size!");
            int n = StdIn.readInt();
            System.out.println("Enter number of trials!");
            int t = StdIn.readInt();
            
            Stopwatch timer = new Stopwatch(); 
            PercolationStats stat = new PercolationStats(n, t);
            double statTime = timer.elapsedTime();
            
            StdOut.println("mean                    = " + stat.mean());
            StdOut.println("stddev                  = " + stat.stddev());
            StdOut.println("95% confidence interval = " + stat.confidenceLo() + ", " + stat.confidenceHi());
            StdOut.println("Elapsed time            = " + statTime);
        }

}
