import java.util.Arrays;

public class PartitionKSubsets {
	
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];
		if(sum % k > 0)
			return false;
		Arrays.sort(nums);
		int[] remain = new int[k];
		Arrays.fill(remain, sum/k);
		return dfs(nums, nums.length-1, remain, k);
    }
	private boolean dfs(int[] nums, int n, int[] remain, int k) {
        if (n == 0) {
        	for(int i = 0; i < k; i++)
        		if(remain[i] > 0)
        			return false;
            return true;
        }
        System.out.println("n = " + n);
        for (int p = 0; p < k; p++) {
        	System.out.println("i, sums[i] = " + remain[p]);
        }
        for (int i = 0; i < k; i++) {
            if (remain[i] - nums[n] < 0) {
                continue;
            }
            remain[i] -= nums[n];
            if (dfs(nums, n - 1, remain, k)) {
                return true;
            }
            remain[i] += nums[n];
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7628, 3147, 7137, 2578, 7742, 2746, 4264, 7704, 9532, 9679, 8963, 3223, 2133, 7792, 5911, 3979};
		PartitionKSubsets obj = new PartitionKSubsets();
		System.out.println(obj.canPartitionKSubsets(arr, 6));
	}

}
