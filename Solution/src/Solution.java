import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {
	public static int totalFruit(int[] tree) {
        int first = -1;
        int second = -1;
        int last = -1;
        int max_first = 0;
        int max_second = 0;
        int max = 0;
        int stretch = 0;
        for (int i = 0; i < tree.length; i++)
        {
            if (first == -1)
                first = tree[i];
            else if (tree[i] != first && second == -1)
                second = tree[i];
            if (tree[i] == first)
                max_first++;
            else if (tree[i] == second)
                max_second++;
            else // new value
            {
                if (max_first + max_second > max)
                    max = max_first + max_second;
                if (last == second)
                    first = second;
                max_second = 1;
                max_first = stretch;
                second = tree[i];
            }
            if (last != tree[i])
            {
                stretch = 0;
            	last = tree[i];
            }
            stretch++;
        }
        if (max_first + max_second > max)
                    max = max_first + max_second;
        return max;
    }
    public static void main(String[] args) 
    {
    	int[] nums1 = {0, 1, 2,2};
    	System.out.println(totalFruit(nums1));;
    }
}
