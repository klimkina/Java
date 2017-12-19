
public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		MinCostClimbingStairs obj = new MinCostClimbingStairs();
		System.out.println(obj.minCostClimbingStairs(cost));
	}
}
