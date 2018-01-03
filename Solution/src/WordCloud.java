import java.util.HashMap;
import java.util.regex.Pattern;

public class WordCloud {
	private HashMap<String, Integer> dic = new HashMap<>();
	public void addString(String s) {
		String[] words = s.trim().split("([.,?!:;()]|\\s)+");
		for(String word:words) {
			if(dic.containsKey(word.toLowerCase()))
				dic.put(word, dic.get(word)+1);
			else if(dic.containsKey(Character.toString(word.charAt(0)).toUpperCase()+word.substring(1))) {
				dic.put(word.toLowerCase(), dic.get(Character.toString(word.charAt(0)).toUpperCase()+word.substring(1))+1);
				dic.remove(Character.toString(word.charAt(0)).toUpperCase()+word.substring(1));
			} else
				dic.put(word, 1);
		}
	}
	public void print() {
		for(String key:dic.keySet())
			System.out.println(key + " " + dic.get(key));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake.";
		String s2 = "The bill came to five dollars.";
		WordCloud obj = new WordCloud();
		obj.addString(s1);
		obj.addString(s2);
		obj.print();
	}
}
