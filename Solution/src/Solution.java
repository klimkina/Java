import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
	public static int maxTurbulenceSize(int[] A) {
        if (A.length < 1)
            return 0;
        if(A.length == 1)
            return 1;
        int res = 1;
        int len = 2;
        boolean prev = A[1] - A[0] > 0 ? true : false;
        for(int i = 2; i < A.length; i++)
        {
            boolean curr = A[i] - A[i-1] > 0 ? true : false;
            if(curr != prev && A[i] != A[i-1])
                len++;
            else
            {
                if (len > res)
                	res = len;
                len = 2;
            }
            prev = curr;
        }
        if (len > res )
             res = len;
        
        return res;
    }
	
	public static void main(final String[] args) {
		int[] A = {2,0,2,4,2,5,0,1,2,3};
		System.out.println(maxTurbulenceSize(A));
		int[] B = {4,8,12,16};
		System.out.println(maxTurbulenceSize(B));
		int[] C = {9,4,2,10,7,8,8,1,9};
		System.out.println(maxTurbulenceSize(C));
		int[] D = {37,199,60,296,257,248,115,31,273,176};
		System.out.println(maxTurbulenceSize(D));
	}
}
