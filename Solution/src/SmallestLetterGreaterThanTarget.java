import java.util.TreeSet;

/*
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 */
public class SmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
		if(letters.length == 1)
			return letters[0];
		TreeSet<Character> set = new TreeSet<>();
		for(char ch : letters)
			set.add(ch);
		Character res = set.higher(target);
		if(res == null)
			res = letters[0];
        return res.charValue();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestLetterGreaterThanTarget sol = new SmallestLetterGreaterThanTarget();
		char[] letters = {'c', 'f', 'j'};
		char target = 'a';
		char res = sol.nextGreatestLetter(letters, target);
		System.out.println(res);

	}

}
