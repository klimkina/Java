import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static int count47(int n) {
		int res = 0;
		char[] charr = Integer.toString(n).toCharArray();
		for(int i = 0; i < charr.length; i++) {
			if(charr[i] == '4')
				res++;
			else if(charr[i] == '7')
				res--;
			else {
				res = -1;
				break;
			}
		}
		return res;
	}
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
    	String[] input = {"4",
    			"HackerBook 777444",
    			"RankBook 3",
    			"TheBook 777",
    			"BestBook 47"};
    	int n = Integer.parseInt(input[0]);
    	int min = Integer.MAX_VALUE;
    	String res = "";
        for(int a0 = 1; a0 <= n; a0++){
        	String next = input[a0];
            String name = next.split(" ")[0];
            String s = next.split(" ")[1];
            int value = Integer.parseInt(next.split(" ")[1]);
            if(count47(value) == 0)
            	if(min > value) {
            		min = value;
            		res = name;
            	}
        }
        
        if(res != "")
        	System.out.println(res);
        else
        	System.out.println("-1");
        //in.close();
    }
}