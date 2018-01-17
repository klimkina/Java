/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
*/
public class MaxProfit {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
        int[] buy = new int[prices.length + 1];
        int[] sell = new int[prices.length + 1];
        buy[0] = -prices[0];
        sell[0] = 0;
        for(int i = 1; i < prices.length; i++) {
        	buy[i] = Math.max(buy[i-1], (i > 1 ? sell[i-2] - prices[i] : -prices[1]));
        	sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return Math.max(buy[prices.length-1], sell[prices.length-1]);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1, 2, 4};
		MaxProfit obj = new MaxProfit();
    	System.out.println(obj.maxProfit(prices));
	}

}
