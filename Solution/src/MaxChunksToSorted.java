
public class MaxChunksToSorted {
	public int maxChunksToSorted(int[] arr) {
        int res = 1;
        int[] min = new int[arr.length];
        min[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length-2; i >= 0; i--)
        	if(arr[i] < min[i+1])
        		min[i] = arr[i];
        	else
        		min[i] = min[i+1];
        int max = arr[0];
        for(int i = 0; i < arr.length-1; i++) {
        	if(max < arr[i])
        		max = arr[i];
        	if(max <= min[i+1]) {// can split
        		res++;
        		max = arr[i+1];
        	}
        }
        /*int start = nextSplit(arr, 0);
        while(start < arr.length-1) {
        	start = nextSplit(arr, start);
            res++; 
        }*/
        return res;
    }
	private int nextSplit(int[] arr, int start) {
		int max = arr[start];
		for(int i = start+1; i < arr.length; i++) {
			if(max < arr[i])
				max = arr[i];
			if(check(arr, i, max))
				return i;
		}
		return arr.length;
	}
	private boolean check(int[] arr, int start, int max) {
		for(int i = start+1; i < arr.length; i++)
			if(arr[i] < max)
				return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,3,2,1,0};
		MaxChunksToSorted obj = new MaxChunksToSorted();
		System.out.println(obj.maxChunksToSorted(arr));
		int[] arr2 = {1,0,2,3,4};
		System.out.println(obj.maxChunksToSorted(arr2));
	}

}
