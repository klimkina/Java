import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
	
	public static List<String> commonChars(String[] A) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        List<String> res = new ArrayList<>();
        if (A.length == 0)
            return res;
        for(char alphabet = 'a'; alphabet <='z'; alphabet++)
            map1.put(alphabet, Integer.MAX_VALUE);
        for (int i = 0; i < A.length; i++) {
            char[] chars = A[i].toCharArray();
            for (char ch : chars)
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            Iterator<Map.Entry<Character, Integer>> iter = map1.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Character,Integer> entry = iter.next();
                int min = Math.min(entry.getValue(), map2.getOrDefault(entry.getKey(), 0));
                if(min == 0){
                    iter.remove();
                }
                else
                    map1.put(entry.getKey(), min);
            }
            map2.clear();
        }
        Iterator<Map.Entry<Character, Integer>> iter2 = map1.entrySet().iterator();
        while (iter2.hasNext()) {
            Map.Entry<Character, Integer> entry = iter2.next();
            for(int k = 0; k < entry.getValue(); k++)
                res.add(entry.getKey().toString());
        }
        return res;
    }
	
	public static void main(final String[] args) {
		String[] s = {"bella","label","roller"};
		List<String> res = commonChars(s);
		for (String str : res)
			System.out.println(str);
	}
}
