
import java.util.ArrayList;
import java.util.List;

/*Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"*/
public class RemoveDuplicateLetters {
	private static final int NUM_LETTERS = 26;
	public String removeDuplicateLetters(String s) {
        List<Integer>[] positions = (List<Integer>[])new List[NUM_LETTERS];
        for(int i = 0; i < s.length(); i++) {
        	if(positions[s.charAt(i) - 'a'] == null)
        		positions[s.charAt(i) - 'a'] = new ArrayList<>();
        	positions[s.charAt(i) - 'a'].add(i);
        }
        int minPos = minPos(positions);
        StringBuilder sb = new StringBuilder();
        while(minPos < Integer.MAX_VALUE) {
        	
        	sb.append(minChar(positions, minPos));
        	minPos = minPos(positions);
        }
        return sb.toString();
    }
	private int minPos(List<Integer>[] positions) {
		int res = Integer.MAX_VALUE;
		for(int i = 0;  i < NUM_LETTERS; i++)
			if(positions[i] != null && positions[i].get(positions[i].size()-1) < res)
				res = positions[i].get(positions[i].size()-1);
		return res;
	}
	private char minChar(List<Integer>[] positions, int pos) {
		char res = 'z' + 1;
		int min_pos = -1;
		for(int i = 0;  i < NUM_LETTERS; i++)
			if(positions[i] != null && positions[i].get(0) <= pos)
				if(i + 'a' < res) {
					res = (char)('a' + i);
					min_pos = i;
				}
		removeSmaller(positions, min_pos);
		return res;
	}
	private void removeSmaller(List<Integer>[] positions, int pos) {
		int new_pos = positions[pos].get(0);
		positions[pos] = null;
		for(int i = 0;  i < NUM_LETTERS; i++)
			while(positions[i] != null && positions[i].get(0) < new_pos)
					positions[i].remove(0);
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicateLetters obj = new RemoveDuplicateLetters();
		System.out.println(obj.removeDuplicateLetters("cbacdcbc"));
	}

}
