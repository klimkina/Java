import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;


class Solution {
	public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        String[][] dp = new String[m+1][n+1];
        for(int i = 0; i <= n; i++)
            dp[0][i] = "";
        for(int i = 0; i <= m; i++)
            dp[i][0] = "";
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(str1.charAt(i) == str2.charAt(j))
                    dp[i+1][j+1] = dp[i][j] + (str1.charAt(i));
                else
                    dp[i+1][j+1] = dp[i+1][j].length() > dp[i][j+1].length() ? dp[i+1][j] : dp[i][j+1];
        StringBuilder sb = new StringBuilder();
        int p1 = 0, p2 = 0;
        for(char ch: dp[m][n].toCharArray())
        {
            while(p1 < str1.length() && str1.charAt(p1) != ch)
                sb.append(str1.charAt(p1++));
            while(p2 < str2.length() && str2.charAt(p2) != ch)
                sb.append(str2.charAt(p2++));
            sb.append(ch);
            p1++;
            p2++;
        }
        sb.append(str1.substring(p1));
        sb.append(str2.substring(p2));
        return sb.toString();
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		String str1 = "abac", str2 = "cab";
		int[] values = {0,6,7,5,7}, labels = {2,0,2,0,2};
		int num_wanted = 3, use_limit = 4;
		System.out.println(obj.shortestCommonSupersequence(str1, str2));
		
	}
}
