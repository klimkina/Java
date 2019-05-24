import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Solution {
	public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] matches = new boolean[n+1][m+1];
        for (int i = 0; i <= n; i++)
            Arrays.fill(matches[i],false);
        char[] charr = s.toCharArray();
        char[] parr = p.toCharArray();
        matches[0][0] = true;
        for (int i = 0; i < m; i++)
            if (parr[i] == '*' && matches[0][i-1])
                matches[0][i+1] = true;
        
        for (int i = 0; i < n; i++ )
            for (int j = 0; j < m; j++)
            {
                if (charr[i] == parr[j] || parr[j] == '.')
                    matches[i+1][j+1] = matches[i][j];
                else if (parr[j] == '*')
                {
                    if (parr[j-1] != charr[i] && parr[j-1] != '.') //empty
                        matches[i+1][j+1] = matches[i+1][j-1];
                    else
                        matches[i+1][j+1] = matches[i][j+1] || matches[i+1][j] || matches[i+1][j-1];
                }
                else
                    matches[i+1][j+1] = false;
            }
        return matches[n][m];
    }
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		System.out.println(obj.isMatch("aaa", "aaaa"));
	}
}
