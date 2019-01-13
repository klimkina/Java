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
	public static int subarraysDivByK(int[] A, int K) {
        
		int count = 0;
        int[] group = new int[K];
        int sum = 0;
        for(int i = 0; i < A.length; i++)
        {
            sum += A[i];
            int rem = sum % K;
            if (rem < 0)
                rem += K;
            group[rem]++;
        }
        for (int i = 0; i < K; i++)
            if (group[i] > 0)
                count += group[i] * (group[i] - 1)/2;
        return count + group[0];
    }
	
    public static void main(String[] args) 
    {
    	int[] A = {4,5,0,-2,-3,1};
    	System.out.print(subarraysDivByK(A, 5));
    }
}
