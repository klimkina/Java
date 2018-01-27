
public class WinningLotteryTicket {
	private static int full = 0;// tickets with all digits
	private static int[] digits;
	private static int[][] ticket_digits;
	static int winningLotteryTicket(String[] tickets) {
		
        // Complete this function
		digits = new int[10];
		ticket_digits = new int[10][];
		for(int i = 0; i < 10; i++)
			ticket_digits[i] = new int[tickets.length];
		
		stringsToBits(tickets);
		
		int mask = (~0)>>> 22;
		//combine tickets with rare digit with other tickets
		/*for(int i = 0; i < zero_pos; i++)
			for(int j = 0; j < nozero_pos; j++)
				if((zero[i]|nozero[j]) == mask)
					res++;
		// combine zero and zero
		for(int i = 0; i < zero_pos; i++)
			for(int j = 0; j < zero_pos; j++)
				if((zero[i]|zero[j]) == mask)
					res++;
		//any full we can combine with any other ticket
		//so we get full * (tickets.length-1) additional
		return res + full * (tickets.length - 1);
    }
	private static void stringsToBits(String[] s) {
		
		for(String str:s) {
			char[] charr = str.toCharArray();
			int res = 0;
			for(int i = 0; i < charr.length; i++)
				res |= (1 << (charr[i]) - '0');
			if(res == 1023)
				full++;
			else {
				for(int i = 0; i < 10; i++)
					if((res & (1<<i)) == 0) {
						nozero[i][nozero_pos[i++]] = res;
						break;
					}
				
			}
		}*/
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
        int result = winningLotteryTicket(tickets);
        System.out.println(result);
        //in.close();
    }

}
