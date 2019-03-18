import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
class Solution {
	
	public static int visuallyBalancedSections(List<Integer> colors) {
	    // Write your code here
	        long[] cols = new long[colors.size()];
	        for (int i = 0; i < cols.length; i++)
	            cols[i] = 1L << colors.get(i);
	        long res = 1L;
	        //res += cols.length;
	        long[] prefix = new long[cols.length];
	        prefix[0] = cols[0];
	        for (int i = 1; i < cols.length; i++)
	        {
	            prefix[i] = prefix[i-1] ^ cols[i];
	            if (isBalanced(prefix[i]))
	            	res++;
	        }
	        
	        for (int i = 0; i < cols.length - 1; i++)
	        	for (int j = i+1; j < cols.length; j++)
	        		if (isBalanced(prefix[i]^prefix[j]))
		            	res++;
	        return (int)res;
	    }

	private static boolean isBalanced(long l)
	{
		for (long c = 1L; c <= (1L << 50); c = c << 1)
        {
            if ((l ^ c) == 0L)
                return true;
        }
		return (l == 0L);
	}
	
	public static void main(final String[] args) {
		Integer[] M = {1,4,1,2};
		System.out.print(visuallyBalancedSections(Arrays.asList(M)));
	}
}
