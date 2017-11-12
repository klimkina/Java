
public class StockProfit {
	public int maxProfit(int[] prices, int fee) {
		int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee); //sell
            hold = Math.max(hold, cash - prices[i]);//buy
        }
        return cash;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1, 3, 2, 8, 4, 9};
		int fee = 2;
		StockProfit obj = new StockProfit();
		System.out.println(obj.maxProfit(prices, fee));
	}

}
