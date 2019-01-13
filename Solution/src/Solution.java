import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {
	public static int largestPerimeter(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        if (n < 3)
            return 0;
        int a = A[n-1];
        int b = A[n-2];
        int c = A[n-3];
        if (check(a,b,c))
            return (a+b+c);
        int curr = n-4;
        while (curr >= 0)
        {
            int d = A[curr];
            int res = 0;
            if (check(a,b,d))
                res = a+b+d;
            if (check(a,d,c) && a+d+c > res)
                res = a+d+c;
            if (check(d,b,c) && b+d+c > res)
                res = b+d+c;
            curr--;
            a = b; b = c; c = d;
        }
        return 0;
    }
    private static boolean check(int a, int b, int c) {
        return (a < b + c) && (b < a + c) && (c < a + b);
    }
	
    public static void main(String[] args) 
    {
    	int[] A = {3, 6,2,3};
    	System.out.print(largestPerimeter(A));
    }
}
