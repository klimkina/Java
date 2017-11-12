import java.util.HashMap;

public class ArrayDegree {
	public int findShortestSubArray(int[] nums) {
		if(nums.length <= 1)
			return nums.length;
		
		HashMap<Integer, Integer> numMaps = new HashMap<Integer, Integer>(); //counter
		HashMap<Integer, Integer> leftMaps = new HashMap<Integer, Integer>(); //first occurrence
		HashMap<Integer, Integer> rightMaps = new HashMap<Integer, Integer>(); //last occurrence
		int max = findDegree(nums, numMaps, leftMaps, rightMaps);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if(numMaps.get(nums[i]) == max) {
				int diff = rightMaps.get(nums[i]) - leftMaps.get(nums[i]) + 1;
				if (diff < min)
					min = diff;
			}
		}
		
        return min;
    }
	private int findDegree(int[] nums, HashMap<Integer, Integer> numMaps, 
			HashMap<Integer, Integer> leftMaps, HashMap<Integer, Integer> rightMaps) {
		int max = 1; // at least one number is there
		for (int i = 0; i < nums.length; i++) {
			if(numMaps.get(nums[i]) != null ) {
				numMaps.put(nums[i], numMaps.get(nums[i])+1);
				if(numMaps.get(nums[i]) > max)
					max = numMaps.get(nums[i]);
				rightMaps.put(nums[i], i);
			}	
			else {
				numMaps.put(nums[i], 1);
				leftMaps.put(nums[i], i);
				rightMaps.put(nums[i], i);
			}
		}
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,1};
		ArrayDegree obj = new ArrayDegree();
		System.out.println(obj.findShortestSubArray(arr));
	}

}
