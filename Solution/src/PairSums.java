import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PairSums {

    static long largestValue(int[] A) {
        // Return the largest value of any of A's nonempty subarrays.
    	for(int i = 0; i < A.length; i++)
    		for(int j = i; j < A.length; j++)
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }*/
    	int[] A = {-3, 7, -2, 3, 5, -2};
        long result = largestValue(A);
        System.out.println(result);
        in.close();
    }
}
