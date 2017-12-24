import java.util.Stack;

class Solution {
	private static class MatchState {
		int sStart;
		int pStart;
		public MatchState(int s, int p) {
			sStart = s;
			pStart = p;
		}
	}
	public boolean isMatch(String s, String p) {
		Stack<MatchState> stack = new Stack<>();
		MatchState curr = null;
		stack.add(new MatchState(0,0));
		while(!stack.isEmpty()) {
			curr = stack.pop();
			if(curr.sStart >= s.length())
				if(curr.pStart >= p.length() || p.charAt(curr.pStart) == '*')
					return true;
			
			if(curr.sStart >= s.length() || curr.pStart >= p.length())
				continue;
			char currS = s.charAt(curr.sStart);
			char currP = p.charAt(curr.pStart);
			if (curr.pStart < p.length()-1 && p.charAt(curr.pStart+1) == '*') // check if next pattern is *
				stack.push(new MatchState(curr.sStart, curr.pStart+1)); //skip pattern
			
			if(currP == '.') // skip both
				stack.push(new MatchState(curr.sStart+1, curr.pStart+1));
			else if (currP != '*') {
				if(currS == currP) // skip both
					stack.push(new MatchState(curr.sStart+1, curr.pStart+1));
				
			} else { // * in pattern
				currP = p.charAt(curr.pStart-1);
				if(currP == '.' || currS == currP) 
					stack.push(new MatchState(curr.sStart+1, curr.pStart));
				stack.push(new MatchState(curr.sStart, curr.pStart+1));
			}
		}
        return false;
    }
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	String s = "aa";
    	String p = ".*";
    	System.out.println(obj.isMatch(s, p));
    	
    }
}