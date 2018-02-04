import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CloudyDay {
	private static class Town implements Comparable<Town> {
		long pos;
		long pop;
		boolean isSunny = true;
		public Town(long pos, long pop) {
			this.pos = pos;
			this.pop = pop;
		}
		@Override 
		public int compareTo(Town that) {
			return Long.compare(this.pos, that.pos);
		}
	}

    static long maximumPeople(long[] p, long[] x, long[] y, long[] r) {
        // Return the maximum number of people that will be in a sunny town after removing exactly one cloud.
    	TreeSet<Town> towns = new TreeSet<>();
    	for(int i = 0; i < p.length; i++)
    		towns.add(new Town(p[i], x[i]));
    	
    	Arrays.sort(y);
    	long[] clouds = new long[y.length];
    	long prev_cloud = 0;
    	for(int i = 0; i < y.length; i++) {
    		long le = Math.max(y[i] - r[i], prev_cloud);
    		long re = y[i] + r[i];
    		for()
    		prev_cloud = Math.max(prev_cloud, re);
    	}
    	return 0;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] p = new long[n];
        for(int p_i = 0; p_i < n; p_i++){
            p[p_i] = in.nextLong();
        }
        long[] x = new long[n];
        for(int x_i = 0; x_i < n; x_i++){
            x[x_i] = in.nextLong();
        }
        int m = in.nextInt();
        long[] y = new long[m];
        for(int y_i = 0; y_i < m; y_i++){
            y[y_i] = in.nextLong();
        }
        long[] r = new long[m];
        for(int r_i = 0; r_i < m; r_i++){
            r[r_i] = in.nextLong();
        }
        long result = maximumPeople(p, x, y, r);
        System.out.println(result);
        in.close();*/
    	long[] p = {10, 100};
    	long[] x = {5, 100};
    	long[] y = {4};
    	long[] r = {1};
    	long result = maximumPeople(p, x, y, r);
        System.out.println(result);
    }
}
