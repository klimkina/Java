
public class SubarrayProductLessThanK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int res = 0;
	
		for(int i = 0; i < nums.length; i++) {
			int product = nums[i];
			if(product <  k)
				res++;
			for(int j = 1; j < nums.length - i && product < k; j++) {
				product *= nums[i+j];
				if(product <  k)
					res++;
				
			}
			
		}
		return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
		int k = 19;
		SubarrayProductLessThanK obj = new SubarrayProductLessThanK();
		System.out.println(obj.numSubarrayProductLessThanK(arr, k));
	}

}
