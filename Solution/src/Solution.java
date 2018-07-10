import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static class ListNode {
	   int val;
	   ListNode next;
	   ListNode(int x) { val = x; }
	 }
	private static int calcSize(ListNode l)
	{
		int s = 0;
        if (l != null)
        {
            s = 1;
            while (l.next != null)
            {
                s++;
                l = l.next;
            }
        }
        return s;
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode big = l1;
        ListNode small = l2;
        int s1=0, s2=0;
        s1 = calcSize(l1);
        s2 = calcSize(l2);
        int diff;
        if (s2 > s1)
        {big = l2;small = l1; diff = s2 - s1;}
        else
           {big = l1;small = l2; diff = s1 - s2;} 
        ListNode res = big;
        while (diff-- > 0)
            big = big.next;
        ListNode add1 = new ListNode(0);
        ListNode curr1 = add1;
        boolean recalc = false;
        while(big != null)
        {
            big.val += small.val;
            if(big.val > 9)
            {
                big.val -=10;
                ListNode node = new ListNode(1);
                curr1.next = node;
                curr1 = node;
                recalc = true;
            }
            else if (recalc)
            {
            	ListNode node = new ListNode(0);
            	curr1.next = node;
                curr1 = node;
            }
            big = big.next; small = small.next;
        }
        if(recalc)
        {
        	ListNode node = new ListNode(0);
            curr1.next = node;
            res = addTwoNumbers(s1 > s2 ? l1 : l2, add1);
        }
        return res;
    }
	
    public static void main(String[] args) {
    	int[] input = {2,4,3};
    	ListNode node = new ListNode(2);
    	ListNode curr = node;
    	for(int i = 1; i < input.length; i++)
    	{
    		ListNode temp = new ListNode(input[i]);
    		curr.next = temp;
    		curr = temp;
    	}
    	int[] input2 = {5,6,4};
    	ListNode node2 = new ListNode(5);
    	ListNode curr2 = node2;
    	for(int i = 1; i < input2.length; i++)
    	{
    		ListNode temp = new ListNode(input2[i]);
    		curr2.next = temp;
    		curr2 = temp;
    	}
    	ListNode res = addTwoNumbers(node, node2);
    	//System.out.println(search(nums, target));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}
