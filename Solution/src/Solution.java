import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static int Fibb (int n) {
		if(n < 3)
			return 1;
		int[] res = new int[2];
		res[0] = 1; res[1] = 1;
		int next = 0;
		System.out.print("1 1 ");
		for (int i = 3; i <= n; i++)
		{
			
			next = res[0] + res[1];
			System.out.print(next + " ");
			res[0] = res[1];
			res[1] = next;
		}
		return next;
    }
	
    public static void main(String[] args) {
        System.out.println(Fibb(8));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}
