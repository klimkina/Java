class Solution {
	public boolean isPalindrome(int x) {
		if(x < 0)
			return false;
		if(x == 0)
			return true;
		int l_mask = 1 << 31;
		int r_mask = 1;
		while((x & l_mask) == 0){ //most significant left bit
		    l_mask >>>= 1; 
		}
		while((x & r_mask) == 0){ //most significant right bit
		    r_mask <<= 1;
		}
		while(l_mask >= r_mask){
		    if((x & l_mask) != 0 && (x & r_mask) == 0
		    		|| (x & l_mask) == 0 && (x & r_mask) != 0)
		    	return false;		    	
		    r_mask <<= 1;
		    l_mask >>>= 1;
		}
        return true;
    }
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	int k = 10;
    	System.out.println(obj.isPalindrome(k));
    	
    }
}