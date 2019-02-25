import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
	
	public static boolean equationsPossible(String[] equations) {
        int[] unions = new int[26];
        for(int i = 0; i < 26; i++)
        	unions[i] = i;
        for(String str : equations) {
        	if (str.charAt(1) == '=')
        		addUnion(str.charAt(0) - 'a', str.charAt(3) - 'a', unions);
        }
        for(String str : equations) {
        	if (str.charAt(1) == '!')
        		if(find(str.charAt(0) - 'a', unions) == find(str.charAt(3) - 'a', unions))
        			return false;
        }
        return true;
    }
	
	private static int find (int a, int[] unions)
	{
		while (unions[a] != a) {			
			unions[a] = unions[unions[a]];
			a = unions[a];
		}
		return a;
	}
	private static void addUnion(int a, int b, int[] unions)
	{
		if (find(a, unions) == find(b, unions))
			return;
		int bid = unions[b];
		int aid = unions[a];
		for (int i = 0; i < unions.length; i++)
			if (unions[i] == bid)
				unions[i] = aid;
	}
	
	public static void main(final String[] args) {
		String[] A = {"a==b","b!=c","c==a"};
		System.out.println(equationsPossible(A));
	}
}
