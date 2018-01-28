
public class WinningLotteryTicket {
	private static int[] ticket_digits;
	private static long[] dp;
	private static int full = 0;
	//(1111111111)2 = (1023)10
	static long winningLotteryTicket(String[] tickets) {
		
        // Complete this function
		long res = 0;
		
		dp = new long[1024];
		
		ticket_digits = new int[tickets.length];
		
		for(int i = 0; i < tickets.length; i++) {
			ticket_digits[i] = stringToBits(tickets[i]);
			dp[ticket_digits[i]]++;
		}
		
		calcRange(0, 1023);
		for(int i = 0; i < tickets.length;i++){
			res += dp[1023 - ticket_digits[i]]; 
		}
		res -= full;
		res /= 2;
		res += full;		
		
		return res;
    }
	private static void calcRange(int l,int r){
		if(l != r) {
			
			int mid = (r + l)/2;
			int len = (r - l + 1)/2;
			calcRange(l, mid);
			calcRange(mid+1, r);
			for(int i = 1; i <= mid; i++){
				dp[i] += dp[i+len];
			}
		}
	}
	
	private static int stringToBits(String s) {
		
		char[] charr = s.toCharArray();
		int res = 0;
		for(int i = 0; i < charr.length; i++) 
			res |= (1 << (charr[i]) - '0');
		if(res == 1023)
			full++;
		return res;		
	}
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] tickets = new String[n];
        for(int tickets_i = 0; tickets_i < n; tickets_i++){
            tickets[tickets_i] = in.next();
        }*/
    	String[] tickets = {"129300455",
    			"5559948277",
    			"012334556", 
    			"56789",
    			"123456879"};
        long result = winningLotteryTicket(tickets);
        System.out.println(result);
        //in.close();
    }

}
