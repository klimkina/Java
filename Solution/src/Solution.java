import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*A string S of lowercase letters is given. We want to partition this string into as many parts as possible 
 * so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * */
class Solution {
	public List<Integer> partitionLabels(String S) {
		List<Integer> res = new ArrayList<>();
		char[] charr = S.toCharArray();
		
		Set<Character> sets[] = new Set[charr.length];
		for(int i = charr.length - 1; i >= 0; i--) {
			sets[i] = new HashSet<>();
			if(i < charr.length-1)
				sets[i].addAll(sets[i+1]);
			sets[i].add(charr[i]);
		}
		int start = 0;
		int prev = -1;
		Set<Character> curr = new HashSet<>();
		Set<Character> intersection = null;
		while(start < charr.length-1) {
			curr.add(charr[start]); 
			intersection = sets[start+1];
			intersection.retainAll(curr);
			if(intersection.isEmpty()) {
				res.add(start-prev);
				prev = start;
				curr.clear();
			}
			start++;
		}
		res.add(start-prev);
		return res;
    }
    
    public static void main(String[] args) {   	
    	Solution obj = new Solution();
    	List<Integer> res = obj.partitionLabels("ababcbacadefegdehijhklij");
    	for(int i : res)
    		System.out.print(i + " ");
    }
}