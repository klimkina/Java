import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static int Factorial (int n) {
		int res = 1;
		for (int i = 2; i <= n; i++)
			res *= i;
		return res;
    }
	
    public static void main(String[] args) {
        System.out.println(Factorial(6));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}
