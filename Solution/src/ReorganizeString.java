import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {
	private static class CharCount implements Comparable<CharCount> {
		char val;
		int count;
		public CharCount(char c, int n) {
			val = c;
			count = n;
		}
		@Override 
		public int compareTo(CharCount that) {
			return that.count - this.count; // max queue
		}
	}
	public String reorganizeString(String S) {
		if(S.isEmpty())
			return "";
		PriorityQueue<CharCount> pq = new PriorityQueue<>();
		HashMap<Character, Integer> map = new HashMap<>();
		char[] charr = S.toCharArray();
		int max = 0;
		for(int i = 0; i < charr.length; i++) {
			if(map.get(charr[i]) == null)
				map.put(charr[i], 0);
			map.put(charr[i], map.get(charr[i]) + 1);
			if(map.get(charr[i]) > map.get(charr[max]))
				max = i;
		}
		if(charr.length % 2 == 0 && (map.get(charr[max]) > charr.length/ 2))
			return "";
		if(map.get(charr[max]) > (charr.length +1)/ 2)
			return "";
		for(Character ch:map.keySet())
			pq.add(new CharCount(ch, map.get(ch)));
		StringBuilder sb = new StringBuilder();
		char prev = charr[max];
		for(int i = 0; i < charr.length; i++) {
			CharCount cc = pq.remove();
			if(i > 0 && cc.val == prev) {
				CharCount temp = cc;
				cc = pq.remove();
				pq.add(temp);
			}
			sb.append(cc.val);
			cc.count--;
			pq.add(cc);
			prev = cc.val;
		}
		return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorganizeString obj = new ReorganizeString();
		//System.out.println(obj.reorganizeString("aab"));
		System.out.println(obj.reorganizeString("bbbaaaaaaaaaaaabbabaaabaabbbbbbaaaaabbbbaaabbaabbaababaaabaaaabbbbbabbbbbbbaababababbabbbbabbaaababaaabbabbbbabbaabbbbbbaabaaababbaaababaabbbaabababaabbbabaaabaaabababbaabbbbbaaabbaaabaaabbbaabbbbbabaabaaaababbbbbbbbabbbabaaaababaaabbabaababaaaaaabbababbaaaabababbbaaababaaaabbbbabbaabbaabbabbbbbbbabababaaabaaaabaaababbbabbbbbaababaabbaabaababbbabbbabaabbbbbbaaaaabaababbbbabaabababaababaabbaaabaaabbabababbabaaaaaabbbbbbaabbaaabbbaabaabbbaababbabaaaaaaaabbbbbaabbaaababbbabaabbaaaaaaaabaabababaaaaa"));
	}

}
