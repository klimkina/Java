import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int cur1 = 0;
        int cur2 = 0;
        int tail = m;
        for(int i = 0; i < n + m && cur2 < n; i++)
            if(tail > i && nums1[cur1] <= nums2[cur2])
                cur1++;
            else
            {
                for(int k = tail; k > cur1; k--)
                    nums1[k] = nums1[k-1];
                tail++;
                nums1[cur1++] = nums2[cur2++];
            }
	}
	
    public static void main(String[] args) {
    	int[] nums1 = {1};
    	int m = 1;
    	int[] nums2 = {};
    	int n = 0;
    	merge(nums1, m, nums2, n);
    	for(int i = 0; i < n+m; i++)
    		System.out.print(nums1[i] + " ");
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}
