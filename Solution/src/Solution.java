import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
	
	public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> k_list = new ArrayList<>();
        while (K > 0) {
            int num = K%10;
            k_list.add(0, num);
            K /= 10;
        }
        int rem = 0;
        List<Integer> res = new ArrayList<>();
        int i = k_list.size() - 1;
        int j = A.length - 1;
        for(; j >= 0 && (i >= 0 || rem > 0); i--, j--)
        {
            int sum = A[j] + (i >= 0 ? k_list.get(i) : 0) + rem;
            if(sum > 9) {
                rem = sum/10;
                sum = sum %10;
            }
            else
                rem = 0;
            res.add(0, sum);
        }
        
        while (j >= 0)
        	res.add(0, A[j--]);
        while (i >= 0)
        {
        	int sum = k_list.get(i--) + rem;
        	if(sum > 9) {
                rem = sum/10;
                sum = sum %10;
            }
            else
                rem = 0;
        	res.add(0, sum);
        }
        if (rem > 0)
        	res.add(0, rem);
        return res;
    }
	
	public static void main(final String[] args) {
		int[] A = {7};
		System.out.println(addToArrayForm(A, 993));
	}
}
