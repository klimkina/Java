import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PyramidTransitionMatrix {
	private HashMap<String, Set<Character>> map = new HashMap<>();
	public boolean pyramidTransition(String bottom, List<String> allowed) {
		initMap(allowed);
		
		ArrayList<Set<Character>> sol[] = new ArrayList[bottom.length()];
		sol[0] = new ArrayList<>();
		for(int i = 0; i < bottom.length(); i++) {
			sol[0].add(new HashSet<Character>());
			sol[0].get(i).add(bottom.charAt(i));
		}
		for(int i = 1; i < bottom.length(); i++) {
			sol[i] = new ArrayList<>();
			for(int j = 0; j < bottom.length() - i; j++) {
				sol[i].add(new HashSet<Character>());
				Set<Character> prev1 = sol[i-1].get(j);
				Set<Character> prev2 = sol[i-1].get(j+1);
				for(Character ch1:prev1)
					for(Character ch2:prev2) {
						String s =new StringBuilder().append(ch1).append(ch2).toString();
						if(map.containsKey(s))
							sol[i].get(j).addAll(map.get(s));
					}
				if(sol[i].get(j).isEmpty())
					return false;
			}
		}
        return true;
    }
	private void initMap(List<String> allowed) {
		for(String s:allowed) {
			String prefix = s.substring(0,2);
			Character ch = s.charAt(2);
			if(!map.containsKey(prefix))
				map.put(prefix, new HashSet<>());
			map.get(prefix).add(ch);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String bottom = "XXYX";
		List<String> allowed = Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ");
		PyramidTransitionMatrix obj = new PyramidTransitionMatrix();
    	System.out.println(obj.pyramidTransition(bottom, allowed));
	}

}
