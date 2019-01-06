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
	public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res = new HashSet<>();
        int first = 1;
        List<Integer> listY = new ArrayList<>();
        int second = 1;
        listY.add(second);
        second = y*second;
        if( y > 1)
	        for(int j = 0; second < bound; j++)
	        {
	        	listY.add(second);
	        	second = y*second;
	        }
        for(int i = 0; first < bound; i++)
        {
            for(int powY : listY)
            {
            	int sum = powY + first;
            	if(sum <= bound)
            		res.add(sum);
            }
            if(x < 2)
        		break;
            first = x * first;
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(res);
        return list;
    }
	
    public static void main(String[] args) 
    {
    	List<Integer> res = powerfulIntegers(2,3,10);
    	for(Integer s : res)
    			System.out.print(s + " ");
    }
}
