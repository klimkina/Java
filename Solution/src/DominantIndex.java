
public class DominantIndex {
	public int dominantIndex(int[] nums) {
        int idMax = 0;
        int idPrev = 0;
        boolean res = false;
        for(int i = 1; i < nums.length; i++)
        	if(nums[i] > nums[idMax]) {
        		idPrev = idMax;
        		idMax = i;
        	} else if(idPrev == idMax || nums[i] > nums[idPrev])
        		idPrev = i;
        return (nums[idPrev] * 2 <= nums[idMax] ? idMax : -1);		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DominantIndex obj = new DominantIndex();
    	int[] nums = {1,0,0,0};
    	System.out.println(obj.dominantIndex(nums));

	}

}
