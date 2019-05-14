import java.util.Arrays;

// array of ints
// find the major element
class Solution {
	public Integer findMajor(int[] arr)
    {
        if (arr != null && arr.length > 0)
        {
            int first = 0;
            int count = 0;
            for(int i = 0; i < arr.length; i++)
            {
                if (count == 0)
                {
                	first = arr[i];
                    count = 1;
                }
                else if (first == arr[i])
                    count++;
                else 
                    count--;
            }
            count = 0;
            for(int i = 0; i < arr.length; i++)
            {
                if (arr[i] == first)
                    count++;
            }
            int half = (arr.length +1)/2;
            if (count >= half)
                return first;
        }
        return null;
    }
	public static void main(String[] args) {   	
    	int[] arr = {2,0,2,1,2,0,2};
    	Solution obj = new Solution();
    	System.out.println(obj.findMajor(arr));
	}
}
