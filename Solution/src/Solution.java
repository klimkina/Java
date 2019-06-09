import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;


class Solution {
	public int numTilePossibilities(String tiles) {
        char[] charr = tiles.toCharArray();
        Arrays.sort(charr);
        HashSet<String> used = new HashSet<>(); // strings with already calculated permutations
        return calcPerm(String.valueOf(charr), used);
    }
    private int calcPerm(String s, HashSet<String> used)
    {
        if (s.length() < 1 || used.contains(s))
            return 0; 
        used.add(s);
        if (s.length() == 1)
            return 1;
        int res = perms(s);
        for (int i = 0; i < s.length(); i++)
            if(i == 0 || s.charAt(i) != s.charAt(i-1))//all original substrings of s
                res += calcPerm(s.substring(0, i) + s.substring(i +1, s.length()), used);
        return res;
    }
    private int perms(String s) //number of permutations of a string n!/m1!m2!...mk!
    {
        int res = fac(s.length());
        int len = 1;
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i) == s.charAt(i-1))
                len++;
            else
            {
                res /= fac(len); // divide for repeated characters
                len = 1;
            }
        res /= fac(len);
        return res;
    }
    private int fac(int n)
    {
        int res = 1;
        for (int i = 2; i <=n; i++)
            res *=i;
        return res;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		System.out.println(obj.smallestSubsequence("bdfecedcbfcfeaaffdbaeeabadbbbddddcafdfeeeebfcdabcfaadecddccdefcabedbebbdcbdfefeffcbbeaefaeefeeceadea"));
	}
}
