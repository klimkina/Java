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
	public static String largestTimeFromDigits(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < 4; i++)
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        int[] res = new int[4];
        int next = -1;
        if(map.containsKey(2))
            next = 2;
        else if (map.containsKey(1))
            next = 1;
        else if (map.containsKey(0))
            next = 0;
        else
        	return "";
        res[0] = next;
        map.put(next, map.get(next) -1 );
        if(next == 2)
        {
	        if(map.containsKey(3))
	            next = 3;
	        else if (map.containsKey(2) && map.get(2) > 0)
	            next = 2;
	        else if (map.containsKey(1) && map.get(1) > 0)
	            next = 1; 
	        else if (map.containsKey(0) && map.get(0) > 0)
	            next = 0;
	        else
	        	return "";
        }
        else
        {
        	next = -1;
        	for(int i = 0; i < 4; i++)
                if(map.get(A[i]) > 0 && A[i] > next)
                    next = A[i]; 
        }
        res[1] = next;
        map.put(next, map.get(next) - 1 );
        int a = 0;
        int b = 0;
        for(int i = 0; i < 4; i++)
            if(map.get(A[i]) > 0)
            {
                a = A[i];
                map.put(A[i], map.get(A[i]) - 1);
                break;
            }
        for(int i = 0; i < 4; i++)
            if(map.get(A[i]) > 0)
            {
                b = A[i];
                break;
            }
        if ((a > b && a < 6) || b > 5)
        {
        	if (a > 5)
        	{
        		if(res[0] == 2 && res[1] < 2)
        		{
        			res[0] = res[1];
        			res[1] = Math.max(a, b);
        			res[2] = 2;
        			res[3] = Math.min(a, b);
        		}
        		else
        			return "";
        	}
        	else
        	{
	            res[2] = a;
	            res[3] = b;
        	}
        }
        else
        {
        	if (b > 5)
        		if(res[0] == 2 && res[1] < 2)
        		{
        			res[0] = res[1];
        			res[1] = Math.max(a, b);
        			res[2] = 2;
        			res[3] = Math.min(a, b);
        		}
        		else
        			return "";
        	else
        	{
	            res[2] = b;
	            res[3] = a;
        	}
        }
        return "" + res[0] + res[1] + ":" + res[2] + res[3];
    }
	
    public static void main(String[] args) 
    {
    	int[] arr = {2,6,6,0};
    	System.out.println(largestTimeFromDigits(arr));
    }
}
