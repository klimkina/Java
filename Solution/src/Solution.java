class Solution {
	public int[] getModifiedArray(int length, int[][] updates) {

	    int[] res = new int[length];
	     for(int[] update : updates) {
	        int value = update[2];
	        int start = update[0];
	        int end = update[1];
	        
	        res[start] += value;
	        
	        if(end < length - 1)
	            res[end + 1] -= value;
	        
	    }
	    
	    int sum = 0;
	    for(int i = 0; i < length; i++) {
	        sum += res[i];
	        res[i] = sum;
	    }
	    
	    return res;
	}
	
	    
    public static void main(String[] args) {
    	int length = 5;
    	int[][]  updates = {
    		        {1,  3,  2},
    		        {2,  4,  3},
    		        {0,  2, -2}
    		        };
    			
    	Solution obj = new Solution();
    	int[] res = obj.getModifiedArray(length, updates);
    	for(int i: res)
    		System.out.print(i + ", ");
    }
}