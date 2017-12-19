/*You recently received a bag of chocolate sticks for Halloween. To prevent you from compulsively eating all the chocolate sticks in one go, your dietician devises the following fun game.

In each move, you choose one of the sticks from your bag. Then, you either eat it, or break it into some number of equally-sized parts and save the pieces for later. The lengths of all sticks must always be integers, so breaking a stick into  parts is possible only if  is a divisor of the stick's length, and .

Note that this means that a stick of length  cannot be broken anymore, and can only be eaten.*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BreakingSticks {

    static long longestSequence(long[] a) {
        //  Return the length of the longest possible sequence of moves.
    	long res = 0;
    	for(int i = 0; i < a.length; i++)
    		res += maxMoves(a[i]);
    	return res;
    }
    private static long maxMoves(long num) {
    	/* pof2 is the greatest power of 2 dividing number . */
    	long res = num;
		while((num & 1)==0) {
		    num >>=1;
	    	res += num;
		}
		for (long i = 3; i <= Math.sqrt(num); i++) {
            while (num % i == 0) {
            	num /= i;
                res += num;
            }
        }
		return res + ((num > 1) ? 1 : 0);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextLong();
        }
        long result = longestSequence(a);
        System.out.println(result);
        in.close();
    }
}
