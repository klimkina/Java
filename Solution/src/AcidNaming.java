import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*Jonathan is in a science class, but because he does not understand how to name acids, 
  he would like you to make a program for him. There are two types of acids at his level, non-metal and polyatomic.

Conditions for naming an acid:

If the given input starts with hydro and ends with ic then it is a non-metal acid.
If the input only ends with ic then it is a polyatomic acid.
If it does not have either case, then output not an acid.
For example, for the input, , the correct output is -  as the input begins with hydro and ends withic.

Complete the function acidNaming which takes a string input with the name of the acid, and return a string describing the appropriate type of acid.
*/
public class AcidNaming {
	private static String end = "ic";
	private static String start = "hydro";
    static String acidNaming(String acid_name) {
        // Complete this function
    	acid_name.trim();
    	String res = "not an acid";
    	if(acid_name.length() > 2)
    		if(acid_name.substring(acid_name.length()-2).toLowerCase().equals(end)) {
	    		if(acid_name.length() > 6 && acid_name.substring(0, 5).toLowerCase().equals(start))
	    			res = "non-metal acid";
	    		else
	    			res = "polyatomic acid";
	    	}
    	return res;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String acid_name = in.next();
            String result = acidNaming(acid_name);
            System.out.println(result);
        }
        in.close();*/
    	String[] names = {"Hydrochloric", "rainbowIc", "idontevenknow"};
    	for(String name:names)
    		System.out.println(acidNaming(name));
    }
}

