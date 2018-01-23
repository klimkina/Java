import java.util.ArrayList;
import java.util.List;

/*
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
*/
public class ShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<>();
		if(strings == null || strings.length == 0)
			return res;
		boolean added;
		for(int i = 0; i < strings.length; i++) {
			added = false;
			for(List<String> list : res)
				if(sameGroup(strings[i], list.get(0))) {
					list.add(strings[i]);
					added = true;
					break;
				}
			if(!added) {
				List<String> temp = new ArrayList<>();
				temp.add(strings[i]);
				res.add(temp);
			}
		}
		return res;
    }
	private boolean sameGroup(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		
		for(int i = 1; i < s1.length(); i++) {
			if(calcDiff(s2.charAt(i), s1.charAt(i)) != calcDiff(s2.charAt(i-1), s1.charAt(i-1)))
				return false;
		}
		return true;
	}
	private int calcDiff(char a, char b) {
		if(b > a)
			return b - a;
		else
			return (b - 'a') + ('z' - a + 1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = {"az", "ba"};
		ShiftedStrings obj = new ShiftedStrings();
		List<List<String>> res = obj.groupStrings(strings);
		for(List<String> list : res) {
			for(String s: list)
				System.out.print(s + " ");
			System.out.println();
		}
	}

}
