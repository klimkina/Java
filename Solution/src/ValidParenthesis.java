import java.util.*;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<Character>();
		//Scanner sc=new Scanner(System.in);
		// String input
        String line = "(*))";//sc.nextLine();
        int isChoice = 0;
        boolean res = true;
       // Character input
        for(int i = 0; i < line.length(); i++) {
        	char ch = line.charAt(i);
        	if(ch == '(' || ch == '*')
        		stack.push(ch);
        	else {
        		if(stack.isEmpty())
        			res = false;
        		else
        		{
        			isChoice = 0;
        			char inStack = stack.pop();
        			if(inStack == '*')
	        			isChoice++;
	        		while(!stack.isEmpty() && inStack != '(') {
		        		inStack = stack.pop();
		        		if(inStack == '*')
		        			isChoice++;
		        		
	        		}
	        		if(inStack != '(') {
	        			if (isChoice > 0)
	        				isChoice--;
	        			else 
	        				res = false;
	        		}
	        		for(int j = 0; j < isChoice; j++)
        				stack.push('*');
        		}
        		
        	}
        }
        isChoice = 0;
        while(!stack.isEmpty()) {
        	char inStack = stack.pop();
        	if(inStack == '*')
        		isChoice++;
        	else if(inStack == '(') {
        		if (isChoice > 0)
        			isChoice--;
        		else
        			res = false;
        	}
        }
        if(res)
        	System.out.println("True");
        else
        	System.out.println("False");
        //sc.close();
	}

}
