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
	public static List<Integer> pancakeSort(int[] A) {
        int max = A.length;
        int max_ind = A.length - 1;
        List<Integer> res = new ArrayList<>();
        while(max_ind > 0)
        {
            int i = 0;
            while(A[i] != max)
                i++;
            if(i < max_ind)
            {            	
                if (i > 0)
                {
                    res.add(i+1);
                    for(int k = 0; k < (i+1)/2; k++)
                    {
                        int t = A[k];
                        A[k] = A[i-k];
                        A[i-k] = t;
                    }
                }
                res.add(max_ind+1);
                for(int k = 0; k < (max_ind+1)/2; k++)
                {
                    int t = A[k];
                    A[k] = A[max_ind-k];
                    A[max_ind-k] = t;
                }
            }
            max--;
            max_ind--;
        }
        return res;
    }
	
    public static void main(String[] args) 
    {
    	int[] A = {3, 2, 4, 1};
    	List<Integer> res = pancakeSort(A);
    	for(Integer i : res)
    		System.out.print(i + " ");
    }
}
