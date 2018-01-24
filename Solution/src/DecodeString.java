import java.util.Stack;

/*Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".*/
		
public class DecodeString {
	public String decodeString(String s) {
		StringBuilder res = new StringBuilder();
		String curr = "";
        Stack<Character> stack = new Stack<>();
        char[] charr = s.toCharArray();
        for(int i = 0; i < charr.length; i++) {
        	if(charr[i] == ']')
        		curr = bracket(stack);
        	else
        		stack.push(charr[i]);
        	if(stack.isEmpty()) 
        		res.append(curr);
        	else 
        		for(int j = 0; j < curr.length(); j++)
        			stack.push(curr.charAt(j));
        	curr = "";
        }
        int pos = res.length();
        while(!stack.empty())
        	res.insert(pos, stack.pop());
        return res.toString();
    }
	
	private String bracket(Stack<Character> stack) {
		StringBuilder res = new StringBuilder();
		char next = stack.pop();
		while(next != '[') {
			res.insert(0, next);
			next = stack.pop();
		}
		String num = "";
		next = stack.peek();
		while(next >= '0' && next <= '9') {
			stack.pop();
			num = next + num;
			if(stack.empty()) break;
			next = stack.peek();
		}
		int reps = Integer.parseInt(num);
		
		String s = "";
		for(int i = 0; i < reps; i++)
			s+= res.toString();
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3[a]2[bc]"; //, return "aaabcbc".
		DecodeString obj = new DecodeString();
		//System.out.println(obj.decodeString(s));
		s = "3[a]2[b4[F]c]"; //
		System.out.println(obj.decodeString(s));
		s = "2[abc]3[cd]ef"; //, return "abcabccdcdcdef"
		//System.out.println(obj.decodeString(s));	
	}

}
