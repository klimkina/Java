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
	    
	    int i;
	    for (i = 1; i <= n; i++) {
	    	//System.out.print(i + " ");
	        sum += i;
	        i *= k;
	        
	    }
	    //System.out.println(i);
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
    	System.out.println(obj.f(3, 0));
    	System.out.println(obj.f(3, 1));
    	System.out.println(obj.f(3, 3));
    	System.out.println(obj.f(3, 4));
    	System.out.println(obj.f(3, 5));
    	System.out.println(obj.f(3, 6));
    	System.out.println(obj.f(3, 7));
    	System.out.println(obj.f(3, 8));
    	System.out.println(obj.f(3, 9));
    	System.out.println(obj.f(3, 10));
    	System.out.println(obj.f(3, 11));
    	System.out.println(obj.f(3, 12));
    	System.out.println(obj.f(3, 13));
    	System.out.println(obj.f(3, 14));
    	System.out.println(obj.f(3, 15));
    	System.out.println(obj.f(3, 16));
    	System.out.println(obj.f(3, 17));
    	System.out.println(obj.f(3, 31));
    	System.out.println(obj.f(3, 32));
    	System.out.println(obj.f(3, 33));
    	System.out.println(obj.f(3, 47));
    	System.out.println(obj.f(3, 64));
        //in.close();
    }

}
