import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AnimalTransport {
	private static TreeMap<Integer, Integer> Emap = new TreeMap<>();
	private static TreeMap<Integer, Integer> Dmap = new TreeMap<>();
	private static TreeMap<Integer, Integer> Cmap = new TreeMap<>();
	private static TreeMap<Integer, Integer> Mmap = new TreeMap<>();
    static int[] minimumZooNumbers(int m, int n, char[] t, int[] s, int[] d) {
        // Return a list of length n consisting of the answers
    	int[] res = new int[n];
    	for(int i = 0; i < n; i++) {
    		switch(t[i]) {
    		case 'E': Emap.put(s[i], d[i]);
    			break;
    		case 'C': Cmap.put(s[i], d[i]);
    			break;
    		case 'D': Dmap.put(s[i], d[i]);
				break;
    		case 'M': Mmap.put(s[i], d[i]);
				break;
    		}
    	}
    	for(int i = 0; i < n; i++)
    		res[i] = findMinimum(m, i);
    	return res;
    }
    static int findMinimum(int m, int count) {
    	return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for(int a0 = 0; a0 < cases; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            char[] t = new char[n];
            for(int t_i = 0; t_i < n; t_i++){
                t[t_i] = in.next().charAt(0);
            }
            int[] s = new int[n];
            for(int s_i = 0; s_i < n; s_i++){
                s[s_i] = in.nextInt();
            }
            int[] d = new int[n];
            for(int d_i = 0; d_i < n; d_i++){
                d[d_i] = in.nextInt();
            }
            int[] result = minimumZooNumbers(m, n, t, s, d);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}