import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	static class MyQueue {
		private static Stack<Integer> stack;
		private static Stack<Integer> stack2;
	    /** Initialize your data structure here. */
	    public MyQueue() {
	        stack = new Stack<>();
	        stack2 = new Stack<>();
	    }
	    
	    private void initStack2()
	    {
	    	while(!stack.isEmpty())
	    		stack2.push(stack.pop());
	    }
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        stack.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        if(stack2.isEmpty())
	        	initStack2();
        	return stack2.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	    	if(stack2.isEmpty())
	        	initStack2();
        	return stack2.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return stack2.isEmpty() && stack.isEmpty();
	    }
	}
	
    public static void main(String[] args) {
    	MyQueue obj = new MyQueue();
    	obj.push(1);
    	obj.push(2);
    	obj.push(3);
    	obj.push(4);
    	int param_2 = obj.pop();
    	System.out.println(param_2);
    	int param_3 = obj.peek();
    	System.out.println(param_3);
    	param_2 = obj.pop();
    	System.out.println(param_2);
    	boolean param_4 = obj.empty();
    	System.out.println(param_4);
    	
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}
