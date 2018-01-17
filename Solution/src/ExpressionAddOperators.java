/*Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) 
		+, -, or * between the digits so they evaluate to the target value.*/

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		if(num.isEmpty() || Long.parseLong(num) > Integer.MAX_VALUE)
			return res;
		res = getOperator(num, target, 0, num.length());
		return res;
    }
	// start inclusive and end is not inclusive
	private List<String> getOperator(String sub, long target, int start, int end) {
		List<String> res = new ArrayList<>();
		if(start >= end)
			return res;
		if(sub.charAt(start) != '0' && Long.parseLong(sub.substring(start, end)) == target) 
			res.add(sub.substring(start, end));
		
		for(int i = start + 1; i < end; i++) {
			long left = Long.parseLong(sub.substring(start, i));
			List<String> right = getOperator(sub, target-left, i, end);
			addOperators(res, "+", left, right);
			right = getOperator(sub, left-target, i, end);
			addOperators(res, "-", left, right);
			
			for(int j = start+i + 1; j < end; j++) {
				long next_left = Long.parseLong(sub.substring(start+i, j));
				right = getOperator(sub, target - left * next_left, j, end);
				if(!right.isEmpty())
					for(String s: right)
						res.add(left + "*" + next_left + "+" + s);
				right = getOperator(sub, left * next_left - target, j, end);
				if(!right.isEmpty())
					for(String s: right)
						res.add(left + "*" + next_left + "-" + s);
			}
		}
		return res;
	}
	private void addOperators(List<String> res, String op, long left, List<String> right) {
		if(!right.isEmpty())
			for(String s: right)
				res.add(left + op + s);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionAddOperators obj = new ExpressionAddOperators();
		List<String> res = obj.addOperators("232", 8);
		for(String s : res)
			System.out.println(s);
	}

}
