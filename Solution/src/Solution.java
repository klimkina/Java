class Solution {
	
	public int lengthLongestPath(String input) {
		
		input = input.replace("\\n", "\n");
		input = input.replace("\\t", "\t");
		String[] paths = input.split("\\n");
	    int[] stack = new int[paths.length+1];
	    int maxLen = 0;
	    for(String s:paths){
	        int lev = s.lastIndexOf("\t")+1;
	        stack[lev+1] = stack[lev]+s.length()-(lev)+1; // remove "\\t", add"\"
	        if(s.contains(".")) 
	        	maxLen = Math.max(maxLen, stack[lev+1]-1);
	    }
	    return maxLen;
   }

    public static void main(String[] args) {
    	String file_sys = "dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext";
    	Solution obj = new Solution();
    	
    	System.out.print(obj.lengthLongestPath(file_sys));
        
    }
}