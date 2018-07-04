import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static int calculate(String s) {
		char[] charr = s.toCharArray();
        Stack<Character> op_stack = new Stack<>();//(2+6* 3+5- (3*14/7+2)*5)+3
        Stack<Integer> term_stack = new Stack<>();
        int curr = 0;
        while(curr < charr.length)
        {
        	if (charr[curr] == '+' || charr[curr] == '-' ||
        			charr[curr] == '*' || charr[curr] == '/' || charr[curr] == '(')
        	{
        		op_stack.push(charr[curr++]);
        	}
        	else if (charr[curr]>= '0' && charr[curr] <= '9')
        	{
        		curr = readInt(charr, curr, term_stack);
        		if(!op_stack.empty())
        		{
        			char ch = op_stack.pop();
        			if (ch == '*' || ch == '/')
        			{
        				int r = term_stack.pop();
        				int l = term_stack.pop();
        				if (ch == '*')
        					term_stack.push(r*l);
        				else
        					term_stack.push(l/r);
        			}
        			else
        				op_stack.push(ch);
        		}
        	}
        	else if (charr[curr] == ' ')
        		curr++;
        	else if (charr[curr] == ')')
        	{
        		calcStack(op_stack, term_stack);
        		curr++;
        	}
        }
        calcStack(op_stack, term_stack);
        return term_stack.pop();
    }
	
	private static void calcStack(Stack<Character> op_stack, Stack<Integer> stack)
	{
		int res = Integer.valueOf(stack.pop());
		boolean par_met = false;
		if(!stack.empty())
		{
			char ch = op_stack.pop();
			while(!stack.empty() && ch != '(' && !(par_met && (ch == '+' || ch == '-')))
			{
				int l = Integer.valueOf(stack.pop());
				switch (ch)
				{
					case '+' : res += l; break;
					case '-' : res = l - res; break;
					case '*' : res *= l; break;
					case '/' : res = l/res; break;
				}
				if (!stack.empty())
				{
					ch = op_stack.pop();
					if (ch == '(' && !par_met)
					{
						par_met = true;
						if (!stack.empty())
							ch = op_stack.pop();
					}
				}
			}
			if(ch == '+' || ch == '-')
				op_stack.push(ch);
		}
		stack.push(res);
	}
	private static int readInt(char[] charr, int pos, Stack<Integer> stack)
	{
		int start = pos;
		while(pos < charr.length && charr[pos]>= '0' && charr[pos] <= '9')
			pos++;
		stack.push(Integer.valueOf(String.valueOf(charr, start, pos-start)));
		return pos;
	}
	
    public static void main(String[] args) {
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}
