import java.util.Arrays;
import java.util.Comparator;

public class ShortestCompletingWord {
	public String shortestCompletingWord(String licensePlate, String[] words) {
		licensePlate = licensePlate.toLowerCase();
		licensePlate = licensePlate.replaceAll("\\s", "");
		licensePlate = licensePlate.replaceAll("\\d", "");
		char[] licensePlateArray = licensePlate.toCharArray();
		Arrays.sort(licensePlateArray);
		Arrays.sort(words, new Comparator<String>() {
    	    public int compare(String s1, String s2) {
    	    	return s1.length() - s2.length();
    	    }
		});
		for(int i = 0; i < words.length; i++) {
			char[] chars = words[i].toCharArray();
			Arrays.sort(chars);
			if(isMatch( licensePlateArray, chars))
				return words[i];
		}
        return "";
    }
	private boolean isMatch(char[] source, char[] target) {
		int start = 0;
		for(int i = 0; i < source.length; i++) {
			if(start >= target.length)
				return false;
			while(target[start] != source[i]) {
				start++;
				if(start >= target.length)
					return false;
			}
			start++;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String licensePlate = "B687015";
		String[] words = {"born","give","would","nice","in","understand","blue","force","have","that"};
		ShortestCompletingWord obj = new ShortestCompletingWord();
		System.out.println(obj.shortestCompletingWord(licensePlate, words));
	}

}
