
public class NextPermutation {
	public void nextPermutation(int[] nums) {
        int pos = nums.length-1;
        while(pos > 0 && nums[pos - 1] >= nums[pos]) 
        	pos--;
        
        if(pos == 0)
        	reverse(nums);
        else
        	getNext(nums, pos-1);
    }
	private void getNext(int[]nums, int pos) {
		int min_id = pos+1;
		while(min_id < nums.length-1 && nums[min_id+1] > nums[pos])
			min_id++;
		//swap pos with min
		nums[min_id] = nums[min_id] - nums[pos];
		nums[pos] = nums[min_id] + nums[pos];
		nums[min_id] = nums[pos] - nums[min_id];	
		sort(nums, pos+1);
	}
	private void sort(int[] nums, int pos) {//sort from pos to the end
		for(int i = pos + 1; i < nums.length; i++) {
			int start = i;
			while(start > pos && nums[start] < nums [start-1]) {
				//swap start and start-1
				nums[start] = nums[start] - nums[start-1];
				nums[start-1] = nums[start] + nums[start-1];
				nums[start] = nums[start-1] - nums[start];	
				start--;
			}
		}
	}
	private void reverse(int[] nums) {
		for(int i = 0; i < nums.length/2; i++) {
			nums[nums.length - 1 - i] = nums[nums.length - 1 - i] - nums[i];
			nums[i] = nums[nums.length - 1 - i] + nums[i];
			nums[nums.length - 1 - i] = nums[i] - nums[nums.length - 1 - i];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation obj = new NextPermutation();
		int[] nums = {5,1,1};
		obj.nextPermutation(nums);
		for(int i : nums)
			System.out.print(i + " ");
		System.out.println();
		int[] nums2 = {3,2,1};
		obj.nextPermutation(nums2);
		for(int i : nums2)
			System.out.print(i + " ");
	}

}
