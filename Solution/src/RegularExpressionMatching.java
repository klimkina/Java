public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }
        boolean[][] state = new boolean[s.length() + 1][p.length() + 1];
        state[0][0] = true;
        // no need to initialize state[i][0] as false
        // initialize state[0][j]
        for (int j = 1; j < state[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                if (state[0][j - 1] || (j > 1 && state[0][j - 2])) {
                    state[0][j] = true;
                }
            } 
        }
        for (int i = 1; i < state.length; i++) {
        	state[i][0] = p.charAt(0) == s.charAt(i-1);
        }
        for (int i = 1; i < state.length; i++) {
            for (int j = 1; j < state[0].length; j++) 
            {
                if (s.charAt(i - 1) == p.charAt(j - 1) ) 
                    state[i][j] = state[i - 1][j - 1];
                
                else if (p.charAt(j - 1) == '*') 
                    state[i][j] = state[i][j -1] || state[i-1][j];// a* counts as empty
                else if (s.charAt(i - 1) < '0' && s.charAt(i - 1) > '9') 
                    state[i][j] = state[i][j -1];  
            }
        }
        return state[s.length()][p.length()];
    }
    public static void main(String[] args) {
    	RegularExpressionMatching obj = new RegularExpressionMatching();
    	String s = "abcmq6g";
    	String p = "mq*g*";
    	System.out.println(obj.isMatch(s, p));
    	
    }

}
