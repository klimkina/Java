import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TopVotedCandidate {
	private TreeMap<Integer, Integer> tree = new TreeMap<>();
    private Map<Integer, Integer> cache = new HashMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        Map<Integer, Integer> votes = new HashMap<>();
        int max = -1;
        for (int i = 0; i < times.length; i++)
        {
        	votes.put(persons[i], votes.getOrDefault(persons[i], 0) + 1);
            if (max == -1 || votes.get(persons[i]) >= votes.get(max))
        		max = persons[i];
        	tree.put(times[i], max);
            cache.put(times[i], max);
        }
    }
    
    public int q(int t) {
        if (!cache.containsKey(t)) {
            int result = tree.floorEntry(t).getValue();
            cache.put(t, result);
        }
        return cache.get(t);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] persons = {0,1,1,0,0,1,0};
		int[] times = {0,5,10,15,20,25,30};
		TopVotedCandidate can = new TopVotedCandidate(persons, times);
		System.out.println(can.q(3));
		System.out.println(can.q(12));
		System.out.println(can.q(25));
		System.out.println(can.q(15));
		System.out.println(can.q(24));
		System.out.println(can.q(8));		
		
	}

}
