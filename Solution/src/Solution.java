import java.util.Arrays;

class Solution {
	public int nextLarger(int num){
		String s = "" + num;
		char[] charr = s.toCharArray();
		for(int i = charr.length-1; i > 0; i--) {
			if(charr[i-1] < charr[i]) {
				return Integer.parseInt(helper(charr, i-1));
			}
		}
		return -1;
	}
	
	private String helper(char[] charr, int start) {
		int next_larger_id =start+1;
		for(int i = start+2; i < charr.length - 1; i++)
			if(charr[i] > charr[start] && charr[i] < charr[next_larger_id])
				next_larger_id = i;
		char temp = charr[start];
		charr[start] = charr[next_larger_id];
		charr[next_larger_id] = temp;
		Arrays.sort(charr, start+1, charr.length-1);
		return String.valueOf(charr);
	}
    
    public static void main(String[] args) {   	
    	Solution obj = new Solution();
    	System.out.print(obj.nextLarger(8142));
    }
}