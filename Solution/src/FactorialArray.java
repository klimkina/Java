import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FactorialArray {
	private static TreeMap<Integer, Long> facMap = new TreeMap<>();
	
	private static long factorial(int a) {
		if(facMap.containsKey(a))
			return facMap.get(a);
		long res = 1;
		Integer l = facMap.lowerKey(a);
		if(l == null)
			l = 1;
		else
			res = facMap.get(l);
		for(int i = l+1; i <= a; i++)
			res *= i;
		facMap.put(a, res);
		
		return res;
	}
	private static void increase(int l, int r, int[] A) {
		for(int i = l-1; i < r; i++)
			A[i]++;
	}
	private static long sum(int l, int r, int[] A) {
		long res = 0;
		for(int i = l-1; i < r; i++)
			res += factorial(A[i]);
		return res % 1000000000;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] A = new int[n];
        
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < m; a0++){
            // Write Your Code Here
        	int cmd = in.nextInt();
        	switch (cmd) {
        		case 1: increase(in.nextInt(), in.nextInt(), A);
        			break;
        		case 2: System.out.println(sum(in.nextInt(), in.nextInt(), A));
        			break;
        		case 3: A[in.nextInt()-1] = in.nextInt();
        			break;
        		default: System.out.println("Invalid input");
                	break;
        	}
        }
        in.close();
    }
}