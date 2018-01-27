import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProgrammingCompetition {

	public int f(int k, int n) {
	    int sum = 0;
	    System.out.println();
	    int i;
	    for (i = 1; i <= n; i++) {
	    	System.out.print(i + " ");
	        sum += i;
	        i *= k;
	        
	    }
	    System.out.println(i);
	    return sum;
	}
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] tickets = new String[n];
        for(int tickets_i = 0; tickets_i < n; tickets_i++){
            tickets[tickets_i] = in.next();
        }*/
    	ProgrammingCompetition obj = new ProgrammingCompetition();
    	System.out.println(obj.f(2, 0));
    	System.out.println(obj.f(2, 1));
    	System.out.println(obj.f(2, 3));
    	System.out.println(obj.f(2, 4));
    	System.out.println(obj.f(2, 5));
    	System.out.println(obj.f(2, 6));
    	System.out.println(obj.f(2, 7));
    	System.out.println(obj.f(2, 8));
    	System.out.println(obj.f(2, 9));
    	System.out.println(obj.f(2, 10));
    	System.out.println(obj.f(2, 11));
    	System.out.println(obj.f(2, 12));
    	System.out.println(obj.f(2, 13));
    	System.out.println(obj.f(2, 14));
    	System.out.println(obj.f(2, 15));
    	System.out.println(obj.f(2, 16));
    	System.out.println(obj.f(2, 47));
    	
        //in.close();
    }

}
