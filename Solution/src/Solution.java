import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	
	public boolean isAnagram(String str1, String str2) {
		str1 = str1.toLowerCase().replaceAll("\\s+", "");
		str2 = str2.toLowerCase().replaceAll("\\s+", "");
		if(str1.length() != str2.length())
			return false;
		char[] charr1 = str1.toCharArray();
		char[] charr2 = str2.toCharArray();
		Arrays.sort(charr1);
		Arrays.sort(charr2);
		for(int i = 0; i < charr1.length; i++)
			if(charr1[i]!= charr2[i])
				return false;
		return true;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int q = in.nextInt();
        int[][] queries = new int[q][2];
        for(int queries_i = 0; queries_i < q; queries_i++){
            for(int queries_j = 0; queries_j < 2; queries_j++){
                queries[queries_i][queries_j] = in.nextInt();
            }
        }*/
    	String s= "anagram";
    	String s2 = "naga ram";
    	Solution obj =  new Solution();
    	System.out.println(obj.isAnagram(s, s2));;
    }
}
