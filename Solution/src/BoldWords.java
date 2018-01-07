import java.util.PriorityQueue;
public class BoldWords {
	public String boldWords(String[] words, String S) {
		PriorityQueue<Integer> starts = new PriorityQueue<>();
		PriorityQueue<Integer> ends = new PriorityQueue<>();
		for(int i = 0; i < words.length; i++) {
			int index = S.indexOf(words[i]);
			while(index >= 0) {
				starts.add(index);
				ends.add(index + words[i].length());
				index = S.indexOf(words[i], index + 1);
			}
		}
		int counter = 0;
		int prev = 0;
		int end = 0;
		StringBuilder sb = new StringBuilder();
		Integer start = starts.poll();
		while(start != null) {
			sb.append(S.substring(prev, start)).append("<b>");
			prev = start;
			counter++;
			end = ends.poll();
			start = starts.poll();
			while(counter > 0) {
				if(start == null || start > end) {
					counter--;
					if(counter > 0)
						end = ends.poll();
				}
				else {
					counter++;
					start = starts.poll();
				}
			}
			sb.append(S.substring(prev, end)).append("</b>");
			prev = end;
		}
		sb.append(S.substring(end, S.length()));
		return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"ccb","b","d","cba","dc"};
		String S = "eeaadadadc";
		BoldWords obj = new BoldWords();
		System.out.println(obj.boldWords(words, S));
	}

}
