/*We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
*/
public class GuessGame {
	public int getMoneyAmount(int n) {
		int[][] dp = new int[n+1][n+1];
		
		return DP(dp, 1, n);
    }
	private int DP(int[][] dp, int start, int end) {
		if(start >= end)
			return 0;
		if(dp[start][end] != 0)
			return dp[start][end];
		
		int res = Integer.MAX_VALUE;
		for(int x = start; x <= end; x++){
            int tmp = x + Math.max(DP(dp, start, x-1), DP(dp, x+1, end));
            res = Math.min(res, tmp);
        }
        dp[start][end] = res;
        return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessGame obj = new GuessGame();
		System.out.println("$" + obj.getMoneyAmount(3));
	}

}
