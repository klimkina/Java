import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {
	public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int n = prices.length;        
        int[] buys = new int[n];
        int[] sells = new int[n];
        buys[0] = -prices[0];
        sells[0] = 0;
        for (int i = 1; i < n; i++)
        {
            buys[i] = Math.max(buys[i-1], sells[i-1] - prices[i]);
            sells[i] = Math.max(buys[i-1] + prices[i], sells[i-1]);
        }
        return sells[n-1];
    }
    public static void main(String[] args) 
    {
    	int[] prices = {7,1,5,3,6,4};
    	System.out.println(maxProfit(prices));
    }
}
