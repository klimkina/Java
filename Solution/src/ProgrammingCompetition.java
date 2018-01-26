import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ProgrammingCompetition {

	static int winningLotteryTicket(String[] tickets) {
		
        // Complete this function
		int res = 0;
		int[] bit_tickets = new int[tickets.length];
		for(int i = 0; i < tickets.length; i++)
			bit_tickets[i] = stringToBits(tickets[i]);
		int mask = (~0)>>> 22;
		for(int i = 0; i < tickets.length; i++)
			for(int j = i + 1; j < tickets.length; j++)
				if((bit_tickets[i]|bit_tickets[j]) == mask)
					res++;
		return res;
    }
	private static int stringToBits(String s) {
		int res = 0;
		char[] charr = s.toCharArray();
		for(int i = 0; i < charr.length; i++)
			res |= (1 << (charr[i] - '0'));
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
        int result = winningLotteryTicket(tickets);
        System.out.println(result);
        //in.close();
    }

}
