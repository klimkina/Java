class Solution {
	public boolean isStrobogrammatic(String num) {
        char[] charr = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = charr.length -1; i >= 0; i--)
        	sb.append(rotate(charr[i]));
        return sb.toString().equals(num);
    }
	private String rotate(char ch) {
		switch(ch) {
			case '0' : return "0";
			case '1' : return "1";
			case '6' : return "9";
			case '8' : return "8";
			case '9' : return "6";
			default: return "#";
		}
	}
	    
    public static void main(String[] args) {   			
    	Solution obj = new Solution();
    	System.out.println(obj.isStrobogrammatic("666"));
    	System.out.println(obj.isStrobogrammatic("88"));
    	System.out.println(obj.isStrobogrammatic("69"));
    	System.out.println(obj.isStrobogrammatic("618"));
    	System.out.println(obj.isStrobogrammatic("619"));
    	System.out.println(obj.isStrobogrammatic("225"));
    }
}