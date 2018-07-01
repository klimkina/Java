import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	private static HashMap<Integer, Integer> my_bills = new HashMap<>();
	public static boolean lemonadeChange(int[] bills) {
		if(bills.length == 0)
			return true;
	
		my_bills.put(bills[0], 1);
		for (int i = 1; i < bills.length; i++)
			if(!getChange(bills[i]))
				return false;
			else
				my_bills.put(bills[i], my_bills.getOrDefault(bills[i], 0) + 1);
        return true;
    }
	public static boolean getChange(int bill) {
		int change = 0;
		HashMap<Integer, Integer> temp = new HashMap<>();
		while (change != bill - 5)
			if(bill - change -5 >= 20 && my_bills.getOrDefault(20, 0) > 0)
			{
				my_bills.put(20, my_bills.get(20) - 1);
				change += 20;
				temp.put(20, temp.getOrDefault(20, 0));
			}
			else if (bill - change -5>= 10 && my_bills.getOrDefault(10, 0) > 0)
			{
				my_bills.put(10, my_bills.get(10) - 1);
				change += 10;
				temp.put(10, temp.getOrDefault(10, 0));
			}
			else if (bill - change -5>= 5 && my_bills.getOrDefault(5, 0) > 0)
			{
				my_bills.put(5, my_bills.get(5) - 1);
				change += 5;
				temp.put(5, temp.getOrDefault(5, 0));
			}
			else
			{
				if (change != bill - 5)
					for(int key : temp.keySet())
						my_bills.put(key, my_bills.get(key) - temp.get(key));
				return change == bill - 5;
			}
		return true;
	}
	
    public static void main(String[] args) {
    	int[] bills = {5,5,10,10,25};
    	System.out.println(lemonadeChange(bills));
    	
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}
