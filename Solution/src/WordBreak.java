import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	Set<String> dict;
	HashMap<String, List<String>> memo;
	public List<String> wordBreak(String s, List<String> wordDict) {
		memo = new HashMap<>();
        dict = new HashSet<>();
        for(String str:wordDict)
        	dict.add(str);
        List<String> res = segmentString(s);
        return res;
    }

	private List<String> segmentString(String input) {
		if(memo.containsKey(input))
			return memo.get(input);
		List<String> res = new ArrayList<>();
		int len = input.length();
		for (int i = 1; i <= len; i++) {
		    String prefix = input.substring(0, i);
		    if (dict.contains(prefix)) {
		    	if( i < len) {
			        String suffix = input.substring(i, len);
			        List<String> segSuffix = segmentString(suffix);
			        if (segSuffix != null && !segSuffix.isEmpty()) 
			    	    for(String s:segSuffix)
						    res.add(prefix + " " + s);		
		    	}
		    	else 
		    		res.add(prefix);
		    }
	    }
		memo.put(input, res);
		return res;
	}
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak obj = new WordBreak();
		/*String s = "catsanddog";
		String[] dict_words = {"cat", "cats", "and", "sand", "dog"};*/
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
				String[] dict_words = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		List<String> wordDict = new ArrayList<>();
		for(String str : dict_words)
			wordDict.add(str);
		List<String> res = obj.wordBreak(s, wordDict);
		for(String str : res)
			System.out.println(str);
	}

}
