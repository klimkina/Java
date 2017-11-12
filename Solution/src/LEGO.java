import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LEGO {

    static int productOfPages(int a, int b, int c, int d, int p, int q) {
        // Return the product of the page counts of the missing books
    	HashMap<Integer, Integer> pieces = new HashMap<Integer, Integer>();
    	addPieces(pieces, a);
    	addPieces(pieces, b);
    	addPieces(pieces, c);
    	addPieces(pieces, d);
    	pieces.put(p, pieces.get(p) - 1); //remove p
    	pieces.put(q, pieces.get(q) - 1);
    	int res = 1;
    	for(Integer k : pieces.keySet())
    		for(int i = 0; i < pieces.get(k); i++)
    			res *= k;
    	return res;
    }

	private static void addPieces(HashMap<Integer, Integer> pieces, int x) {
		if(pieces.containsKey(x))
			pieces.put(x, pieces.get(x) + 1);
		else
			pieces.put(x, 1);
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            int answer = productOfPages(a, b, c, d, p, q);
            System.out.println(answer);
        }
        in.close();
    }
}