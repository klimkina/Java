import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	private boolean isVowel(char ch)
	{
		String vowels = "aeiou";
		char low = Character.toLowerCase(ch);
		return (vowels.indexOf(low) >= 0);
	}
	public String toGoatLatin(String S)
	{
		StringBuilder sb = new StringBuilder();
		String[] words = S.split("\\s+");
		StringBuilder ending = new StringBuilder();
		for (int i = 0; i < words.length; i++)
		{
			if(sb.length() > 0)
				sb.append(' ');	
			String word = words[i];
			char first = word.charAt(0);
			if(isVowel(first))
				sb.append(word);
			else
				sb.append(word.substring(1) + first);
			sb.append("ma");
			ending.append("a");
			sb.append(ending);
						
		}
		return sb.toString();
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
    	String s1 = "I speak Goat Latin";
    	String s2 = "The quick brown fox jumped over the lazy dog";
    	Solution obj =  new Solution();
    	System.out.println(obj.toGoatLatin(s1));
    	System.out.println(obj.toGoatLatin(s2));
        //in.close();
    }
}
