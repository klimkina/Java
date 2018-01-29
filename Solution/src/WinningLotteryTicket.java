/*
The SuperBowl Lottery is about to commence, and there are several lottery tickets being sold, and each ticket is identified with a ticket ID. In one of the many winning scenarios in the Superbowl lottery, a winning pair of tickets is:

Concatenation of the two ticket IDs in the pair, in any order, contains each digit from  to  at least once.
For example, if there are  distinct tickets with ticket ID  and ,  is a winning pair.

NOTE: The ticket IDs can be concantenated in any order. Digits in the ticket ID can occur in any order.

Your task is to find the number of winning pairs of distinct tickets, such that concatenation of their ticket IDs (in any order) makes for a winning scenario. Complete the function winningLotteryTicket which takes a string array of ticket IDs as input, and return the number of winning pairs.
*/	
		
public class WinningLotteryTicket {
	
	//(1111111111)2 = (1023)10
	static long winningLotteryTicket(String[] tickets) {
		
        // Complete this function
		long res = 0;
		
		long[] dp = new long[1024];
		
		for(int i = 0; i < tickets.length; i++) 
			dp[stringToBits(tickets[i])]++;
		
		for(int i = 0; i < 1024; i++){
			for(int j = i+1; j < 1024; j++) 
				if((i|j) == 1023) {
					res += dp[i]* dp[j];	
			}
		}
		res += dp[1023]*(dp[1023]-1)/2;
		return res;
    }
	
	private static int stringToBits(String s) {
		
		char[] charr = s.toCharArray();
		int res = 0;
		for(int i = 0; i < charr.length; i++) 
			res |= (1 << (charr[i]) - '0');
		
		return res;		
	}
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] tickets = new String[n];
        for(int tickets_i = 0; tickets_i < n; tickets_i++){
            tickets[tickets_i] = in.next();
        }*/
    	String[] tickets = {"0123456789",
    			"1023456789",
    			"1023456789",
    			"129300455",
    			"12930045",
    			"129304550",
    			"5559948277",
    			"012334556",
    			"56789",
    			"5678955",
    			"0123456879"};
        long result = winningLotteryTicket(tickets);
        System.out.println(result);
        //in.close();
    }

}
